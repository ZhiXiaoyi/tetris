package com.zxy.view.ui;

import java.awt.Graphics;


/**
 * 背景界面图片显示
 * @author 陈先生
 *
 */
public class LayerBackground extends Layer {

	// private static int IMG_BG_W =IMG_BG.getWidth(null);
	// private static int IMG_BG_H=IMG_BG.getHeight(null);

	public LayerBackground(int xPoint, int yPoint, int w, int h) {
		super(xPoint, yPoint, w, h);
	}

	@Override
	public void paint(Graphics g) {
		// g.drawImage(IMG_BG,xPoint,yPoint,1162, 654, 0, 0, IMG_BG_W, IMG_BG_H,
		// null);
		int bgIdx = this.gameDto.getNowLevel()%Img.BG_LIST.size();
		g.drawImage(Img.BG_LIST.get(bgIdx), 0, 0, 1165, 655, null);
	}
}
