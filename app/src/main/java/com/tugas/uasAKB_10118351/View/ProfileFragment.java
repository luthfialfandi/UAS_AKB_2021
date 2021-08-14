// Tgl Pengerjaan : 9 Agustus 2021
// NIM            : 10118351
// Nama           : Luthfi Alfandi
// Kelas          : IF-8

package com.tugas.uasAKB_10118351.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tugas.uasAKB_10118351.R;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}