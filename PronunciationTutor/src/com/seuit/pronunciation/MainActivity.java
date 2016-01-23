package com.seuit.pronunciation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.seuit.pronounciation.common.Constants;
import com.seuit.pronounciation.common.Recognizer;
import com.seuit.pronounciation.common.StoreUserProfiles;
import com.seuit.pronounciation.common.UserProfile;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import edu.cmu.pocketsphinx.Assets;
import edu.cmu.pocketsphinx.SpeechRecognizer;

public class MainActivity extends Activity {

	private SpeechRecognizer recognizer;

	@Override
	public void onCreate(Bundle state) {

		super.onCreate(state);

		// Initialize speech recognizer
		new AsyncTask<Void, Void, Exception>() {

			@Override
			protected Exception doInBackground(Void... params) {
				try {
					// load user profiles
					ArrayList<UserProfile> lstUserProfile = StoreUserProfiles
							.readFromFile(getApplicationContext());
					if (lstUserProfile == null) {
						Constants.lstUserProfile = new ArrayList<UserProfile>();
					} else {
						Constants.lstUserProfile = lstUserProfile;
					}
					// sync assets
					Assets assets = new Assets(MainActivity.this);
					File assetDir = assets.syncAssets();
					// setup recognizer
					setupRecognizer(assetDir);
				} catch (IOException e) {
					return e;
				}
				return null;
			}

			@Override
			protected void onPostExecute(Exception result) {
				if (result != null) {
				} else {
					// set common.Recognizer.recognizer to
					// the initialized SpeechRecognizer recognizer
					Recognizer.setSpeechRecognizer(recognizer);

					// start MenuActivity and finish MainActivity
					Intent intent = new Intent(MainActivity.this,
							MenuActivity.class);
					startActivity(intent);
					MainActivity.this.finish();
				}
			}
		}.execute();
	}

	private void setupRecognizer(File assetsDir) {
		File modelsDir = new File(assetsDir, "models");
		Recognizer.setModelsDir(modelsDir);
	}

	@Override
	public void onBackPressed() {
	}

}