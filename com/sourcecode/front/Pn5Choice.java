package com.sourcecode.front;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class Pn5Choice extends JPanel{
	public JLabel titleLabel;
	public JPanel subPanel5;
	public JButton nextBtn5;
	public JButton prevBtn5;
	public JTable[] choice = new JTable[4];
	public JScrollPane[] choiceV = new JScrollPane[4];
	JProgressBar progress;

	public Pn5Choice() {
		setBounds(0, 0, 1920, 1015);
		setVisible(false);
		setLayout(new BorderLayout());
		subPanel5 = new JPanel();
		titleLabel = new JLabel("구성원별 요금제 선택");
		nextBtn5 = new JButton();
		prevBtn5 = new JButton();
		nextBtn5.setActionCommand("next5");
		prevBtn5.setActionCommand("prev5");
		prevBtn5.setBorderPainted(false);
		prevBtn5.setContentAreaFilled(false);
		prevBtn5.setFocusPainted(false);
		nextBtn5.setBorderPainted(false);
		nextBtn5.setContentAreaFilled(false);
		nextBtn5.setFocusPainted(false);
		
		//null예외 방지
		for(int i=0; i<4; i++) {
			choice[i] = new JTable() {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			choice[i].setRowHeight(45);
			choice[i].setFillsViewportHeight(true);
			choice[i].setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			choiceV[i] = new JScrollPane(choice[i]);
		}
		progress = new JProgressBar();
		progress.setValue(80);
		add(titleLabel, BorderLayout.NORTH);
		add(subPanel5, BorderLayout.CENTER);
		add(nextBtn5, BorderLayout.EAST);
		add(prevBtn5, BorderLayout.WEST);
		add(progress, BorderLayout.SOUTH);
	}

}
