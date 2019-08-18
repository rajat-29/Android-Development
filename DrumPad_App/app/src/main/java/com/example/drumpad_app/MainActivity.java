package com.example.drumpad_app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer one,two,three,four,five,six,seven,eight;
    int[] changeColors = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = MediaPlayer.create(MainActivity.this,R.raw.one);
        two = MediaPlayer.create(MainActivity.this,R.raw.two);
        three = MediaPlayer.create(MainActivity.this,R.raw.three);
        four = MediaPlayer.create(MainActivity.this,R.raw.four);
        five = MediaPlayer.create(MainActivity.this,R.raw.five);
        six = MediaPlayer.create(MainActivity.this,R.raw.six);
        seven = MediaPlayer.create(MainActivity.this,R.raw.seven);
        eight = MediaPlayer.create(MainActivity.this,R.raw.eight);

        getSupportActionBar().setTitle("DrumPad");
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        int randomNo;

        switch(id)
        {
            case R.id.one:
                one.start();
                randomNo = (int)(Math.random()*(changeColors.length));
                view.setBackgroundResource(changeColors[randomNo]);
                break;

            case R.id.two:
                two.start();
                randomNo = (int)(Math.random()*(changeColors.length));
                view.setBackgroundResource(changeColors[randomNo]);
                break;

            case R.id.three:
                three.start();
                randomNo = (int)(Math.random()*(changeColors.length));
                view.setBackgroundResource(changeColors[randomNo]);
                break;

            case R.id.four:
                four.start();
                randomNo = (int)(Math.random()*(changeColors.length));
                view.setBackgroundResource(changeColors[randomNo]);
                break;

            case R.id.five:
                five.start();
                randomNo = (int)(Math.random()*(changeColors.length));
                view.setBackgroundResource(changeColors[randomNo]);
                break;

            case R.id.six:
                six.start();
                randomNo = (int)(Math.random()*(changeColors.length));
                view.setBackgroundResource(changeColors[randomNo]);
                break;

            case R.id.seven:
                seven.start();
                randomNo = (int)(Math.random()*(changeColors.length));
                view.setBackgroundResource(changeColors[randomNo]);
                break;

            case R.id.eight:
                eight.start();
                randomNo = (int)(Math.random()*(changeColors.length));
                view.setBackgroundResource(changeColors[randomNo]);
                break;

            default:
                break;
        }



    }
}
