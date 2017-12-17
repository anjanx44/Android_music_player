package com.example.asus.custom_music_player;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lvPlayIist);

        ArrayList<File> mySongs = findSong(Environment.getExternalStorageDirectory());
        items = new String[mySongs.size()];

        for(int i=0; i<mySongs.size(); i++){
//            toast(mySongs.get(i).getName().toString());
            items[i] = mySongs.get(i).getName().toString();
        }


        ArrayAdapter<String> adp = new ArrayAdapter<String>(getApplicationContext(),R.layout.song_layout,R.id.textView,items);
        lv.setAdapter(adp);


    }



    public ArrayList<File> findSong(File root){
        ArrayList<File> al = new ArrayList<File>();
        File[] files = root.listFiles();

        for(File singleFile : files){
            if(singleFile.isDirectory() && !singleFile.isHidden()){
                al.addAll(findSong(singleFile));
            }
            else{
                if(singleFile.getName().endsWith(".mp3") || singleFile.getName().endsWith(".wav") ){
                    al.add(singleFile);
                }
            }

        }

        return al;
    }


    public void toast(String text){
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }

}
