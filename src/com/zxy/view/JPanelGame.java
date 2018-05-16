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
 * 游戏的主面板 在这里面添加各个Layer
 * 
 * @author 陈先生
 *
 */
@SuppressWarnings("serial")
public class JPanelGame extends JPanel {

	private List<Layer> layers = null;

	private JButton btnStart;// 开始按钮

	private JButton btnConfig;// 设置按钮

	private GameControl gameControl = null;
	
	private GameDto gameDto= null;
	
	private JDialogCustom mCustomJDialog;

	public JPanelGame(GameControl gameControl, GameDto gameDto,JDialogCustom mCustomJDialog) {
		// 链接游戏控制器
		this.gameControl = gameControl;
		
		this.gameDto = gameDto;
		
		this.mCustomJDialog=mCustomJDialog;

		// 初始化层
		this.initLayer();
		this.setLayout(null);
		// 初始化控件
		this.initComponent();
		// 安装键盘监听
		this.setGameControl();

	}

	/**
	 * 定义各个界面的的大小
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
			// 获得游戏配置
			GameConfig cfg = ConfigFactory.getGameConfig();
			// 获得层(frame标签层)配置（存入列表）
			List<LayerConfig> layersCfg = cfg.getLayersConfig();
			// 创建游戏层数组
			layers = new ArrayList<Layer>(layersCfg.size());// 填size，效率高
			// 循环创建所有层对象
			for (LayerConfig layerCfg : layersCfg) {
				// 获得类对象(这里利用反射，来通过类名字符串来创建对象)
				Class<?> cls = Class.forName(layerCfg.getClassName());
				// 获得构造函数 (Constructor构造器类)
				Constructor<?> ctr = cls.getConstructor(int.class, int.class, int.class, int.class);
				// 调用构造函数创建对象 ctr.newInstance()
				Layer layer = (Layer) (ctr.newInstance(layerCfg.getxPoint(), layerCfg.getyPoint(), layerCfg.getW(),
						layerCfg.getH()));
				// 设置游戏数据对象（利用Layer内部方法设置GameDto）
				layer.setGameDto(gameDto);
				// 把创建的Layer对象放入集合
				layers.add(layer);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 安装玩家控制器
	 * 
	 * @param playerControl
	 */
	public void setGameControl() {
		
		PlayerControl playerControl = new PlayerControl(gameControl);
		
		this.addKeyListener(playerControl);

	}

	@Override
	protected void paintComponent(Graphics g) {

		// 返回父类方法
		super.paintComponent(g);

		// 循环刷新游戏界面//刷新层窗口
		for (int i = 0; i < layers.size(); i++)
			layers.get(i).paint(g);

		// 返回焦点
		this.requestFocus();

	}

	/**
	 * 初始化控件
	 */
	private void initComponent() {
		// 初始化开始按钮键
		this.btnStart = new JButton(Img.STAR_ICON);
		// 设置开始按钮键的位置
		this.btnStart.setBounds(this.getX() + 835, this.getY() + 55, 105, 100);
		// 给开始按钮增加事件监听
		this.btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				gameControl.star();
			}
		});
		this.add(btnStart);
		// 初始化设置按钮键
		this.btnConfig = new JButton(Img.CONFIG_ICON);
		// 设置 设置按钮键的位置
		this.btnConfig.setBounds(this.getX() + 970, this.getY() + 55, 105, 100);
		// 给设置按钮增加事件监听
		this.btnConfig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mCustomJDialog.getCustomDialog().setVisible(true);
			}
		});
		this.add(btnConfig);

	}

	/**
	 * 控制按钮是否可点击
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