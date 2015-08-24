package com.example.jsondemo.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpDownloader {
	private URL url = null;
	
	public String download(String urlString){
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader reader = null;
		HttpURLConnection connection = null;
		InputStream is = null; 
		try {
			url = new URL(urlString);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("apikey", " 463937c0fbcf5a76617d7608ffa3fe5f");
			connection.setConnectTimeout(8 * 1000);
			connection.setReadTimeout(8 * 1000);
			is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is,"utf-8"));
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				reader.close();
				is.close();
				connection.disconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sb.toString();
		
	}
}
