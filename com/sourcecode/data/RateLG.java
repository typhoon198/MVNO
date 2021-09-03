package com.sourcecode.data;

public class RateLG implements Rate{
	String[][] plan = {
			//0요금제번호	1요금제				2통화		3문자		4데이터	5속도제한	6요금 	7메이저와 비교	8통신사			9url			
			{"0", "최강가성비 120분 1.5GB",		"120분",	"100건",	"1.5GB",	"0",	"5940", 	"-19635",	"U+알뜰모바일",	"https://url.kr/aqlou4"},
			{"1", "홈플러스 (시니어1GB+100분)",	"100분",	"100건",	"1GB",		"0.4",	"4900",	  	"-16550",	"U+알뜰모바일",	"https://url.kr/mtpzao"},
			{"2", "GS25(5GB/100분)", 			"100분",	"100건",	"5GB",		"0",	"11100",	"-21075",	"U+알뜰모바일",	"https://url.kr/9jikbs"},
			{"3", "GS25(7GB/180분)",			"180분",	"100건",	"7GB",		"0",	"17790",	"-14385",	"U+알뜰모바일",	"https://url.kr/9jikbs"},
			{"4", "이십세 5GB",					"180분",	"100건",	"5GB",		"0",	"11900",	"-25638",	"U+알뜰모바일",	"https://url.kr/jgfx3v"},
			{"5", "이십세 10GB", 				"180분",	"100건",	"10GB",		"0",	"17900",	"-19638",	"U+알뜰모바일",	"https://url.kr/jgfx3v"},
			{"6", "최강가성비 200분 2GB",		"200분",	"100건",	"2GB",		"0",	"7700",		"-21175",	"U+알뜰모바일",	"https://url.kr/aqlou4"},
			{"7", "최강가성비 200분 3.5GB",		"200분",	"100건",	"3.5GB",	"0",	"11800",	"-21200",	"U+알뜰모바일",	"https://url.kr/aqlou4"},
			{"8", "홈플러스 (5GB/200분)",		"200분",	"100건",	"5GB",		"1",	"12700",	"-24838",	"U+알뜰모바일",	"https://url.kr/mtpzao"},
			{"9", "홈플러스 (5GB/300분)",		"200분",	"100건",	"5GB",		"1",	"15180",	"-26070",	"U+알뜰모바일",	"https://url.kr/mtpzao"},
			{"10", "홈플러스 (10GB+/200분)",	"200분",	"100건",	"10GB",		"1",	"18810",	"-22400",	"U+알뜰모바일",	"https://url.kr/mtpzao"},
			{"11", "최강가성비 100분 15GB+",	"100분",	"100건",	"15GB",		"3",	"25300",	"-16775",	"U+알뜰모바일",	"https://url.kr/aqlou4"},
			{"12", "최강가성비 180분 15GB+",	"180분",	"100건",	"15GB",		"3",	"26900", 	"-15175",	"U+알뜰모바일",	"https://url.kr/aqlou4"},
			{"13", "이십세 15GB+",				"180분",	"100건",	"1.5GB",	"3",	"26900",	"-15175",	"U+알뜰모바일",	"https://url.kr/jgfx3v"},
			{"14", "통화 마음껏 데이터 1.5GB", 	"무제한",	"무제한",	"2.5GB",	"0",	"8900",		"-15850",	"U+알뜰모바일",	"https://url.kr/n3hlcb"},
			{"15", "통화 마음껏 데이터 2.5GB",	"무제한",	"무제한",	"4.5GB",	"0",	"13600",	"-20968",	"U+알뜰모바일",	"https://url.kr/n3hlcb"},
			{"16", "통화 마음껏 데이터 4.5GB",	"무제한",	"무제한",	"1.5GB",	"0",	"14850",	"-27143",	"U+알뜰모바일",	"https://url.kr/n3hlcb"},
			{"17", "통화 마음껏 데이터 6B+"	, 	"무제한",	"무제한",	"6GB",		"1",	"16900",	"-27350",	"U+알뜰모바일",	"https://url.kr/n3hlcb"},
			{"18", "데이터 통화 마음껏",		"무제한",	"무제한",	"무제한",	"3",	"32950",	"-16468",	"U+알뜰모바일",	"https://url.kr/scru1p"},
			{"19", "이십세 Freedom",			"무제한",	"무제한",	"무제한",	"3",	"32950",	"-16468",	"U+알뜰모바일",	"https://url.kr/jgfx3v"},
	};

	int[][] match = {
			{0,1},
			{2,3,4,5},
			{8,9,10},
			{11,12,13},
			{6},
			{13,14,15},
			{8,9,10},
			{13},
			{14,15},
			{16},
			{17},
			{11,12,13},
			{14,15},
			{16},
			{17},
			{18,19}
	};
	String url = "https://www.uplussave.com/shop/cmmn/index.mhp";
	@Override
	public String getPlanName(int i) {
		return plan[i][1];
	}
	public String getPlanVoice(int i) {
		return plan[i][2];
	}
	public String getPlanSms(int i) {
		return plan[i][3];
	}
	public String getPlanData(int i) {
		return plan[i][4];
	}
	public String getPlanCarrier(int i){
		return plan[i][8];
	}
	public String getPlanUrl(int i) {
		return plan[i][9] ;
	}
	public double getPlanSpeed(int i) {
		return Double.parseDouble(plan[i][5]) ;
	}
	public int getPlanRate(int i) {
		return Integer.parseInt(plan[i][6]) ;
	}
	public int getPlanDown(int i) {
		return Integer.parseInt(plan[i][7]) ;
	}
	public String getURL() {
		return url;
	}
	public int[] getMatch(int i) {
		return match[i];
	}

}


