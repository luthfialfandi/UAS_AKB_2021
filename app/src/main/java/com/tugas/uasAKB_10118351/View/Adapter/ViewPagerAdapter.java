// Tgl Pengerjaan : 9 Agustus 2021
// NIM            : 10118351
// Nama           : Luthfi Alfandi
// Kelas          : IF-8

package com.tugas.uasAKB_10118351.View.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tugas.uasAKB_10118351.R;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


public class ViewPagerAdapter extends PagerAdapter {
    String[] texts = {
            "Selamat Datang",
            "Aplikasi Informasi Tempat Wisata di Bandung Raya"
    };

    Context ctx;

    public ViewPagerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.view_pager, null);

        TextView title = layoutScreen.findViewById(R.id.titleviewpager);

        title.setText(texts[position]);
        container.addView(layoutScreen);
        return layoutScreen;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
