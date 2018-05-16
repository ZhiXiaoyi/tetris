package com.zxy.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.zxy.config.ConfigFactory;
import com.zxy.config.GameConfig;
import com.zxy.config.LayerConfig;
import com.zxy.control.GameControl;
import com.zxy.control.PlayerControl;
import com.zxy.model.GameDto;
import com.zxy.view.ui.Img;
import com.zxy.view.ui.Layer;

/**
 * ��Ϸ������� ����������Ӹ���Layer
 * 
 * @author ������
 *
 */
@SuppressWarnings("serial")
public class JPanelGame extends JPanel {

	private List<Layer> layers = null;

	private JButton btnStart;// ��ʼ��ť

	private JButton btnConfig;// ���ð�ť

	private GameControl gameControl = null;
	
	private GameDto gameDto= null;
	
	private JDialogCustom mCustomJDialog;

	public JPanelGame(GameControl gameControl, GameDto gameDto,JDialogCustom mCustomJDialog) {
		// ������Ϸ������
		this.gameControl = gameControl;
		
		this.gameDto = gameDto;
		
		this.mCustomJDialog=mCustomJDialog;

		// ��ʼ����
		this.initLayer();
		this.setLayout(null);
		// ��ʼ���ؼ�
		this.initComponent();
		// ��װ���̼���
		this.setGameControl();

	}

	/**
	 * �����������ĵĴ�С
	 */

	private void initLayer() {

		// layers = new Layer[] {
		// new LayerBackground(0, 0, 1162, 654),
		// new LayerDataBase(40, 32, 334, 279),
		// new LayerDisk(40, 343, 334, 279),
		// new LayerGame(414, 32, 334, 590),
		// new LayerButton(788, 32, 334, 124),
		// new LayerNext(788, 188, 176, 148),
		// new LayerLevel(964, 188, 158, 148),
		// new LayerPoint(788, 368, 334, 200),
		//
		// };
		try {
			// �����Ϸ����
			GameConfig cfg = ConfigFactory.getGameConfig();
			// ��ò�(frame��ǩ��)���ã������б�
			List<LayerConfig> layersCfg = cfg.getLayersConfig();
			// ������Ϸ������
			layers = new ArrayList<Layer>(layersCfg.size());// ��size��Ч�ʸ�
			// ѭ���������в����
			for (LayerConfig layerCfg : layersCfg) {
				// ��������(�������÷��䣬��ͨ�������ַ�������������)
				Class<?> cls = Class.forName(layerCfg.getClassName());
				// ��ù��캯�� (Constructor��������)
				Constructor<?> ctr = cls.getConstructor(int.class, int.class, int.class, int.class);
				// ���ù��캯���������� ctr.newInstance()
				Layer layer = (Layer) (ctr.newInstance(layerCfg.getxPoint(), layerCfg.getyPoint(), layerCfg.getW(),
						layerCfg.getH()));
				// ������Ϸ���ݶ�������Layer�ڲ���������GameDto��
				layer.setGameDto(gameDto);
				// �Ѵ�����Layer������뼯��
				layers.add(layer);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * ��װ��ҿ�����
	 * 
	 * @param playerControl
	 */
	public void setGameControl() {
		
		PlayerControl playerControl = new PlayerControl(gameControl);
		
		this.addKeyListener(playerControl);

	}

	@Override
	protected void paintComponent(Graphics g) {

		// ���ظ��෽��
		super.paintComponent(g);

		// ѭ��ˢ����Ϸ����//ˢ�²㴰��
		for (int i = 0; i < layers.size(); i++)
			layers.get(i).paint(g);

		// ���ؽ���
		this.requestFocus();

	}

	/**
	 * ��ʼ���ؼ�
	 */
	private void initComponent() {
		// ��ʼ����ʼ��ť��
		this.btnStart = new JButton(Img.STAR_ICON);
		// ���ÿ�ʼ��ť����λ��
		this.btnStart.setBounds(this.getX() + 835, this.getY() + 55, 105, 100);
		// ����ʼ��ť�����¼�����
		this.btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				gameControl.star();
			}
		});
		this.add(btnStart);
		// ��ʼ�����ð�ť��
		this.btnConfig = new JButton(Img.CONFIG_ICON);
		// ���� ���ð�ť����λ��
		this.btnConfig.setBounds(this.getX() + 970, this.getY() + 55, 105, 100);
		// �����ð�ť�����¼�����
		this.btnConfig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mCustomJDialog.getCustomDialog().setVisible(true);
			}
		});
		this.add(btnConfig);

	}

	/**
	 * ���ư�ť�Ƿ�ɵ��
	 */
	public void buttonSwitch(boolean onOff) {
		this.btnConfig.setEnabled(onOff);
		this.btnStart.setEnabled(onOff);

	}

	public void setGameControl(GameControl gameControl) {
		this.gameControl = gameControl;
	}

	public GameDto getGameDto() {
		return gameDto;
	}

}