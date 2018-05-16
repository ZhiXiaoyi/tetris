package com.zxy.view.ui;

import java.awt.Graphics;

/**
 * 预览区界面显示
 * 
 * @author 陈先生
 *
 */
public class LayerNext extends Layer {

	

	public LayerNext(int xPoint, int yPoint, int w, int h) {
		super(xPoint, yPoint, w, h);
	}

	public void paint(Graphics g) {
		this.createWindow(g);
		//如果是开始状态才绘制下一个方块
		if(this.gameDto.isStar()){
		this.drawImageAtCenter(Img.NEXT_ACT[this.gameDto.getNext()], g);
		}
	}



}
