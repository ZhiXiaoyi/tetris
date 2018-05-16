package com.zxy.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;

import com.zxy.config.ConfigFactory;
import com.zxy.config.GameConfig;
import com.zxy.control.GameControl;
import com.zxy.control.MyWindowListener;

/**
 * 游戏的主框架
 * 
 * @author 陈先生
 *
 */
@SuppressWarnings("serial")
public class JFrameGame extends JFrame {

	private boolean focusFlag = false; // 是否获得焦点的判断

	private MyWindowListener mWindowListener;

	private JPanelGame gamePanel;
	
	private GameControl gameControl;

	/**
	 * 设置JFrame的属性
	 */
	public JFrameGame(GameControl gameControl,JPanelGame gamePanel, JMenuBarGame gameMenBar) {
		
		this.gameControl = gameControl;

		this.gamePanel = gamePanel;

		// 添加菜单栏
		this.setJMenuBar(gameMenBar);

		mWindowListener = new MyWindowListener(this.gameControl);
		// 添加窗口监听
		this.addWindowListener(mWindowListener);
		
		// 获得游戏配置
		GameConfig cfg = ConfigFactory.getGameConfig();

		this.setTitle(cfg.getTitle());

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// 设置窗口大小
		this.setSize(cfg.getWidth(), cfg.getHeight());

		// 不允许改变窗口大小
		this.setResizable(false);

		// 桌面居中
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = screen.width - this.getWidth() >> 1;
		int y = screen.height - this.getHeight() >> 1;
		this.setLocation(x, y);

		// 默认Panel
		this.setContentPane(this.gamePanel);

		// 默认改窗口为显示
		this.setVisible(true);

	}

}
