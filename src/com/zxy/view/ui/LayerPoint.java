package com.zxy.view.ui;

import java.awt.Graphics;

/**
 * 游戏分数，消行界面显示
 * 
 * @author 陈先生
 *
 */
public class LayerPoint extends Layer {

	private static final int LEVEL_UP = 10;	// 配置文件升级行数，默认10行

	private static final int IMG_RMLINE_H = Img.RMLINE.getHeight(null);

	private static final int POINT_BIT = 5; // 分数最大位数

	private final int rmlineY; // 预设消行图片的y值

	private final int pointY; // 预设分数图片的y值

	private final int comX; // 分数显示和消行数的左上角X坐标

	private final int expY; // 经验值Y坐标

	public LayerPoint(int xPoint, int yPoint, int w, int h) {
		super(xPoint, yPoint, w, h);

		// 初始化分数显示的X坐标
		this.comX = this.w - IMG_NUMBER_W * POINT_BIT - PADDING;
		this.pointY = PADDING;
		// 初始化
		this.rmlineY = this.pointY + Img.POINT.getHeight(null) + PADDING;
		this.expY = this.rmlineY + Img.RMLINE.getHeight(null) + PADDING;
	}

	public void paint(Graphics g) {
		this.createWindow(g);
		// 显示窗口标题(分数)
		g.drawImage(Img.POINT, this.xPoint + PADDING, this.yPoint + PADDING, null);
		this.drawNumberLeftPad(comX, PADDING, this.gameDto.getNowPoint(), 5, g);

		// 显示窗口标题(消行)
		g.drawImage(Img.RMLINE, this.xPoint + PADDING, this.yPoint + IMG_RMLINE_H + (PADDING << 1), null);
		this.drawNumberLeftPad(comX, IMG_RMLINE_H + (PADDING << 1), this.gameDto.getNowRemoveLine(), 5, g);

		// 绘制经验曹 
		int rmline = this.gameDto.getNowRemoveLine();
		this.drawRect(expY, "下一级", null, (double) (rmline % LEVEL_UP) / (double) LEVEL_UP, g);
	}
}
