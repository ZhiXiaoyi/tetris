package com.zxy.view.ui;

import java.awt.Graphics;

public class LayerButton extends Layer {

	public LayerButton(int xPoint, int yPoint, int w, int h) {
		super(xPoint, yPoint, w, h);
	}

	public void paint(Graphics g) {
		this.createWindow(g);
		

	}
}
