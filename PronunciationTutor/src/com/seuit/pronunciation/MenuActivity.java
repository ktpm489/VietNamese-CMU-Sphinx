package com.seuit.pronunciation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.seuit.pronounciation.common.MusicManager;

public class MenuActivity extends Activity {
	
	/**
	 * boolean to continue playing music
	 */
	boolean continueMusic = true;

	/**
	 * textView Watch Tutorial
	 */
	TextView textViewWatchTutorial;

	/**
	 * button to Play
	 */
	Button buttonPlay;

	/**
	 * button to view Scores
	 */
	Button buttonScores;

	/**
	 * button to view instructions
	 */
	Button buttonInstructions;

	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle state) {

		super.onCreate(state);

		/* Create a full screen window */
		 @SuppressWarnings("unused")
		final Animation animTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
	     final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
	     final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.together);
	     final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		this.setContentView(R.layout.menu_layout);

		/*Set Background Image */
		//wheel animation
			/*	ImageView wheel = (ImageView)findViewById(R.id.wheel);
				//load the wheel animation
				AnimatorSet wheelSet = (AnimatorSet) 
						AnimatorInflater.loadAnimator(this, R.animator.wheel_spin);
				//set the view as target
				wheelSet.setTarget(wheel);
				//start the animation
				wheelSet.start();*/

				//get the sun view
				ImageView sun = (ImageView)findViewById(R.id.sun);
				//load the sun movement animation
				AnimatorSet sunSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.sun_swing);
				//set the view as target
				sunSet.setTarget(sun);
				//start the animation
				sunSet.start();

			/*	//darken sky
				ValueAnimator skyAnim = ObjectAnimator.ofInt
						(findViewById(R.id.car_layout), "backgroundColor",
								Color.rgb(0x66, 0xcc, 0xff), Color.rgb(0x00, 0x66, 0x99));
				skyAnim.setDuration(3000);
				skyAnim.setRepeatCount(ValueAnimator.INFINITE);
				skyAnim.setRepeatMode(ValueAnimator.REVERSE);
				skyAnim.setEvaluator(new ArgbEvaluator());
				skyAnim.start();
*/
				//move clouds
				ObjectAnimator cloudAnim = 
						ObjectAnimator.ofFloat(findViewById(R.id.cloud1), "x", -350);
				cloudAnim.setDuration(3000);
				cloudAnim.setRepeatCount(ValueAnimator.INFINITE);
				cloudAnim.setRepeatMode(ValueAnimator.REVERSE);
				cloudAnim.start();
				//other cloud
				ObjectAnimator cloudAnim2 = ObjectAnimator.ofFloat(findViewById(R.id.cloud2), "x", -300);
				cloudAnim2.setDuration(3000);
				cloudAnim2.setRepeatCount(ValueAnimator.INFINITE);
				cloudAnim2.setRepeatMode(ValueAnimator.REVERSE);
				cloudAnim2.start();
		
		/* Background Image */

		// adapt the image to the size of the display
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		/*Bitmap bmp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
				getResources(), R.drawable.game_easy_background), size.x, size.y,
				true);*/

		// fill the background ImageView with the resized image
		//ImageView iv_background = (ImageView) findViewById(R.id.menu_imageBackground);
		//iv_background.setImageBitmap(bmp);
		//iv_background.setBackgroundDrawable(R.drawable.game_easy_background);
		/* Initialize views */

		//textViewWatchTutorial = (TextView) findViewById(R.id.menu_textViewWatchTutorial);
		//textViewWatchTutorial.setClickable(true);
		SpannableString content = new SpannableString("Watch Tutorial");
		content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
		//textViewWatchTutorial.setText(content);
		/*textViewWatchTutorial.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// start VideoActivity and finish MenuActivity
				Intent intent = new Intent(MenuActivity.this,
						VideoActivity.class);
				startActivity(intent);
				finish();
			}
		});*/

		buttonPlay = (Button) findViewById(R.id.menu_buttonPlay);
		buttonPlay.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				arg0.startAnimation(animAlpha);
				disableButtons();
				// start GameModeActivity and finish MenuActivity
				Intent intent = new Intent(MenuActivity.this,
						GameModeActivity.class);
				startActivity(intent);
				finish();
			}
		});

		buttonScores = (Button) findViewById(R.id.menu_buttonScores);
		buttonScores.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				arg0.startAnimation(animRotate);
				disableButtons();
				// start ScoresActivity and finish MenuActivity
				Intent intent = new Intent(MenuActivity.this,
						ScoresActivity.class);
				startActivity(intent);
				finish();
			}
		});

		buttonInstructions = (Button) findViewById(R.id.menu_buttonInstructions);
		buttonInstructions.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				arg0.startAnimation(animScale);
				disableButtons();
				// start InstructionsActivity and finish MenuActivity
				Intent intent = new Intent(MenuActivity.this,
						InstructionsActivity.class);
				startActivity(intent);
				finish();
			}
		});

	}

	/**
	 * disable all buttons
	 */
	private void disableButtons() {
		buttonPlay.setEnabled(false);
		buttonScores.setEnabled(false);
		buttonInstructions.setEnabled(false);
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

	
	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(this)
				.setMessage("Bé có muốn thoát không")
				.setCancelable(false)
				.setPositiveButton("Có",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								MenuActivity.this.finish();
							}
						}).setNegativeButton("Không", null).show();
	}

}
