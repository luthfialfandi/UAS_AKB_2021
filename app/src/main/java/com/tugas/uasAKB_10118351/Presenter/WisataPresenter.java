// Tgl Pengerjaan : 9 Agustus 2021
// NIM            : 10118351
// Nama           : Luthfi Alfandi
// Kelas          : IF-8

package com.tugas.uasAKB_10118351.Presenter;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tugas.uasAKB_10118351.Model.WisataModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WisataPresenter {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Wisata");
    private WisataListener wisataListener;
    public interface WisataListener {
        void onSuccess(List<WisataModel> result);
    }
    public void setWisataListener(WisataListener wisataListener) {
        this.wisataListener = wisataListener;
    }

    public void getWisatas(String bandung) {
        String kota = "";
        if (bandung.equals("Kota Bandung")) {
            kota = "Bandung";
        } else if (bandung.equals("Kab. Bandung")) {
            kota = "Kab_Bandung";
        } else if (bandung.equals("Kab. Bandung Barat")) {
            kota = "Kab_Bandung_Barat";
        } else if (bandung.equals("Kota Cimahi")) {
            kota = "Cimahi";
        }
        myRef.child(kota).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                ArrayList<Object> res = (ArrayList<Object>) task.getResult().getValue();
                ArrayList<WisataModel> result = new ArrayList<WisataModel>();
                for (int i = 0; i < res.size(); i++) {
                    HashMap<String, Object> explrObject = (HashMap<String, Object>) res.get(i);
                    String nama = (String) explrObject.get("nama");
                    String deskripsi = (String) explrObject.get("deskripsi");
                    String foto = (String) explrObject.get("foto");
                    String lat = String.valueOf(explrObject.get("lat"));
                    String lng = String.valueOf(explrObject.get("lng"));

                    WisataModel wisataModel = new WisataModel(nama, deskripsi, foto, new LatLng(Double.parseDouble(lat), Double.parseDouble(lng)));
                    result.add(wisataModel);
                }
                wisataListener.onSuccess(result);
            } else {
                Log.e("firebase", "Error getting data", task.getException());
            }
        });
    }
}
