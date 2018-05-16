package com.zxy.view.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.zxy.model.GameDto;

/**
 * 一个画窗口的类
 * 
 * @author 陈先生
 *
 */
public abstract class Layer {

	public static final int PADDING = 16;

	private static final int SEVEN = 7;

	protected static final int SIZE = 7;


	private static final int IMG_W = Img.WINDOW.getWidth(null);

	private static final int IMG_H = Img.WINDOW.getHeight(null);
	
	private static final Image IMG_NUMBER = new ImageIcon("graphics/string/num.png").getImage();

	protected static final int IMG_NUMBER_W = 26;

	private static final int IMG_NUMBER_H = 36;
	

	protected static final int IMG_RECT_H = Img.RECT.getHeight(null);	// 矩形值槽图片的(内矩形高度)

	private static final int IMG_RECT_W =Img.RECT.getWidth(null);	// 矩形值槽图片的(内矩形宽度)

	private static final Font DED_FONT_ = new Font("黑体", Font.BOLD, 20);	// 默认字体

	private final int rectW;	// 经验值曹植宽度（外矩形）
	
	/**
	 * 窗口的左上角左边x
	 */
	protected int xPoint;
	/**
	 * 窗口的左上角左边y
	 */
	protected int yPoint;
	/**
	 * 窗口的宽度
	 */
	protected int w;
	/**
	 * 窗口的高度
	 */
	protected int h;
	
	protected   GameDto gameDto=null;

	protected Layer(int xPoint, int yPoint, int w, int h ) {

		this.xPoint = xPoint;
		this.yPoint = yPoint;
		this.w = w;
		this.h = h;
		
		this.rectW = this.w - PADDING * 2;

	}

	/**
	 * 绘制窗口用
	 */
	protected void createWindow(Graphics g) {

		// 左上
		g.drawImage(Img.WINDOW, xPoint, yPoint, xPoint + SEVEN, yPoint + SEVEN, 0, 0, SIZE, SIZE, null);
		// 中上
		g.drawImage(Img.WINDOW, xPoint + SEVEN, yPoint, xPoint + w - SEVEN, yPoint + SEVEN, SIZE, 0, IMG_W - SIZE, SIZE,
				null);
		// 右上
		g.drawImage(Img.WINDOW, xPoint + w - SEVEN, yPoint, xPoint + w, yPoint + SEVEN, IMG_W - SIZE, 0, IMG_W, SIZE,
				null);
		// 左中
		g.drawImage(Img.WINDOW, xPoint, yPoint + SEVEN, xPoint + SEVEN, yPoint + h - SEVEN, 0, SIZE, SIZE, IMG_H - SIZE,
				null);
		// 中
		g.drawImage(Img.WINDOW, xPoint + SEVEN, yPoint + SEVEN, xPoint + w - SEVEN, yPoint + h - SEVEN, SIZE, SIZE,
				IMG_W - SIZE, IMG_H - SIZE, null);
		// 右中
		g.drawImage(Img.WINDOW, xPoint + w - SEVEN, yPoint + SEVEN, xPoint + w, yPoint + h - SEVEN, IMG_W - SIZE, SIZE,
				IMG_W, IMG_H - SIZE, null);
		// 左下
		g.drawImage(Img.WINDOW, xPoint, yPoint + h - SEVEN, xPoint + SEVEN, yPoint + h, 0, IMG_H - SIZE, SIZE, IMG_H,
				null);
		// 中下
		g.drawImage(Img.WINDOW, xPoint + SEVEN, yPoint + h - SEVEN, xPoint + w - SEVEN, yPoint + h, SIZE, IMG_H - SIZE,
				IMG_W - SIZE, IMG_H, null);
		// 右下
		g.drawImage(Img.WINDOW, xPoint + w - SEVEN, yPoint + h - SEVEN, xPoint + w, yPoint + h, IMG_W - SIZE,
				IMG_H - SIZE, IMG_W, IMG_H, null);
	}

	/**
	 * 刷新游戏
	 * 
	 * @param g
	 *            画笔
	 */
	abstract public void paint(Graphics g);

	public void setGameDto(GameDto gameDto) {
		this.gameDto = gameDto;
	}
	
	
	/**
	 * 显示等级数
	 * 
	 * @param x
	 * @param y
	 * @param num
	 * @param g
	 */
	protected void drawNumberLeftPad(int x, int y, int num, int maxBit, Graphics g) {
		// 把要打印的数字转换成字符串
		String strNum = Integer.toString(num);
		// 绘制字符串右对齐
		for (int i = 0; i < maxBit; i++) {
			// 判断是否满足绘制条件
			if (maxBit - i <= strNum.length()) {
				// 获得数字在字符串中的下标
				int idx = i - maxBit + strNum.length();
				// 把数字NUMBER中的每一位取出
				int bit = strNum.charAt(idx) - '0';
				// 绘制数字
				g.drawImage(IMG_NUMBER, this.xPoint + x + IMG_NUMBER_W * i, this.yPoint + y,
						this.xPoint + x + IMG_NUMBER_W * (i + 1), this.yPoint + y + IMG_NUMBER_H, bit * IMG_NUMBER_W, 0,
						(bit + 1) * IMG_NUMBER_W, IMG_NUMBER_H, null);
			}

		}

	}

	/**
	 * 绘制值槽 参数（， ， 需要绘制的数值，当前曹值的分与曹值总分的比值，）
	 */
	protected void drawRect(int y, String title, String number, double percent, Graphics g) {
		// 各种值初始化
		int rect_x = this.xPoint + PADDING;// 外框x坐标，this.x+是必须写的。所以给它一次初始化
		int rect_y = this.yPoint + y;// 外框y坐标

		// 绘制背景
		g.setColor(Color.BLACK);
		g.fillRect(rect_x, rect_y, this.rectW, IMG_RECT_H + 4);
		g.setColor(Color.WHITE);
		g.fillRect(rect_x + 1, rect_y + 1, this.rectW - 2, IMG_RECT_H + 2);
		g.setColor(Color.BLACK);
		g.fillRect(rect_x + 2, rect_y + 2, this.rectW - 4, IMG_RECT_H);

		// 求出宽度
		int w = (int) (percent * (this.rectW - 4));
		// 求出颜色,subIdx是当前消行应截取的rect图片宽度。用来做被截图的左上x坐标，
		// 右下x坐标是subIdx+1（因为是渐变图，加1使更像一种颜色），截取宽度变化一次，颜色变化一次（从左往右均匀
		// 跳过几像素截一像素）。
		int subIdx = (int) (percent * IMG_RECT_W) - 1;
		// 绘制值槽
		g.drawImage(Img.RECT, rect_x + 2, rect_y + 2, rect_x + 2 + w, rect_y + 2 + IMG_RECT_H, subIdx, 0, subIdx + 1,
				IMG_RECT_H, null);
		g.setColor(Color.WHITE);
		g.setFont(DED_FONT_);
		g.drawString(title, rect_x + 4, rect_y + 22);
		if (number != null) {
			// 绘制数值
			g.drawString(number, rect_x + 160, rect_y + 22);
		}
	}
	
	/**
	 * 绘制图片在区域中间
	 * 
	 * @param img
	 * @param g
	 */
	protected void drawImageAtCenter(Image img, Graphics g) {

		int imgW = img.getWidth(null);
		int imgH = img.getHeight(null);
		g.drawImage(img, this.xPoint + (this.w - imgW >> 1), this.yPoint + (this.h - imgH >> 1), null);
	};
}
