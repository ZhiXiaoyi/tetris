package com.zxy.control;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

/**
 * 游戏主窗口监听
 * 
 * @author 陈先生
 *
 */
public class MyWindowListener implements WindowListener {
	
	private GameControl gameControl;
	
	public MyWindowListener(GameControl gameControl) {
		this.gameControl = gameControl;
	}

	public void windowOpened(WindowEvent e) {

	}

	public void windowClosing(WindowEvent e) {
		if (JOptionPane.showConfirmDialog(null, "确定退出？", "退出", JOptionPane.YES_NO_OPTION) == 0)

			System.exit(0);

	}

	public void windowClosed(WindowEvent e) {

	}

	public void windowIconified(WindowEvent e) {

	}

	public void windowDeiconified(WindowEvent e) {

	}

	public void windowActivated(WindowEvent e) {
		if (gameControl.getGameDto().isPause())this.gameControl.keyForPause();
	}

	public void windowDeactivated(WindowEvent e) {
		if (gameControl.getGameDto().isPause()) {
		}else{
			this.gameControl.keyForPause();
		}
	
		
	}

}
