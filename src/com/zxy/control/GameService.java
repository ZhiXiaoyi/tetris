package com.zxy.control;

import java.awt.Point;
import java.util.Random;

import com.zxy.model.GameAct;
import com.zxy.model.GameDto;
import com.zxy.view.JDialogCustom;

/**
 * ��Ϸ�Լ����߼�
 * 
 * @author ������
 *
 */
public class GameService {

	private GameDto gameDto;

	private MusicService musicService;

	private Random random = new Random();

	private JDialogCustom mCustomJDialog;

	private static final int LEVEL_UP = 10; // ����������Ĭ��10��

	public GameService(JDialogCustom mCustomJDialog, GameDto gameDto, MusicService musicService) {

		this.gameDto = gameDto;

		this.musicService = musicService;

		this.mCustomJDialog = mCustomJDialog;

	}

	/**
	 * ���������
	 */
	public boolean keyDown() {
		if (!this.gameDto.isStar()) {
			return true;
		}
		if (this.gameDto.isPause()) {
			return true;
		}
		// ���������ƶ��������ж��Ƿ�����ƶ��ɹ�
		if (this.gameDto.getGameAct().move(0, 1, this.gameDto.getGameMap())) {
			return false;
		}
		// �����Ϸ��ͼ����
		boolean[][] map = this.gameDto.getGameMap();
		Point[] act = this.gameDto.getGameAct().getActPoints();
		// ������ѻ�����ͼ����
		for (int i = 0; i < act.length; i++) {
			map[act[i].x][act[i].y] = true;
		}
		// �ӷֲ��������溬�����в�����
		int plusExp = this.plusExp();
		// ���Ӿ���ֵ ����
		this.plusPoint(plusExp);
		// ��������
		if (this.mCustomJDialog.blockAddUp) {
			this.gameDto.setTime(gameDto.getTime() + 1);
			if (gameDto.getTime() == 5) {
				this.actAddUp(gameDto.getGameMap());
				this.gameDto.setTime(1);
			}

		}

		// ˢ��һ������
		this.gameDto.getGameAct().init(this.gameDto.getNext());
		// �漴��������һ������
		this.gameDto.setNext(random.nextInt(gameDto.MAX_TYPE));
		// �����Ϸ�Ƿ�ʧ��
		if (this.isLose()) {
			// ��Ϸ��ʼ״̬Ϊfalse
			musicService.playBM();
			this.gameDto.setStar(false);
		}
		return true;
	}

	/**
	 * �����Ϸ�Ƿ�ʧ��
	 */
	private boolean isLose() {
		// ������ڵķ���
		Point[] actPoints = gameDto.getGameAct().getActPoints();
		//������ڵĵ�ͼ
		boolean[][] map = gameDto.getGameMap();
		for (int i = 0; i < actPoints.length; i++) {
			if (map[actPoints[i].x][actPoints[i].y]) {
				return true;
			}
		}

		return false;
	}

	/**
	 * ��������
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
	 * �ӷֲ���
	 */
	private int plusExp() {

		boolean[][] map = this.gameDto.getGameMap();
		int exp = 0;
		// ɨ����Ϸ��ͼ
		for (int y = 0; y < gameDto.GAMEZONE_H; y++) {
			// �ж��Ƿ��������
			if (isCanRemoveLine(y, map)) {
				this.removeLine(y, map);
				// ���Ӿ���
				exp++;
			}

		}
		return exp;
	}

	/**
	 * ��������
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
	 * ���д���
	 * 
	 * @param y
	 * @param map
	 */
	private void removeLine(int rowNumber, boolean[][] map) {
		for (int x = 0; x < gameDto.GAMEZONE_W; x++) {
			for (int y = rowNumber; y > 0; y--) {
				map[x][y] = map[x][y - 1];
				// ������������
				musicService.playCRM();
			}
			map[x][0] = false;
		}

	}

	/**
	 * 
	 * �ж�y���Ƿ������(����һ����ѭ��)
	 */
	private boolean isCanRemoveLine(int y, boolean[][] map) {

		for (int x = 0; x < GameDto.GAMEZONE_W; x++)// ���ж�ÿһ�����ӽ���ɨ��
		{
			if (!map[x][y]) {
				// �����һ������Ϊfalse����ֱ��������һ��
				return false;// ����
			}
		}

		return true;

	}

	/**
	 * ���������
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
	 * ���������
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
	 * ���������
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
	 * ˲������
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
	 * ��Ӱ����
	 */
	public boolean keyForShadow() {
		if (!this.gameDto.isStar()) {
			return true;
		}
		this.gameDto.changeShowShadow();
		return true;
	}

	/**
	 * ���Ʒ��񿪹�
	 */
	public boolean keyForGraticule() {
		if (!this.gameDto.isStar()) {
			return true;
		}
		this.gameDto.changeShowGraticule();
		return true;
	}
	/**
	 * ��ͣ
	 */
	public boolean keyForPause() {
		if (this.gameDto.isStar()) {
			this.gameDto.changePause();
		}
		return true;
	}

	/**
	 * ������Ϸ
	 */
	public void starGame() {
		// ���������һ������
		this.gameDto.setNext(gameDto.MAX_TYPE);
		// ����������ڷ���
		this.gameDto.setGameAct(new GameAct(random.nextInt(gameDto.MAX_TYPE)));
		// ������Ϸ״̬Ϊ��ʼ
		this.gameDto.setStar(true);
		// gameDto��ʼ��
		this.gameDto.gameDtoInit();
	}

	/**
	 * ��Ϸ����Ϊ
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
