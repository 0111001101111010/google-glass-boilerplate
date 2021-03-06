package com.example.glass.main;

import com.google.android.glass.app.Card;
import android.app.Activity;
import android.content.Intent;
import android.hardware.*;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.os.Bundle;
import android.hardware.Camera.PictureCallback;
import android.provider.MediaStore;


public class MainActivity extends Activity {

// create variable instances

	private static final String TAG = MainActivity.class.getSimpleName();

	private Camera mCamera;
    PictureCallback mPicture = null;


	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//keeps the camera on
	    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


		Card card1 = new Card(this);
		card1.setText("Nice Picture!");
		card1.setFootnote("Cool! ...");
		View card1View = card1.getView();
		setContentView(card1View);

		//take a picture intent
		//takePicture();

	}
/**
 * Boiler plate google code
 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_CAMERA) {
	        // Stop the preview and release the camera.
	        // Execute your logic as quickly as possible
	        // so the capture happens quickly.
	        return false;
	    } else {
	        return super.onKeyDown(keyCode, event);
	    }
	}



	/*** boiler plate google code
	 * https://developers.google.com/glass/develop/gdk/media-camera/camera
	 */
	@Override
	protected void onResume() {
	    super.onResume();
	    // Re-acquire the camera and start the preview.
	}
	private static final int TAKE_PICTURE_REQUEST = 1;

	public void takePicture() {
	    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	    startActivityForResult(intent, TAKE_PICTURE_REQUEST);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == TAKE_PICTURE_REQUEST && resultCode == RESULT_OK) {
//	        String picturePath = data.getStringExtra(
//	                CameraManager.EXTRA_PICTURE_FILE_PATH);
//	        processPictureWhenReady(picturePath);
	    }

	    super.onActivityResult(requestCode, resultCode, data);
	}


	/**
	 * end of boiler plate
	 */


	public void takePic() {
	    // get an image from the camera
		mCamera.takePicture(null, null, mPicture);
	}
	/*
	 * end of boiler plate
	 */
}
