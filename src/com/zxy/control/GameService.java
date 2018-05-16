package com.zxy.control;

import java.awt.Point;
import java.util.Random;

import com.zxy.model.GameAct;
import com.zxy.model.GameDto;
import com.zxy.view.JDialogCustom;

/**
 * 游戏自己的逻辑
 * 
 * @author 陈先生
 *
 */
public class GameService {

	private GameDto gameDto;

	private MusicService musicService;

	private Random random = new Random();

	private JDialogCustom mCustomJDialog;

	private static final int LEVEL_UP = 10; // 升级行数，默认10行

	public GameService(JDialogCustom mCustomJDialog, GameDto gameDto, MusicService musicService) {

		this.gameDto = gameDto;

		this.musicService = musicService;

		this.mCustomJDialog = mCustomJDialog;

	}

	/**
	 * 按方向键下
	 */
	public boolean keyDown() {
		if (!this.gameDto.isStar()) {
			return true;
		}
		if (this.gameDto.isPause()) {
			return true;
		}
		// 方块向下移动，并且判断是否可以移动成功
		if (this.gameDto.getGameAct().move(0, 1, this.gameDto.getGameMap())) {
			return false;
		}
		// 获得游戏地图对象
		boolean[][] map = this.gameDto.getGameMap();
		Point[] act = this.gameDto.getGameAct().getActPoints();
		// 将方块堆积到地图数组
		for (int i = 0; i < act.length; i++) {
			map[act[i].x][act[i].y] = true;
		}
		// 加分操作（里面含有消行操作）
		int plusExp = this.plusExp();
		// 增加经验值 升级
		this.plusPoint(plusExp);
		// 方块上涨
		if (this.mCustomJDialog.blockAddUp) {
			this.gameDto.setTime(gameDto.getTime() + 1);
			if (gameDto.getTime() == 5) {
				this.actAddUp(gameDto.getGameMap());
				this.gameDto.setTime(1);
			}

		}

		// 刷新一个方块
		this.gameDto.getGameAct().init(this.gameDto.getNext());
		// 随即生成再下一个方块
		this.gameDto.setNext(random.nextInt(gameDto.MAX_TYPE));
		// 检查游戏是否失败
		if (this.isLose()) {
			// 游戏开始状态为false
			musicService.playBM();
			this.gameDto.setStar(false);
		}
		return true;
	}

