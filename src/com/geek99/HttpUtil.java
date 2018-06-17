package com.geek99;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	public static String doPost(String url, List<NameValuePair> list) {
		HttpPost post = new HttpPost(url);
		HttpEntity entity = null;
		if (list != null) {
			try {
				entity = new UrlEncodedFormEntity(list, "gbk");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			post.setEntity(entity);
		}

		HttpClient client = new DefaultHttpClient();
		try {
			HttpResponse response = client.execute(post);
			if (response.getStatusLine().getStatusCode() == 200) {
				String result = EntityUtils.toString(response.getEntity());
				// save SharedPre...
				//result = new String(result.getBytes("iso-8859-1"),"gbk");
				//post.setHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");
				System.out.println(result);
				return result;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

