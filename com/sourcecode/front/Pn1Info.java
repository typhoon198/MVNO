package com.sourcecode.front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class Pn1Info extends JPanel {
	JLabel titleLabel ;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JPanel subPanel1;
	JButton nextBtn1;
	JTextArea text;
	JButton news1Btn;
	JButton news2Btn;
	JButton news3Btn;
	JProgressBar progress;

	Pn1Info(){
		setBounds(0, 0, 1920, 1015);
		setBackground(new Color(238,240,242));
		setVisible(false);
		setLayout(new BorderLayout());

		subPanel1 = new JPanel();
		subPanel1.setLayout(null);
		subPanel1.setBackground(new Color(238,240,242));//중간에 패널 들어옴 블루로 확인
		subPanel1.setVisible(true); 
	
		titleLabel = new JLabel("알뜰폰 더 알아보기"); //제목부분

		label2 = new JLabel( new ImageIcon(".\\img\\goodbad.png"));
		label2.setBounds(160, 400, 1605,520); 		
		subPanel1.add(label2);
		
		nextBtn1 = new JButton();
		nextBtn1.setActionCommand("next1");

		nextBtn1.setBorderPainted(false);
		nextBtn1.setContentAreaFilled(false);
		nextBtn1.setFocusPainted(false);
		
		news1Btn = new JButton( new ImageIcon(".\\img\\news1.png"));
		news2Btn = new JButton(new ImageIcon(".\\img\\news2.png"));
		news3Btn = new JButton(new ImageIcon(".\\img\\news3.png"));
		news1Btn.setActionCommand("news1");
		news2Btn.setActionCommand("news2");
		news3Btn.setActionCommand("news3");
		
		news1Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime runtime = Runtime.getRuntime();
					runtime.exec("explorer.exe https://url.kr/bxps4k");
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "인터넷 브라우저를  찾지못했습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		news2Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime runtime = Runtime.getRuntime();
					runtime.exec("explorer.exe https://url.kr/erw3dy");
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "인터넷 브라우저를  찾지못했습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		news3Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime runtime = Runtime.getRuntime();
					runtime.exec("explorer.exe https://url.kr/64xied");
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "인터넷 브라우저를  찾지못했습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		news1Btn.setBounds(1220,22,550,115);
		news2Btn.setBounds(1220,132,550,102);
		news3Btn.setBounds(1220,232,550,102);
		
		subPanel1.add(news1Btn);
		subPanel1.add(news2Btn);
		subPanel1.add(news3Btn);
			
		label3 = new JLabel(new ImageIcon(".\\img\\mvno.png"));
		label3.setBounds(85, 22, 1096, 310); 
		subPanel1.add(label3);
		
		progress = new JProgressBar();
		progress.setValue(0);
		
		add(progress, BorderLayout.SOUTH);
		add(nextBtn1,BorderLayout.EAST);
		add(subPanel1,BorderLayout.CENTER); 
		add(titleLabel,BorderLayout.NORTH);
		

	}
	
	
}

