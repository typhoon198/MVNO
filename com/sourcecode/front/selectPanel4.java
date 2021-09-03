package com.sourcecode.front;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class selectPanel4  extends JPanel{
	int btnFontSize;
	int titleFontSize;
	int textAreaFontSize;
	String speedText0;
	String speedText1;
	String speedText2;
	String speedText3;
	Font titleFont;
	Font areaFont;
	Font btnFont ;
	JLabel voiceTitle;
	JLabel dataTitle;
	JTextArea speedTextArea;
	ColorToggleButton[] voiceBtn;
	ColorToggleButton[] dataBtn ;
	GridBagLayout gbl;
	GridBagConstraints gbcL;
	GridBagConstraints gbcB;
	public ButtonGroup groupVoice;
	public ButtonGroup groupData;
	public selectPanel4(){
	}
	public selectPanel4(int member){
		gbl = new GridBagLayout();
		setLayout(gbl);
		gbcL = new GridBagConstraints();	
		gbcL.fill= GridBagConstraints.BOTH;
		gbcL.insets = new Insets(2,2,2,2);
		gbcB = new GridBagConstraints();
		gbcB.fill= GridBagConstraints.BOTH;

		//버튼간의 간격, 버튼 안 여백조정,글씨크기 조정
		switch (member) {
		case 1:
			gbcB.insets = new Insets(8,8,8,8);
			gbcB.ipadx = 60;
			gbcB.ipady = 80;
			btnFontSize = 24;
			titleFontSize = 25;
			textAreaFontSize= 20;
			break;
		case 2:
			gbcB.insets = new Insets(6,6,6,6);
			gbcB.ipadx = 40;
			gbcB.ipady = 60;
			btnFontSize = 23;
			titleFontSize = 24;
			textAreaFontSize= 18;
			break;
		case 3:
			gbcB.insets = new Insets(2,2,2,2);
			gbcB.ipadx = 5;
			gbcB.ipady = 30;
			btnFontSize = 20;
			titleFontSize = 23;
			textAreaFontSize= 14;
			break;
		case 4:
			gbcB.insets = new Insets(3,3,3,3);
			gbcB.ipadx = 17;
			gbcB.ipady = 25;
			btnFontSize = 17;
			titleFontSize = 20;
			textAreaFontSize= 15;
			break;
		}
		
		titleFont = new Font("맑은 고딕", Font.BOLD, titleFontSize);
		areaFont = new Font("맑은 고딕", Font.PLAIN, textAreaFontSize) ;
		btnFont = new Font("맑은 고딕", Font.PLAIN, btnFontSize);

		voiceTitle = new JLabel("※ 통화");
		voiceTitle.setFont(titleFont);
		voiceBtn = new ColorToggleButton[4];
		dataBtn = new ColorToggleButton[4];
		dataTitle = new JLabel("<html><br/>※ 데이터</html>");
		dataTitle.setFont(titleFont);

		speedText0=	"-월 요금> 3,630원~11,000원(1년 한정 0원 프로모션)\n"
				+ "-월 데이터 제공량> 2.5GB이하\n"
				+ "-카카오 메세지 보낼때만 사용하는경우\n"
				+ "-공기계에 유심꽂아서 업무폰,네비폰,명부기입폰으로 사용가능";
		
		speedText1="-월 요금> 8,800원~18,900원\n"
				+ "-월 데이터 제공량> 3GB~10GB\n"
				+ "-이동할때만 조금씩 와이파이가 보이면 재빠르게 모드전환\n"
				+ " (이동반경에 와이파이존 구축이 잘 되어 있을시 유리)";
		
		speedText2="-월 요금> 12,100원~24,200원\n"
				+ "-월 데이터 제공량> 5GB~12GB\n"
				+ "-소진시 1mbps속도로 무제한 사용(텍스트 웹서핑,SNS 5초 로딩)\n"
				+ "-2020년 대한민국 평균 데이터 사용량 10GB";
		
		speedText3="-월 요금> 25,300원~33,000원\n"
				+ "-월 데이터 제공량>15GB~170GB\n"
				+ "-15GB소진시 속도제한 3mps(Youtube 480p 되감기 로딩 없음)\n"
				+ "-65GB소진시 속도제한 5mps(Youtube 720p 되감기 로딩없음)";
		
		speedTextArea = new JTextArea(5,30);
		speedTextArea.setText(speedText3);
		speedTextArea.setEditable(false);
		speedTextArea.setBackground(null);
		speedTextArea.setFont(areaFont);

		groupVoice = new ButtonGroup();
		groupData = new ButtonGroup();
		String[] voiceStr = {"100분","200분","<html>커플<br/>(1회선)</html>","무제한"};
		String[] dataStr = {"실속","가성비", "<html>느리지만<br />마음껏</html>","무제한"};

		addL(voiceTitle, 0, 0, 1, 1);
		for(int i = 0; i<4; i++) {
			voiceBtn[i] = new ColorToggleButton(voiceStr[i]);
			voiceBtn[i].setActionCommand(String.valueOf(i));
			voiceBtn[i].setFont(btnFont);
			voiceBtn[i].setHorizontalTextPosition(SwingConstants.CENTER);
			groupVoice.add(voiceBtn[i]);
			addB(voiceBtn[i], i, 1, 1, 1);
		}
		addL(dataTitle,0, 2, 1, 1);

		for(int i = 0; i<4; i++) {
			dataBtn[i] = new ColorToggleButton(dataStr[i]);
			dataBtn[i].setActionCommand(String.valueOf(i));
			dataBtn[i].setFont(btnFont);
			dataBtn[i].setHorizontalTextPosition(SwingConstants.CENTER);
			groupData.add(dataBtn[i]);
			dataBtn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					switch (e.getActionCommand()) {
					case "0":
						speedTextArea.setText(speedText0);
							break;
					case "1":
						speedTextArea.setText(speedText1);
						break;
					case "2":
						speedTextArea.setText(speedText2);
						break;
					case "3":
						speedTextArea.setText(speedText3);
						break;
					}
				}
			});
			addB(dataBtn[i], i, 3, 1, 1);
		}
		addL(speedTextArea, 0, 4, 4, 1);
		voiceBtn[3].setSelected(true);
		dataBtn[3].setSelected(true);
	}
	public void addL(Component c, 
			int gridx, int gridy, int gridwidth, int gridheight){
		gbcL.gridx = gridx;
		gbcL.gridy = gridy;
		gbcL.gridwidth = gridwidth;
		gbcL.gridheight = gridheight;
		gbl.setConstraints(c, gbcL);
		add(c);
	}
	public void addB(Component c, 
			int gridx, int gridy, int gridwidth, int gridheight){
		gbcB.gridx = gridx;
		gbcB.gridy = gridy;
		gbcB.gridwidth = gridwidth;
		gbcB.gridheight = gridheight;
		gbl.setConstraints(c, gbcB);
		add(c);
	}
}
class ColorToggleButton extends JToggleButton{
	public ColorToggleButton(String string) {
		super(string);
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
	}
}

