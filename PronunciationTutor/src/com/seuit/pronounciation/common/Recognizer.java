package com.seuit.pronounciation.common;

import java.io.File;

import edu.cmu.pocketsphinx.SpeechRecognizer;

public class Recognizer {

	/**
	 * models directory for speech recognition
	 */
	public static File modelsDir;

	/**
	 * recognizer
	 */
	public static SpeechRecognizer recognizer;

	private Recognizer() {
	}

	public static void setModelsDir(File m) {
		modelsDir = m;
	}

	public static File getModelsDir() {
		return modelsDir;
	}

	public static void setSpeechRecognizer(SpeechRecognizer r) {
		recognizer = r;
	}

	public static SpeechRecognizer getSpeechRecognizer() {
		return recognizer;
	}
}
