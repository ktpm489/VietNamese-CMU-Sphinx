package com.seuit.pronounciation.common;

import java.io.Serializable;
import java.util.ArrayList;

public class UserProfile implements Serializable {

	private static final long serialVersionUID = -581702561632077140L;

	/**
	 * name of user
	 */
	public String userName;

	public String gradeLevel;

	/**
	 * list of results in easy mode
	 */
	public ArrayList<ResultWrapper> lstEasyResult;

	/**
	 * list of results in normal mode
	 */
	public ArrayList<ResultWrapper> lstNormalResult;

	/**
	 * list of results in hard mode
	 */
	public ArrayList<ResultWrapper> lstHardResult;

	/**
	 * initialize UserProfile
	 */
	public UserProfile() {
		userName = "";
		gradeLevel = "";
		lstEasyResult = new ArrayList<ResultWrapper>();
		lstNormalResult = new ArrayList<ResultWrapper>();
		lstHardResult = new ArrayList<ResultWrapper>();
	}

}
