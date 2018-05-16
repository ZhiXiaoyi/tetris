package com.zxy.view.ui;

import java.awt.Graphics;

/**
 * ��Ϸ���������н�����ʾ
 * 
 * @author ������
 *
 */
public class LayerPoint extends Layer {

	private static final int LEVEL_UP = 10;	// �����ļ�����������Ĭ��10��

	private static final int IMG_RMLINE_H = Img.RMLINE.getHeight(null);

	private static final int POINT_BIT = 5; // �������λ��

	private final int rmlineY; // Ԥ������ͼƬ��yֵ

	private final int pointY; // Ԥ�����ͼƬ��yֵ

	private final int comX; // ������ʾ�������������Ͻ�X����

	private final int expY; // ����ֵY����

	public LayerPoint(int xPoint, int yPoint, int w, int h) {
		super(xPoint, yPoint, w, h);

		// ��ʼ��������ʾ��X����
		this.comX = this.w - IMG_NUMBER_W * POINT_BIT - PADDING;
		this.pointY = PADDING;
		// ��ʼ��
		this.rmlineY = this.pointY + Img.POINT.getHeight(null) + PADDING;
		this.expY = this.rmlineY + Img.RMLINE.getHeight(null) + PADDING;
	}

	public void paint(Graphics g) {
		this.createWindow(g);
		// ��ʾ���ڱ���(����)
		g.drawImage(Img.POINT, this.xPoint + PADDING, this.yPoint + PADDING, null);
		this.drawNumberLeftPad(comX, PADDING, this.gameDto.getNowPoint(), 5, g);

		// ��ʾ���ڱ���(����)
		g.drawImage(Img.RMLINE, this.xPoint + PADDING, this.yPoint + IMG_RMLINE_H + (PADDING << 1), null);
		this.drawNumberLeftPad(comX, IMG_RMLINE_H + (PADDING << 1), this.gameDto.getNowRemoveLine(), 5, g);

		// ���ƾ���� 
		int rmline = this.gameDto.getNowRemoveLine();
		this.drawRect(expY, "��һ��", null, (double) (rmline % LEVEL_UP) / (double) LEVEL_UP, g);
	}
}
