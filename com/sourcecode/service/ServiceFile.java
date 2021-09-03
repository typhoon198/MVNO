package com.sourcecode.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.sourcecode.dao.DAOFile;
import com.sourcecode.front.Pn3Member;
import com.sourcecode.front.Pn4VoiceData;
import com.sourcecode.front.Pn5Choice;
import com.sourcecode.front.Pn6Result;


public class ServiceFile{
	private static ServiceFile service = new ServiceFile();

	private int member = 1;
	private String user = "";
	private String carrier = "";
	public DAOFile dao = null;

	JFileChooser fileComponent = new JFileChooser();

	public ServiceFile() {
	}
	public static ServiceFile getInstance() {
		return service;
	}
	public int getMember() {
		return member;
	}
	public String getUser() {
		return user;
	}
	public String memberName(int index){
		return dao.memberName(index);
	}

//Panel 3 : 가족구성원 입력 및 통신사 입력	
	public void setUser(Pn3Member panel3) {
		user = panel3.nameField[0].getText();
		member = Integer.parseInt(panel3.numField.getText());
		carrier = panel3.group.getSelection().getActionCommand();
	}
	public boolean isExistFile() {
		//파일이 있는지 확인하고 
		//1)존재하면  		새로시작(false) / 불러오기(true) /  취소 
		//2)존재하지않으면  새로시작(false)
		String path = ".\\save\\"+user+member+carrier+".ser";
		File file = new File(path);
		if(file.exists()) {
			int result = JOptionPane.showConfirmDialog(null, user +"님 환영합니다. \n "
					+ "기존의 선택,추천정보를 불러올까요?", "불러오기", 
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null);

			if(result==JOptionPane.YES_OPTION) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public void loadDAO() {
		String path = ".\\save\\"+user+member+carrier+".ser";

		try {
			FileInputStream 	 	fis = new FileInputStream(path);
			BufferedInputStream 	bis = new BufferedInputStream(fis);
			ObjectInputStream 		in = new ObjectInputStream(bis);
			dao = (DAOFile)in.readObject();
			in.close();
		} catch (Exception e)  {
		} 
		dao.setCarrier(carrier);

	}

	public void saveDAO(Pn6Result panel6) {
		String dirPath = ".\\save";
		File dir = new File(dirPath);
		if(!dir.exists()) {
			dir.mkdir();

		}
		
		String filePath = dir+"\\"+user+member+carrier+".ser";

		try {
			FileOutputStream 	 fos = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream out = new ObjectOutputStream(bos);
			out.writeObject(dao);
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void creatDAO(Pn3Member panel3) {
		dao = new DAOFile();
		dao.setCarrier(carrier);
		dao.addMember(panel3.nameField[0].getText().equals("")? "대표자" : panel3.nameField[0].getText());
		for(int i=1; i<member;i++) {
			dao.addMember(panel3.nameField[i].getText().equals("")? "구성원" + i : panel3.nameField[i].getText());
		}
	}

//Panel 4 : 구성원별 사용량선택
	public void putMatchPlan(Pn4VoiceData panel4) {
	for(int i=0; i<member;i++) {
		int v = Integer.parseInt(panel4.select[i].groupVoice.getSelection().getActionCommand());
		int d = Integer.parseInt(panel4.select[i].groupData.getSelection().getActionCommand());
		dao.matchPlan(i, 4*v+d);
	}
}	

	
//Panel 5 : 구성원별 요금제선택
	public void	creatChoice(Pn5Choice panel5){
		String[][][] strArr = new String[member][][];
		String[]  columns = {carrier.equals("etc")? "통신사":"요금제명", "통화", "데이터", "요금"};
		int rows;
		for(int k=0; k<member; k++) {
			rows = dao.matchPlanList(k).size();
			strArr[k] = new String[rows][4];
			if(carrier.equals("etc")) {	//기타통신사일때만 통신사표시 
				for(int i=0; i<rows; i++) {
					strArr[k][i][0] = dao.matchPlanList(k).get(i).getCarrier();						//통신사
					strArr[k][i][1] = dao.matchPlanList(k).get(i).getVoice();						//통화
					strArr[k][i][2] = dao.matchPlanList(k).get(i).getData();						//데이터
					strArr[k][i][3] = String.format("%,d원",dao.matchPlanList(k).get(i).getRate());//요금
				}	
			} else {					//ktM모바일, U+알뜰모바일일때는 요금제명 표시
				for(int i=0; i<rows; i++) {
					strArr[k][i][0] = dao.matchPlanList(k).get(i).getPlan();						//요금제명
					strArr[k][i][1] = dao.matchPlanList(k).get(i).getVoice();						//통화
					strArr[k][i][2] = dao.matchPlanList(k).get(i).getData();						//데이터
					strArr[k][i][3] = String.format("%,d원",dao.matchPlanList(k).get(i).getRate());//요금
				}
			}
			panel5.choice[k].setModel(new DefaultTableModel(strArr[k],columns));
			panel5.choice[k].setRowSelectionInterval(0, 0);
		}
	}

	public void	putChoicePlan(Pn5Choice panel5) {
		for(int i=0; i<member;i++) {
			dao.inputPlan(i,panel5.choice[i].getSelectedRow());
		}
	}

	public void	saveText(Pn6Result panel6) {
		//총요금
		String str0 = "<" + user + "님의 가족 알뜰폰요금제>\n";
		String str1 = "\t총 요금 :"+ panel6.table.getModel().getValueAt(member, 6) + "원\n"
				+ "\t메이저 대비 :"+ panel6.table.getModel().getValueAt(member, 7) + "원 절약\n\n";

		//제휴카드 정보
		String str2 = "2.통신사 제휴카드 정보 : https://bnkmvno.com/prdinfo/src/mvno/card/index.html\n\n";
		String str3 = "3.그밖에 알뜰폰통신사(기간 할인(6개월~12개월) 요금제)\n"
				+"\t1)알요조 https://blog.naver.com/pridemee\n"
				+"\t2)알뜰폰 허브 https://www.mvnohub.kr/user/promotion/TblUserEventList.do\n"
				+"\t3)livem(국민은행 주거래) https://www.liivm.com/\n"
				+"\t4)펀다이렉트샵(카카오) https://www.pinplay.co.kr/\n\n";

		String str4 ="4. 자급제 할인정보\n"
				+"1)아이폰 : 차기작 출시전 구매\n"
				+"\t→구매경로 : 쿠팡 카드할인 또는 11번가 십일절(매월 11일) 타임세일 구매 또는 이마트\n"
				+"\t→세일정보 : 세일닥터 https://saledoctor.co.kr/?s=%EC%95%84%EC%9D%B4%ED%8F%B0\n"				
				+"2)갤럭시 : 출시 전 예약구매 또는 아이폰 출시전 구매\n"
				+"\t→구매경로 : 홈플러스 디지털프라자 또는 직구(삼성페이, 중고로 되팔기 불가)\n"
				+"\t→세일정보 : https://www.ppomppu.co.kr/zboard/view.php?id=shopping&no=12872\n";

		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(chooser.DIRECTORIES_ONLY);
		//경로만 선택

		int result = chooser.showSaveDialog(null);
		if ( result == JFileChooser.APPROVE_OPTION ) {
			try {
				String filename = user+"님의 가족 알뜰폰요금제.txt";
				File savfile = new File(chooser.getSelectedFile().getAbsolutePath() 
						+"\\"+filename);
				BufferedWriter bw = new BufferedWriter(new FileWriter(savfile) );
				bw.write(str0);
				bw.write(dao.toString());
				bw.write(str1);
				bw.write(str2);
				bw.write(str3);
				bw.write(str4);
				bw.flush();
				bw.close();
				panel6.progress.setStringPainted(true);
				panel6.progress.setString(chooser.getSelectedFile().getAbsolutePath()
						+"\\"+filename + "  저장 완료");
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "<html><h2>저장하실 경로를 선택해주세요</h2></html>", "경고", JOptionPane.WARNING_MESSAGE);
			}
		} 
	}
//Panel 6: 결과화면
	public void	creatResultTable(Pn6Result panel6) {
		String[][] result = new String[member+1][10];
		int sum = 0;
		int down = 0;

		for(int i=0; i<member; i++) {
			result[i] = new String[] {memberName(i)
					, dao.outputPlan(i).getPlan()
					, dao.outputPlan(i).getVoice()
					, dao.outputPlan(i).getSms()
					, dao.outputPlan(i).getData()
					, dao.outputPlan(i).getSpeed()==0? "초과요금" : String.valueOf(dao.outputPlan(i).getSpeed())+"mbps"
					, String.format("%,d원",dao.outputPlan(i).getRate())
					, String.format("%,d원",dao.outputPlan(i).getDown())
					, dao.outputPlan(i).getCarrier()
					, dao.outputPlan(i).getUrl() 	
			};
			sum += dao.outputPlan(i).getRate();
			down += dao.outputPlan(i).getDown();
		}
		result[member] = new String[] {"총 "+String.valueOf(member)+"명",
				"",
				"",
				"",
				"",
				"",
				String.format("총%,d원",sum),
				String.format("총%,d원",down),
				"", 
				"더블클릭후 복사",
		};

		String[] columns = new String[] {
				"구성원", "요금제", "통화", "문자", "데이터", "제공량소진시", "요금", "이통3사 대비", "통신사", "URL"};		
		panel6.table.setModel(new DefaultTableModel(result,columns) {
			//URL 열만 수정가능(붙여넣기)
			public boolean isCellEditable(int row, int column) {
				if(column==1 ||column==9) {
					return true;
				} else {
					return false;
				}
			}
		});
	}
	public void	linkCarrierPage() {
		try {
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("explorer.exe "+dao.rateT.getURL());
		} catch (IOException e2) {
			JOptionPane.showMessageDialog(null, "인터넷 브라우저를  찾지못했습니다.", "경고", JOptionPane.WARNING_MESSAGE);
		}
	
	}
	public void	linkCardPage() {
		try {
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("explorer.exe http://bnkmvno.com/prdinfo/src/mvno/card/index.html");
		} catch (IOException e2) {
			JOptionPane.showMessageDialog(null, "인터넷 브라우저를  찾지못했습니다.", "경고", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
}






