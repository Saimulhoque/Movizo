package com.forbit.movizo.ui.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.forbit.movizo.ui.kids.KidsActivity;
import com.forbit.movizo.ui.livetv.LiveTvActivity;
import com.forbit.movizo.R;
import com.forbit.movizo.ui.main.popularVideos.PopularVideosFragment;
import com.forbit.movizo.ui.upcoming.UpcomingActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    int images[] = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4,R.drawable.slide5,R.drawable.slide6};
    int currentPageCounter = 0;
    PopularVideosFragment popularVideosFragment, recentlyAddedMovies;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.inflateMenu(R.menu.menu);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = df.format(cal.getTime());
        toolbar.setSubtitle(currentDate);
        toolbar.setSubtitleTextColor(Color.WHITE);
        toolbar.setTitle("Movizo");
        toolbar.setTitleTextColor(Color.WHITE);

        popularVideosFragment = (PopularVideosFragment) getSupportFragmentManager().findFragmentById(R.id.popularVideos);
        recentlyAddedMovies = (PopularVideosFragment) getSupportFragmentManager().findFragmentById(R.id.recentlyadded);
        popularVideosFragment.setTitle("Popular Movies");
        recentlyAddedMovies.setTitle("Recently Added Movies");

        viewPager = findViewById(R.id.slideview);
        viewPager.setAdapter(new SliderAdapter(images, MainActivity.this));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager, true);

        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPageCounter == images.length) {
                    currentPageCounter = 0;
                }
                viewPager.setCurrentItem(currentPageCounter++, true);
            }
        };
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 3000, 3000);

        //initialize and assign variable//
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavigation);
        //Set home selected//
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        return true;
                    case R.id.upcoming:
                        startActivity(new Intent(getApplicationContext(), UpcomingActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.livetv:
                        startActivity(new Intent(getApplicationContext(), LiveTvActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.kids:
                        startActivity(new Intent(getApplicationContext(), KidsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.search);
        return super.onCreateOptionsMenu(menu);
    }

    public void onBackPressed() {
        finishAffinity();
    }
}

