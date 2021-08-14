// Tgl Pengerjaan : 9 Agustus 2021
// NIM            : 10118351
// Nama           : Luthfi Alfandi
// Kelas          : IF-8

package com.tugas.uasAKB_10118351.Model;

import com.google.android.gms.maps.model.LatLng;

public class WisataModel {
    public WisataModel(String nama, String desc, String img, LatLng latLng) {
        this.nama = nama;
        Desc = desc;
        this.img = img;
        this.latLng = latLng;
    }
    String nama;
    String Desc;
    String img;
    LatLng latLng;

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


}