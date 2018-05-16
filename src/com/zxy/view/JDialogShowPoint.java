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

		this.setTitle("���÷�");
		this.setSize(256, 128);

		this.setLayout(new BorderLayout());

		this.setResizable(false);

		this.creatCom(gameControl);

		// ���þ���
		this.setLocationRelativeTo(null);

		// ���ò����Է��ں���
		this.setModal(true);

	}

	public void showPoint(int point) {
		this.lbPoint.setText("���ĵ÷֣�" + point);

		this.setVisible(true);

	}

	private void creatCom(GameControl gameControl) {

		JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.lbPoint = new JLabel();
		north.add(lbPoint);
		this.add(north, BorderLayout.NORTH);

		// ����ȷ����ť
		this.btnOK = new JButton("���¿�ʼ");
		this.btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gameControl.star();

			}
		});

		// ����ȡ����ť
		this.btnCanel = new JButton("ȡ��");
		this.btnCanel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				gameControl.getGamePanel().buttonSwitch(true);
			}
		});
		// �����ϲ����
		JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER));
		south.add(btnOK);
		south.add(btnCanel);
		this.add(south, BorderLayout.SOUTH);
	}

}
