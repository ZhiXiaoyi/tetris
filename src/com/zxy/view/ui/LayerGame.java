package com.zxy.view.ui;

import java.awt.Graphics;
import java.awt.Point;

import com.zxy.model.GameAct;

/**
 * 游戏窗口界面显示
 * 
 * @author 陈先生
 *
 */
public class LayerGame extends Layer {

	/**
	 * 右位移5相当于乘32
	 */
	private static final int ACT_SIZE_ROL = 5;

	 private static int ACT_SIZE = 32;

	public LayerGame(int xPoint, int yPoint, int w, int h) {
		super(xPoint, yPoint, w, h);
	}

	public void paint(Graphics g) {
		this.createWindow(g);

		// 获得方块数组集合
		GameAct act = this.gameDto.getGameAct();
		if (act != null) {
			Point[] points = act.getActPoints();
			// 绘制阴影
			this.drawShadow(points, g);
			//绘制网格
			this.drawGraticule(g);
			// 绘制活动方块
			this.drawMainAct(points, g);
		}

		// 绘制游戏地图
		this.drawMap(g);
		// 暂停
		if (this.gameDto.isPause()) {
			this.drawImageAtCenter(Img.PAUSE, g);
		}

	}

	/**
	 * 绘制活动方块
	 * 
	 * @param g
	 */
	private void drawMainAct(Point[] points, Graphics g) {

		// 获得方块类型编号(0--6)
		int typeCode = this.gameDto.getGameAct().getTypeCode();

		// 打印方块
		for (int i = 0; i < points.length; i++) {

			this.drawActByPoint(points[i].x, points[i].y, typeCode + 1, g);
		}

	}

	/**
	 * 绘制地图
	 * 
	 * @param g
	 */
	private void drawMap(Graphics g) {
		// 打印地图
		boolean[][] map = this.gameDto.getGameMap();
		int lv = this.gameDto.getNowLevel();
		int imgIdx = lv == 0 ? 0 : (lv - 1) % 7 + 1;// 计算当前图片颜色
		// imgIdx=8输的话
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				// 判断方块是否到底
				if (map[x][y]) {
					this.drawActByPoint(x, y, imgIdx, g);
				}

			}
		}

	}

	/**
	 * 绘制阴影
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
	 * 绘制正方形方块
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
