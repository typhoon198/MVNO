package com.sourcecode.front;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import com.sourcecode.service.ServiceFile;

public class MainFrame extends JFrame implements ActionListener {

	Pn0Start 		panel0 ;
	Pn1Info 		panel1 ;
	Pn2Benefit		panel2;
	Pn3Member 		panel3 ;
	Pn4VoiceData 	panel4 ;
	Pn5Choice	 	panel5 ;
	Pn6Result 		panel6 ;
	ServiceFile 	service;
	JFileChooser fileComponent = new JFileChooser();

	public MainFrame() {
		setBounds(0, 0, 1920, 1080);
		setLocationRelativeTo(null);
		setTitle("알뜰폰으로 가계통신비 줄이기 프로젝트");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				//이름 입력시만 저장
				if(panel6.isVisible()&&!service.getUser().equals("대표자")) {
					int state = JOptionPane.showConfirmDialog(null, "<html><h2>저장하시겠습니까?</h2><h3>(재실행시 사용량선택,추천요금제 저장)</h3></html>", "저장", JOptionPane.YES_NO_OPTION);
					if(state == JOptionPane.YES_NO_OPTION) {
						service.saveDAO(panel6);
					} 
				} 					   
				System.exit(0);
			}
		});

		service = ServiceFile.getInstance(); //싱글톤

		panel0 = new Pn0Start();
		panel1 = new Pn1Info();
		panel2 = new Pn2Benefit();
		panel3 = new Pn3Member();
		panel4 = new Pn4VoiceData();
		panel5 = new Pn5Choice();
		panel6 = new Pn6Result();

		Color bg = new Color(240, 240, 240); 
		panel1.setBackground(bg);
		panel2.setBackground(bg);
		panel3.setBackground(bg);
		panel4.setBackground(bg);
		panel5.setBackground(bg);
		panel6.setBackground(bg);

		Font font = new Font("맑은 고딕", Font.BOLD, 90);
		panel1.titleLabel.setFont(font);
		panel2.titleLabel.setFont(font);
		panel3.titleLabel.setFont(font);
		panel4.titleLabel.setFont(font);
		panel5.titleLabel.setFont(font);
		panel6.titleLabel.setFont(font);

		panel1.titleLabel.setHorizontalAlignment(JLabel.CENTER);
		panel2.titleLabel.setHorizontalAlignment(JLabel.CENTER);
		panel3.titleLabel.setHorizontalAlignment(JLabel.CENTER);
		panel4.titleLabel.setHorizontalAlignment(JLabel.CENTER);
		panel5.titleLabel.setHorizontalAlignment(JLabel.CENTER);
		panel6.titleLabel.setHorizontalAlignment(JLabel.CENTER);

		add(panel0);
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panel6);

		ImageIcon nextBtnOffIcon = new ImageIcon(".\\img\\nextBtnOff.png");
		ImageIcon prevBtnOffIcon = new ImageIcon(".\\img\\prevBtnOff.png");
		ImageIcon nextBtnOnIcon = new ImageIcon(".\\img\\nextBtnOn.png");
		ImageIcon prevBtnOnIcon = new ImageIcon(".\\img\\prevBtnOn.png");

		panel1.nextBtn1.setIcon(nextBtnOffIcon);
		panel2.nextBtn2.setIcon(nextBtnOffIcon);
		panel3.nextBtn3.setIcon(nextBtnOffIcon);
		panel4.nextBtn4.setIcon(nextBtnOffIcon);
		panel5.nextBtn5.setIcon(nextBtnOffIcon);

		panel3.prevBtn3.setIcon(prevBtnOffIcon);
		panel4.prevBtn4.setIcon(prevBtnOffIcon);
		panel5.prevBtn5.setIcon(prevBtnOffIcon);
		panel6.prevBtn6.setIcon(prevBtnOffIcon);
		
		panel1.nextBtn1.setRolloverIcon(nextBtnOnIcon);
		panel2.nextBtn2.setRolloverIcon(nextBtnOnIcon);
		panel3.nextBtn3.setRolloverIcon(nextBtnOnIcon);
		panel4.nextBtn4.setRolloverIcon(nextBtnOnIcon);
		panel5.nextBtn5.setRolloverIcon(nextBtnOnIcon);

		panel3.prevBtn3.setRolloverIcon(prevBtnOnIcon);
		panel4.prevBtn4.setRolloverIcon(prevBtnOnIcon);
		panel5.prevBtn5.setRolloverIcon(prevBtnOnIcon);
		panel6.prevBtn6.setRolloverIcon(prevBtnOnIcon);

		panel1.nextBtn1.addActionListener(this);
		panel0.infoBtn.addActionListener(this);
		panel0.startBtn.addActionListener(this);
		panel2.nextBtn2.addActionListener(this);
		panel3.nextBtn3.addActionListener(this);
		panel4.nextBtn4.addActionListener(this);
		panel5.nextBtn5.addActionListener(this); 
		panel3.prevBtn3.addActionListener(this);
		panel4.prevBtn4.addActionListener(this);
		panel5.prevBtn5.addActionListener(this);
		panel6.prevBtn6.addActionListener(this);
		panel6.saveBtn.addActionListener(this);
		panel6.pageBtn.addActionListener(this);
		panel6.cardBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "start":
			panel0.setVisible(false);
			panel2.setVisible(true);
			break;
		case "info":
			panel0.setVisible(false);
			panel1.setVisible(true);
			break;
		case "next1":
			panel1.setVisible(false);
			panel2.setVisible(true);
			break;
		case "next2":
			panel2.setVisible(false);
			panel3.setVisible(true);
			break;

		case "next3":
			service.setUser(panel3);
			//파일이 있는지 확인하고 
			//1)존재하면  		새로시작(false) / 불러오기(true)
			//2)존재하지않으면  새로시작(false)
			
			//새로시작이든 불러오기인드 dao.setCarrier(carrier)
			//(직렬화시 요금테이블은 저장안함 역직렬화시 다시생성)
			
			if(service.isExistFile()) {
				//<불러오기>
				//panel5로 넘어감(Next4버튼에서 선택량입력제외)
				panel3.setVisible(false);
				panel5.setVisible(true);
				service.loadDAO();
				service.creatChoice(panel5);
				addChoice();
				showComponet(panel5.choiceV);
			} else {
				//<새로시작>
				panel3.setVisible(false);
				panel4.setVisible(true);
				service.creatDAO(panel3);
				addSelect();
				showComponet(panel4.select);	
			}
			break;
		case "next4":
			panel4.setVisible(false);
			panel5.setVisible(true);
			service.putMatchPlan(panel4);
			service.creatChoice(panel5);
			addChoice();
			showComponet(panel5.choiceV);	
			break;
		case "next5":
			panel5.setVisible(false);
			panel6.setVisible(true);
			service.putChoicePlan(panel5);
			service.creatResultTable(panel6);
			showResultTable();
			break;
		case "prev3":
			panel3.setVisible(false);
			panel2.setVisible(true);
			break;
		case "prev4":
			panel4.setVisible(false);
			panel3.setVisible(true);
			break;
		case "prev5":
			panel5.setVisible(false);
			panel4.setVisible(true);
			showComponet(panel4.select);	
			break;
		case "prev6":
			panel6.setVisible(false);
			panel5.setVisible(true);
			showComponet(panel5.choiceV);	
			break;
		case "page":
			service.linkCarrierPage();
			break;
		case "card":
			service.linkCardPage();
			break;
		case "text":
			service.saveText(panel6);
			break;
		}
	}
	public void	showComponet(Component[] comp) {
		for(int i=0; i<service.getMember();i++) {
			comp[i].setVisible(true);
		}
		for(int i=3; i>=service.getMember(); i--) {
			comp[i].setVisible(false);
		}
	}
