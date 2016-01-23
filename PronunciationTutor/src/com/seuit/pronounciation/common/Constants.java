package com.seuit.pronounciation.common;

import android.annotation.SuppressLint;
import java.util.ArrayList;

public class Constants {

	/**
	 * constant values used for transferring data between activities using keys
	 */
	public static final String KEYWORD_SEARCH = "keyword";
	public static final String PHONE_SEARCH = "phones";
	public static final String KWS_SEARCH = "keyphrase";

	public static final String GAMEMODE_EASY = "Học Nào";
	public static final String GAMEMODE_NORMAL = "Normal";
	public static final String GAMEMODE_HARD = "Hard";

	public static final String GRADELEVEL_3 = "Học Từ";
	public static final String GRADELEVEL_4 = "Học Chữ";
	public static final String GRADELEVEL_5 = "Học Số";

	public static final String GRADELEVEL3_MARKER = "#grade3";
	public static final String GRADELEVEL4_MARKER = "#grade4";
	public static final String GRADELEVEL5_MARKER = "#grade5";

	/**
	 * number of words to pronounce per game instance
	 */
	public static final int itemsPerGame = 10;

	/**
	 * list of word, threshold, image, and phoneme per game mode
	 */
	public static ArrayList<String> easyCorrect;
	public static ArrayList<String> easyWrong;
	public static ArrayList<Float> easyThreshold;
	public static ArrayList<String> easyImage;
	public static ArrayList<String> easyPhoneme;

	public static ArrayList<String> normalCorrect;
	public static ArrayList<String> normalWrong;
	public static ArrayList<Float> normalThreshold;
	public static ArrayList<String> normalImage;
	public static ArrayList<String> normalPhoneme;

	public static ArrayList<String> hardCorrect;
	public static ArrayList<String> hardWrong;
	public static ArrayList<Float> hardThreshold;
	public static ArrayList<String> hardImage;
	public static ArrayList<String> hardPhoneme;

	/**
	 * images directory per game mode
	 */
	public static final String easyImagesDir = "game_images/easy/";
	public static final String normalImagesDir = "game_images/normal/";
	public static final String hardImagesDir = "game_images/hard/";

	/**
	 * store scores
	 */
	public static final String userScoreFile = "userScore.txt";
	public static ArrayList<UserProfile> lstUserProfile;

