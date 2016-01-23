package com.seuit.pronunciation;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.seuit.pronounciation.common.Constants;
import com.seuit.pronounciation.common.Keys;
import com.seuit.pronounciation.common.MusicManager;
import com.seuit.pronounciation.common.UserProfile;

public class GameModeActivity extends Activity {

	/**
	 * boolean to continue playing music
	 */
	boolean continueMusic = true;

	/**
	 * editText for input user name
	 */
	EditText editTextName;

	/**
	 * button for easy mode
	 */
	Button buttonEasy;

	/**
	 * button for normal mode
	 */
	// Button buttonNormal;

	/**
	 * button for hard mode
	 */
	// Button buttonHard;

	TextView textViewExistingUser;
	TextView textViewEnterName;
	TextView textViewGradeLevel;

	CheckBox checkBoxNewUser;
	Spinner spinnerGradeLevel;
	Spinner spinnerExistingUsers;

	String userProfiles;
	String userProfilesSeparator;

	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle state) {

		super.onCreate(state);

		/* Create a full screen window */

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		this.setContentView(R.layout.gamemode_layout);

		/* Background Image */

		// adapt the image to the size of the display
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		/*
		 * Bitmap bmp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
		 * getResources(), R.drawable.menu_background), size.x, size.y, true);
		 */
		// fill the background ImageView with the resized image
		@SuppressWarnings("unused")
		ImageView iv_background = (ImageView) findViewById(R.id.gamemode_imageBackground);
		// iv_background.setImageBitmap(bmp);

		/* Initialize views */

		textViewExistingUser = (TextView) findViewById(R.id.gamemode_textViewExistingUser);
		textViewEnterName = (TextView) findViewById(R.id.gamemode_textViewEnterName);
		textViewGradeLevel = (TextView) findViewById(R.id.gamemode_textViewGradeLevel);

		checkBoxNewUser = (CheckBox) findViewById(R.id.gamemode_checkboxNewUser);
		checkBoxNewUser
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean isChecked) {
						editTextName.setVisibility(isChecked ? View.VISIBLE
								: View.GONE);
						spinnerGradeLevel
								.setVisibility(isChecked ? View.VISIBLE
										: View.GONE);
						textViewEnterName
								.setVisibility(isChecked ? View.VISIBLE
										: View.GONE);
						textViewGradeLevel
								.setVisibility(isChecked ? View.VISIBLE
										: View.GONE);

						spinnerExistingUsers
								.setVisibility(!isChecked ? View.VISIBLE
										: View.GONE);
						textViewExistingUser
								.setVisibility(!isChecked ? View.VISIBLE
										: View.GONE);

						if (isChecked) {
							if (editTextName.getText().toString().equals("")) {
								// disable buttons if player name is not entered
								disableButtons();
							} else {
								// enable buttons
								buttonEasy.setVisibility(View.VISIBLE);
								// buttonNormal.setVisibility(View.VISIBLE);
								// buttonHard.setVisibility(View.VISIBLE);
							}
						} else {
							// enable buttons
							buttonEasy.setVisibility(View.VISIBLE);
							// buttonNormal.setVisibility(View.VISIBLE);
							// buttonHard.setVisibility(View.VISIBLE);
						}
					}
				});

		spinnerGradeLevel = (Spinner) findViewById(R.id.gamemode_spinnerGradeLevel);
		ArrayList<String> lstGradeLevel = new ArrayList<String>();
		lstGradeLevel.add(Constants.GRADELEVEL_3);
		lstGradeLevel.add(Constants.GRADELEVEL_4);
		lstGradeLevel.add(Constants.GRADELEVEL_5);
		ArrayAdapter<String> spinnerGradeLevelArrayAdapter = new ArrayAdapter<String>(
				this, R.layout.custom_spinner, lstGradeLevel);
		spinnerGradeLevelArrayAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerGradeLevel.setAdapter(spinnerGradeLevelArrayAdapter);

		spinnerExistingUsers = (Spinner) findViewById(R.id.gamemode_spinnerExistingUsers);
		ArrayList<String> lstUserName = new ArrayList<String>();
		for (UserProfile p : Constants.lstUserProfile) {
			lstUserName.add(p.userName);
		}
		ArrayAdapter<String> spinnerExistingUsersArrayAdapter = new ArrayAdapter<String>(
				this, R.layout.custom_spinner, lstUserName);
		spinnerExistingUsersArrayAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerExistingUsers.setAdapter(spinnerExistingUsersArrayAdapter);

		editTextName = (EditText) findViewById(R.id.gamemode_editTextName);
		editTextName.addTextChangedListener(new TextWatcher() {
			@Override
			public void afterTextChanged(Editable arg0) {
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
			}

			@Override
			public void onTextChanged(CharSequence name, int arg1, int arg2,
					int arg3) {
				if (checkBoxNewUser.isChecked()) {
					if (name.toString().equals("")) {
						// disable buttons if player name is not entered
						disableButtons();
					} else if (userProfiles.contains(userProfilesSeparator
							+ name.toString() + userProfilesSeparator)) {
						disableButtons();
						Toast.makeText(
								getApplicationContext(),
								"User name already exists!\n Choose a different one.",
								Toast.LENGTH_SHORT).show();
					} else {
						// enable buttons
						buttonEasy.setVisibility(View.VISIBLE);
						// buttonNormal.setVisibility(View.VISIBLE);
						// buttonHard.setVisibility(View.VISIBLE);
					}
				}
			}
		});

		buttonEasy = (Button) findViewById(R.id.gamemode_buttonEasy);
		buttonEasy.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				buttonEasy.setEnabled(false);
				// buttonNormal.setEnabled(false);
				// buttonHard.setEnabled(false);
				String userNameEntered;
				if (checkBoxNewUser.isChecked()) {
					userNameEntered = editTextName.getText().toString();
				} else {
					userNameEntered = spinnerExistingUsers.getSelectedItem()
							.toString();
				}
				// start GameActivity and finish GameModeActivity
				Intent intent = new Intent(GameModeActivity.this,
						GameActivity.class);
				// send player name and game mode to GameActivity
				intent.putExtra(Keys.PLAYER_NAME, userNameEntered);
				if (checkBoxNewUser.isChecked()) {
					intent.putExtra(Keys.GRADELEVEL, spinnerGradeLevel
							.getSelectedItem().toString());
				}
				intent.putExtra(Keys.GAME_MODE, Constants.GAMEMODE_EASY);
				startActivity(intent);
				GameModeActivity.this.finish();
			}
		});

		/*
		 * buttonNormal = (Button) findViewById(R.id.gamemode_buttonNormal);
		 * buttonNormal.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View arg0) {
		 * buttonEasy.setEnabled(false); buttonNormal.setEnabled(false);
		 * buttonHard.setEnabled(false); String userNameEntered; if
		 * (checkBoxNewUser.isChecked()) { userNameEntered =
		 * editTextName.getText().toString(); } else { userNameEntered =
		 * spinnerExistingUsers.getSelectedItem() .toString(); } // start
		 * GameActivity and finish GameModeActivity Intent intent = new
		 * Intent(GameModeActivity.this, GameActivity.class); // send player
		 * name and game mode to GameActivity intent.putExtra(Keys.PLAYER_NAME,
		 * userNameEntered); if (checkBoxNewUser.isChecked()) {
		 * intent.putExtra(Keys.GRADELEVEL, spinnerGradeLevel
		 * .getSelectedItem().toString()); } intent.putExtra(Keys.GAME_MODE,
		 * Constants.GAMEMODE_NORMAL); startActivity(intent);
		 * GameModeActivity.this.finish(); } });
		 * 
		 * buttonHard = (Button) findViewById(R.id.gamemode_buttonHard);
		 * buttonHard.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View arg0) {
		 * buttonEasy.setEnabled(false); buttonNormal.setEnabled(false);
		 * buttonHard.setEnabled(false); String userNameEntered; if
		 * (checkBoxNewUser.isChecked()) { userNameEntered =
		 * editTextName.getText().toString(); } else { userNameEntered =
		 * spinnerExistingUsers.getSelectedItem() .toString(); } // start
		 * GameActivity and finish GameModeActivity Intent intent = new
		 * Intent(GameModeActivity.this, GameActivity.class); // send player
		 * name and game mode to GameActivity intent.putExtra(Keys.PLAYER_NAME,
		 * userNameEntered); if (checkBoxNewUser.isChecked()) {
		 * intent.putExtra(Keys.GRADELEVEL, spinnerGradeLevel
		 * .getSelectedItem().toString()); } intent.putExtra(Keys.GAME_MODE,
		 * Constants.GAMEMODE_HARD); startActivity(intent);
		 * GameModeActivity.this.finish(); } });
		 */

		boolean isLstUserEmpty = Constants.lstUserProfile.isEmpty();
		checkBoxNewUser.setChecked(isLstUserEmpty);
		checkBoxNewUser.setClickable(!isLstUserEmpty);

		editTextName.setVisibility(isLstUserEmpty ? View.VISIBLE : View.GONE);
		textViewEnterName.setVisibility(isLstUserEmpty ? View.VISIBLE
				: View.GONE);
		textViewGradeLevel.setVisibility(isLstUserEmpty ? View.VISIBLE
				: View.GONE);
		spinnerGradeLevel.setVisibility(isLstUserEmpty ? View.VISIBLE
				: View.GONE);
		spinnerExistingUsers.setVisibility(!isLstUserEmpty ? View.VISIBLE
				: View.GONE);
		textViewExistingUser.setVisibility(!isLstUserEmpty ? View.VISIBLE
				: View.GONE);

		userProfilesSeparator = "!@#$%^&";
		userProfiles = userProfilesSeparator;
		for (UserProfile u : Constants.lstUserProfile) {
			userProfiles += u.userName + userProfilesSeparator;
		}

		if (isLstUserEmpty) {
			disableButtons();
		}

	}

	/**
	 * disable all buttons
	 */
	private void disableButtons() {
		buttonEasy.setVisibility(View.GONE);
		// buttonNormal.setVisibility(View.GONE);
		// buttonHard.setVisibility(View.GONE);
	}

	@Override
	public void onBackPressed() {
		// start MenuActivity and finish GameModeActivity
		Intent intent = new Intent(GameModeActivity.this, MenuActivity.class);
		startActivity(intent);
		finish();
		super.onBackPressed();
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (!continueMusic) {
			MusicManager.pause();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		continueMusic = false;
		MusicManager.start(this, MusicManager.MUSIC_ALL);
	}

}
