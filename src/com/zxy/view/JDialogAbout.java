package com.zxy.view;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ����-����С����
 * 
 * @author ������
 *
 */
@SuppressWarnings("serial")
public class JDialogAbout extends JDialog {
	private JDialog aboutDialog;
	private JPanel aboutPanel;
	private JLabel gName, gEdition, gCopyright, gAuthor, gLog;

	public JDialogAbout() {

		this.aboutJDialog();

	}

	// About����С����
	public void aboutJDialog() {

		aboutDialog = new JDialog();

		aboutPanel = new JPanel();

		aboutPanel.setPreferredSize(new Dimension(300, 300));

		ImageIcon imageIcon = new ImageIcon("graphics/game/log.png");
		Image img = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_FAST);
		imageIcon.setImage(img);
		gLog = new JLabel(imageIcon);

		aboutPanel.add(gLog);

		gName = new JLabel("����˹����Tetris");
		gName.setPreferredSize(new Dimension(300, 40));
		gName.setHorizontalAlignment(JLabel.HORIZONTAL);

		gEdition = new JLabel("�汾  VO.1");
		gEdition.setPreferredSize(new Dimension(300, 40));
		gEdition.setHorizontalAlignment(JLabel.HORIZONTAL);

		gCopyright = new JLabel("��Ȩ���� 2016 fuzhou JF160704");
		gCopyright.setPreferredSize(new Dimension(300, 40));
		gCopyright.setHorizontalAlignment(JLabel.HORIZONTAL);

		gAuthor = new JLabel("JF160704  ������");
		gAuthor.setHorizontalAlignment(JLabel.HORIZONTAL);
		gAuthor.setPreferredSize(new Dimension(300, 40));

		aboutPanel.add(gName);
		aboutPanel.add(gEdition);
		aboutPanel.add(gCopyright);
		aboutPanel.add(gAuthor);

		aboutDialog.setTitle("����");

		aboutDialog.add(aboutPanel);

		aboutDialog.pack();

		aboutDialog.setLocationRelativeTo(null);

		aboutDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// ���ò����Է��ں���
		aboutDialog.setModal(true);

		aboutDialog.setResizable(false);

	}

	// ------------get/set-----------------
	public JDialog getAboutDialog() {
		return aboutDialog;
	}

	public void setAboutDialog(JDialog aboutDialog) {
		this.aboutDialog = aboutDialog;
	}

}
