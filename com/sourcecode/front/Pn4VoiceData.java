package com.sourcecode.front;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

public class Pn4VoiceData extends JPanel {
	public selectPanel4[] select = new selectPanel4[4];
	public JPanel subPanel4;
	public JButton nextBtn4;
	public JButton prevBtn4;
	public JLabel titleLabel;
	JProgressBar progress;

	public Pn4VoiceData() {
		setBounds(0, 0, 1920, 1015);
		setVisible(false);
		setLayout(new BorderLayout());
		subPanel4 = new JPanel();

		titleLabel = new JLabel("구성원별 사용량 선택");
		nextBtn4 = new JButton();
		nextBtn4.setActionCommand("next4");
		prevBtn4 = new JButton();
		prevBtn4.setActionCommand("prev4");
		progress = new JProgressBar();
		prevBtn4.setBorderPainted(false);
		prevBtn4.setContentAreaFilled(false);
		prevBtn4.setFocusPainted(false);
		nextBtn4.setBorderPainted(false);
		nextBtn4.setContentAreaFilled(false);
		nextBtn4.setFocusPainted(false);
		progress.setValue(60);
		add(titleLabel, BorderLayout.NORTH);
		add(subPanel4, BorderLayout.CENTER);
		add(nextBtn4, BorderLayout.EAST);
		add(prevBtn4, BorderLayout.WEST);
		add(progress, BorderLayout.SOUTH);

		//null예외 방지
		for(int i = 0; i<4; i++) {
			select[i] = new selectPanel4();
		}
	}
}

