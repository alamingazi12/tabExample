package com.example.tabapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tabapplication.ui.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ViewPager viewPager = findViewById(R.id.view_pager2);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs2);
        tabs.setupWithViewPager(viewPager);
        Typeface tf=Typeface.createFromAsset(getAssets(),"fonts/Regular.ttf");
        TextView tv=new TextView(this);
        tv.setTypeface(tf);
       // FloatingActionButton fab = findViewById(R.id.fab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater=getMenuInflater();
       inflater.inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId()){
               case R.id.record:
               Toast.makeText(MainActivity2.this,"record Call",Toast.LENGTH_LONG).show();
               break;
               case   R.id.download:
               Toast.makeText(MainActivity2.this,"record Call",Toast.LENGTH_LONG).show();
               break;
               default:
                   break;
       }
       return true;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }



        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new Frag1();
                    break;
                case 1:
                    fragment = new Frag2();
                    break;
                case 2:
                    fragment = new Frag3();
                    break;
            }
            return fragment;
        }
        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Sent";
                case 1:
                    return "Received";
                case 2:
                    return "Fragment 3";
            }
           return null;
        }
    }
}