	/**
	 * 检查游戏是否失败
	 */
	private boolean isLose() {
		// 获得现在的方块
		Point[] actPoints = gameDto.getGameAct().getActPoints();
		//获得现在的地图
		boolean[][] map = gameDto.getGameMap();
		for (int i = 0; i < actPoints.length; i++) {
			if (map[actPoints[i].x][actPoints[i].y]) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 升级操作
	 * 
	 * @param exp
	 */
	private void plusPoint(int plusExp) {
		int lv = this.gameDto.getNowLevel();
		int rmLine = this.gameDto.getNowRemoveLine();
		int point = this.gameDto.getNowPoint();
		if (rmLine % LEVEL_UP + plusExp >= LEVEL_UP) {
			this.gameDto.setNowLevel(++lv);
		}
		this.gameDto.setNowRemoveLine(rmLine + plusExp);
		this.gameDto.setNowPoint((rmLine + plusExp) * 10);
	}

	/**
	 * 加分操作
	 */
	private int plusExp() {

		boolean[][] map = this.gameDto.getGameMap();
		int exp = 0;
		// 扫描游戏地图
		for (int y = 0; y < gameDto.GAMEZONE_H; y++) {
			// 判断是否可以消行
			if (isCanRemoveLine(y, map)) {
				this.removeLine(y, map);
				// 增加经验
				exp++;
			}

		}
		return exp;
	}

	/**
	 * 方块上涨
	 */
	public void actAddUp(boolean[][] map) {
		// if (!this.gameDto.isActUp()) {
		// return;
		// }
		for (int x = 0; x < this.gameDto.GAMEZONE_W; x++) {
			for (int y = 0; y < this.gameDto.GAMEZONE_H - 1; y++) {
				map[x][y] = map[x][y + 1];

			}
			for (int i = 0; i < this.gameDto.GAMEZONE_W; i++) {
				map[i][17] = block();
			}
		}

	}

	private boolean block() {
		Random ran = new Random();
		if (ran.nextInt(2) == 1) {
			return false;
		}
		return true;
	}

	/**
	 * 消行处理
	 * 
	 * @param y
	 * @param map
	 */
	private void removeLine(int rowNumber, boolean[][] map) {
		for (int x = 0; x < gameDto.GAMEZONE_W; x++) {
			for (int y = rowNumber; y > 0; y--) {
				map[x][y] = map[x][y - 1];
				// 播放消行音乐
				musicService.playCRM();
			}
			map[x][0] = false;
		}

	}

	/**
	 * 
	 * 判断y行是否可消除(算是一层内循环)
	 */
	private boolean isCanRemoveLine(int y, boolean[][] map) {

		for (int x = 0; x < GameDto.GAMEZONE_W; x++)// 单行对每一个格子进行扫描
		{
			if (!map[x][y]) {
				// 如果有一个方格为false，则直接跳到下一行
				return false;// 跳到
			}
		}

		return true;

	}

	/**
	 * 按方向键上
	 */
	public boolean keyUp() {
		if (!this.gameDto.isStar()) {
			return true;
		}
		if (this.gameDto.isPause()) {
			return true;
		}

		this.gameDto.getGameAct().round(this.gameDto.getGameMap());

		return true;

	}

	/**
	 * 按方向键左
	 */
	public boolean keyLeft() {
		if (!this.gameDto.isStar()) {
			return true;
		}
		if (this.gameDto.isPause()) {
			return true;
		}
		this.gameDto.getGameAct().move(-1, 0, this.gameDto.getGameMap());
		return true;
	}

	/**
	 * 按方向键右
	 */
	public boolean keyRight() {
		if (!this.gameDto.isStar()) {
			return true;
		}
		if (this.gameDto.isPause()) {
			return true;
		}
		this.gameDto.getGameAct().move(1, 0, this.gameDto.getGameMap());

		return true;
	}

	/**
	 * 瞬间下落
	 */
	public boolean keyFunDown() {
		if (!this.gameDto.isStar()) {
			return true;
		}
		if (this.gameDto.isPause()) {
			return true;
		}
		while (!this.keyDown())
			;
		return true;
	}

	/**
	 * 阴影开关
	 */
	public boolean keyForShadow() {
		if (!this.gameDto.isStar()) {
			return true;
		}
		this.gameDto.changeShowShadow();
		return true;
	}

	/**
	 * 绘制方格开关
	 */
	public boolean keyForGraticule() {
		if (!this.gameDto.isStar()) {
			return true;
		}
		this.gameDto.changeShowGraticule();
		return true;
	}
	/**
	 * 暂停
	 */
	public boolean keyForPause() {
		if (this.gameDto.isStar()) {
			this.gameDto.changePause();
		}
		return true;
	}

	/**
	 * 启动游戏
	 */
	public void starGame() {
		// 随机生成下一个方块
		this.gameDto.setNext(gameDto.MAX_TYPE);
		// 随机生成现在方块
		this.gameDto.setGameAct(new GameAct(random.nextInt(gameDto.MAX_TYPE)));
		// 设置游戏状态为开始
		this.gameDto.setStar(true);
		// gameDto初始化
		this.gameDto.gameDtoInit();
	}

	/**
	 * 游戏主行为
	 */
	public void mainAction() {
		this.keyDown();

	}

	// ------------------------------------------------------------
	public boolean testLevelUp() {

		int point = this.gameDto.getNowPoint();

		int rmLine = this.gameDto.getNowRemoveLine();

		int lv = this.gameDto.getNowLevel();

		point += 10;
		rmLine += 1;

		if (rmLine % 10 == 0) {
			lv += 1;
		}
		this.gameDto.setNowPoint(point);
		this.gameDto.setNowRemoveLine(rmLine);
		this.gameDto.setNowLevel(lv);

		return true;

	}



}
