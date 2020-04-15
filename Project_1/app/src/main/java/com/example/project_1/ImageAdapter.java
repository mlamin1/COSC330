package com.example.project_1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ImageAdapter extends PagerAdapter {

    private Context mContext;

    private int[] mImageIds = new int[] {
            R.drawable.maria,
            R.drawable.sick,
            R.drawable.maria_does_not_want_to_go_hospital,
            R.drawable.maaria_had_a_bad_cough,
            R.drawable.maria_could_not_breath,
            R.drawable.maaria_calls_her_doctor,
            R.drawable.maria_asks_for_interpreter,
            R.drawable.husband_took_he_to_the_hospital,
            R.drawable.ask_maria_for_name,
            R.drawable.ask_maria_for_insurance,
            R.drawable.ask_maria_for_health_card,
            R.drawable.give_maria_form,
            R.drawable.maaria_stayed_in_hospital_3_days
    };

    ImageAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return mImageIds.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setImageResource(mImageIds[position]);
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }
}
