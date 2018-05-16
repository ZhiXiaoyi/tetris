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
 * 点击游戏 - 自定义界面
 * 
 * @author 陈先生
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

	// custom自定义小窗口
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
	 * 滑块选择
	 */
	private void chooseSlider() {

		gSpeed = new JLabel("增加下落速度选择");
		gSpeed.setHorizontalAlignment(JLabel.HORIZONTAL);
		gSpeed.setPreferredSize(new Dimension(400, 40));
		customPanel.add(gSpeed);

		// 滑块
		slider = new JSlider();
		// 设置主刻度值
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(10);
		// 设置是否绘制刻度
		slider.setPaintTicks(true);
		// 设置是否绘制刻度值
		slider.setPaintLabels(true);
		// 设置自动贴合刻度
		slider.setSnapToTicks(true);
		slider.setPreferredSize(new Dimension(350, 60));

		// int i = slider.getValue();
		// System.out.println(i);
		customPanel.add(slider);

	}

	/**
	 * 方块难度选择
	 */
	private void chooseBlockEasy() {

		gShape = new JLabel("方块难度选择");
		gShape.setPreferredSize(new Dimension(100, 50));
		gShape.setHorizontalAlignment(JLabel.HORIZONTAL);
		customPanel.add(gShape);

		circular = new JRadioButtonMenuItem("初级");
		block = new JRadioButtonMenuItem("中级");
		fivePointedStar = new JRadioButtonMenuItem("高级");
		ButtonGroup btng = new ButtonGroup();
		btng.add(block);
		btng.add(circular);
		btng.add(fivePointedStar);
		customPanel.add(circular);
		customPanel.add(block);
		customPanel.add(fivePointedStar);
	}

	/**
	 * 游戏音乐是否开启
	 */
	private void chooseMusic() {
		jcb2 = new JCheckBox("游戏音乐是否开启");
		jcb2.setPreferredSize(new Dimension(170, 50));
		jcb2.setHorizontalAlignment(JCheckBox.HORIZONTAL);
		customPanel.add(jcb2);
	}

	/**
	 * 方块是否自动上涨
	 */
	private void chooosBlockUp() {
		jcb1 = new JCheckBox("方块是否自动上涨");
		jcb1.setPreferredSize(new Dimension(170, 50));
		jcb1.setHorizontalAlignment(JCheckBox.HORIZONTAL);
		customPanel.add(jcb1);
	}

	/**
	 * 确定取消按钮
	 */
	private void yesOrNoButton(MusicService musicService) {

		yes = new JButton("确定(Y)");
		yes.setHorizontalAlignment(JButton.HORIZONTAL);
		yes.addActionListener(new ActionListener() {

			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				// 选择速度
				gameDto.SPEED = (-slider.getValue() * 4 + 504);
				// 方块上涨
				if(jcb1.isSelected()){
					blockAddUp=true;
				}else{
					blockAddUp=false;
				}
				// 音乐开启
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
		no = new JButton("取消(N)");
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
	 * 自定义面板的默认设置
	 * 
	 */
	private void initCustomDialog() {
		// 默认设置
		customDialog.setTitle("自定义游戏");

		customDialog.add(customPanel);

		customDialog.pack();

		customDialog.setLocationRelativeTo(null);

		customDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// 设置不可以放在后面
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
