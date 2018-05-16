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
 * ��Ϸ�������
 * 
 * @author ������
 *
 */
@SuppressWarnings("serial")
public class JFrameGame extends JFrame {

	private boolean focusFlag = false; // �Ƿ��ý�����ж�

	private MyWindowListener mWindowListener;

	private JPanelGame gamePanel;
	
	private GameControl gameControl;

	/**
	 * ����JFrame������
	 */
	public JFrameGame(GameControl gameControl,JPanelGame gamePanel, JMenuBarGame gameMenBar) {
		
		this.gameControl = gameControl;

		this.gamePanel = gamePanel;

		// ��Ӳ˵���
		this.setJMenuBar(gameMenBar);

		mWindowListener = new MyWindowListener(this.gameControl);
		// ��Ӵ��ڼ���
		this.addWindowListener(mWindowListener);
		
		// �����Ϸ����
		GameConfig cfg = ConfigFactory.getGameConfig();

		this.setTitle(cfg.getTitle());

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// ���ô��ڴ�С
		this.setSize(cfg.getWidth(), cfg.getHeight());

		// ������ı䴰�ڴ�С
		this.setResizable(false);

		// �������
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = screen.width - this.getWidth() >> 1;
		int y = screen.height - this.getHeight() >> 1;
		this.setLocation(x, y);

		// Ĭ��Panel
		this.setContentPane(this.gamePanel);

		// Ĭ�ϸĴ���Ϊ��ʾ
		this.setVisible(true);

	}

}
