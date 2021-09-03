package com.sourcecode.data;
public interface Rate {
	String getPlanName(int i);
	String getPlanCarrier(int i);
	String getPlanVoice(int i);
	String getPlanSms(int i);
	String getPlanData(int i);
	String getPlanUrl(int i);
	int getPlanRate(int i);
	double getPlanSpeed(int i);
	int getPlanDown(int i);
	int[] getMatch(int i);
	String getURL();
	

}

