package com.seuit.pronunciation;

import java.util.ArrayList;
import java.util.HashMap;

import com.seuit.pronounciation.common.MusicManager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.VideoView;

public class VideoActivity extends Activity {

	/**
	 * boolean to continue playing music
	 */
	boolean continueMusic = true;

	private VideoView videoView;
	private int position = 0;
	private ProgressDialog progressDialog;
	private MediaController mediaControls;

	Spinner spinner;
	ArrayList<String> lstVideoTutorial;
	HashMap<String, Integer> hashVideoTutorial;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(final Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		/* Create a full screen window */

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.video_layout);

		/* Background Image */

		// adapt the image to the size of the display
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		/*
		 * Bitmap bmp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
		 * getResources(),R.drawable.result_background),size.x,size.y,true);
		 */
		// fill the background ImageView with the resized image
		@SuppressWarnings("unused")
		ImageView iv_background = (ImageView) findViewById(R.id.video_imageBackground);
		// iv_background.setImageBitmap(bmp);

		initVideosListAndHash();

		if (mediaControls == null) {
			mediaControls = new MediaController(VideoActivity.this);
		}

		// Find your VideoView in your video_main.xml layout
		videoView = (VideoView) findViewById(R.id.video_videoView);

		// Create a progressbar
		progressDialog = new ProgressDialog(VideoActivity.this);
		// Set progressbar message
		progressDialog.setMessage("Loading...");

		progressDialog.setCancelable(false);
		// Show progressbar
		progressDialog.show();

		spinner = (Spinner) findViewById(R.id.video_spinner);
		ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, lstVideoTutorial);
		spinnerArrayAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(spinnerArrayAdapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				String fileName = "android.resource://"
						+ getPackageName()
						+ "/"
						+ hashVideoTutorial.get(spinner.getSelectedItem()
								.toString());
				videoView.setVideoURI(Uri.parse(fileName));
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				spinner.setSelection(0);
			}
		});

		videoView.setMediaController(mediaControls);

		videoView.requestFocus();
		videoView.setOnPreparedListener(new OnPreparedListener() {
			// Close the progress bar and play the video
			public void onPrepared(MediaPlayer mp) {
				progressDialog.dismiss();
				videoView.seekTo(position);
				if (position == 0) {
					MusicManager.pause();
					videoView.start();
				} else {
					videoView.pause();
					MusicManager.start(getApplicationContext(),
							MusicManager.MUSIC_ALL);
				}
			}
		});

	}

	private void initVideosListAndHash() {
		lstVideoTutorial = new ArrayList<String>();
		hashVideoTutorial = new HashMap<String, Integer>();

		// lstVideoTutorial.add("Stress and Rhythm");
		// hashVideoTutorial.put("Stress and Rhythm", R.raw.stress_and_rhythm);
		//
		// lstVideoTutorial.add("Introduction to Intonation");
		// hashVideoTutorial.put("Introduction to Intonation",
		// R.raw.introduction_to_intonation);
		//
		// lstVideoTutorial.add("Basic Helping Verbs");
		// hashVideoTutorial.put("Basic Helping Verbs",
		// R.raw.basic_helping_verbs_in_english);
		//
		// lstVideoTutorial.add("Seat, Sit, Set");
		// hashVideoTutorial.put("Seat, Sit, Set", R.raw.seat_sit_set);

		lstVideoTutorial.add("Homophones Tutorial");
		hashVideoTutorial.put("Homophones Tutorial", R.raw.background_music);

		lstVideoTutorial.add("Homophones Examples");
		hashVideoTutorial.put("Homophones Examples", R.raw.background_music);

		lstVideoTutorial.add("Homophones Seatwork");
		hashVideoTutorial.put("Homophones Seatwork", R.raw.background_music);

	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putInt("Position", videoView.getCurrentPosition());
		videoView.pause();
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		position = savedInstanceState.getInt("Position");
		videoView.seekTo(position);
	}

	public void onBackPressed() {
		// start MenuActivity and finish VideoActivity
		Intent intent = new Intent(VideoActivity.this, MenuActivity.class);
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
