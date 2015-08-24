package com.example.jsondemo.Bean;

import java.util.List;

public class Weather {
	private int errNum;
	private String errMsg;
	RetData retData;
	List<RetData> retDatas;
	public int getErrNum() {
		return errNum;
	}
	public void setErrNum(int errNum) {
		this.errNum = errNum;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public RetData getRetData() {
		return retData;
	}
	public void setRetData(RetData retData) {
		this.retData = retData;
	}
	@Override
	public String toString() {
		return "weather [errNum=" + errNum + ", errMsg=" + errMsg
				+ ", retData=" + retData + "]";
	}
}
