package com.sourcecode.front;


import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class Pn2Benefit extends JPanel{

	JLabel titleLabel ;
	JPanel subPanel2;
	JButton nextBtn2;
	JProgressBar progress;

	
	public Pn2Benefit(){
		setBounds(0, 0, 1920, 1015);
		setVisible(false);
		setLayout(new BorderLayout());		
		subPanel2 = new JPanel();
		subPanel2.setLayout(null);
		titleLabel = new JLabel("기대효과"); //제목부분
		
		nextBtn2 = new JButton();
		nextBtn2.setActionCommand("next2");

		nextBtn2.setBorderPainted(false);
		nextBtn2.setContentAreaFilled(false);
		nextBtn2.setFocusPainted(false);
		progress = new JProgressBar();
		progress.setValue(10);
	
		add(progress, BorderLayout.SOUTH);
		add(nextBtn2,BorderLayout.EAST);
		add(subPanel2,BorderLayout.CENTER); 
		add(titleLabel,BorderLayout.NORTH);
		
		
	}


}
