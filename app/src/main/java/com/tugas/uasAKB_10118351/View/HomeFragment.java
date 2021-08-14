// Tgl Pengerjaan : 9 Agustus 2021
// NIM            : 10118351
// Nama           : Luthfi Alfandi
// Kelas          : IF-8

package com.tugas.uasAKB_10118351.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.tugas.uasAKB_10118351.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    List<String> arraykota = new ArrayList<>();
    Spinner dropdown;
    ArrayAdapter<String> adapterdropdown;
    View view;
    boolean firstdropdown = true;
    String selectedkota = "";
    Button BtnGo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        arraykota.add("Pilih Kota");
        arraykota.add("Kota Bandung");
        arraykota.add("Kab. Bandung");
        arraykota.add("Kab. Bandung Barat");
        arraykota.add("Kota Cimahi");
        dropdown= view.findViewById(R.id.spinnerbandung);
        BtnGo = view.findViewById(R.id.go_to_list);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapterdropdown = new ArrayAdapter<>(getActivity().getApplicationContext(), R.layout.list_dropdown, arraykota);
        dropdown.setAdapter(adapterdropdown);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0||!firstdropdown){
                    selectedkota=arraykota.get(position);
                    BtnGo.setText("Pilih "+selectedkota);
                    if(firstdropdown){
                        arraykota.remove(0);
                        firstdropdown=false;
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedkota="";
            }
        });
        BtnGo.setOnClickListener(v -> {
            if(!selectedkota.equals("")){
                Intent intent = new Intent(requireContext(), ListActivity.class);
                intent.putExtra("kota", selectedkota);
                startActivity(intent);
            }else{
                Toast.makeText(requireContext(),"Belum Memilih Kota",Toast.LENGTH_LONG).show();
            }
        });

    }
}