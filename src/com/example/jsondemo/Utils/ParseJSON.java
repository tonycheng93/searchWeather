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
		 * ���Ӷ�retData�Ƿ�Ϊ�յ��жϣ���������������������ʱ�����ֿ�ָ���쳣
		 * ������һ������ֵ�������ǣ�JSON��Ƶĸ�ʽ��
		 * 1����������ȷ���ʱ��retData��һ������
		 * 2�������ش���Ľ��ʱ��retData��һ������
		 * �����������������ȼ����жϾͻ���ֿ�ָ���쳣������
		 */
		JSONObject retData = json.optJSONObject("retData");
		if (retData != null) {
			gson = new Gson();
			weather = gson.fromJson(jsonData, Weather.class);
		} else {
			Toast.makeText(mContext, "��ȷ��������ĵ���������ȷ", Toast.LENGTH_SHORT)
					.show();
		}
	}
}
