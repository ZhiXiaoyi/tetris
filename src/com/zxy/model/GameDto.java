package com.zxy.model;

/**
 * 游戏各种的载体
 * 
 * @author 陈先生
 *
 */
public class GameDto {

	public static int SPEED = 500;// 游戏速度

	public static int MAX_TYPE = 6;// 方块种类

	public static final int GAMEZONE_W = 10;// 游戏的宽度

	public static final int GAMEZONE_H = 18;// 游戏的高度

	private boolean[][] gameMap;// 游戏地图

	private GameAct gameAct;// 下落方块

	private int next;// 下一个方块

	private int nowPoint;// 现在分数

	private int nowRemoveLine;// 现在移除多少行

	private int nowLevel;// 现在等级

	private boolean star;// 控制游戏开始

	private boolean showShadow;// 阴影

	private boolean pause; // 暂停

	 private boolean showGraticule;//方格

	private int time;

	public GameDto() {
		this.gameDtoInit();
	}

	/**
	 * 初始化数组对象
	 */
	public void gameDtoInit() {
		this.gameMap = new boolean[10][18];
		this.nowLevel = 0;
		this.nowPoint = 0;
		this.nowRemoveLine = 0;
		this.time = 1;
		this.pause = false;
	}

	// ---------------------get/set--------------------------

	public boolean[][] getGameMap() {
		return gameMap;
	}

	public void setGameMap(boolean[][] gameMap) {
		this.gameMap = gameMap;
	}

	public GameAct getGameAct() {
		return gameAct;
	}

	public void setGameAct(GameAct gameAct) {
		this.gameAct = gameAct;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getNowPoint() {
		return nowPoint;
	}

	public void setNowPoint(int nowPoint) {
		this.nowPoint = nowPoint;
	}

	public int getNowRemoveLine() {
		return nowRemoveLine;
	}

	public void setNowRemoveLine(int nowRemoveLine) {
		this.nowRemoveLine = nowRemoveLine;
	}

	public int getNowLevel() {
		return nowLevel;
	}

	public void setNowLevel(int nowLevel) {
		this.nowLevel = nowLevel;
	}

	public boolean isStar() {
		return star;
	}

	public void setStar(boolean star) {
		this.star = star;
	}

	public boolean isShowShadow() {
		return showShadow;
	}

	public void changeShowShadow() {
		this.showShadow = !this.showShadow;// boolean类型反转
	}

	public boolean isPause() {
		return pause;
	}

	public void changePause() {

		this.pause = !this.pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public boolean isShowGraticule() {
		return showGraticule;
	}

	public void changeShowGraticule() {
		this.showGraticule=!this.showGraticule;
		
	}

}
