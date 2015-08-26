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

	public ParseJSON(Context context) {
		this.mContext = context;
	}

	public static void parseJson(String jsonData) {
		JSONObject json = null;
		try {
			json = new JSONObject(jsonData);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * 增加对retData是否为空的判断，避免出现输入地区不存在时，出现空指针异常
		 * 这里有一个很奇怪的问题就是，JSON设计的格式，
		 * 1、当返回正确结果时，retData是一个对象
		 * 2、当返回错误的结果时，retData是一个数组
		 * 如果不对这种情况事先加以判断就会出现空指针异常的现象
		 */
		JSONObject retData = json.optJSONObject("retData");
		if (retData != null) {
			gson = new Gson();
			weather = gson.fromJson(jsonData, Weather.class);
		} else {
			Toast.makeText(mContext, "请确认您输入的地区名称正确", Toast.LENGTH_SHORT)
					.show();
		}
	}
}
