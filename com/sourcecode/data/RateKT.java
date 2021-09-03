package com.sourcecode.data;
public class RateKT implements Rate {
	String[][] plan = {
			//0요금제번호	1요금제				2통화		3문자		4데이터	5속도제한	6요금 	7메이저와 비교	8통신사			9url			
			{"0",	"초알뜰 1GB/100분\t",		"100분",	"100건",	"1GB",		"0",	"4100", 	"-16525", 	"ktM모바일",	"https://url.kr/qutyig"},
			{"1",	"초알뜰 1.5GB/100분\t",		"100분",	"100건",	"1.5GB",	"0",	"4900", 	"-18200", 	"ktM모바일",	"https://url.kr/6vjyco"},
			{"2",	"초알뜰 1.5GB/150분\t",		"150분",	"100건",	"1.5GB",	"0",	"5500", 	"-22550", 	"ktM모바일",	"https://url.kr/nxbvay"},
			{"3",	"데이터 함께쓰기 120분",	"120분",	"120건",	"2GB",		"0.4",	"4400", 	"-18700", 	"ktM모바일",	"https://url.kr/3wavoy"},
			{"4",	"데이터 충분 2.4GB/100분",	"100분",	"50건",		"2.4GB",	"0",	"6800", 	"-21250", 	"ktM모바일",	"https://url.kr/eqlc1i"},
			{"5",	"데이터 충분 2.4GB/150분",	"150분",	"50건",		"2.4GB",	"0",	"7800", 	"-23550", 	"ktM모바일",	"https://url.kr/to1347"},
			{"6",	"데이터 충분 3.5GB/100분",	"100분",	"50건",		"3.5GB",	"0",	"8800", 	"-19250", 	"ktM모바일",	"https://url.kr/zndwis"},
			{"7",	"데이터 충분 3.5GB/150분",	"150분",	"50건",		"3.5GB",	"0",	"9800", 	"-21550", 	"ktM모바일",	"https://url.kr/cx6fts"},
			{"8",	"데이터 충분 5GB/100분",	"100분",	"50건",		"5GB",		"0",	"11800", 	"-19138", 	"ktM모바일",	"https://url.kr/pz6x9s"},
			{"9",	"데이터 충분 5GB/150분",	"150분",	"50건",		"5GB",		"0",	"12800", 	"-21850", 	"ktM모바일",	"https://url.kr/6aexpz"},
			{"10",	"데이터 많이 12GB/100분",	"100분",	"100건",	"10GB",		"0",	"16500", 	"-17738", 	"ktM모바일",	"https://url.kr/k38h14"},
			{"11",	"데이터 맘껏 2.2GB+/100분",	"100분",	"100건",	"2.2GB",	"1",	"11500", 	"-19438", 	"ktM모바일",	"https://url.kr/682nxf"},
			{"12",	"데이터 맘껏 5GB+/100분",	"100분",	"100건",	"5GB",		"1",	"14300", 	"-19938", 	"ktM모바일",	"https://url.kr/e2jl7t"},
			{"13",	"데이터 맘껏 12GB+/100분",	"100분",	"100건",	"12GB",		"1",	"19800", 	"-14438", 	"ktM모바일",	"https://url.kr/ngclpa"},
			{"14",	"초알뜰 2GB/200분\t",		"200분",	"100건",	"2GB",		"0",	"7700", 	"-20350", 	"ktM모바일",	"https://url.kr/wpvfkc"},
			{"15",	"데이터 함께쓰기 240분",	"240분",	"240건",	"2GB",		"0.4",	"6600", 	"-21450", 	"ktM모바일",	"https://url.kr/g85a7w"},
			{"16",	"데이터 충분 2.4GB/200분",	"200분",	"50건",		"2.4GB",	"0",	"8800", 	"-19250", 	"ktM모바일",	"https://url.kr/48qhdt"},
			{"17",	"데이터 충분 3.5GB/200분",	"200분",	"50건",		"3.5GB",	"0",	"10800", 	"-20550", 	"ktM모바일",	"https://url.kr/qmvyrj"},
			{"18",	"데이터 충분 5GB/200분",	"200분",	"50건",		"5GB",		"0",	"13800", 	"-20850", 	"ktM모바일",	"https://url.kr/y6on52"},
			{"19",	"데이터 맘껏 15GB+/100분",	"100분",	"100건",	"15GB",		"3",	"25300", 	"-16775", 	"ktM모바일",	"https://url.kr/j2s79r"},
			{"20",	"데이터 맘껏 15GB+/300분",	"300분",	"300건",	"15GB",		"3",	"27500", 	"-14575", 	"ktM모바일",	"https://url.kr/t3hov6"},
			{"21",	"통화 맘껏 1.5GB\t",		"무제한",	"무제한",	"1.5GB",	"0",	"8900", 	"-15850", 	"ktM모바일",	"https://url.kr/86jwxk"},
			{"22",	"통화 맘껏 2.5GB\t",		"무제한",	"무제한",	"2.5GB",	"0",	"9900", 	"-18893", 	"ktM모바일",	"https://url.kr/7qp2nk"},
			{"23",	"시니어 안심 2GB+\t",		"무제한",	"무제한",	"2GB",		"0.4",	"8900", 	"-19893", 	"ktM모바일",	"https://url.kr/16w4kt"},
			{"24",	"통화 맘껏 4.5GB+\t",		"무제한",	"무제한",	"4.5GB",	"0",	"12100", 	"-20818", 	"ktM모바일",	"https://url.kr/rhlueb"},
			{"25",	"통화 맘껏 6.5GB+\t",		"무제한",	"무제한",	"6.5GB",	"0",	"14500", 	"-22543", 	"ktM모바일",	"https://url.kr/qtkmbf"},
			{"26",	"시니어 안심 4GB+\t",		"무제한",	"무제한",	"4GB",		"0.4",	"11900", 	"-21018", 	"ktM모바일",	"https://url.kr/tafgzq"},
			{"27",	"모두다 맘껏 5.4GB+\t",		"무제한",	"무제한",	"5.4GB",	"1",	"16900", 	"-19850", 	"ktM모바일",	"https://url.kr/wvgdx3"},
			{"28",	"모두다 맘껏 7GB+\t",		"무제한",	"무제한",	"7GB",		"1",	"24200", 	"-12550", 	"ktM모바일",	"https://url.kr/qgapnz"},
			{"29",	"모두다 맘껏 12GB+\t",		"무제한",	"무제한",	"12GB",		"1",	"28600", 	"-20818", 	"ktM모바일",	"https://url.kr/ceg6j7"},
			{"30",	"모두다 맘껏 11GB+\t",		"무제한",	"무제한",	"무제한",	"1",	"32980", 	"-16438", 	"ktM모바일",	"https://url.kr/3epw61"}
	};

	int[][] match = {
			{0,1,2,3,4,5},
			{6,7,8,9,10},
			{11,12,13},
			{19},
			{14,15,16},
			{17,18},
			{27,28},
			{20},
			{21,22,23},
			{24,25,26},
			{19,20,27,28},
			{19,20},
			{21,22,23},
			{24,25,26},
			{27,28,29},
			{30}
	};
	String url = "https://www.ktmmobile.com/main.do";

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