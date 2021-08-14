// Tgl Pengerjaan : 9 Agustus 2021
// NIM            : 10118351
// Nama           : Luthfi Alfandi
// Kelas          : IF-8

package com.tugas.uasAKB_10118351.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tugas.uasAKB_10118351.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView botnav = findViewById(R.id.activitymain_bottomnav);
        loadFragment(new HomeFragment());
        botnav
                .setOnNavigationItemSelectedListener(item -> {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.homemenu:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.profilemenu:
                            selectedFragment = new ProfileFragment();
                            break;

                    }
                    return loadFragment(selectedFragment);
                });
    }
    private boolean loadFragment(Fragment selectedFragment) {

        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.activitymain_fragmentcontainer, selectedFragment).commit();
            if (! getSupportFragmentManager().isDestroyed())
                getSupportFragmentManager().beginTransaction().replace(R.id.activitymain_fragmentcontainer, selectedFragment).commit();
            return true;
        }
        return false;
    }
}