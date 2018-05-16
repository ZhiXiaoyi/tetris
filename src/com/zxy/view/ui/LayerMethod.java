package com.zxy.view.ui;

import java.awt.Font;
import java.awt.Graphics;

import com.zxy.view.ui.Layer;

/**
 * 游戏方法界面显示
 * 
 * @author 陈先生
 *
 */
public class LayerMethod extends Layer {
	
	private static final String str1 = "游戏方法";
	private static final String str2 = "↑ - :旋转方块";
	private static final String str3 = "↓ - :方块下落";
	private static final String str4 = "← - :左移方块";
	private static final String str5 = "→ - :方块右移";
	private static final String str6 = "P -- :暂停/继续";
	private static final String str7 = "S -- :阴影开关";
	private static final String str8 = "G --:方格开关";
	private static final String str9 = "E -- :退出游戏";
	private static final String str10 = "SPACE ------- : 快速下落";
	

	public LayerMethod(int xPoint, int yPoint, int w, int h) {
		super(xPoint, yPoint, w, h);

	}

	public void paint(Graphics g) {
		this.createWindow(g);
		g.setFont(new Font("楷体", Font.BOLD, 35));
		g.drawString(str1, this.xPoint + 90, this.yPoint + 45);
		g.setFont(new Font("华文楷体", Font.CENTER_BASELINE, 23));
		g.drawString(str2, this.xPoint + 10, this.yPoint + 85);
		g.drawString(str3, this.xPoint + 175, this.yPoint + 85);
		g.drawString(str4, this.xPoint + 10, this.yPoint + 125);
		g.drawString(str5, this.xPoint + 175, this.yPoint + 125);
		g.drawString(str6, this.xPoint + 10, this.yPoint + 165);
		g.drawString(str7, this.xPoint + 175, this.yPoint + 165);
		g.drawString(str8, this.xPoint + 10, this.yPoint + 205);
		g.drawString(str9, this.xPoint + 175, this.yPoint + 205);
		g.drawString(str10, this.xPoint + 40, this.yPoint + 245);
		
	}

}
