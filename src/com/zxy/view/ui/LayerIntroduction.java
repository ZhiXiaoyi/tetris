package com.zxy.view.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * ��Ϸ���ܽ�����ʾ
 * 
 * @author ������
 *
 */
public class LayerIntroduction extends Layer {

	private static final String str1 = "����˹������";
	private static final String str2 = "����˼�壬����˹������Ȼ�Ƕ�";
	private static final String str3 = "��˹�˷����ġ����˽а��п�л����";
	private static final String str4 = "����ŵ��(���ݧ֧ܧ�֧� ���ѧاڧ�ߧ��Ӣ����";
	private static final String str5 = "AlexeyPazhitno)����˹����ԭ����";
	private static final String str6 = "���林�֧��ڧ㣨Ӣ����Tetris����";
	private static final String str7 = "������˹���顷�Ļ����������ƶ���";
	private static final String str8 = "��ת�Ͱڷ���Ϸ�Զ�����ĸ��ַ��飬";
	private static final String str9 = "ʹ֮���г�������һ�л���в�����";
	private static final String str10 = "���÷֡�";
	private static final String str11 = "���׼ӷּ���D";

	public LayerIntroduction(int xPoint, int yPoint, int w, int h) {
		super(xPoint, yPoint, w, h);
	}

	public void paint(Graphics g) {
		this.createWindow(g);
		g.setFont(new Font("����", Font.BOLD, 30));
		g.drawString(str1, this.xPoint + 55, this.yPoint + 40);
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("���Ŀ���", Font.BOLD, 19));
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