//Next3 버튼
	public void	addSelect() {
		//이전버튼 누르고 구성원수 바꾸고 다시 다음버튼 누를시
		//새로추가되는거 방지
		panel4.subPanel4.removeAll();
		switch (service.getMember()) {
		case 1:
			panel4.subPanel4.setLayout(new GridLayout(1,1));
			break;
		case 2:
			panel4.subPanel4.setLayout(new GridLayout(1,2,70,70));
			break;
		case 3:
			panel4.subPanel4.setLayout(new GridLayout(1,3,20,20));
			break;
		case 4:
			panel4.subPanel4.setLayout(new GridLayout(2,2,30,30));
			break;
		}
		Font font = new Font("맑은 고딕", Font.BOLD, 30);
		for(int i = 0; i<service.getMember(); i++) {
			//인원수에 따라서 크기달라져서 재생성
			panel4.select[i] = new selectPanel4(service.getMember());
			TitledBorder title = new TitledBorder(service.memberName(i));
			title.setTitleFont(font);
			panel4.select[i].setBorder(title);
			panel4.subPanel4.add(panel4.select[i]);
		}
	}

//Next5버튼
	public void	addChoice() {
		//이전버튼 누르고 구성원수 바꾸고 다시 다음버튼 누를시
		//새로추가되는거 방지
		panel5.subPanel5.removeAll();
		int headerFontSize =0;
		int tableFontSize = 0;
		
		switch (service.getMember()) {
		case 1:
			panel5.subPanel5.setLayout(new GridLayout());
			headerFontSize =30;
			tableFontSize = 28;
			break;
		case 2:
			panel5.subPanel5.setLayout(new GridLayout(1,2,70,70));
			headerFontSize = 28;
			tableFontSize = 26;
			break;
		case 3:
			panel5.subPanel5.setLayout(new GridLayout(1,3,20,20));
			headerFontSize = 24;
			tableFontSize = 21;
			break;
		case 4:
			panel5.subPanel5.setLayout(new GridLayout(2,2,30,30));
			headerFontSize=26;
			tableFontSize = 23;
			break;
		}
		Font headerFont = new Font("맑은 고딕", Font.BOLD, headerFontSize);
		Font tableFont = new Font("맑은 고딕", Font.PLAIN, tableFontSize);
		for(int i=0; i<service.getMember();i++) {
			TitledBorder title = new TitledBorder(service.memberName(i));
			title.setTitleFont(new Font("맑은 고딕", Font.BOLD, 30));
			title.setTitle(service.memberName(i));
			
			panel5.choice[i].getTableHeader().setFont(headerFont);
			panel5.choice[i].getColumnModel().getColumn(0).setMinWidth(180);
			panel5.choice[i].setFont(tableFont);
			panel5.choiceV[i].setBorder(title);
			panel5.subPanel5.add(panel5.choiceV[i]);

		}
	}
