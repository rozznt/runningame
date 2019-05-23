package com.example.runningame;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1,cb2,cb3;
    SeekBar sk1,sk2,sk3;
    TextView txtPoint;
    ImageButton btnplay;
    int point =10;
    Button rt,quit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reflection();
        sk1.setEnabled(false);
        sk2.setEnabled(false);
        sk3.setEnabled(false);


        txtPoint.setText(point +"");


        final CountDownTimer countDownTimer =new CountDownTimer(60000,300) {
            @Override
            public void onTick(long millisUntilFinished) {

                int num = 5;
                Random random = new Random();
                int one = random.nextInt(num);
                int two = random.nextInt(num);
                int three = random.nextInt(num);
                sk1.setProgress(sk1.getProgress() + one);
                sk2.setProgress(sk2.getProgress()+ two);
                sk3.setProgress(sk3.getProgress() + three );

                if(sk1.getProgress() >= sk1.getMax()){

                   this.cancel();
                   btnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Sonic win!", Toast.LENGTH_SHORT).show();
                    if(cb1.isChecked()){
                        point += 4;
                        Toast.makeText(MainActivity.this, "congrats!, you have been added 4 point", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        point -= 3;
                        Toast.makeText(MainActivity.this, "sorry :( ! you have been lost 4 point, try again !", Toast.LENGTH_SHORT).show();
                    }

                        txtPoint.setText(point + "");
                        enable();

                }

                if(sk2.getProgress() >=sk2.getMax()){
                    this.cancel();
                    btnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Pika win!", Toast.LENGTH_SHORT).show();

                    if(cb2.isChecked()){
                        point += 2;
                        Toast.makeText(MainActivity.this, "congrats!, you have been added 2 point", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        point -= 2;
                        Toast.makeText(MainActivity.this, "sorry :( ! you have been lost 2 point, try again !", Toast.LENGTH_SHORT).show();
                    }



                        txtPoint.setText(point + "");
                        enable();

            }
                if(sk3.getProgress() >= sk3.getMax()){
                    this.cancel();
                    btnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "doraenon win!", Toast.LENGTH_SHORT).show();
                    if(cb3.isChecked()){
                        point += 1;
                        Toast.makeText(MainActivity.this, "congrats!, you have been added 1 point", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        point -= 1;
                        Toast.makeText(MainActivity.this, "sorry :( ! you have been lost 1 point, try again !", Toast.LENGTH_SHORT).show();
                    }

                        txtPoint.setText(point + "");
                        enable();

                }

            }

            @Override
            public void onFinish() {

            }
        };

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cb2.setChecked(false);
                cb3.setChecked(false);

            }
        });

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cb1.setChecked(false);
                cb3.setChecked(false);

            }
        });

        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cb2.setChecked(false);
                cb1.setChecked(false);
            }
        });

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (point > 0) {
                    if (cb1.isChecked() || cb2.isChecked() || cb3.isChecked()) {
                        sk1.setProgress(0);
                        sk2.setProgress(0);
                        sk3.setProgress(0);

                        btnplay.setVisibility(View.INVISIBLE);

                        countDownTimer.start();


                        disable();
                    } else {
                        Toast.makeText(MainActivity.this, "please bet your house to play!", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "you have no more point to play, please bet your another home!", Toast.LENGTH_SHORT).show();
                    countDownTimer.cancel();
                }
            }

        });

        rt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                point = 5;
                txtPoint.setText(point + "");
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    private void enable(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);

    }

    private void disable(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }
    private void reflection(){
        cb1 = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        sk1 = (SeekBar) findViewById(R.id.seekBar1);
        sk2 = (SeekBar) findViewById(R.id.seekBar2);
        sk3 = (SeekBar) findViewById(R.id.seekBar3);
        txtPoint =(TextView) findViewById(R.id.txt);
        btnplay = (ImageButton) findViewById(R.id.play);
        rt = (Button) findViewById(R.id.reset);
        quit = (Button) findViewById(R.id.quit);

    }

}
