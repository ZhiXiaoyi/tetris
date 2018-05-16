package com.zxy.config;

import java.io.Serializable;

/**
 * ��������
 * @author ������
 *
 */
public class LayerConfig implements Serializable {

	private String className;// ����������
	private int xPoint;
	private int yPoint;
	private int w;
	private int h;

	public LayerConfig(String className, int xPoint, int yPoint, int w, int h) {
		this.className = className;
		this.xPoint = xPoint;
		this.yPoint = yPoint;
		this.w = w;
		this.h = h;
	}

	public String getClassName() {
		return className;
	}

	public int getxPoint() {
		return xPoint;
	}

	public int getyPoint() {
		return yPoint;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

}
