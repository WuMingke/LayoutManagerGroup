package com.erkuai.layoutmanagergroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.erkuai.layoutmanagergroup.fragments.PickerFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        PickerFragment pickerFragment = new PickerFragment();

        manager.beginTransaction().add(R.id.layout, pickerFragment).commit();

    }
}
