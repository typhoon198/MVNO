package com.sourcecode.front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Pn3Member extends JPanel{
	int num = 1;
	JPanel subPanel3;
	ImageIcon icon;
	JLabel icon0; 
	JLabel icon1; 
	JLabel icon2; 
	JLabel icon3;
	JLabel preview;
	JLabel label1;
	JButton btnM;
	JButton btnP;
	JButton logokt; //성호
	JButton logofreet;
	JButton logosky;
	JButton logolg;
	JButton logosk;
	JButton logohello; //여기까지 버튼추가
	
	JProgressBar progress;
 
	public JTextField[] nameField = new JTextField[4];
	public ButtonGroup group;
	public JLabel numField;
	public JLabel titleLabel;
	public JButton nextBtn3;
	public JButton prevBtn3;
	
	public Pn3Member(){
		setBounds(0, 0, 1920, 1015);
		setLayout(new BorderLayout());		
		setVisible(false);
		subPanel3 = new JPanel();
		subPanel3.setLayout(null);

		nameField[0] = new JTextField("대표자");
		nameField[0].setBounds(210, 450, 180, 50);
		nameField[0].setColumns(10);
		nameField[0].setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		nameField[0].setHorizontalAlignment(JTextField.CENTER);
		nameField[0].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				nameField[0].setText("");
			}
		});
		Font font = new Font("맑은 고딕", Font.PLAIN, 50);
		btnM = new JButton("-");
		btnM.setBounds(330, 680, 110, 110);
		btnM.setFont(font);
		btnM.setBackground(new Color(221,226,231));

		btnP = new JButton("+");
		btnP.setBounds(180, 680, 110, 110);
		btnP.setFont(font);
		btnP.setBackground(new Color(221,226,231));
		
		label1 = new JLabel("명");
		label1.setBounds(340, 510, 150, 150);
		label1.setFont(font);
		
		font  = new Font("맑은 고딕", Font.PLAIN, 110);
		numField = new JLabel("1");
		numField.setBounds(220, 500, 150,150);
		numField.setFont(font);
		numField.setHorizontalAlignment(JLabel.CENTER);
		subPanel3.add(numField);
		
		font = new Font("맑은 고딕", Font.PLAIN, 20);
		for(int i=1; i<4; i++) {
			nameField[i] = new JTextField("구성원"+i);
			nameField[i].setBounds(625, 250*i, 130, 38);
			nameField[i].setColumns(10);
			nameField[i].setHorizontalAlignment(JTextField.CENTER);
			nameField[i].setFont(font);
		}

		nameField[1].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				nameField[1].setText("");
			}
		});
		nameField[2].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				nameField[2].setText("");
			}
		});
		nameField[3].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				nameField[3].setText("");
			}
		});

		
		icon0 = new JLabel(new ImageIcon(".\\img\\icon.png"));
		icon0.setBounds(110, 10, 359, 517);
		icon1 = new JLabel(new ImageIcon(".\\img\\member1icon.png"));
		icon1.setBounds(570, 80, 236, 237);
		icon2 = new JLabel(new ImageIcon(".\\img\\member2icon.png"));
		icon2.setBounds(570, 330, 236, 237);
		icon3 = new JLabel(new ImageIcon(".\\img\\member3icon.png"));
		icon3.setBounds(570, 580, 236, 237);
		//성호 : 여기서부터
		
		preview = new JLabel("요금제 미리보기");
		preview.setBounds(1400, 40, 300, 40);
		preview.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		
		logosk= new JButton(new ImageIcon(".\\img\\logosk.png"));   
		logosk.setBounds(1400,95,200,40);
		logosk.setActionCommand("logosk");
		
		logosky= new JButton(new ImageIcon(".\\img\\logosky.png"));
		logosky.setBounds(1400,140,200,40);
		logosky.setActionCommand("logosky");
		
		logohello= new JButton(new ImageIcon(".\\img\\logohello.png"));
		logohello.setBounds(1400,185,200,40);
		logohello.setActionCommand("logohello");
		
		logofreet = new JButton(new ImageIcon(".\\img\\logofreet.png"));
		logofreet.setBounds(1400,230,200,40);
		logofreet.setActionCommand("logofreet");
		
		logokt = new JButton(new ImageIcon(".\\img\\logokt.png"));
		logokt.setBounds(1400,440,200,40);
		logokt.setActionCommand("logokt");

		logolg= new JButton(new ImageIcon(".\\img\\logolg.png"));
		logolg.setBounds(1400,730,200,40);
		logolg.setActionCommand("logolg");
	
		logosk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime runtime = Runtime.getRuntime();
					runtime.exec("explorer.exe https://url.kr/3rdq8h");
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "인터넷 브라우저를  찾지못했습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		logosky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime runtime = Runtime.getRuntime();
					runtime.exec("explorer.exe https://shop.skylife.co.kr/mvno/usimPayPlan.do");
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "인터넷 브라우저를  찾지못했습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		logohello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime runtime = Runtime.getRuntime();
					runtime.exec("explorer.exe https://url.kr/31mfys");
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "인터넷 브라우저를  찾지못했습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		logofreet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime runtime = Runtime.getRuntime();
					runtime.exec("explorer.exe https://url.kr/hwciqk");
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "인터넷 브라우저를  찾지못했습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		logokt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime runtime = Runtime.getRuntime();
					runtime.exec("explorer.exe https://url.kr/frajyi");
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "인터넷 브라우저를  찾지못했습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		logolg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime runtime = Runtime.getRuntime();
					runtime.exec("explorer.exe https://url.kr/vnxh24");
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "인터넷 브라우저를  찾지못했습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
			}
		});//여기까지 성호
		
		
		//기본값이 1명이니깐 일단 안보이게
		icon1.setVisible(false);
		icon2.setVisible(false);
		icon3.setVisible(false);
		nameField[1].setVisible(false);
		nameField[2].setVisible(false);
		nameField[3].setVisible(false);

		//플러스 버튼
		btnP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(num<4) {					
					switch (num) {
					case 1:
						nameField[1].setVisible(true);
						icon1.setVisible(true);
						break;
					case 2:
						nameField[2].setVisible(true);
						icon2.setVisible(true);
						break;
					case 3:
						nameField[3].setVisible(true);
						icon3.setVisible(true);
						break;
					default:
						break;
					}
					numField.setText(String.valueOf(++num));
				}
			}
		});
		//마이너스버튼
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(num>1) {					
					switch (num) {
					case 4:
						nameField[3].setVisible(false);
						icon3.setVisible(false);
						break;
					case 3:
						nameField[2].setVisible(false);
						icon2.setVisible(false);
						break;
					case 2:
						nameField[1].setVisible(false);
						icon1.setVisible(false);
						break;
					default:
						break;
					}
					numField.setText(String.valueOf(--num));
				}
			}
		});
		group = new	ButtonGroup();
		JToggleButton etc = new JToggleButton();
		etc.setBounds(1000, 40, 386, 287);   //성호 x좌표값 바꿈 1100-100 밑에도 다
		etc.setIcon(new ImageIcon(".\\img\\etc.png"));
		etc.setSelectedIcon(new ImageIcon(".\\img\\etcon.png"));
		etc.setActionCommand("etc");

		JToggleButton kt = new JToggleButton();
		kt.setBounds(1000, 330, 386, 287);
		kt.setIcon(new ImageIcon(".\\img\\kt.png"));
		kt.setSelectedIcon(new ImageIcon(".\\img\\kton.png"));
		kt.setActionCommand("kt");
		
		JToggleButton lg = new JToggleButton();
		lg.setBounds(1000, 620, 386, 287);
		lg.setIcon(new ImageIcon(".\\img\\lg.png"));
		lg.setSelectedIcon(new ImageIcon(".\\img\\lgon.png"));
		lg.setActionCommand("lg");

		lg.setBorderPainted(false);
		lg.setContentAreaFilled(false);
		kt.setBorderPainted(false);
		kt.setContentAreaFilled(false);
		etc.setBorderPainted(false);
		etc.setContentAreaFilled(false);
	
		etc.setSelected(true);
		//kt기본선택

		group.add(etc);
		group.add(lg);
		group.add(kt);
		
		subPanel3.add(etc);
		subPanel3.add(lg);
		subPanel3.add(kt);
		subPanel3.add(btnM);
		subPanel3.add(btnP);
		subPanel3.add(nameField[0]);
		subPanel3.add(nameField[1]);
		subPanel3.add(nameField[2]);
		subPanel3.add(nameField[3]);
		subPanel3.add(label1);
		subPanel3.add(icon0);
		subPanel3.add(icon1);
		subPanel3.add(icon2);
		subPanel3.add(icon3);
		subPanel3.add(preview);
		subPanel3.add(logosk); //성호
		subPanel3.add(logokt);
		subPanel3.add(logosky);
		subPanel3.add(logofreet);
		subPanel3.add(logohello);
		subPanel3.add(logolg); //여기까지 성호
	
		titleLabel = new JLabel();
		titleLabel.setText("가족구성원 및  희망통신사 선택");
		progress = new JProgressBar();
		progress.setValue(20);
		nextBtn3 = new JButton();
		nextBtn3.setActionCommand("next3");
		prevBtn3 = new JButton();
		prevBtn3.setActionCommand("prev3");
		prevBtn3.setBorderPainted(false);
		prevBtn3.setContentAreaFilled(false);
		prevBtn3.setFocusPainted(false);
		nextBtn3.setBorderPainted(false);
		nextBtn3.setContentAreaFilled(false);
		nextBtn3.setFocusPainted(false);
		add(titleLabel, BorderLayout.NORTH);
		add(subPanel3, BorderLayout.CENTER);
		add(nextBtn3, BorderLayout.EAST);
		add(prevBtn3, BorderLayout.WEST);
		add(progress, BorderLayout.SOUTH);
		
	}
}