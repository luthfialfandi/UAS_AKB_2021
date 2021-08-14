// Tgl Pengerjaan : 9 Agustus 2021
// NIM            : 10118351
// Nama           : Luthfi Alfandi
// Kelas          : IF-8

package com.tugas.uasAKB_10118351.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.tugas.uasAKB_10118351.Presenter.WisataPresenter;
import com.tugas.uasAKB_10118351.R;
import com.tugas.uasAKB_10118351.View.Adapter.ListWisataAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    String kota;
    WisataPresenter wisataPresenter;
    ListWisataAdapter listAdapter;
    RecyclerView rcvListWisata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        kota = getIntent().getStringExtra("kota");
        rcvListWisata = findViewById(R.id.rcvListWisata);
        wisataPresenter = new WisataPresenter();
        wisataPresenter.getWisatas(kota);
        wisataPresenter.setWisataListener(result ->{
            listAdapter = new ListWisataAdapter(new ArrayList(result),getApplicationContext(), ListActivity.this);
            rcvListWisata.setAdapter(listAdapter);
            rcvListWisata.setLayoutManager(new LinearLayoutManager(getApplication()));
            rcvListWisata.setHasFixedSize(true);
        });
    }
}