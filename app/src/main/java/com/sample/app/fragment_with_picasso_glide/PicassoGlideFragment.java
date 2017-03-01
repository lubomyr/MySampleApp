package com.sample.app.fragment_with_picasso_glide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.app.R;

public class PicassoGlideFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView      = inflater.inflate(R.layout.fragment_picasso_glide, container, false);
        return rootView;
    }

    private void picassoExamples() {
        /*Picasso.with(context).load(R.drawable.sample).into(mImageView1);
        Picasso.with(context).load("file:///android_asset/image.png").into(mImageView2);
        Picasso.with(context).load(new File(...)).into(mImageView3);*/

        /*Picasso.with(context)
                .load("здесь ссылка на картинку")
                .placeholder(R.drawable.placeholder) //показываем что-то, пока не загрузится указанная картинка
                .error(R.drawable.error) // показываем что-то, если не удалось скачать картинку
                .into(imageView);

        Picasso.with(context)
                .load("здесь ссылка на картинку")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .resize(width, height) // изменяем размер картинки до указанной ширины и высоты
                .rotate(degree) // указываем градус, на который следует повернуть картинку
                .into(imageView);

        Picasso.with(context)
                .load("здесь ссылка на картинку")
                .resize(width, height) // изменяем размер картинки
                .centerCrop() // обрезаем по центре
                .into(imageView);*/
    }

    private void glideExample() {
        //Glide.with(context).load(icon).into(imageViewForGlide);
    }
}
