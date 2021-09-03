package com.sourcecode.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.sourcecode.data.Rate;
import com.sourcecode.data.RateEtc;
import com.sourcecode.data.RateKT;
import com.sourcecode.data.RateLG;
import com.sourcecode.vo.RateVO;

public class DAOFile implements Serializable {
	static final long serialVersionUID = 8353411796156573590L;
	//요금표 제외하고 직렬화
	public transient Rate rateT = null;
	private String carrier = "";
	private ArrayList<String> 						memberList = new ArrayList<String>();
	private HashMap<Integer,ArrayList<RateVO>> 		casePlan = new HashMap<Integer, ArrayList<RateVO>>();
	private HashMap<Integer,RateVO> 				selectPlan = new HashMap<Integer, RateVO>();	

	//text파일 저장시 형식
	@Override
	public String toString() {
		String result="이름\t통신사\t\t요금제명\t\t\t요금\t통화\t데이터\turl\n";
		for(int index : selectPlan.keySet()) {
			result = result +memberList.get(index)+"\t"+selectPlan.get(index).toString();
		}
		return result;
	}
	
	public void addMember(String name){
		memberList.add(name);
	}
	public String memberName(int index){
		return memberList.get(index);
	}
	public ArrayList<String> memberList(){
		return memberList;
	}

	//역직렬화 할때 통신사별로 요금표 생성 다시
	public void setCarrier(String carrier) {
		this.carrier = carrier ;
		switch (carrier) {
		case "kt":
			rateT = new RateKT();
			break;
		case "lg":
			rateT = new RateLG();
			break;
		default:
			rateT = new RateEtc();
			break;
		}
	}

	public void matchPlan(int key, int value) {
	int[] match = rateT.getMatch(value);
	ArrayList<RateVO> memberPlanList = new ArrayList<RateVO>(); 
	for (int i=0; i<match.length; i++) {	
		RateVO vo = new RateVO(rateT.getPlanName(match[i])
				,rateT.getPlanVoice(match[i])
				,rateT.getPlanSms(match[i])
				,rateT.getPlanData(match[i])
				,rateT.getPlanSpeed(match[i])
				,rateT.getPlanRate(match[i])
				,rateT.getPlanDown(match[i])
				,rateT.getPlanCarrier(match[i])
				,rateT.getPlanUrl(match[i])
				);
		memberPlanList.add(vo);
	}
	Collections.sort(memberPlanList);
	casePlan.put(key,memberPlanList);
}
	public ArrayList<RateVO> matchPlanList(int key){
		return casePlan.get(key);

	}
	public void inputPlan(int key,int tableSelect){
		RateVO tempdto = casePlan.get(key).get(tableSelect);
		selectPlan.put(key,tempdto);

	}
	public RateVO outputPlan(int key){
		return selectPlan.get(key);
	}

}





