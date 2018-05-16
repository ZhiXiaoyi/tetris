package com.zxy.view.ui;

import java.awt.Font;
import java.awt.Graphics;

import com.zxy.view.ui.Layer;

/**
 * ��Ϸ����������ʾ
 * 
 * @author ������
 *
 */
public class LayerMethod extends Layer {
	
	private static final String str1 = "��Ϸ����";
	private static final String str2 = "�� - :��ת����";
	private static final String str3 = "�� - :��������";
	private static final String str4 = "�� - :���Ʒ���";
	private static final String str5 = "�� - :��������";
	private static final String str6 = "P -- :��ͣ/����";
	private static final String str7 = "S -- :��Ӱ����";
	private static final String str8 = "G --:���񿪹�";
	private static final String str9 = "E -- :�˳���Ϸ";
	private static final String str10 = "SPACE ------- : ��������";
	

	public LayerMethod(int xPoint, int yPoint, int w, int h) {
		super(xPoint, yPoint, w, h);

	}

	public void paint(Graphics g) {
		this.createWindow(g);
		g.setFont(new Font("����", Font.BOLD, 35));
		g.drawString(str1, this.xPoint + 90, this.yPoint + 45);
		g.setFont(new Font("���Ŀ���", Font.CENTER_BASELINE, 23));
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
