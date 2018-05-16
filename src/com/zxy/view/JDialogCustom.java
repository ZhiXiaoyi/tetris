package com.zxy.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;

import com.zxy.control.MusicService;
import com.zxy.model.GameDto;

/**
 * �����Ϸ - �Զ������
 * 
 * @author ������
 *
 */
@SuppressWarnings("serial")
public class JDialogCustom extends JDialog {
	private JDialog customDialog;
	private JPanel customPanel;
	private JLabel gSpeed, gShape;
	private JSlider slider;
	private JRadioButtonMenuItem circular, block, fivePointedStar;
	private JCheckBox jcb1, jcb2;
	private JButton yes, no;
	
	public boolean blockAddUp;

	private GameDto gameDto;

	public JDialogCustom(MusicService musicService, GameDto gameDto) {

		this.gameDto = gameDto;

		this.customJDialog(musicService);

	}

	// custom�Զ���С����
	public void customJDialog(MusicService musicService) {

		customDialog = new JDialog();

		customPanel = new JPanel();

		customPanel.setPreferredSize(new Dimension(400, 270));

		this.chooseSlider();

		this.chooseBlockEasy();

		this.chooosBlockUp();

		this.chooseMusic();

		this.yesOrNoButton(musicService);

		this.initCustomDialog();

	}

	/**
	 * ����ѡ��
	 */
	private void chooseSlider() {

		gSpeed = new JLabel("���������ٶ�ѡ��");
		gSpeed.setHorizontalAlignment(JLabel.HORIZONTAL);
		gSpeed.setPreferredSize(new Dimension(400, 40));
		customPanel.add(gSpeed);

		// ����
		slider = new JSlider();
		// �������̶�ֵ
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(10);
		// �����Ƿ���ƿ̶�
		slider.setPaintTicks(true);
		// �����Ƿ���ƿ̶�ֵ
		slider.setPaintLabels(true);
		// �����Զ����Ͽ̶�
		slider.setSnapToTicks(true);
		slider.setPreferredSize(new Dimension(350, 60));

		// int i = slider.getValue();
		// System.out.println(i);
		customPanel.add(slider);

	}

	/**
	 * �����Ѷ�ѡ��
	 */
	private void chooseBlockEasy() {

		gShape = new JLabel("�����Ѷ�ѡ��");
		gShape.setPreferredSize(new Dimension(100, 50));
		gShape.setHorizontalAlignment(JLabel.HORIZONTAL);
		customPanel.add(gShape);

		circular = new JRadioButtonMenuItem("����");
		block = new JRadioButtonMenuItem("�м�");
		fivePointedStar = new JRadioButtonMenuItem("�߼�");
		ButtonGroup btng = new ButtonGroup();
		btng.add(block);
		btng.add(circular);
		btng.add(fivePointedStar);
		customPanel.add(circular);
		customPanel.add(block);
		customPanel.add(fivePointedStar);
	}

	/**
	 * ��Ϸ�����Ƿ���
	 */
	private void chooseMusic() {
		jcb2 = new JCheckBox("��Ϸ�����Ƿ���");
		jcb2.setPreferredSize(new Dimension(170, 50));
		jcb2.setHorizontalAlignment(JCheckBox.HORIZONTAL);
		customPanel.add(jcb2);
	}

	/**
	 * �����Ƿ��Զ�����
	 */
	private void chooosBlockUp() {
		jcb1 = new JCheckBox("�����Ƿ��Զ�����");
		jcb1.setPreferredSize(new Dimension(170, 50));
		jcb1.setHorizontalAlignment(JCheckBox.HORIZONTAL);
		customPanel.add(jcb1);
	}

	/**
	 * ȷ��ȡ����ť
	 */
	private void yesOrNoButton(MusicService musicService) {

		yes = new JButton("ȷ��(Y)");
		yes.setHorizontalAlignment(JButton.HORIZONTAL);
		yes.addActionListener(new ActionListener() {

			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				// ѡ���ٶ�
				gameDto.SPEED = (-slider.getValue() * 4 + 504);
				// ��������
				if(jcb1.isSelected()){
					blockAddUp=true;
				}else{
					blockAddUp=false;
				}
				// ���ֿ���
				if (jcb2.isSelected()) {
					musicService.playBGM();
				}else{
					musicService.stopBGM();
				}

				if (circular.isSelected())
					gameDto.MAX_TYPE = 6;
				if (block.isSelected())
					gameDto.MAX_TYPE = 7;
				if (fivePointedStar.isSelected())
					gameDto.MAX_TYPE = 8;
				customDialog.setVisible(false);

			}
		});
		no = new JButton("ȡ��(N)");
		no.setHorizontalAlignment(JButton.HORIZONTAL);
		no.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				customDialog.setVisible(false);
			}
		});
		customPanel.add(yes);
		customPanel.add(no);

	}

	/**
	 * �Զ�������Ĭ������
	 * 
	 */
	private void initCustomDialog() {
		// Ĭ������
		customDialog.setTitle("�Զ�����Ϸ");

		customDialog.add(customPanel);

		customDialog.pack();

		customDialog.setLocationRelativeTo(null);

		customDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// ���ò����Է��ں���
		customDialog.setModal(true);

		customDialog.setResizable(false);
	}

	// ------------get/set-----------------

	public JDialog getCustomDialog() {
		return customDialog;
	}

	public JCheckBox getJcb1() {
		return jcb1;
	}

	public JCheckBox getJcb2() {
		return jcb2;
	}

}
