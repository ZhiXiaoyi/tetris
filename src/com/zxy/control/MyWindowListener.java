package com.zxy.control;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

/**
 * ��Ϸ�����ڼ���
 * 
 * @author ������
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
		if (JOptionPane.showConfirmDialog(null, "ȷ���˳���", "�˳�", JOptionPane.YES_NO_OPTION) == 0)

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
