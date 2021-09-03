package com.sourcecode.front;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
public class Pn0Start extends JPanel {
	JButton startBtn;
	JLabel logoLabel ;
	JLabel titleLabel ;
	JButton infoBtn;
	public Pn0Start(){
		setBounds(0, 0, 1920, 1015);
		setLayout(null);
		startBtn = new JButton("시작하기");
		startBtn.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		startBtn.setBounds(840, 700, 250, 75);
		startBtn.setActionCommand("start");

		ImageIcon logoImg = new ImageIcon(getClass().getClassLoader().getResource("logo.png"));
		logoLabel = new JLabel();
		logoLabel.setIcon(logoImg);
		logoLabel.setBounds(530, 300, 894, 245); //위치 바꿔야됨
	

		titleLabel = new JLabel();
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		titleLabel.setText("알뜰폰으로 가족통신비 줄이기 프로젝트");
		titleLabel.setBounds(677, 550, 566, 50);
		
		ImageIcon infoImg = new ImageIcon(getClass().getClassLoader().getResource("infoBtn.png"));
//		infoBtn = new JButton(new ImageIcon(".\\img\\infoBtn.jpg"));
		infoBtn = new JButton();
		infoBtn.setIcon(infoImg);
		infoBtn.setActionCommand("info");
		infoBtn.setBounds(840, 810, 250, 50);
		add(startBtn);
		add(logoLabel);
		add(titleLabel);
		add(infoBtn);
		
				
	}
}
