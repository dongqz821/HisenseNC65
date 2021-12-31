package nc.impl.baseapp.utils;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.itf.baseapp.utils.ICallNccOpenAPIUtil;
import nc.itf.bpm.utils.ICommonUtils;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

import com.alibaba.fastjson.JSONObject;

/*
 * ����NCC openAPI�Ĺ�����
 * */
public class CallNccOpenAPIUtiIlmpl implements ICallNccOpenAPIUtil {
	@Override
	public String callAPI(String url, JSONObject content){//httpsЭ���post����
		ICommonUtils util = NCLocator.getInstance().lookup(ICommonUtils.class);
		String result = util.getBPMWorkflowurl_RequiresNew(url, JSONObject.toJSONString(content));
		return result;
	}
	
	public String callAPI_one(String nccip, JSONObject json) {
//		String nccip = ConfigUtils.getValueFromProperties("nccip");
		String param = json.toJSONString();
        StringBuffer sb = new StringBuffer("");
          try {
              // ��������
              URL url = new URL(nccip);
              if("https".equalsIgnoreCase(url.getProtocol())){
  				createSSLClientDefault();//�����https����������֤
  	          }
              HttpURLConnection connection = (HttpURLConnection) url.openConnection();
              connection.setDoOutput(true);
              connection.setDoInput(true);
              connection.setRequestMethod("POST");
              connection.setUseCaches(false);
              connection.setInstanceFollowRedirects(true);
              connection.setRequestProperty("Content-Type", "application/json;");
              connection.setRequestProperty("encoding", "UTF-8");
              connection.setConnectTimeout(120000);
              connection.setReadTimeout(120000);
              connection.connect();  
              // POST����
              DataOutputStream out = new DataOutputStream(
                              connection.getOutputStream());
              out.write(param.getBytes("UTF-8"));
              out.flush();
              out.close();
              // ��ȡ��Ӧ
              BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
              
              String lines;
              while ((lines = reader.readLine()) != null) {
                      lines = new String(lines.getBytes());
                      sb.append(lines);
              }
              reader.close();
              // �Ͽ�����
              connection.disconnect();
          } catch (Exception e) {
              Logger.error(e.getMessage());
              ExceptionUtils.wrappBusinessException("���ýӿ�("+ nccip +")�����쳣��"+e.getMessage());
          } 
          return sb.toString();
	}

	//https֤��������֤
	public static String createSSLClientDefault() {
        try {
        	 HostnameVerifier hv = new HostnameVerifier() {
					public boolean verify(String hostname, SSLSession session) {
						return true;
					}
        	    };
    	    trustAllHttpsCertificates();
    	    HttpsURLConnection.setDefaultHostnameVerifier(hv);

        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        return "";
    }
	private static void trustAllHttpsCertificates() throws Exception {
	    TrustManager[] trustAllCerts = new TrustManager[1];
	    TrustManager tm = new miTM();
	    trustAllCerts[0] = tm;
	    SSLContext sc = SSLContext.getInstance("SSL");
	    sc.init(null, trustAllCerts, null);
	    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}
	static class miTM implements TrustManager,X509TrustManager {
	    public X509Certificate[] getAcceptedIssuers() {
	        return null;
	    }
	  
	    public boolean isServerTrusted(X509Certificate[] certs) {
	        return true;
	    }
	  
	    public boolean isClientTrusted(X509Certificate[] certs) {
	        return true;
	    }
	  
	    public void checkServerTrusted(X509Certificate[] certs, String authType)
	            throws CertificateException {
	        return;
	    }
	  
	    public void checkClientTrusted(X509Certificate[] certs, String authType)
	            throws CertificateException {
	        return;
	    }
	}
}
