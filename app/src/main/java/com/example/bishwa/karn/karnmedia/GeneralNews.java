package com.example.bishwa.karn.karnmedia;

import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class GeneralNews extends AppCompatActivity implements AdapterView.OnItemClickListener {

    DrawerLayout drawerLayout;
    ListView listView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private ArrayAdapter<String> adapter;
    String[] newsList = {"Social", "Sport", "TV", "Polistics"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_news);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listView = (ListView) findViewById(R.id.list_item_view);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close) {


            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle("General News");
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("News Section");
            }
        };

        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, newsList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        changeFragment(position);
    }


    private void changeFragment(int position) {
        Fragment fragment;
        FragmentManager fm;
        android.support.v4.app.FragmentTransaction ft;
        switch (position) {
            case 0:
                fragment = new FragmentSocial();
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.main_fragment, fragment);
                ft.commit();
                break;
            case 1:
                fragment = new FragmentSport();
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.main_fragment, fragment);
                ft.commit();
                break;
            case 2:
                fragment = new FragmentSocial();
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.main_fragment, fragment);
                ft.commit();
                break;
            case 3:
                fragment = new FragmentSport();
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.main_fragment, fragment);
                ft.commit();
                break;
        }
    }

}
