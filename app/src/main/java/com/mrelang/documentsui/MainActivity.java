package com.mrelang.documentsui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Button;
import android.graphics.Color;
import android.view.View;
import android.os.Vibrator;
import android.widget.Toast;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    TextView tv;
    Button btn;
    Handler h = new Handler();
    int step = 0;

    String[] teksPrank = {
        "⚠️ SYSTEM BREACH DETECTED ⚠️\n\nMalware attacking bootloader\n\nPress REBOOTING ALL to enter Recovery Mode",
        "REBOOTING ALL...\n\nPreparing emergency protocol...",
        "MANUAL RECOVERY REQUIRED:\n\n1. TEKAN VOL UP + VOL DOWN + POWER\n2. Tunggu logo Android muncul ☁️🛠️\n3. Lepas POWER setelah muncul:\n 'ENTERING SAFE MODE REPAIR'\n4. Lepas semua tombol",
        "DETECTING BUTTON COMBO...\n\nSafe Mode Repair: ACTIVE\nBypassing virus signature...",
        "FACTORY DATA RESET INITIATED\n\nWiping /data... 12%\nWiping /cache... 34%",
        "SCAN COMPLETE...\n\n0 files corrupted\n0 threats found\nSystem integrity: 100%",
        "FATAL ERR: 0xDEAD0001\n\nVirus panic - self destruct\nReason: User terlalu OP",
        "REBOOTING TO SYSTEM...\n\nGa jadi rusak bang. Virusnya takut 😭"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tv = new TextView(this);
        tv.setText(teksPrank[0]);
        tv.setTextSize(16);
        tv.setTextColor(Color.GREEN);
        tv.setPadding(30, 80, 30, 30);
        tv.setBackgroundColor(Color.BLACK);

        btn = new Button(this);
        btn.setText("REBOOTING ALL");
        btn.setTextSize(20);
        btn.setBackgroundColor(Color.RED);
        btn.setTextColor(Color.WHITE);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.BLACK);
        layout.addView(tv);
        layout.addView(btn);
        setContentView(layout);

        Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        v.vibrate(800);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn.setVisibility(View.GONE);
                jalaninPrank();
            }
        });
    }

    void jalaninPrank() {
        tv.setText(teksPrank);

        Vibrator vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        if (step == 2) vib.vibrate(1500);
        else if (step == 4) vib.vibrate(new long[]{0,300,100,300}, -1);
        else if (step == 6) vib.vibrate(2000);
        else vib.vibrate(100);

        step++;
        if (step < teksPrank.length) {
            int delay = 2500;
            if (step == 3) delay = 4500;
            if (step == 5) delay = 3000;
            if (step == 6) delay = 3500;

            h.postDelayed(new Runnable() {
                public void run() {
                    jalaninPrank();
                }
            }, delay);

        } else {
            Toast.makeText(this, "Virus: Maaf bang, saya nyerah 🙏", Toast.LENGTH_LONG).show();
            h.postDelayed(new Runnable() {
                public void run() {
                    finish();
                    System.exit(0);
                }
            }, 2000);
        }
    }
}
