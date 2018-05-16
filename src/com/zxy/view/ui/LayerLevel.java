package com.zxy.view.ui;

import java.awt.Graphics;

/**
 * ��Ϸ����������ʾ
 * 
 * @author ������
 *
 */
public class LayerLevel extends Layer {


	private static final int IMG_LEVEL_W = Img.LEVEL.getWidth(null);

	public LayerLevel(int xPoint, int yPoint, int w, int h) {

		super(xPoint, yPoint, w, h);
	}

	public void paint(Graphics g) {
		this.createWindow(g);
		// ��ʾ���ڱ���
		int centerX = (this.w - IMG_LEVEL_W >> 1);
		g.drawImage(Img.LEVEL, this.xPoint + centerX, this.yPoint + Layer.PADDING, null);

		// ��ʾ�ȼ�
		this.drawNumberLeftPad(centerX, 64, this.gameDto.getNowLevel(), 2, g);
	}

}
