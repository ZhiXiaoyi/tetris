package com.zxy.config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


/**
 * ��Ϸ������
 * 
 * @author ������
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

		// ����XML��ȡ��
		SAXReader reader = new SAXReader();
		// ��ȡXML�ļ�
		Document doc = reader.read("config/cfg.xml");
		// ��ȡXML�ļ��ĸ���� // �õ�xml�ļ���Ԫ��
		Element game = doc.getRootElement();
		// // ���ô���
		// Element fram = game.element("frame");
		// ���ô���
		this.setUiConfig(game.element("frame"));
	}

	/**
	 * ���ô���
	 * 
	 * @param fram
	 */
	@SuppressWarnings("unchecked")
	private void setUiConfig(Element fram) {
		// ��ȡ���ڱ���
		this.title = fram.attributeValue("title");
		// ��ȡ���ڿ��
		this.width = Integer.parseInt(fram.attributeValue("width"));
		// ��ȡ���ڸ߶�
		this.height = Integer.parseInt(fram.attributeValue("height"));
		// ��ȡ�߿��ϸ
		this.windowSize = Integer.parseInt(fram.attributeValue("windowSize"));
		// ��ȡ�߿��ڱ߾�
		this.padding = Integer.parseInt(fram.attributeValue("padding"));
		// ��ȡ��������
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
