package com.example.asus.custom_music_player;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.util.ArrayList;

public class Player extends AppCompatActivity {

    MediaPlayer mp;
    ArrayList<File> mySongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);


        Intent i = getIntent();
//
        Bundle b = i.getExtras();
//
//
        mySongs = (ArrayList) b.getParcelableArrayList("songlist");
//
        int possition = b.getInt("pos",0);
//
//
        Uri u = Uri.parse(mySongs.get(possition).toString());
//
        mp = MediaPlayer.create(getApplicationContext(),u);
//
        mp.start();
    }
}
