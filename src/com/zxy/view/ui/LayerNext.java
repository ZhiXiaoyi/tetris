package com.zxy.view.ui;

import java.awt.Graphics;

/**
 * Ԥ����������ʾ
 * 
 * @author ������
 *
 */
public class LayerNext extends Layer {

	

	public LayerNext(int xPoint, int yPoint, int w, int h) {
		super(xPoint, yPoint, w, h);
	}

	public void paint(Graphics g) {
		this.createWindow(g);
		//����ǿ�ʼ״̬�Ż�����һ������
		if(this.gameDto.isStar()){
		this.drawImageAtCenter(Img.NEXT_ACT[this.gameDto.getNext()], g);
		}
	}



}
