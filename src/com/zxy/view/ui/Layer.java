package com.zxy.view.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.zxy.model.GameDto;

/**
 * һ�������ڵ���
 * 
 * @author ������
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
	

	protected static final int IMG_RECT_H = Img.RECT.getHeight(null);	// ����ֵ��ͼƬ��(�ھ��θ߶�)

	private static final int IMG_RECT_W =Img.RECT.getWidth(null);	// ����ֵ��ͼƬ��(�ھ��ο��)

	private static final Font DED_FONT_ = new Font("����", Font.BOLD, 20);	// Ĭ������

	private final int rectW;	// ����ֵ��ֲ��ȣ�����Σ�
	
	/**
	 * ���ڵ����Ͻ����x
	 */
	protected int xPoint;
	/**
	 * ���ڵ����Ͻ����y
	 */
	protected int yPoint;
	/**
	 * ���ڵĿ��
	 */
	protected int w;
	/**
	 * ���ڵĸ߶�
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
	 * ���ƴ�����
	 */
	protected void createWindow(Graphics g) {

		// ����
		g.drawImage(Img.WINDOW, xPoint, yPoint, xPoint + SEVEN, yPoint + SEVEN, 0, 0, SIZE, SIZE, null);
		// ����
		g.drawImage(Img.WINDOW, xPoint + SEVEN, yPoint, xPoint + w - SEVEN, yPoint + SEVEN, SIZE, 0, IMG_W - SIZE, SIZE,
				null);
		// ����
		g.drawImage(Img.WINDOW, xPoint + w - SEVEN, yPoint, xPoint + w, yPoint + SEVEN, IMG_W - SIZE, 0, IMG_W, SIZE,
				null);
		// ����
		g.drawImage(Img.WINDOW, xPoint, yPoint + SEVEN, xPoint + SEVEN, yPoint + h - SEVEN, 0, SIZE, SIZE, IMG_H - SIZE,
				null);
		// ��
		g.drawImage(Img.WINDOW, xPoint + SEVEN, yPoint + SEVEN, xPoint + w - SEVEN, yPoint + h - SEVEN, SIZE, SIZE,
				IMG_W - SIZE, IMG_H - SIZE, null);
		// ����
		g.drawImage(Img.WINDOW, xPoint + w - SEVEN, yPoint + SEVEN, xPoint + w, yPoint + h - SEVEN, IMG_W - SIZE, SIZE,
				IMG_W, IMG_H - SIZE, null);
		// ����
		g.drawImage(Img.WINDOW, xPoint, yPoint + h - SEVEN, xPoint + SEVEN, yPoint + h, 0, IMG_H - SIZE, SIZE, IMG_H,
				null);
		// ����
		g.drawImage(Img.WINDOW, xPoint + SEVEN, yPoint + h - SEVEN, xPoint + w - SEVEN, yPoint + h, SIZE, IMG_H - SIZE,
				IMG_W - SIZE, IMG_H, null);
		// ����
		g.drawImage(Img.WINDOW, xPoint + w - SEVEN, yPoint + h - SEVEN, xPoint + w, yPoint + h, IMG_W - SIZE,
				IMG_H - SIZE, IMG_W, IMG_H, null);
	}

	/**
	 * ˢ����Ϸ
	 * 
	 * @param g
	 *            ����
	 */
	abstract public void paint(Graphics g);

	public void setGameDto(GameDto gameDto) {
		this.gameDto = gameDto;
	}
	
	
	/**
	 * ��ʾ�ȼ���
	 * 
	 * @param x
	 * @param y
	 * @param num
	 * @param g
	 */
	protected void drawNumberLeftPad(int x, int y, int num, int maxBit, Graphics g) {
		// ��Ҫ��ӡ������ת�����ַ���
		String strNum = Integer.toString(num);
		// �����ַ����Ҷ���
		for (int i = 0; i < maxBit; i++) {
			// �ж��Ƿ������������
			if (maxBit - i <= strNum.length()) {
				// ����������ַ����е��±�
				int idx = i - maxBit + strNum.length();
				// ������NUMBER�е�ÿһλȡ��
				int bit = strNum.charAt(idx) - '0';
				// ��������
				g.drawImage(IMG_NUMBER, this.xPoint + x + IMG_NUMBER_W * i, this.yPoint + y,
						this.xPoint + x + IMG_NUMBER_W * (i + 1), this.yPoint + y + IMG_NUMBER_H, bit * IMG_NUMBER_W, 0,
						(bit + 1) * IMG_NUMBER_W, IMG_NUMBER_H, null);
			}

		}

	}

	/**
	 * ����ֵ�� �������� �� ��Ҫ���Ƶ���ֵ����ǰ��ֵ�ķ����ֵ�ֵܷı�ֵ����
	 */
	protected void drawRect(int y, String title, String number, double percent, Graphics g) {
		// ����ֵ��ʼ��
		int rect_x = this.xPoint + PADDING;// ���x���꣬this.x+�Ǳ���д�ġ����Ը���һ�γ�ʼ��
		int rect_y = this.yPoint + y;// ���y����

		// ���Ʊ���
		g.setColor(Color.BLACK);
		g.fillRect(rect_x, rect_y, this.rectW, IMG_RECT_H + 4);
		g.setColor(Color.WHITE);
		g.fillRect(rect_x + 1, rect_y + 1, this.rectW - 2, IMG_RECT_H + 2);
		g.setColor(Color.BLACK);
		g.fillRect(rect_x + 2, rect_y + 2, this.rectW - 4, IMG_RECT_H);

		// ������
		int w = (int) (percent * (this.rectW - 4));
		// �����ɫ,subIdx�ǵ�ǰ����Ӧ��ȡ��rectͼƬ��ȡ�����������ͼ������x���꣬
		// ����x������subIdx+1����Ϊ�ǽ���ͼ����1ʹ����һ����ɫ������ȡ��ȱ仯һ�Σ���ɫ�仯һ�Σ��������Ҿ���
		// ���������ؽ�һ���أ���
		int subIdx = (int) (percent * IMG_RECT_W) - 1;
		// ����ֵ��
		g.drawImage(Img.RECT, rect_x + 2, rect_y + 2, rect_x + 2 + w, rect_y + 2 + IMG_RECT_H, subIdx, 0, subIdx + 1,
				IMG_RECT_H, null);
		g.setColor(Color.WHITE);
		g.setFont(DED_FONT_);
		g.drawString(title, rect_x + 4, rect_y + 22);
		if (number != null) {
			// ������ֵ
			g.drawString(number, rect_x + 160, rect_y + 22);
		}
	}
	
	/**
	 * ����ͼƬ�������м�
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
