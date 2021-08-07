package com.example.videoswipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private ArrayList<Model> dataList = new ArrayList<>();
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager =(ViewPager2) findViewById(R.id.viewPager);
        buildData();
        Adapter adapter = new Adapter(dataList);
        viewPager.setAdapter(adapter);
    }

    private void buildData() {
        Model dark_muscle = new Model("android.resource://" + getPackageName() + "/" + R.raw.darkmuscle,"Dark Muscle","The most powerful muscle car on planet.");
        dataList.add(dark_muscle);
        Model pc = new Model("android.resource://" + getPackageName() + "/" + R.raw.pc,"High-End PC","Have a look on this Ryzen powered Beast.");
        dataList.add(pc);
        Model gt500 = new Model("android.resource://" + getPackageName() + "/" + R.raw.gt500,"Shelby GT-500 720HP","Shelby`s snake is on road.");
        dataList.add(gt500);
        Model dance = new Model("android.resource://" + getPackageName() + "/" + R.raw.hdance,"Sync on the beat","New dance video.Please like");
        dataList.add(dance);
        Model ironman = new Model("android.resource://" + getPackageName() + "/" + R.raw.ironman,"Iron Man Tribute","Tony was always ready to sacrifice for the world.");
        dataList.add(ironman);
        Model bomb_mustang = new Model("android.resource://" + getPackageName() + "/" + R.raw.bombmustang,"RTR - Dark Muscle","Join Ford Performance Club.");
        dataList.add(bomb_mustang);
        Model tokyoDrift = new Model("android.resource://" + getPackageName() + "/" + R.raw.tokyo,"how legends take turns","JDM drifting during race.");
        dataList.add(tokyoDrift);
    }
}