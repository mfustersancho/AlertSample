package com.example.alertsample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.example.alertsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonAlert1.setOnClickListener(view -> {
            AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
            myAlertBuilder.setTitle(R.string.alert_title);
            myAlertBuilder.setMessage(R.string.alert_message);
            myAlertBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(), R.string.pressed_ok, Toast.LENGTH_SHORT).show();
                }
            });
            myAlertBuilder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(), R.string.pressed_cancel, Toast.LENGTH_SHORT).show();
                }
            });
            myAlertBuilder.show();
        });

        mBinding.buttonDate.setOnClickListener(view -> {
            DialogFragment newFragment = new DatePickerFragment();
            newFragment.show(getSupportFragmentManager(), getString(R.string.date_picker));
        });

        mBinding.buttonTime.setOnClickListener(view -> {
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getSupportFragmentManager(), getString(R.string.time_picker));
        });
    }
}