package com.sample.app.fragment_with_capturing_photo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.sample.app.R;

import static android.app.Activity.RESULT_OK;

public class FragmentWithCapturingPhoto extends Fragment implements View.OnClickListener {
    private ImageView imageView;
    private static final int RESULT_IMAGE = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_with_capturing_photo, container, false);

        bindView(rootView);

        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("activityResult", "activityResult");
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case RESULT_IMAGE:
                    Bitmap image = (Bitmap) data.getExtras().get("data");
                    imageView.setImageBitmap(image);
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.galleryButton:
                addFromPhotos();
                break;
            case R.id.cameraButton:
                capturePhotoFromCamera();
                break;
        }
    }

    private void bindView(View view) {
        imageView = (ImageView) view.findViewById(R.id.image);
        Button galleryButton = (Button) view.findViewById(R.id.galleryButton);
        Button cameraButton = (Button) view.findViewById(R.id.cameraButton);
        galleryButton.setOnClickListener(this);
        cameraButton.setOnClickListener(this);
    }

    private void addFromPhotos() {
        Intent pickImageIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        pickImageIntent.setType("image/*");
        pickImageIntent.putExtra("crop", "true");
        //pickImageIntent.putExtra("outputX", 200);
        //pickImageIntent.putExtra("outputY", 200);
        //pickImageIntent.putExtra("aspectX", 1);
        //pickImageIntent.putExtra("aspectY", 1);
        pickImageIntent.putExtra("scale", true);
        pickImageIntent.putExtra("return-data", true);
        pickImageIntent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        startActivityForResult(pickImageIntent, RESULT_IMAGE);
    }

    private void capturePhotoFromCamera() {
        Intent takePicIntent = new Intent("android.media.action.IMAGE_CAPTURE");

//        takePicIntent .putExtra("crop", "true");
        takePicIntent.putExtra("outputX", 200);
        takePicIntent.putExtra("outputY", 200);
        takePicIntent.putExtra("aspectX", 1);
        takePicIntent.putExtra("aspectY", 1);
        takePicIntent.putExtra("scale", true);
        takePicIntent.putExtra("return-data", true);
        takePicIntent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        startActivityForResult(takePicIntent, RESULT_IMAGE);
    }

}
