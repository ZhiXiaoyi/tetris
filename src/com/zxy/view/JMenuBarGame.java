package com.zxy.view;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import com.zxy.control.GameControl;
import com.zxy.control.MyActionListener;

/**
 * 
 * ��Ϸ�Ĳ˵���
 * 
 * @author ������
 *
 */
@SuppressWarnings("serial")
public class JMenuBarGame extends JMenuBar {

	private JMenu game, help, star;// ��Ϸ����������ʼ
	private JRadioButtonMenuItem primary, middle, senior;// �������м����߼�
	private JMenuItem exit, about, custom;// �˳������ڣ��Զ���

	private MyActionListener action;

	private JDialogAbout mAboutJDialog;

	public JMenuBarGame(GameControl gameControl,JPanelGame gamePanel, JDialogCustom mCustomJDialog) {

		mAboutJDialog = new JDialogAbout();

		action = new MyActionListener(gameControl,gamePanel, this.mAboutJDialog, mCustomJDialog);

		this.myJMenuBar();

		this.menuActionListener();
	}

	private void myJMenuBar() {

		game = new JMenu("��Ϸ(G)");
		help = new JMenu("����(H)");
		star = new JMenu("����(S)");

		primary = new JRadioButtonMenuItem("����(p)");
		middle = new JRadioButtonMenuItem("�м�(M)");
		senior = new JRadioButtonMenuItem("�߼�(S)");

		ButtonGroup btng = new ButtonGroup();
		btng.add(primary);
		btng.add(middle);
		btng.add(senior);

		exit = new JMenuItem("�˳�(E)");
		about = new JMenuItem("����(A)");
		custom = new JMenuItem("�Զ���(C)");

		star.add(primary);
		star.add(middle);
		star.add(senior);
		game.add(star);
		game.add(custom);
		game.add(exit);
		this.add(game);

		help.add(about);
		this.add(help);

	}

	// ���û����
	private void menuActionListener() {

		primary.setActionCommand("P");
		primary.addActionListener(action);

		middle.setActionCommand("M");
		middle.addActionListener(action);

		senior.setActionCommand("S");
		senior.addActionListener(action);

		custom.setActionCommand("C");
		custom.addActionListener(action);

		exit.setActionCommand("E");
		exit.addActionListener(action);

		about.setActionCommand("A");
		about.addActionListener(action);
	}
}
