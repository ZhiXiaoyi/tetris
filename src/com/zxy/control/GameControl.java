package com.zxy.control;

import com.zxy.model.GameDto;
import com.zxy.view.JDialogCustom;
import com.zxy.view.JDialogShowPoint;
import com.zxy.view.JFrameGame;
import com.zxy.view.JMenuBarGame;
import com.zxy.view.JPanelGame;


/**
 * 接收玩家键盘事件 控制画面 控制游戏逻辑
 * 
 * @author 陈先生
 *
 */
public class GameControl {

	/**
	 * 游戏界面层
	 */
	private JPanelGame gamePanel;

	/**
	 * 游戏逻辑层
	 */
	private GameService gameService;

	/**
	 * 游戏线程
	 */
	private Thread gameThread = null;

	/**
	 * 游戏数据源
	 */
	private GameDto gameDto = null;

	/**
	 * 游戏失败得分界面
	 */
	private JDialogShowPoint showPointFrame;

	/**
	 * 音乐
	 */
	private MusicService musicService;

	/**
	 * 菜单栏
	 */
	private JMenuBarGame gameMenBar;

	/**
	 * 自定义面板
	 */
	private JDialogCustom mCustomJDialog;

	public GameControl() {
		// 初始化音乐
		this.musicService = new MusicService();
		// 初始化自定义面板
		this.mCustomJDialog = new JDialogCustom(this.musicService,this.gameDto);
		// 创建游戏数据源
		this.gameDto = new GameDto();
		// 创建游戏逻辑块（链接游戏数据源）
		this.gameService = new GameService(this.mCustomJDialog,this.gameDto, this.musicService);
		// 创建游戏面板
		this.gamePanel = new JPanelGame(this, this.gameDto, this.mCustomJDialog);
		// 初始化菜单栏
		this.gameMenBar = new JMenuBarGame(this,this.gamePanel, this.mCustomJDialog);
		// 初始化显示分数界面
		this.showPointFrame = new JDialogShowPoint(this);
		// 创建游戏窗口（安装游戏面板）
		new JFrameGame(this,this.gamePanel, this.gameMenBar);

	}

	/**
	 * 按方向键上
	 */
	public void keyUp() {

		this.gameService.keyUp();
		this.gamePanel.repaint();
	}

	/**
	 * 按方向键下
	 */
	public void keyDown() {
		this.gameService.keyDown();
		this.gamePanel.repaint();
	}

	/**
	 * 按方向键左
	 */
	public void keyLeft() {
		this.gameService.keyLeft();
		this.gamePanel.repaint();
	}

	/**
	 * 按方向键右
	 */
	public void keyRight() {
		this.gameService.keyRight();
		this.gamePanel.repaint();
	}

	/**
	 * 开始按钮事件
	 */
	public void star() {
		// 面板按钮设置不可点击
		this.gamePanel.buttonSwitch(false);
		// 关闭分数窗口
		this.showPointFrame.setVisible(false);
		// 开始游戏
		this.gameService.starGame();
		this.gamePanel.repaint();
		// 创建线程
		this.gameThread = new MainThread();
		// 启动线程
		this.gameThread.start();
		this.gamePanel.repaint();// 刷新画面
	}

	/**
	 * 游戏失败后的处理
	 */
	private void afterLose() {
		this.showPointFrame.showPoint(this.gameDto.getNowPoint());
		// //开始和设置按钮可以重新点击
		// this.gamePanel.buttonSwitch(true);

	}

	private class MainThread extends Thread {
		@SuppressWarnings("static-access")
		@Override
		public void run() {
			gamePanel.repaint();
			// 主循环
			while (gameDto.isStar()) {
				try {
					// 等待时间
					Thread.sleep(gameDto.SPEED);

					if (gameDto.isPause()) {
						continue;
					}
					// 游戏主行为(方块下落)
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
	 * 快速下落
	 */
	public void keyFunDown() {
		this.gameService.keyFunDown();
		this.gamePanel.repaint();
	}

	/**
	 * 阴影开关
	 */
	public void keyForShadow() {
		this.gameService.keyForShadow();
		this.gamePanel.repaint();
	}
	
	/**
	 * 绘制方格开关
	 */
	public void keyForGraticule() {
		this.gameService.keyForGraticule();
		this.gamePanel.repaint();
	}
	/**
	 * 暂停开关
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
