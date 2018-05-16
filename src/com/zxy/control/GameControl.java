package com.zxy.control;

import com.zxy.model.GameDto;
import com.zxy.view.JDialogCustom;
import com.zxy.view.JDialogShowPoint;
import com.zxy.view.JFrameGame;
import com.zxy.view.JMenuBarGame;
import com.zxy.view.JPanelGame;


/**
 * ������Ҽ����¼� ���ƻ��� ������Ϸ�߼�
 * 
 * @author ������
 *
 */
public class GameControl {

	/**
	 * ��Ϸ�����
	 */
	private JPanelGame gamePanel;

	/**
	 * ��Ϸ�߼���
	 */
	private GameService gameService;

	/**
	 * ��Ϸ�߳�
	 */
	private Thread gameThread = null;

	/**
	 * ��Ϸ����Դ
	 */
	private GameDto gameDto = null;

	/**
	 * ��Ϸʧ�ܵ÷ֽ���
	 */
	private JDialogShowPoint showPointFrame;

	/**
	 * ����
	 */
	private MusicService musicService;

	/**
	 * �˵���
	 */
	private JMenuBarGame gameMenBar;

	/**
	 * �Զ������
	 */
	private JDialogCustom mCustomJDialog;

	public GameControl() {
		// ��ʼ������
		this.musicService = new MusicService();
		// ��ʼ���Զ������
		this.mCustomJDialog = new JDialogCustom(this.musicService,this.gameDto);
		// ������Ϸ����Դ
		this.gameDto = new GameDto();
		// ������Ϸ�߼��飨������Ϸ����Դ��
		this.gameService = new GameService(this.mCustomJDialog,this.gameDto, this.musicService);
		// ������Ϸ���
		this.gamePanel = new JPanelGame(this, this.gameDto, this.mCustomJDialog);
		// ��ʼ���˵���
		this.gameMenBar = new JMenuBarGame(this,this.gamePanel, this.mCustomJDialog);
		// ��ʼ����ʾ��������
		this.showPointFrame = new JDialogShowPoint(this);
		// ������Ϸ���ڣ���װ��Ϸ��壩
		new JFrameGame(this,this.gamePanel, this.gameMenBar);

	}

	/**
	 * ���������
	 */
	public void keyUp() {

		this.gameService.keyUp();
		this.gamePanel.repaint();
	}

	/**
	 * ���������
	 */
	public void keyDown() {
		this.gameService.keyDown();
		this.gamePanel.repaint();
	}

	/**
	 * ���������
	 */
	public void keyLeft() {
		this.gameService.keyLeft();
		this.gamePanel.repaint();
	}

	/**
	 * ���������
	 */
	public void keyRight() {
		this.gameService.keyRight();
		this.gamePanel.repaint();
	}

	/**
	 * ��ʼ��ť�¼�
	 */
	public void star() {
		// ��尴ť���ò��ɵ��
		this.gamePanel.buttonSwitch(false);
		// �رշ�������
		this.showPointFrame.setVisible(false);
		// ��ʼ��Ϸ
		this.gameService.starGame();
		this.gamePanel.repaint();
		// �����߳�
		this.gameThread = new MainThread();
		// �����߳�
		this.gameThread.start();
		this.gamePanel.repaint();// ˢ�»���
	}

	/**
	 * ��Ϸʧ�ܺ�Ĵ���
	 */
	private void afterLose() {
		this.showPointFrame.showPoint(this.gameDto.getNowPoint());
		// //��ʼ�����ð�ť�������µ��
		// this.gamePanel.buttonSwitch(true);

	}

	private class MainThread extends Thread {
		@SuppressWarnings("static-access")
		@Override
		public void run() {
			gamePanel.repaint();
			// ��ѭ��
			while (gameDto.isStar()) {
				try {
					// �ȴ�ʱ��
					Thread.sleep(gameDto.SPEED);

					if (gameDto.isPause()) {
						continue;
					}
					// ��Ϸ����Ϊ(��������)
					gameService.mainAction();

					gamePanel.repaint();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			afterLose();
		}
	}

	/**
	 * ��������
	 */
	public void keyFunDown() {
		this.gameService.keyFunDown();
		this.gamePanel.repaint();
	}

	/**
	 * ��Ӱ����
	 */
	public void keyForShadow() {
		this.gameService.keyForShadow();
		this.gamePanel.repaint();
	}
	
	/**
	 * ���Ʒ��񿪹�
	 */
	public void keyForGraticule() {
		this.gameService.keyForGraticule();
		this.gamePanel.repaint();
	}
	/**
	 * ��ͣ����
	 */
	public void keyForPause() {
		this.gameService.keyForPause();
		this.gamePanel.repaint();
	}

	public JPanelGame getGamePanel() {
		return gamePanel;
	}

	public GameDto getGameDto() {
		return gameDto;
	}

	// ------------------------------------------------------
	public void testLevelUp() {

		this.gameService.testLevelUp();
		this.gamePanel.repaint();
	}



}
