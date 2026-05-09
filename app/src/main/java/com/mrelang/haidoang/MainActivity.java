package com.mrelang.haidoang;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Ritual 20 detik diem
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Munculin "hai" 
                Toast.makeText(MainActivity.this, "hai", Toast.LENGTH_SHORT).show();
                
                // 1 detik kemudian bunuh diri
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        System.exit(0);
                    }
                }, 1000);
            }
        }, 20000); // 20000ms = 20 detik
    }
}
