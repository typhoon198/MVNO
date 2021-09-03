package com.sourcecode.front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Pn6Result  extends JPanel{
	public JLabel processLabel;
	public JButton cardBtn;
	public JButton saveBtn;
	public JButton pageBtn;
	public GridBagLayout gbl;
	public GridBagConstraints gbc;
	public JButton prevBtn6;
	public JPanel subPanel6;
	public JTable table;
	public JScrollPane table1; 
	public JLabel titleLabel;
	public JProgressBar progress;


	public Pn6Result(){
		setBounds(0, 0, 1920, 1015);
		setVisible(false);
		setLayout(new BorderLayout());		
		subPanel6 = new JPanel();

		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		gbc.fill= GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);        
        subPanel6.setLayout(gbl);

        Color color = new Color(221,226,231);
        
		processLabel = new JLabel();
		processLabel.setIcon( new ImageIcon(".\\img\\process.png"));
		processLabel.setSize(getPreferredSize());
		Font font = new Font("맑은 고딕", Font.BOLD, 30);
		pageBtn = new JButton("추천통신사 홈페이지");
		pageBtn.setActionCommand("page");
		pageBtn.setFont(font);
		pageBtn.setBackground(color);
		cardBtn = new JButton("제휴카드 알아보기");
		cardBtn.setActionCommand("card");
		cardBtn.setFont(font);
		cardBtn.setBackground(color);

		saveBtn = new JButton("메모장파일로 저장");
		saveBtn.setActionCommand("text");
		saveBtn.setFont(font);
		saveBtn.setBackground(color);

		table = new JTable();
		table.setColumnSelectionAllowed(true);
		
		titleLabel = new JLabel();
		prevBtn6 = new JButton();
		prevBtn6.setActionCommand("prev6");
		prevBtn6.setBorderPainted(false);
		prevBtn6.setContentAreaFilled(false);
		prevBtn6.setFocusPainted(false);
		progress = new JProgressBar();
		progress.setValue(100);
		add(titleLabel, BorderLayout.NORTH);
		add(prevBtn6, BorderLayout.WEST);
		add(subPanel6, BorderLayout.CENTER);
		add(progress, BorderLayout.SOUTH);
	}

	public void addGrid(Component c, 
			int gridx, int gridy, int gridwidth, int gridheight,
			int weightx, int weighty){
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbl.setConstraints(c, gbc);
		subPanel6.add(c);
	}

}
