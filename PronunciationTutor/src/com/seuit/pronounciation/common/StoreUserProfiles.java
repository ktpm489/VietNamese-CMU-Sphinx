package com.seuit.pronounciation.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import android.content.Context;
import android.widget.Toast;

public class StoreUserProfiles {

	// Constant with a file name
	private final static String fileName = Constants.userScoreFile;

	// Serializes an object and saves it to a file
	public static void saveToFile(Context context) {
		try {
			FileOutputStream fileOutputStream = context.openFileOutput(
					fileName, Context.MODE_PRIVATE);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					fileOutputStream);
			objectOutputStream.writeObject(Constants.lstUserProfile);
			objectOutputStream.close();
			fileOutputStream.close();
			Toast.makeText(context, "Lưu Điểm", Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Creates an object by reading it from a file
	@SuppressWarnings("unchecked")
	public static ArrayList<UserProfile> readFromFile(Context context) {
		ArrayList<UserProfile> lstUserProfile = null;
		try {
			FileInputStream fileInputStream = context.openFileInput(fileName);
			ObjectInputStream objectInputStream = new ObjectInputStream(
					fileInputStream);
			lstUserProfile = (ArrayList<UserProfile>) objectInputStream
					.readObject();
			objectInputStream.close();
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return lstUserProfile;
	}

}
