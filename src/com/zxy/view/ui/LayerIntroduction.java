package com.zxy.view.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * 游戏介绍界面显示
 * 
 * @author 陈先生
 *
 */
public class LayerIntroduction extends Layer {

	private static final String str1 = "俄罗斯方块简介";
	private static final String str2 = "顾名思义，俄罗斯方块自然是俄";
	private static final String str3 = "罗斯人发明的。这人叫阿列克谢·帕";
	private static final String str4 = "基特诺夫(Алексей Пажитнов英文名";
	private static final String str5 = "AlexeyPazhitno)俄罗斯方块原名是";
	private static final String str6 = "俄语Тетрис（英语是Tetris）。";
	private static final String str7 = "《俄罗斯方块》的基本规则是移动、";
	private static final String str8 = "旋转和摆放游戏自动输出的各种方块，";
	private static final String str9 = "使之排列成完整的一行或多行并且消";
	private static final String str10 = "除得分。";
	private static final String str11 = "作弊加分键：D";

	public LayerIntroduction(int xPoint, int yPoint, int w, int h) {
		super(xPoint, yPoint, w, h);
	}

	public void paint(Graphics g) {
		this.createWindow(g);
		g.setFont(new Font("楷体", Font.BOLD, 30));
		g.drawString(str1, this.xPoint + 55, this.yPoint + 40);
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("华文楷体", Font.BOLD, 19));
		g.drawString(str2, this.xPoint + 45, this.yPoint + 70);
		g.drawString(str3, this.xPoint + 8, this.yPoint + 93);
		g.drawString(str4, this.xPoint + 8, this.yPoint + 116);
		g.drawString(str5, this.xPoint + 8, this.yPoint + 139);
		g.drawString(str6, this.xPoint + 8, this.yPoint + 162);
		g.drawString(str7, this.xPoint + 45, this.yPoint + 185);
		g.drawString(str8, this.xPoint + 8, this.yPoint + 208);
		g.drawString(str9, this.xPoint + 8, this.yPoint + 231);
		g.drawString(str10, this.xPoint + 8, this.yPoint + 254);
		g.drawString(str11, this.xPoint + 160, this.yPoint + 263);

	}

}
