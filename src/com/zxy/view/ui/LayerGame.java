package com.zxy.view.ui;

import java.awt.Graphics;
import java.awt.Point;

import com.zxy.model.GameAct;

/**
 * ��Ϸ���ڽ�����ʾ
 * 
 * @author ������
 *
 */
public class LayerGame extends Layer {

	/**
	 * ��λ��5�൱�ڳ�32
	 */
	private static final int ACT_SIZE_ROL = 5;

	 private static int ACT_SIZE = 32;

	public LayerGame(int xPoint, int yPoint, int w, int h) {
		super(xPoint, yPoint, w, h);
	}

	public void paint(Graphics g) {
		this.createWindow(g);

		// ��÷������鼯��
		GameAct act = this.gameDto.getGameAct();
		if (act != null) {
			Point[] points = act.getActPoints();
			// ������Ӱ
			this.drawShadow(points, g);
			//��������
			this.drawGraticule(g);
			// ���ƻ����
			this.drawMainAct(points, g);
		}

		// ������Ϸ��ͼ
		this.drawMap(g);
		// ��ͣ
		if (this.gameDto.isPause()) {
			this.drawImageAtCenter(Img.PAUSE, g);
		}

	}

	/**
	 * ���ƻ����
	 * 
	 * @param g
	 */
	private void drawMainAct(Point[] points, Graphics g) {

		// ��÷������ͱ��(0--6)
		int typeCode = this.gameDto.getGameAct().getTypeCode();

		// ��ӡ����
		for (int i = 0; i < points.length; i++) {

			this.drawActByPoint(points[i].x, points[i].y, typeCode + 1, g);
		}

	}

	/**
	 * ���Ƶ�ͼ
	 * 
	 * @param g
	 */
	private void drawMap(Graphics g) {
		// ��ӡ��ͼ
		boolean[][] map = this.gameDto.getGameMap();
		int lv = this.gameDto.getNowLevel();
		int imgIdx = lv == 0 ? 0 : (lv - 1) % 7 + 1;// ���㵱ǰͼƬ��ɫ
		// imgIdx=8��Ļ�
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				// �жϷ����Ƿ񵽵�
				if (map[x][y]) {
					this.drawActByPoint(x, y, imgIdx, g);
				}

			}
		}

	}

	/**
	 * ������Ӱ
	 * 
	 * @param points
	 * @param b
	 */
	private void drawShadow(Point[] points, Graphics g) {
		if (!this.gameDto.isShowShadow()) {
			return;
		}
		int leftX = 9;
		int rightX = 0;
		for (Point p : points) {
			leftX = p.x < leftX ? p.x : leftX;
			rightX = p.x > rightX ? p.x : rightX;

		}
		g.drawImage(Img.SHADOW, 
				this.xPoint + SIZE + (leftX << ACT_SIZE_ROL),
				this.yPoint + SIZE,
				(rightX - leftX + 1) << ACT_SIZE_ROL, 
				this.h - (SIZE << 1), null);

	}

	private void drawGraticule(Graphics g){
		if (!this.gameDto.isShowGraticule()) {
				return;
					}	
		for (int i = 0; i <=10; i++) {
			for (int j = 0; j <= 17; j++) {
				g.drawLine(this.xPoint+SIZE, yPoint+SIZE+ACT_SIZE*j, 
						   this.xPoint+this.w-SIZE, this.yPoint+SIZE+ACT_SIZE*j);
				g.drawLine(this.xPoint+7+ACT_SIZE*i, this.yPoint+SIZE, 
						   this.xPoint+ACT_SIZE*i+SIZE, this.yPoint+this.h-SIZE);
			}
		}
		
	}

	/**
	 * 
	 * ���������η���
	 * 
	 * @param x
	 * @param y
	 * @param imaIdx
	 * @param g
	 */
	public void drawActByPoint(int x, int y, int imgIdx, Graphics g) {
		imgIdx = this.gameDto.isStar() ? imgIdx : 10;

		g.drawImage(Img.ACT, 
				this.xPoint + (x << ACT_SIZE_ROL) + 7,
				this.yPoint + (y << ACT_SIZE_ROL) + 7,
				this.xPoint + (x + 1 << ACT_SIZE_ROL) + 7,
				this.yPoint + (y + 1 << ACT_SIZE_ROL) + 7,
				(imgIdx) << ACT_SIZE_ROL,
				0, 
				(imgIdx + 1) << ACT_SIZE_ROL,
				1 << ACT_SIZE_ROL, 
				null);
	}
}
