package com.sample.app.fragment_with_capturing_photo

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.sample.app.R

class FragmentWithCapturingPhoto : Fragment(), View.OnClickListener {
    private var imageView: ImageView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater!!.inflate(R.layout.fragment_with_capturing_photo, container, false)

        bindView(rootView)

        return rootView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.d("activityResult", "activityResult")
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                RESULT_IMAGE -> {
                    val image = data!!.extras.get("data") as Bitmap
                    imageView!!.setImageBitmap(image)
                }
            }
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.galleryButton -> addFromPhotos()
            R.id.cameraButton -> capturePhotoFromCamera()
        }
    }

    private fun bindView(view: View) {
        imageView = view.findViewById(R.id.image) as ImageView
        val galleryButton = view.findViewById(R.id.galleryButton) as Button
        val cameraButton = view.findViewById(R.id.cameraButton) as Button
        galleryButton.setOnClickListener(this)
        cameraButton.setOnClickListener(this)
    }

    private fun addFromPhotos() {
        val pickImageIntent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

        pickImageIntent.type = "image/*"
        pickImageIntent.putExtra("crop", "true")
        //pickImageIntent.putExtra("outputX", 200);
        //pickImageIntent.putExtra("outputY", 200);
        //pickImageIntent.putExtra("aspectX", 1);
        //pickImageIntent.putExtra("aspectY", 1);
        pickImageIntent.putExtra("scale", true)
        pickImageIntent.putExtra("return-data", true)
        pickImageIntent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString())
        startActivityForResult(pickImageIntent, RESULT_IMAGE)
    }

    private fun capturePhotoFromCamera() {
        val takePicIntent = Intent("android.media.action.IMAGE_CAPTURE")

        //        takePicIntent .putExtra("crop", "true");
        takePicIntent.putExtra("outputX", 200)
        takePicIntent.putExtra("outputY", 200)
        takePicIntent.putExtra("aspectX", 1)
        takePicIntent.putExtra("aspectY", 1)
        takePicIntent.putExtra("scale", true)
        takePicIntent.putExtra("return-data", true)
        takePicIntent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString())
        startActivityForResult(takePicIntent, RESULT_IMAGE)
    }

    companion object {
        private val RESULT_IMAGE = 1
    }

}
