package com.zxy.control;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

public class MusicService {
	File clearRowMusic = new File("sound\\œ˚––.wav");
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
	 * —≠ª∑≤•∑≈±≥æ∞“Ù¿÷
	 */
	public void playBGM() {
		bgm.loop();
	}

	/**
	 * Õ£÷π±≥æ∞“Ù¿÷
	 */
	public void stopBGM() {
		bgm.stop();
	}

	/**
	 * ≤•∑≈œ˚––“Ù¿÷“ª¥Œ
	 */
	public void playCRM() {
		crm.play();
	}

	/**
	 * ≤•∑≈’®µØ“Ù–ß
	 */
	public void playBM() {
		bm.play();
	}

}
