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
 * 游戏的菜单栏
 * 
 * @author 陈先生
 *
 */
@SuppressWarnings("serial")
public class JMenuBarGame extends JMenuBar {

	private JMenu game, help, star;// 游戏，帮助，开始
	private JRadioButtonMenuItem primary, middle, senior;// 初级，中级，高级
	private JMenuItem exit, about, custom;// 退出，关于，自定义

	private MyActionListener action;

	private JDialogAbout mAboutJDialog;

	public JMenuBarGame(GameControl gameControl,JPanelGame gamePanel, JDialogCustom mCustomJDialog) {

		mAboutJDialog = new JDialogAbout();

		action = new MyActionListener(gameControl,gamePanel, this.mAboutJDialog, mCustomJDialog);

		this.myJMenuBar();

		this.menuActionListener();
	}

	private void myJMenuBar() {

		game = new JMenu("游戏(G)");
		help = new JMenu("帮助(H)");
		star = new JMenu("开局(S)");

		primary = new JRadioButtonMenuItem("初级(p)");
		middle = new JRadioButtonMenuItem("中级(M)");
		senior = new JRadioButtonMenuItem("高级(S)");

		ButtonGroup btng = new ButtonGroup();
		btng.add(primary);
		btng.add(middle);
		btng.add(senior);

		exit = new JMenuItem("退出(E)");
		about = new JMenuItem("关于(A)");
		custom = new JMenuItem("自定义(C)");

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

	// 设置活动监听
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
