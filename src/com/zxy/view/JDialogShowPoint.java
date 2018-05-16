package com.zxy.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.zxy.control.GameControl;

@SuppressWarnings("serial")
public class JDialogShowPoint extends JDialog {

	private JButton btnOK = null;

	private JLabel lbPoint = null;

	private JButton btnCanel = null;

	public JDialogShowPoint(GameControl gameControl) {

		this.setTitle("最后得分");
		this.setSize(256, 128);

		this.setLayout(new BorderLayout());

		this.setResizable(false);

		this.creatCom(gameControl);

		// 设置居中
		this.setLocationRelativeTo(null);

		// 设置不可以放在后面
		this.setModal(true);

	}

	public void showPoint(int point) {
		this.lbPoint.setText("您的得分：" + point);

		this.setVisible(true);

	}

	private void creatCom(GameControl gameControl) {

		JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.lbPoint = new JLabel();
		north.add(lbPoint);
		this.add(north, BorderLayout.NORTH);

		// 创建确定按钮
		this.btnOK = new JButton("重新开始");
		this.btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gameControl.star();

			}
		});

		// 创建取消按钮
		this.btnCanel = new JButton("取消");
		this.btnCanel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				gameControl.getGamePanel().buttonSwitch(true);
			}
		});
		// 创建南部面板
		JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER));
		south.add(btnOK);
		south.add(btnCanel);
		this.add(south, BorderLayout.SOUTH);
	}

}
