package com.sourcecode.vo;

import java.io.Serializable;

public class RateVO implements Comparable<RateVO>, Serializable{
	static final long serialVersionUID = 4339496124551897136L;
	private String plan;
	private String voice;
	private String sms;
	private String data;
	private double speed;	
	private int rate;
	private int down;
	private String carrier;
	private String url;
	public RateVO() {}
	public RateVO(String plan, String voice, String sms, String data, double speed, int rate, int down,
			String carrier, String url) {
		super();
		this.plan = plan;
		this.voice = voice;
		this.sms = sms;
		this.data = data;
		this.speed = speed;
		this.rate = rate;
		this.down = down;
		this.carrier = carrier;
		this.url = url;
	}

	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	public String getVoice() {
		return voice;
	}
	public void setVoice(String voice) {
		this.voice = voice;
	}
	public String getData() {
		return data;
	}
	public String getUrl() {
		return url;
	}
	public void setData(String data) {
		this.data = data;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public long getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getDown() {
		return down;
	}
	public void setDwon(int down) {
		this.down = down;
	}
	@Override
	public int compareTo(RateVO o) {
		if(this.rate > o.rate) {
			return 1;
		}else if(this.rate < o.rate) {
			return -1;
		}else {
			return this.carrier.compareTo(o.carrier);
		}
	}
	@Override
	public String toString() {
		//text파일 저장시
		String str1 = carrier + "\t" + plan + "\t"+ rate +"원\t" + voice + "\t" + data+"\t"+ url +"\t";
		String str2 = speed==0? "\n" :" (기본제공량 소진 시 " + speed + "mbps 로 속도제한)\n";
		return  str1+str2;
	}
}









