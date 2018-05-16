package com.zxy.config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


/**
 * 游戏配置器
 * 
 * @author 陈先生
 *
 */
public class GameConfig {

	private int width;

	private int height;

	private int windowSize;

	private int padding;

	private String title;

	private List<LayerConfig> layersConfig;

	public GameConfig() throws Exception {

		// 创建XML读取器
		SAXReader reader = new SAXReader();
		// 读取XML文件
		Document doc = reader.read("config/cfg.xml");
		// 获取XML文件的根结点 // 拿到xml文件根元素
		Element game = doc.getRootElement();
		// // 配置窗口
		// Element fram = game.element("frame");
		// 配置窗口
		this.setUiConfig(game.element("frame"));
	}

	/**
	 * 配置窗口
	 * 
	 * @param fram
	 */
	@SuppressWarnings("unchecked")
	private void setUiConfig(Element fram) {
		// 获取窗口标题
		this.title = fram.attributeValue("title");
		// 获取窗口宽度
		this.width = Integer.parseInt(fram.attributeValue("width"));
		// 获取窗口高度
		this.height = Integer.parseInt(fram.attributeValue("height"));
		// 获取边框粗细
		this.windowSize = Integer.parseInt(fram.attributeValue("windowSize"));
		// 获取边框内边距
		this.padding = Integer.parseInt(fram.attributeValue("padding"));
		// 获取窗体属性
		List<Element> layers = fram.elements("layer");
		layersConfig = new ArrayList<LayerConfig>();

		for (Element layer : layers) {
			LayerConfig lc = new LayerConfig(layer.attributeValue("className"),
					Integer.parseInt(layer.attributeValue("xPoint")), Integer.parseInt(layer.attributeValue("yPoint")),
					Integer.parseInt(layer.attributeValue("w")), Integer.parseInt(layer.attributeValue("h")));
			layersConfig.add(lc);
		}
	}



	public List<LayerConfig> getLayersConfig() {
		return layersConfig;
	}

	public void setLayersConfig(List<LayerConfig> layersConfig) {
		this.layersConfig = layersConfig;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getWindowSize() {
		return windowSize;
	}

	public int getPadding() {
		return padding;
	}

	public String getTitle() {
		return title;
	}

}
