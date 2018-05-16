package com.zxy.control;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

public class MusicService {
	File clearRowMusic = new File("sound\\����.wav");
	File backgroundMusic = new File("sound\\background.wav");
	File bombMusic = new File("sound\\over.wav");
	AudioClip crm, bgm, bm;

	@SuppressWarnings("deprecation")
	public MusicService() {
		try {
			crm = Applet.newAudioClip(clearRowMusic.toURL());
			bgm = Applet.newAudioClip(backgroundMusic.toURL());
			bm = Applet.newAudioClip(bombMusic.toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ѭ�����ű�������
	 */
	public void playBGM() {
		bgm.loop();
	}

	/**
	 * ֹͣ��������
	 */
	public void stopBGM() {
		bgm.stop();
	}

	/**
	 * ������������һ��
	 */
	public void playCRM() {
		crm.play();
	}

	/**
	 * ����ը����Ч
	 */
	public void playBM() {
		bm.play();
	}

}
