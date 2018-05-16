package com.zxy.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.zxy.view.JDialogAbout;
import com.zxy.view.JDialogCustom;
import com.zxy.view.JPanelGame;

/**
 * �˵�����ť����
 * 
 * @author ������
 *
 */
public class MyActionListener implements ActionListener {

	private JDialogAbout mAboutJDialog;
	private JDialogCustom mCustomJDialog;

	private JPanelGame gamePanel;
	private GameControl gameControl;

	public MyActionListener(GameControl gameControl, JPanelGame gamePanel, JDialogAbout mJDialog,
			JDialogCustom mCustomJDialog) {

		this.gamePanel = gamePanel;

		this.mAboutJDialog = mJDialog;

		this.mCustomJDialog = mCustomJDialog;

		this.gameControl = gameControl;
	}

	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand().charAt(0)) {
		case 'P':
			this.gamePanel.getGameDto().SPEED = 500;
			this.gamePanel.getGameDto().MAX_TYPE = 6;
			gameControl.star();
			// System.out.println("����");
			break;
		case 'M':
			this.gamePanel.getGameDto().SPEED = 300;
			this.gamePanel.getGameDto().MAX_TYPE = 7;
			gameControl.star();
			// System.out.println("�м�");
			break;
		case 'S':
			this.gamePanel.getGameDto().SPEED = 100;
			this.gamePanel.getGameDto().MAX_TYPE = 8;
			gameControl.star();
			// System.out.println("�߼�");
			break;
		case 'C':
			mCustomJDialog.getCustomDialog().setVisible(true);
			break;
		case 'E':
			// System.out.println("�˳�");
			if (JOptionPane.showConfirmDialog(null, "ȷ���˳���", "�˳�", JOptionPane.YES_NO_OPTION) == 0)
				System.exit(0);
			break;
		case 'A':
			mAboutJDialog.getAboutDialog().setVisible(true);
			break;

		default:
			break;
		}

	}

}
