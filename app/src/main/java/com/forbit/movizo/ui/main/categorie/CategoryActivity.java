package com.forbit.movizo.ui.main.categorie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.forbit.movizo.R;
import com.forbit.movizo.model.Category;
import com.forbit.movizo.model.Movie;
import com.forbit.movizo.utils.Constant;
import com.forbitbd.myplayer.MyPlayerActivity;

import java.util.Calendar;
import java.util.List;

public class CategoryActivity extends AppCompatActivity implements MovieClickListener, CategoryContract.View {

    private RadioGroup radioGroup;
    MovieAdapter adapter;
    RecyclerView recyclerView;
    private Category category;
    private CategoryPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        mPresenter = new CategoryPresenter(this);
        this.category = (Category) getIntent().getSerializableExtra(Constant.CATEGORY);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MovieAdapter(this,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(category.getName());
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.inflateMenu(R.menu.menu);

        radioGroup = findViewById(R.id.radio_group);
//        int year = new Date().getYear();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);

        for (int i=0;i<100;i++){
            RadioButton radioButton = new RadioButton(this);
            if(i==0){
                radioButton.setText("ALL");
            }else{
                radioButton.setText(String.valueOf(year+1-i));
            }

            radioButton.setGravity(Gravity.CENTER);
            radioButton.setId(i);
            radioButton.setTypeface(radioButton.getTypeface(), Typeface.BOLD);
            radioButton.setTextSize(15f);
            radioButton.setBackground(getDrawable(R.drawable.radiobutton_selector));
            radioButton.setButtonDrawable(null);
            radioButton.setWidth(150);
            radioButton.setTextColor(R.color.black);
            radioGroup.addView(radioButton);


        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("HHHHHHH",checkedId+"");
            }
        });


        mPresenter.getCategorizedMovies(category);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.search); // get my MenuItem with placeholder submenu
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onMovieClick(Movie movie) {
        Intent intent = new Intent(getApplicationContext(), MyPlayerActivity.class);
        intent.putExtra(Constant.VIDEO_URL,movie.getVideo_url());
        startActivity(intent);
    }

    @Override
    public void renderMovies(List<Movie> movieList) {
        for(Movie x: movieList){
            adapter.addMovie(x);
        }
    }
}
