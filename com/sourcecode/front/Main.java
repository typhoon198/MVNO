package com.sourcecode.front;
import java.awt.EventQueue;

public class Main {
	public Main() {
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainFrame frame = new MainFrame();
					frame.setVisible(true);;
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args) {
		new Main();
	}


}

