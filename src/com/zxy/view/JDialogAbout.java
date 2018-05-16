package com.zxy.view;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 帮助-关于小窗口
 * 
 * @author 陈先生
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

	// About关于小窗口
	public void aboutJDialog() {

		aboutDialog = new JDialog();

		aboutPanel = new JPanel();

		aboutPanel.setPreferredSize(new Dimension(300, 300));

		ImageIcon imageIcon = new ImageIcon("graphics/game/log.png");
		Image img = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_FAST);
		imageIcon.setImage(img);
		gLog = new JLabel(imageIcon);

		aboutPanel.add(gLog);

		gName = new JLabel("俄罗斯方块Tetris");
		gName.setPreferredSize(new Dimension(300, 40));
		gName.setHorizontalAlignment(JLabel.HORIZONTAL);

		gEdition = new JLabel("版本  VO.1");
		gEdition.setPreferredSize(new Dimension(300, 40));
		gEdition.setHorizontalAlignment(JLabel.HORIZONTAL);

		gCopyright = new JLabel("版权所有 2016 fuzhou JF160704");
		gCopyright.setPreferredSize(new Dimension(300, 40));
		gCopyright.setHorizontalAlignment(JLabel.HORIZONTAL);

		gAuthor = new JLabel("JF160704  智晓毅");
		gAuthor.setHorizontalAlignment(JLabel.HORIZONTAL);
		gAuthor.setPreferredSize(new Dimension(300, 40));

		aboutPanel.add(gName);
		aboutPanel.add(gEdition);
		aboutPanel.add(gCopyright);
		aboutPanel.add(gAuthor);

		aboutDialog.setTitle("关于");

		aboutDialog.add(aboutPanel);

		aboutDialog.pack();

		aboutDialog.setLocationRelativeTo(null);

		aboutDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// 设置不可以放在后面
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
