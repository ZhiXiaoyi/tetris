package com.zxy.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
/**
 * 玩家操作方法
 * 
 * @author 陈先生
 *
 */
public class PlayerControl extends KeyAdapter {

//	private JPanelGame gamePanel;

	private GameControl gameControl;

	public PlayerControl(GameControl gameControl) {

//		this.gamePanel = gamePanel;

		this.gameControl = gameControl;

	}

	/**(non-Javadoc)
	 * 
	 * 键盘按一下事件
	 * 
	 * @see java.awt.event.KeyAdapter#keyPressed(java.awt.event.KeyEvent)
	 **/
	@Override
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			this.gameControl.keyUp();
			break;
		case KeyEvent.VK_DOWN:
			this.gameControl.keyDown();
			break;
		case KeyEvent.VK_LEFT:
			this.gameControl.keyLeft();
			break;
		case KeyEvent.VK_RIGHT:
			this.gameControl.keyRight();
			break;
		case KeyEvent.VK_S://阴影控制
			this.gameControl.keyForShadow();
			break;
		case KeyEvent.VK_G://
			this.gameControl.keyForGraticule();
			break;
		case KeyEvent.VK_SPACE://快速下落
			this.gameControl.keyFunDown();
			break;
		case KeyEvent.VK_P://暂停/继续
			this.gameControl.keyForPause();
			break;
		case KeyEvent.VK_E:
			if(JOptionPane.showConfirmDialog(null, "确定退出？", "退出", JOptionPane.YES_NO_OPTION)==0)
				System.exit(0);
			break;
		case KeyEvent.VK_D://作弊加分键
			this.gameControl.testLevelUp();
			break;

		default:
			break;
		}
		

	}

}
