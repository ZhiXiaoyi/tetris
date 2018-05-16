package com.zxy.view.ui;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

/**
 * 图片管理
 * 
 * @author 陈先生
 *
 */
public class Img {

	private Img() {
	}
	// Layer 窗口图片
	public static Image WINDOW = new ImageIcon("graphics/window/Window.png").getImage();
	// Layer 数字图片(0-9)
	public static Image NUMBER = new ImageIcon("graphics/string/num.png").getImage();
	// Layer 矩形值槽图片
	public static Image RECT = new ImageIcon("graphics/window/rect.png").getImage();
	// LayerGame 方块长条
	public static Image ACT = new ImageIcon("graphics/game/rectt.png").getImage();
	// LayerLevel 标题图片
	public static Image LEVEL = new ImageIcon("graphics/string/level.png").getImage();
	// LayerPoint 标题图片（分数）
	public static Image POINT = new ImageIcon("graphics/string/point.png").getImage();
	// LayerPoint 标题图片（消行）
	public static Image RMLINE = new ImageIcon("graphics/string/rmline.png").getImage();
	// 阴影图片
	public static Image SHADOW = new ImageIcon("graphics/game/shadow.png").getImage();
	// 暂停图片
	public static Image PAUSE = new ImageIcon("graphics/string/pause.png").getImage();
	// 开始图片
	public static ImageIcon STAR_ICON = new ImageIcon("graphics/string/star.png");
	// 设置图片
	public static ImageIcon CONFIG_ICON = new ImageIcon("graphics/string/config.png");
	// 下一个方块
	public static Image[] NEXT_ACT;

	public static List<Image> BG_LIST;

	static {
		NEXT_ACT = new Image[9];
		for (int i = 0; i < NEXT_ACT.length; i++) {
			NEXT_ACT[i] = new ImageIcon("graphics/game/" + i + ".png").getImage();
		}

		// 背景图片数组
		File dir = new File("graphics/background");
		File[] files = dir.listFiles();
		BG_LIST = new ArrayList();
		for (File file : files) {
			if (!file.isDirectory()) {// 如果是文件夹，跳过
				BG_LIST.add(new ImageIcon(file.getPath()).getImage());
			}

		}
	}
}
