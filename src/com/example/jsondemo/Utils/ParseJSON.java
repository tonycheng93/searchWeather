package com.example.jsondemo.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.widget.Toast;

import com.example.jsondemo.Bean.Weather;
import com.google.gson.Gson;

public class ParseJSON {
	public static Context mContext;
	public static Gson gson;
	public static Weather weather;
	public ParseJSON(Context context){
		this.mContext = context;
	}
	public static void parseJson(String jsonData){
		JSONObject json = null;
		try {
			json = new JSONObject(jsonData);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject retData = json.optJSONObject("retData");
		if (retData != null) {
			gson = new Gson();
			weather = gson.fromJson(jsonData, Weather.class);
		}else {
			Toast.makeText(mContext,"请确认您输入的地区名称正确", Toast.LENGTH_SHORT).show();
		}
	}
}
