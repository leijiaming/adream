package com.dream.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
 
  
public class HttpsSendData {   
    /**
     * @param url 请求地址
     * @param paramsMap 将参数的名作为键
     * @return
     */
    public static String send(String url, Map<String, String> paramsMap) {  
    	System.out.println("准备开始发送请求:"+System.currentTimeMillis());
        String result = null;  
        PostMethod postMethod = null;  
        HttpClient httpClient = new HttpClient();
        httpClient.getParams().setParameter(  
                HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");  
        postMethod = new PostMethod(url);  
  
        if (paramsMap != null && paramsMap.size() > 0) {  
            NameValuePair[] datas = new NameValuePair[paramsMap.size()];  
            int index = 0;  
            for (String key : paramsMap.keySet()) {  
                datas[index++] = new NameValuePair(key,paramsMap.get(key));  
            }  
            postMethod.setRequestBody(datas);  
        }  
        HttpClientParams httparams = new HttpClientParams();  
        httparams.setSoTimeout(60000);  
        postMethod.setParams(httparams);  
  
        try {  
            int statusCode = httpClient.executeMethod(postMethod);  
            if (statusCode == HttpStatus.SC_OK) {  
            	//result = postMethod.getResponseBodyAsString();//原来的方式
            	InputStream is = postMethod.getResponseBodyAsStream();
                Scanner scanner = new Scanner(is, "UTF-8");
                result=scanner.useDelimiter("\\A").next();
            } else {  
 
            }  
        } catch (HttpException e) {
        	e.printStackTrace();
        } catch (IOException e) {  
        	e.printStackTrace();
        } finally {  
            if (postMethod != null) {
            	//释放链接
                postMethod.releaseConnection();  
            }  
        }
        System.out.println("收到响应                :"+System.currentTimeMillis());
        return result;  
    }
}  
