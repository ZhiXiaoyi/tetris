package com.zxy.view.ui;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

/**
 * ͼƬ����
 * 
 * @author ������
 *
 */
public class Img {

	private Img() {
	}
	// Layer ����ͼƬ
	public static Image WINDOW = new ImageIcon("graphics/window/Window.png").getImage();
	// Layer ����ͼƬ(0-9)
	public static Image NUMBER = new ImageIcon("graphics/string/num.png").getImage();
	// Layer ����ֵ��ͼƬ
	public static Image RECT = new ImageIcon("graphics/window/rect.png").getImage();
	// LayerGame ���鳤��
	public static Image ACT = new ImageIcon("graphics/game/rectt.png").getImage();
	// LayerLevel ����ͼƬ
	public static Image LEVEL = new ImageIcon("graphics/string/level.png").getImage();
	// LayerPoint ����ͼƬ��������
	public static Image POINT = new ImageIcon("graphics/string/point.png").getImage();
	// LayerPoint ����ͼƬ�����У�
	public static Image RMLINE = new ImageIcon("graphics/string/rmline.png").getImage();
	// ��ӰͼƬ
	public static Image SHADOW = new ImageIcon("graphics/game/shadow.png").getImage();
	// ��ͣͼƬ
	public static Image PAUSE = new ImageIcon("graphics/string/pause.png").getImage();
	// ��ʼͼƬ
	public static ImageIcon STAR_ICON = new ImageIcon("graphics/string/star.png");
	// ����ͼƬ
	public static ImageIcon CONFIG_ICON = new ImageIcon("graphics/string/config.png");
	// ��һ������
	public static Image[] NEXT_ACT;

	public static List<Image> BG_LIST;

	static {
		NEXT_ACT = new Image[9];
		for (int i = 0; i < NEXT_ACT.length; i++) {
			NEXT_ACT[i] = new ImageIcon("graphics/game/" + i + ".png").getImage();
		}

		// ����ͼƬ����
		File dir = new File("graphics/background");
		File[] files = dir.listFiles();
		BG_LIST = new ArrayList();
		for (File file : files) {
			if (!file.isDirectory()) {// ������ļ��У�����
				BG_LIST.add(new ImageIcon(file.getPath()).getImage());
			}

		}
	}
}
