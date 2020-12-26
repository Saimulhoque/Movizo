package com.forbit.movizo.ui.livetv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.forbit.movizo.R;
import com.forbit.movizo.ui.upcoming.UpcomingActivity;
import com.forbit.movizo.ui.kids.KidsActivity;
import com.forbit.movizo.ui.main.MainActivity;
import com.forbit.movizo.utils.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class LiveTvActivity extends BaseActivity {

    LiveTvAdapter liveTvAdapter;
    RecyclerView recyclerView;
    List<LiveTv> liveTvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_tv);

        setupToolBar(R.id.toolbar);

        liveTvList = new ArrayList<>();
        for (int i=0;i<1;i++){
            liveTvList.add(new LiveTv(R.drawable.somoy, "TV "+String.valueOf(i+1)));
        }

        recyclerView = findViewById(R.id.recyclerView);
        liveTvAdapter = new LiveTvAdapter(this,liveTvList);
        recyclerView.setAdapter(liveTvAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        //initialize and assign variable//
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavigation);

        //Set live tv selected//
        bottomNavigationView.setSelectedItemId(R.id.livetv);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.upcoming:
                        startActivity(new Intent(getApplicationContext(), UpcomingActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.livetv:
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

    public void onBackPressed() {
        this.startActivity(new Intent(this,MainActivity.class));
        return;
    }
}