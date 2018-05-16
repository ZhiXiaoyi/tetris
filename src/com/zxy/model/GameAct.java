package com.zxy.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * 方块模型
 * 
 * @author 陈先生
 *
 */
public class GameAct {

	/**
	 * 方块数组
	 */
	private Point[] actPoints = null;

	private static int MIN_X = 0;
	private static int MAX_X = 9;
	private static int MIN_Y = 0;
	private static int MAX_Y = 17;
	
	private int typeCode;
	
	private static List<Point[]>TYPE_CONFIG;
	
	static{
		TYPE_CONFIG= new ArrayList<Point[]>(9);
		TYPE_CONFIG.add(new Point[]{
				new Point(4, 0),
				new Point(3, 0), 
				new Point(5, 0), 
				new Point(6, 0)});
		TYPE_CONFIG.add(new Point[]{
				new Point(4, 0), 
				new Point(3, 0), 
				new Point(5, 0), 
				new Point(4, 1)});
		TYPE_CONFIG.add(new Point[]{
				new Point(4, 0), 
				new Point(3, 0), 
				new Point(5, 0), 
				new Point(3, 1)});
		TYPE_CONFIG.add(new Point[]{
				new Point(4, 0), 
				new Point(5, 0), 
				new Point(3, 1), 
				new Point(4, 1)});
		TYPE_CONFIG.add(new Point[]{
				new Point(4, 0), 
				new Point(5, 0), 
				new Point(4, 1), 
				new Point(5, 1)});
		TYPE_CONFIG.add(new Point[]{
				new Point(4, 0), 
				new Point(3, 0), 
				new Point(5, 0), 
				new Point(5, 1)});
		TYPE_CONFIG.add(new Point[]{
				new Point(4, 0), 
				new Point(3, 0), 
				new Point(4, 1),
				new Point(5, 1)});
		
		TYPE_CONFIG.add(new Point[]{
				new Point(4,0),
				new Point(4,1),
				new Point(5,1)});
		
		TYPE_CONFIG.add(new Point[]{
				new Point(4,0),
				new Point(3,0),
				new Point(5,0),
				new Point(3,1),
				new Point(5,1)});
	}

	public GameAct(int typeCode) {

		this.init(typeCode);

	}

	public void init(int typeCode) {
		
		this.typeCode = typeCode;
		
		Point[] points=actPoints=TYPE_CONFIG.get(typeCode);
		
		actPoints= new Point[points.length];
		for (int i = 0; i < points.length; i++) {
			actPoints[i] = new Point(points[i].x,points[i].y);
		}
	}

	public Point[] getActPoints() {
		return actPoints;
	}

	/**
	 * 方块移动
	 * 
	 * @param moveX
	 * @param moveY
	 */
	public boolean move(int moveX, int moveY, boolean[][] gameMap) {

		// 移动处理
		for (int i = 0; i < actPoints.length; i++) {
			int newX = actPoints[i].x + moveX;
			int newY = actPoints[i].y + moveY;

			if (this.isOverZone(newX, newY, gameMap)) {

				return false;
			}
		}
		for (int i = 0; i < actPoints.length; i++) {
			actPoints[i].x += moveX;
			actPoints[i].y += moveY;
		}
		return true;

	}

	/**
	 * 方块旋转
	 * 
	 * 顺时针 A.=0.y+0.x-B.y A.y=0.y-0.x+B.y
	 */
	public void round(boolean[][] gameMap) {
		
		//田子方块直接返回
		if(this.typeCode == 4){
			return;
		}

		//判断旋转操作
		for (int i = 1; i < actPoints.length; i++) {

			int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			if (this.isOverZone(newX, newY, gameMap)) {

				return;
			}
		}
		//进行旋转操作
		for (int i = 0; i < actPoints.length; i++) {

			int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;

			actPoints[i].x = newX;
			actPoints[i].y = newY;
		}
	}

	/**
	 * 
	 * 判断是否超出边界
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isOverZone(int x, int y, boolean[][] gameMap) {

		return x < MIN_X || x > MAX_X || y < MIN_Y || y > MAX_Y || gameMap[x][y];

	}

	public int getTypeCode() {
		return typeCode;
	}


}
