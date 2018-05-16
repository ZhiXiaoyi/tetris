package com.zxy.model;

/**
 * ��Ϸ���ֵ�����
 * 
 * @author ������
 *
 */
public class GameDto {

	public static int SPEED = 500;// ��Ϸ�ٶ�

	public static int MAX_TYPE = 6;// ��������

	public static final int GAMEZONE_W = 10;// ��Ϸ�Ŀ��

	public static final int GAMEZONE_H = 18;// ��Ϸ�ĸ߶�

	private boolean[][] gameMap;// ��Ϸ��ͼ

	private GameAct gameAct;// ���䷽��

	private int next;// ��һ������

	private int nowPoint;// ���ڷ���

	private int nowRemoveLine;// �����Ƴ�������

	private int nowLevel;// ���ڵȼ�

	private boolean star;// ������Ϸ��ʼ

	private boolean showShadow;// ��Ӱ

	private boolean pause; // ��ͣ

	 private boolean showGraticule;//����

	private int time;

	public GameDto() {
		this.gameDtoInit();
	}

	/**
	 * ��ʼ���������
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
		this.showShadow = !this.showShadow;// boolean���ͷ�ת
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
