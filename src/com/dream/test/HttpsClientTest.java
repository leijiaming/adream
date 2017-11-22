package com.dream.test;

import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.HttpClient;

public class HttpsClientTest {

	public static void main(String[] args) throws Exception {
		HttpClient http = new HttpClient();
//		String url = "https://127.0.0.1:8443/sjcj/services/up";
//		String url = "https://125.76.230.178:8443/sxsjcjxm/services/up";
		String url = "https://125.76.230.178/sxsjcjxm/services/up";
		
		Protocol myhttps = new Protocol("https",
				new MySSLProtocolSocketFactory(), 8443);
		Protocol.registerProtocol("https", myhttps);
		PostMethod pm = new PostMethod(url);
		pm.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
		pm.setRequestHeader("ACNT", "sys");//替换为分配的用户
		pm.setRequestHeader("PSWD", "123");//替换为分配的密码
		
		RequestEntity entity = new ByteArrayRequestEntity(ZipUtil
				.zip("d:/serviceTestFile/GCHF.TXT"));//组织数据
		pm.setRequestEntity(entity);
		int code = http.executeMethod(pm);
		System.err.println("Post 方式的返回值是:" + code);
		if (code == 200) {
			String ss = pm.getResponseBodyAsString();
			System.err.println(">>:" + ss);
		} else {

		}
		pm.releaseConnection();

	}
}