//Next6버튼 : 결과출력
	public void	showResultTable() {
		//이전버튼 누르고 구성원수 바꾸고 다시 다음버튼 누를시
		//새로추가되는거 방지
		panel6.subPanel6.removeAll();
		String str = service.memberName(0).equals("대표자")? "" : service.memberName(0)+"님의 가족분들께 ";
		panel6.titleLabel.setText(str+"추천드립니다");
		panel6.table.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		panel6.table.getColumnModel().getColumn(1).setPreferredWidth(220);
		panel6.table.getColumnModel().getColumn(8).setPreferredWidth(100);		
		panel6.table.setRowHeight(47);
		panel6.table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 23));
		panel6.table.setPreferredScrollableViewportSize(panel6.table.getPreferredSize());
		panel6.table1 = new JScrollPane(panel6.table);
		panel6.table1.setBorder(BorderFactory.createEmptyBorder());
		panel6.addGrid(panel6.table1, 0, 0, 2, 1 ,1, 10);	
		panel6.addGrid(panel6.processLabel, 0, 1, 1, 3,1,1);	
		panel6.addGrid(panel6.pageBtn, 1, 1, 1, 1, 1, 1);	
		panel6.addGrid(panel6.cardBtn, 1, 2, 1, 1, 1, 1);	
		panel6.addGrid(panel6.saveBtn, 1, 3, 1, 1, 1, 1);	

	}
}








