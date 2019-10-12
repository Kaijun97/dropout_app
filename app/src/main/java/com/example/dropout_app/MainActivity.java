package com.example.dropout_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.RECEIVE_SMS)
                != PackageManager.PERMISSION_GRANTED)
            requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS}, 1000);
        //checkManifest check = new checkManifest();
        //check.checkStatus();


    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==1000)
        {
            if(grantResults[0]== PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this, "Permission granted",Toast.LENGTH_SHORT).show();
            else
                finish();
        }
    }

    public void sendJSON(String data) {
        RequestQueue requestQueue;
        final String saveData = data;
        Object appContext =getApplicationContext() ;
        String URL = "https://us-central1-dropouts-54029.cloudfunctions.net/widgets";

        requestQueue = Volley.newRequestQueue(getApplicationContext());

    }



}
