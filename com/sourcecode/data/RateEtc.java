package com.sourcecode.data;

public class RateEtc implements Rate {
	String[][] plan = {
			//0요금제번호	1요금제			2통화		3문자		4데이터	 5속도제한	6요금 	7메이저와비교	8통신사			9url		
			{"0",	"심플100분 2G\t",		"100분",	"50건",		"2GB",		"0",	"3630",		"-19470", 	"프리티(u+망)",	"https://url.kr/kgjatm"},
			{"1",	"프리티데이터 2.5G",	"100분",	"0건",		"2.5GB",	"0",	"4400",		"-23650",	"프리티(u+망)",	"https://url.kr/28r4ip"},
			{"2",	"프리티든든한 5G",		"100분",	"100건",	"5GB",		"0",	"11000",	"-21175",	"프리티(u+망)",	"https://url.kr/cfv6pw"},
			{"3",	"LTE 23.1\t",			"200분",	"200건",	"1.5GB",	"0",	"4400",		"-24475", 	"프리티(u+망)",	"https://url.kr/ie2jz9"},
			{"4",	"LTE 28.6\t",			"250분",	"250건",	"2.5GB",	"0",	"4950",		"-23925", 	"프리티(u+망)",	"https://url.kr/meu2b7"},
			{"5",	"프리티데이터2G",		"200분",	"50건",		"2GB",		"0",	"5500",		"-22550", 	"프리티(kt망)",	"https://url.kr/9xwdom"},
			{"6",	"이마트24_Grande+",		"240분",	"240건",	"5GB",		"0",	"9900",		"-27638", 	"프리티(u+망)",	"https://url.kr/tu71k5"},
			{"7",	"보편유심5GB 200분",	"200분",	"100건",	"5GB",		"0",	"9900",		"-27638", 	"헬로모바일",	"https://url.kr/byzsop"},
			{"8",	"든든한 200분 10GB",	"200분",	"100건",	"10GB",		"0",	"16500",	"-21038", 	"프리티(sk망)",	"https://url.kr/6jstan"},
			{"9",	"LTE28.6+\t",			"250분",	"250건",	"2.5GB",	"1",	"12100",	"-20900", 	"프리티(u+망)",	"https://url.kr/6ips9x"},
			{"10",	"보편안심 5GB 200분",	"200분",	"100건",	"5GB",		"1",	"15000",	"-22538", 	"헬로모바일",	"https://url.kr/kncdxf"},
			{"11",	"보편안심 10GB 200분",	"200분",	"100건",	"10GB",		"1",	"18900",	"-18638", 	"헬로모바일",	"https://url.kr/r3tg1m"},
			{"12",	"데이터안심300분15G+",	"300분",	"300건",	"무제한",	"3",	"27500",	"-14575", 	"프리티(kt망)",	"https://url.kr/ql1awj"},
			{"13",	"보편안심 15GB 100분", 	"100분+",	"100건",	"무제한",	"3",	"25300",	"-16775", 	"헬로모바일",	"https://url.kr/4dxzv6"},
			{"14",	"LTE유심15GB+/100분",	"100분+",	"100건",	"무제한",	"3",	"25300",	"-16775", 	"sk7모바일",	"https://url.kr/jcf438"},
			{"15",	"데이터충분 15GB+",		"100분+",	"무제한",	"무제한",	"3",	"25300",	"-16775", 	"Skylife(kt망)","https://url.kr/lu9t5a"},
			{"16",	"LTE유심(2GB/2000분)",	"2000분",	"2000건",	"2GB",		"0",	"8800",		"-23450", 	"sk7모바일",	"https://url.kr/zinw2h"},
			{"17",	"The착한데이터1.3GB",	"무제한",	"무제한",	"1.3GB",	"0",	"8500",		"-16250", 	"헬로모바일",	"https://url.kr/mkafzb"},
			{"18",	"골드2GB+(시니어)",		"무제한",	"무제한",	"2GB",		"0.4",	"7400",		"-17350", 	"Skylife(kt망)","https://url.kr/74irc2"},
			{"19",	"프리티 시니어2G",		"무제한",	"무제한",	"2GB",		"0.4",	"11000",	"-13750", 	"프리티(u+망)",	"https://url.kr/76owy4"},
			{"20",	"LTE유심(4GB/2000분)",	"2000분",	"2000건",	"4GB",		"0",	"12100",	"-25400", 	"sk7모바일",	"https://url.kr/hl485c"},
			{"21",	"LTE유심(6GB/2000분)",	"2000분",	"2000건",	"6GB",		"0",	"15400",	"-22100", 	"sk7모바일",	"https://url.kr/572yz3"},
			{"22",	"The착한데이터3.6GB",	"무제한",	"무제한",	"3.6GB",	"0",	"13090",	"-23660", 	"헬로모바일",	"https://url.kr/qbmh6d"},
			{"23",	"골드4GB+(시니어)",		"무제한",	"무제한",	"4GB",		"0.4",	"10400",	"-26350", 	"Skylife(kt망)","https://url.kr/9lnra6"},
			{"24",	"프리티 시니어4G",		"무제한",	"무제한",	"4GB",		"0.4",	"13200",	"-23550", 	"프리티(u+망)",	"https://url.kr/ekl1xj"},
			{"25",	"DATA걱정없는 4.5GB",	"무제한",	"무제한",	"4.5GB",	"1",	"16600",	"-20150", 	"헬로모바일",	"https://url.kr/zim3j8"},
			{"26",	"DATA걱정없는 7GB",		"무제한",	"무제한",	"7GB",		"1",	"18500",	"-25750", 	"헬로모바일",	"https://url.kr/pdavwb"},
			{"27",	"The착한데이터11GB",	"무제한",	"무제한",	"무제한",	"3",	"33000",	"-18750", 	"헬로모바일",	"https://url.kr/zavn6j"},
			{"28",	"LTE음성다유심11GB",	"무제한",	"무제한",	"무제한",	"3",	"33000",	"-18750", 	"sk7모바일",	"https://url.kr/m7h9g5"},
			{"29",	"모두다 충분11GB+",		"무제한",	"무제한",	"무제한",	"3",	"33000",	"-18750", 	"Skylife(kt망)","https://url.kr/hp9ske"}
	};

	int[][] match = {
			{0,1},
			{2,6,7},
			{9,10},
			{13,14,15},
			{3,4,5},
			{6,7},
			{9,10,11},
			{12},
			{17,18,19},
			{22},
			{25,26},
			{13,14,15},
			{16,17,18,19},
			{20,21,22,23,24},
			{25,26},
			{27,28,29}
	};

	String url = "https://www.mvnohub.kr/user/svc/CarrierInfo.do";

	//0요금제번호 1요금제 2통화  3문자 4데이터  5속도제한 6요금 7메이저와 비교	8통신사	9url
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
