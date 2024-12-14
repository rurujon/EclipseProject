package com.day20;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Test1 extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lbl;
	
	public Test1() {
		
		lbl = new JLabel("메세지",JLabel.CENTER);
		add(lbl);
		
		//메뉴 추가
		JMenuBar mbar = new JMenuBar();
		JMenu menu;
		JMenuItem mi;
		
		menu = new JMenu("메세지대화상자");
		
		mi = new JMenuItem("메세지");
		menu.add(mi);
		mi.addActionListener(this);
		
		mi = new JMenuItem("입력");
		menu.add(mi);
		mi.addActionListener(this);
		
		mi = new JMenuItem("종료");
		menu.add(mi);
		mi.addActionListener(this);
		
		mbar.add(menu);
		
		setJMenuBar(mbar);
		
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		setTitle("대화상자");
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		
		new Test1();

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		String str = evt.getActionCommand();
		
		if(str.equals("메세지")) {
			
			JOptionPane.showMessageDialog(this, "오늘은 금요일", "불금", JOptionPane.INFORMATION_MESSAGE);
			//showMessageDialog : 메시지를 가지고 있다 필요한 때에 호출한다.
			
		}
		else if(str.equals("입력")) {
			
			String age = JOptionPane.showInputDialog(this,"나이?","당신의 나이는?",JOptionPane.QUESTION_MESSAGE);
			lbl.setText("당신의 나이는 " + age + "살입니다.");
			
			
		}
		else if(str.equals("종료")) {
			
			int result;
			
			result = JOptionPane.showConfirmDialog(this, "프로그램을 종료하시겠습니까?", "종료확인", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			
			lbl.setText(Integer.toString(result));
			
			if(result==JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}
			
		}
	}
	

}
