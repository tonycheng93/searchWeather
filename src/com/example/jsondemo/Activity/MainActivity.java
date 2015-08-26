package com.example.jsondemo.Activity;

import java.net.URLDecoder;
import java.net.URLEncoder;

import com.example.jsondemo.R;
import com.example.jsondemo.Bean.Weather;
import com.example.jsondemo.Utils.HttpDownloader;
import com.example.jsondemo.Utils.ParseJSON;
import com.google.gson.Gson;

import android.support.v7.app.ActionBarActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private EditText mQuery;
	private Button mSearch;
	private TextView mCityName;
	private TextView mWeather;
	private TextView mTemp;
	private TextView mLowTmp;
	private TextView mHighTmp;

	private Weather weather;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();

		mSearch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				new SerachAsyTask().execute();
				System.out.println("�������Ϣ�ǣ�"
						+ URLDecoder.decode(mQuery.getText().toString()));
			}
		});
	}

	private void findView() {
		mQuery = (EditText) findViewById(R.id.edit_query);
		mSearch = (Button) findViewById(R.id.search);
		mCityName = (TextView) findViewById(R.id.city_name);
		mWeather = (TextView) findViewById(R.id.weather);
		mTemp = (TextView) findViewById(R.id.temp);
		mLowTmp = (TextView) findViewById(R.id.l_tmp);
		mHighTmp = (TextView) findViewById(R.id.h_tmp);
	}

	class SerachAsyTask extends AsyncTask<Void, Void, String> {

		// ����ֱ���ں������mQuery.getText().toString(),���뾭��ת���Ժ����ȷ
		/**
		 * ������Ĳ�ѯ�ַ�������ת�룬�����޷���ѯ
		 */
		String address = "http://apis.baidu.com/apistore/weatherservice/cityname?cityname="
				+ URLEncoder.encode(mQuery.getText().toString());

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			Log.d("TAG", result);
			ParseJSON parseJSON = new ParseJSON(getApplicationContext());
			parseJSON.parseJson(result);
			if (ParseJSON.weather.getRetData() != null) {
				mCityName.setText(ParseJSON.weather.getRetData().getCity());
				mWeather.setText(ParseJSON.weather.getRetData().getWeather());
				mTemp.setText(ParseJSON.weather.getRetData().getTemp());
				mLowTmp.setText(ParseJSON.weather.getRetData().getL_tmp());
				mHighTmp.setText(ParseJSON.weather.getRetData().getH_tmp());
			}
		}

		@Override
		protected String doInBackground(Void... arg0) {
			HttpDownloader httpDownloader = new HttpDownloader();
			String jsonData = httpDownloader.download(address);
			return jsonData;
		}
	}
}