	static {

		lstUserProfile = new ArrayList<UserProfile>();

		easyCorrect = new ArrayList<String>();
		easyWrong = new ArrayList<String>();
		easyThreshold = new ArrayList<Float>();
		easyImage = new ArrayList<String>();
		easyPhoneme = new ArrayList<String>();

		/*
		 * easyCorrect.add("BLACK#grade5"); easyWrong.add("BLOCK");
		 * easyThreshold.add(1e-20f); easyImage.add("BLACK - block.jpg");
		 * easyPhoneme.add("B L AE K");
		 * 
		 * easyCorrect.add("BLOND#grade5"); easyWrong.add("BLAND");
		 * easyThreshold.add(1e-25f); easyImage.add("BLOND - bland.jpg");
		 * easyPhoneme.add("B L AA N D");
		 * 
		 * easyCorrect.add("BOTTLE#grade5"); easyWrong.add("BATTLE");
		 * easyThreshold.add(1e-20f); easyImage.add("BOTTLE - battle.jpg");
		 * easyPhoneme.add("B AA T AH L");
		 * 
		 * easyCorrect.add("BOX#grade3"); easyWrong.add("BACKS");
		 * easyThreshold.add(1e-10f); easyImage.add("BOX - BACKS.jpg");
		 * easyPhoneme.add("B AA K S");
		 * 
		 * easyCorrect.add("BUG#grade3"); easyWrong.add("BAG");
		 * easyThreshold.add(1e-10f); easyImage.add("BUG - bag.jpg");
		 * easyPhoneme.add("B AH G");
		 * 
		 * easyCorrect.add("BUS#grade3"); easyWrong.add("BASS");
		 * easyThreshold.add(1e-10f); easyImage.add("BUS - bass.JPG");
		 * easyPhoneme.add("B AH S");
		 * 
		 * easyCorrect.add("CAT#grade3"); easyWrong.add("CUT");
		 * easyThreshold.add(1e-5f); easyImage.add("CAT - cut.jpg");
		 * easyPhoneme.add("K AE T");
		 * 
		 * easyCorrect.add("COP#grade3"); easyWrong.add("CAP");
		 * easyThreshold.add(1f); easyImage.add("COP - cap.jpg");
		 * easyPhoneme.add("K AA P");
		 * 
		 * easyCorrect.add("DIP#grade4"); easyWrong.add("DEEP");
		 * easyThreshold.add(1e-15f); easyImage.add("DIP - deep.jpg");
		 * easyPhoneme.add("D IH P");
		 * 
		 * easyCorrect.add("DRUM#grade4"); easyWrong.add("DRAM");
		 * easyThreshold.add(1e-20f); easyImage.add("DRUM - dram.jpg");
		 * easyPhoneme.add("D R AH M");
		 * 
		 * easyCorrect.add("GREEN#grade5"); easyWrong.add("GRIN");
		 * easyThreshold.add(1e-15f); easyImage.add("GREEN - grin.jpg");
		 * easyPhoneme.add("G R IY N");
		 * 
		 * easyCorrect.add("HEEL#grade4"); easyWrong.add("HILL");
		 * easyThreshold.add(1e-10f); easyImage.add("HEEL - hill.jpg");
		 * easyPhoneme.add("HH IY L");
		 * 
		 * easyCorrect.add("JUG#grade3"); easyWrong.add("JAG");
		 * easyThreshold.add(1e-10f); easyImage.add("JUG - jag.jpg");
		 * easyPhoneme.add("JH AH G");
		 * 
		 * easyCorrect.add("LEAVE#grade4"); easyWrong.add("LIVE");
		 * easyThreshold.add(1e-15f); easyImage.add("LEAVE - live.jpg");
		 * easyPhoneme.add("L IY V");
		 * 
		 * easyCorrect.add("LOG#grade3"); easyWrong.add("LAG");
		 * easyThreshold.add(1e-5f); easyImage.add("LOG - lag.jpg");
		 * easyPhoneme.add("L AO G");
		 * 
		 * easyCorrect.add("MEAT#grade5"); easyWrong.add("MEET");
		 * easyThreshold.add(1e-10f); easyImage.add("MEAT - meet.jpg");
		 * easyPhoneme.add("M IY T");
		 * 
		 * easyCorrect.add("MILL#grade5"); easyWrong.add("MEAL");
		 * easyThreshold.add(1e-10f); easyImage.add("MILL - meal.jpg");
		 * easyPhoneme.add("M IH L");
		 * 
		 * easyCorrect.add("MOP#grade3"); easyWrong.add("MAP");
		 * easyThreshold.add(1e-10f); easyImage.add("MOP - map.jpg");
		 * easyPhoneme.add("M AA P");
		 * 
		 * easyCorrect.add("PEAS#grade3"); easyWrong.add("PEACE");
		 * easyThreshold.add(1e-10f); easyImage.add("PEAS - peace.jpg");
		 * easyPhoneme.add("P IY Z");
		 * 
		 * easyCorrect.add("POOL#grade4"); easyWrong.add("PULL");
		 * easyThreshold.add(1e-5f); easyImage.add("POOL - pull.jpg");
		 * easyPhoneme.add("P UW L");
		 * 
		 * easyCorrect.add("RAT#grade3"); easyWrong.add("ROT");
		 * easyThreshold.add(1e-5f); easyImage.add("RAT - rot.jpg");
		 * easyPhoneme.add("R AE T");
		 * 
		 * easyCorrect.add("RICE#grade4"); easyWrong.add("RISE");
		 * easyThreshold.add(1e-10f); easyImage.add("RICE - rise.jpg");
		 * easyPhoneme.add("R AY S");
		 * 
		 * easyCorrect.add("ROCK#grade4"); easyWrong.add("RACK");
		 * easyThreshold.add(1e-10f); easyImage.add("ROCK - rack.jpg");
		 * easyPhoneme.add("R AA K");
		 * 
		 * easyCorrect.add("SACK#grade4"); easyWrong.add("SOCK");
		 * easyThreshold.add(1e-5f); easyImage.add("SACK - sock.jpg");
		 * easyPhoneme.add("S AE K");
		 * 
		 * easyCorrect.add("SEA#grade4"); easyWrong.add("SEE");
		 * easyThreshold.add(1e-10f); easyImage.add("SEA - see.jpg");
		 * easyPhoneme.add("S IY");
		 * 
		 * easyCorrect.add("STEEL#grade5"); easyWrong.add("STEAL");
		 * easyThreshold.add(1e-15f); easyImage.add("STEEL - steal.jpg");
		 * easyPhoneme.add("S T IY L");
		 * 
		 * easyCorrect.add("TAIL#grade4"); easyWrong.add("TALE");
		 * easyThreshold.add(1e-25f); easyImage.add("TAIL - tale.jpg");
		 * easyPhoneme.add("T EY L");
		 * 
		 * easyCorrect.add("TRUCK#grade5"); easyWrong.add("TRACK");
		 * easyThreshold.add(1e-20f); easyImage.add("TRUCK - track.jpg");
		 * easyPhoneme.add("T R AH K"); easyCorrect.add("TRUNK#grade5");
		 * easyWrong.add("TRANK"); easyThreshold.add(1e-20f);
		 * easyImage.add("TRUNK - trank.png"); easyPhoneme.add("T R AH NG K");
		 * 
		 * easyCorrect.add("WITCH#grade5"); easyWrong.add("WHICH");
		 * easyThreshold.add(1e-25f); easyImage.add("WITCH - which.jpg");
		 * easyPhoneme.add("W IH CH");
		 */
		easyCorrect.add("bi#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("bi.png");
		easyPhoneme.add("--");
		easyCorrect.add("bieern#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-5f);
		easyImage.add("bieern.png");
		easyPhoneme.add("--");
		easyCorrect.add("bof#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("bof.png");
		easyPhoneme.add("--");
		easyCorrect.add("boj#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-10f);
		easyImage.add("boj.png");
		easyPhoneme.add("--");
		easyCorrect.add("bosng#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-15f);
		easyImage.add("bosng.png");
		easyPhoneme.add("--");
		easyCorrect.add("bow#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-25f);
		easyImage.add("bow.png");
		easyPhoneme.add("--");
		easyCorrect.add("buwowsm#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-15f);
		easyImage.add("buwowsm.png");
		easyPhoneme.add("--");
		easyCorrect.add("caay#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-10f);
		easyImage.add("caay.png");
		easyPhoneme.add("--");
		easyCorrect.add("cas#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-30f);
		easyImage.add("cas.png");
		easyPhoneme.add("--");
		easyCorrect.add("caso#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-35f);
		easyImage.add("caso.png");
		easyPhoneme.add("--");
		easyCorrect.add("chai#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-5f);
		easyImage.add("chai.png");
		easyPhoneme.add("--");
		easyCorrect.add("chuoojt#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-25f);
		easyImage.add("chuoojt.png");
		easyPhoneme.add("--");
		easyCorrect.add("cof#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-5f);
		easyImage.add("cof.png");
		easyPhoneme.add("--");
		easyCorrect.add("ddawju#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("ddawju.png");
		easyPhoneme.add("--");
		easyCorrect.add("desp#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-15f);
		easyImage.add("desp.png");
		easyPhoneme.add("--");
		easyCorrect.add("dieefu#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-35f);
		easyImage.add("dieefu.png");
		easyPhoneme.add("--");
		easyCorrect.add("duf#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-10f);
		easyImage.add("duf.png");
		easyPhoneme.add("--");
		easyCorrect.add("eesch#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("eesch.png");
		easyPhoneme.add("--");
		easyCorrect.add("gaf#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-25f);
		easyImage.add("gaf.png");
		easyPhoneme.add("--");
		easyCorrect.add("gajch#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-30f);
		easyImage.add("gajch.png");
		easyPhoneme.add("--");
		easyCorrect.add("gajo#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-25f);
		easyImage.add("gajo.png");
		easyPhoneme.add("--");
		easyCorrect.add("ghees#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-5f);
		easyImage.add("ghees.png");
		easyPhoneme.add("--");
		easyCorrect.add("goox#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-10f);
		easyImage.add("goox.png");
		easyPhoneme.add("--");
		easyCorrect.add("guoosc#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("guoosc.png");
		easyPhoneme.add("--");
		easyCorrect.add("hoa#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-25f);
		easyImage.add("hoa.png");
		easyPhoneme.add("--");
		easyCorrect.add("hoor#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-15f);
		easyImage.add("hoor.png");
		easyPhoneme.add("--");
		easyCorrect.add("keso#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-35f);
		easyImage.add("keso.png");
		easyPhoneme.add("--");
		easyCorrect.add("las#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("las.png");
		easyPhoneme.add("--");
		easyCorrect.add("lee#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-15f);
		easyImage.add("lee.png");
		easyPhoneme.add("--");
		easyCorrect.add("luwju#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-30f);
		easyImage.add("luwju.png");
		easyPhoneme.add("--");
		easyCorrect.add("ly#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("ly.png");
		easyPhoneme.add("--");
		easyCorrect.add("maajn#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-15f);
		easyImage.add("maajn.png");
		easyPhoneme.add("--");
		easyCorrect.add("me#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-10f);
		easyImage.add("me.png");
		easyPhoneme.add("--");
		easyCorrect.add("mefo#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-15f);
		easyImage.add("mefo.png");
		easyPhoneme.add("--");
		easyCorrect.add("mux#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("mux.png");
		easyPhoneme.add("--");
		easyCorrect.add("nai#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-25f);
		easyImage.add("nai.png");
		easyPhoneme.add("--");
		easyCorrect.add("nguwja#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-35f);
		easyImage.add("nguwja.png");
		easyPhoneme.add("--");
		easyCorrect.add("noofi#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-10f);
		easyImage.add("noofi.png");
		easyPhoneme.add("--");
		easyCorrect.add("now#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("now.png");
		easyPhoneme.add("--");
		easyCorrect.add("ong#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-30f);
		easyImage.add("ong.png");
		easyPhoneme.add("--");
		easyCorrect.add("quaafn#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-15f);
		easyImage.add("quaafn.png");
		easyPhoneme.add("--");
		easyCorrect.add("quaf#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("quaf.png");
		easyPhoneme.add("--");
		easyCorrect.add("quyst#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-15f);
		easyImage.add("quyst.png");
		easyPhoneme.add("--");
		easyCorrect.add("rawsn#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-35f);
		easyImage.add("rawsn.png");
		easyPhoneme.add("--");
		easyCorrect.add("roofng#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("roofng.png");
		easyPhoneme.add("--");
		easyCorrect.add("rufa#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-10f);
		easyImage.add("rufa.png");
		easyPhoneme.add("--");
		easyCorrect.add("saau#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-5f);
		easyImage.add("saau.png");
		easyPhoneme.add("--");
		easyCorrect.add("sasch#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-10f);
		easyImage.add("sasch.png");
		easyPhoneme.add("--");
		easyCorrect.add("sosc#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-15f);
		easyImage.add("sosc.png");
		easyPhoneme.add("--");
		easyCorrect.add("taso#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("taso.png");
		easyPhoneme.add("--");
		easyCorrect.add("thufng#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-25f);
		easyImage.add("thufng.png");
		easyPhoneme.add("--");
		easyCorrect.add("troosng#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-30f);
		easyImage.add("troosng.png");
		easyPhoneme.add("--");
		easyCorrect.add("tusi#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-35f);
		easyImage.add("tusi.png");
		easyPhoneme.add("--");
		easyCorrect.add("ve#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("ve.png");
		easyPhoneme.add("--");
		easyCorrect.add("vejt#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-10f);
		easyImage.add("vejt.png");
		easyPhoneme.add("--");
		easyCorrect.add("vis#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("vis.png");
		easyPhoneme.add("--");
		easyCorrect.add("voi#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-25f);
		easyImage.add("voi.png");
		easyPhoneme.add("--");
		easyCorrect.add("xe#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-30f);
		easyImage.add("xe.png");
		easyPhoneme.add("--");
		easyCorrect.add("xerng#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-5f);
		easyImage.add("xerng.png");
		easyPhoneme.add("--");
		easyCorrect.add("xoo#grade3");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("xoo.png");
		easyPhoneme.add("--");

		easyCorrect.add("a#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-5f);
		easyImage.add("a.png");
		easyPhoneme.add("--");
		easyCorrect.add("aa#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("aa.png");
		easyPhoneme.add("--");
		easyCorrect.add("aw#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-15f);
		easyImage.add("aw.png");
		easyPhoneme.add("--");
		easyCorrect.add("b#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-25f);
		easyImage.add("b.png");
		easyPhoneme.add("--");
		easyCorrect.add("c#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-30f);
		easyImage.add("c.png");
		easyPhoneme.add("--");
		easyCorrect.add("d#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-35f);
		easyImage.add("d.png");
		easyPhoneme.add("--");
		easyCorrect.add("dd#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-10f);
		easyImage.add("dd.png");
		easyPhoneme.add("--");
		easyCorrect.add("e#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-15f);
		easyImage.add("e.png");
		easyPhoneme.add("--");
		easyCorrect.add("ee#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("ee.png");
		easyPhoneme.add("--");
		easyCorrect.add("g#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-25f);
		easyImage.add("g.png");
		easyPhoneme.add("--");
		easyCorrect.add("h#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-30f);
		easyImage.add("h.png");
		easyPhoneme.add("--");
		easyCorrect.add("i#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-10f);
		easyImage.add("i.png");
		easyPhoneme.add("--");
		easyCorrect.add("k#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-15f);
		easyImage.add("k.png");
		easyPhoneme.add("--");
		easyCorrect.add("l#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("l.png");
		easyPhoneme.add("--");
		easyCorrect.add("m#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-25f);
		easyImage.add("m.png");
		easyPhoneme.add("--");
		easyCorrect.add("n#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-30f);
		easyImage.add("n.png");
		easyPhoneme.add("--");
		easyCorrect.add("o#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-35f);
		easyImage.add("o.png");
		easyPhoneme.add("--");
		easyCorrect.add("oo#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("oo.png");
		easyPhoneme.add("--");
		easyCorrect.add("ow#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-10f);
		easyImage.add("ow.png");
		easyPhoneme.add("--");
		easyCorrect.add("p#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-5f);
		easyImage.add("p.png");
		easyPhoneme.add("--");
		easyCorrect.add("q#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-10f);
		easyImage.add("q.png");
		easyPhoneme.add("--");
		easyCorrect.add("r#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("r.png");
		easyPhoneme.add("--");
		easyCorrect.add("s#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-25f);
		easyImage.add("s.png");
		easyPhoneme.add("--");
		easyCorrect.add("t#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-30f);
		easyImage.add("t.png");
		easyPhoneme.add("--");
		easyCorrect.add("u#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-35f);
		easyImage.add("u.png");
		easyPhoneme.add("--");
		easyCorrect.add("uw#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-30f);
		easyImage.add("uw.png");
		easyPhoneme.add("--");
		easyCorrect.add("v#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("v.png");
		easyPhoneme.add("--");
		easyCorrect.add("x#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-10f);
		easyImage.add("x.png");
		easyPhoneme.add("--");
		easyCorrect.add("y#grade4");
		easyWrong.add("--");
		easyThreshold.add(1e-25f);
		easyImage.add("y.png");
		easyPhoneme.add("--");

		easyCorrect.add("ba#grade5");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("ba.png");
		easyPhoneme.add("--");
		easyCorrect.add("bary#grade5");
		easyWrong.add("--");
		easyThreshold.add(1e-5f);
		easyImage.add("bary.png");
		easyPhoneme.add("--");
		easyCorrect.add("boosn#grade5");
		easyWrong.add("--");
		easyThreshold.add(1e-10f);
		easyImage.add("boosn.png");
		easyPhoneme.add("--");
		easyCorrect.add("chisn#grade5");
		easyWrong.add("--");
		easyThreshold.add(1e-15f);
		easyImage.add("chisn.png");
		easyPhoneme.add("--");
		easyCorrect.add("hai#grade5");
		easyWrong.add("--");
		easyThreshold.add(1e-25f);
		easyImage.add("hai.png");
		easyPhoneme.add("--");
		easyCorrect.add("khoong#grade5");
		easyWrong.add("--");
		easyThreshold.add(1e-30f);
		easyImage.add("khoong.png");
		easyPhoneme.add("--");
		easyCorrect.add("moojt#grade5");
		easyWrong.add("--");
		easyThreshold.add(1e-35f);
		easyImage.add("moojt.png");
		easyPhoneme.add("--");
		easyCorrect.add("nawm#grade5");
		easyWrong.add("--");
		easyThreshold.add(1e-20f);
		easyImage.add("nawm.png");
		easyPhoneme.add("--");
		easyCorrect.add("sasu#grade5");
		easyWrong.add("--");
		easyThreshold.add(1e-10f);
		easyImage.add("sasu.png");
		easyPhoneme.add("--");
		easyCorrect.add("tasm#grade5");
		easyWrong.add("--");
		easyThreshold.add(1e-15f);
		easyImage.add("tasm.png");
		easyPhoneme.add("--");

		

	}

	@SuppressLint("DefaultLocale")
	public static String convertVietNamese(final String input) {
		String str = input;
		str = str.replace("AAS","Ấ").replace("aas","ấ").replace("AAF","Ầ").replace("aaf","ầ").replace("AAR","Ẩ").replace("aar","ẩ").replace("AAX","Ẫ");
		str = str.replace("aax","ẫ").replace("AAJ","Ậ").replace("aaj","ậ").replace("AWS","Ắ").replace("aws","ắ").replace("AWF","Ằ").replace("awf","ằ").replace("AAR","Ẳ").replace("awr","ẳ").replace("AWX","Ẵ").replace("awx","ẵ");
		str = str.replace("AWJ","Ặ").replace("awj","ặ").replace("EES","Ế").replace("ees","ế").replace("EEF","Ề").replace("eef","ề");
		str = str.replace("EER","Ể").replace("eer","ể").replace("EEX","Ễ").replace("eex","ễ").replace("EEJ","Ệ").replace("eej","ệ").replace("IR","Ỉ");
		str = str.replace("OOS","Ố").replace("oos","ố").replace("OOF","Ồ").replace("oof","ồ").replace("OOR","Ổ").replace("oor","ổ").replace("OOX","Ỗ");
		str = str.replace("oox","ỗ").replace("OOJ","Ộ").replace("ooj","ộ").replace("OWS","Ớ").replace("ows","ớ").replace("OWF","Ờ").replace("owf","ờ").replace("OWR","Ở").replace("owr","ở").replace("OWX","Ỡ").replace("owx","ỡ");
		str = str.replace("OWJ","Ợ").replace("owj","ợ").replace("UWS","Ứ").replace("uws","ứ").replace("UWF","Ừ").replace("uwf","ừ").replace("UWR","Ử");
		str = str.replace("uwr","ử").replace("UWX","Ữ").replace("uwx","ữ").replace("UWJ","Ự").replace("uwj","ự");
		str = str.replace("AF","À").replace("AS","Á").replace("AA","Â").replace("AX","Ã").replace("EF","È").replace("ES","É").replace("EE","Ê").replace("IF","Ì").replace("IS","Í").replace("OF","Ò").replace("uw","ư");
		str = str.replace("OS","Ó").replace("OO","Ô").replace("OX","Õ").replace("UF","Ù").replace("UX","Ú").replace("YX","Ý").replace("af","à").replace("as","á").replace("aa","â").replace("ax","ã").replace("ef","è");
		str = str.replace("es","é").replace("ee","ê").replace("if","ì").replace("is","í").replace("of","ò").replace("os","ó").replace("oo","ô").replace("ox","õ").replace("uf","ù").replace("us","ú").replace("yf","ý");
		str = str.replace("AW","Ă").replace("aw","ă").replace("DD","Đ").replace("dd","đ").replace("IX","Ĩ").replace("ix","ĩ").replace("UX","Ũ").replace("ux","ũ").replace("OW","Ơ").replace("ow","ơ").replace("UW","Ư");
		str = str.replace("EJ","Ẹ").replace("ej","ẹ").replace("ER","Ẻ").replace("er","ẻ").replace("EX","Ẽ").replace("ex","ẽ").replace("ir","ỉ").replace("IJ","Ị").replace("ij","ị").replace("OJ","Ọ");
		str = str.replace("oj","ọ").replace("OR","Ỏ").replace("or","ỏ").replace("UJ","Ụ").replace("uj","ụ").replace("UR","Ủ").replace("ur","ủ");
		str = str.replace("AJ","Ạ").replace("aj","ạ").replace("AR","Ả").replace("ar","ả");
		return str.toUpperCase();
	}

}
