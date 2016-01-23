package com.seuit.pronounciation.common;

import java.io.Serializable;
import java.util.ArrayList;

public class ResultWrapper implements Serializable {

	private static final long serialVersionUID = -2693994326835555706L;

	public String dateAndTimePlayed;

	public ArrayList<String> lstWord;
	public ArrayList<Integer> lstScore;

	public ResultWrapper() {
		dateAndTimePlayed = "";
		lstWord = new ArrayList<String>();
		lstScore = new ArrayList<Integer>();
	}
}
