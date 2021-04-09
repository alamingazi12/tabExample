package com.example.tabapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.tabs.TabLayout;
public class TabTestActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout my_tablayout;
    ViewPager view_pager;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        view_pager=findViewById(R.id.view_pager);
        SectionPagerAdepter sectionPagerAdepter=new SectionPagerAdepter(getSupportFragmentManager());
        view_pager.setAdapter(sectionPagerAdepter);
        my_tablayout=findViewById(R.id.my_tab);
        my_tablayout.setupWithViewPager(view_pager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu_item,menu);
      return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.record:
                Toast.makeText(this, "Refresh selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            // action with ID action_settings was selected
            case R.id.update:
                Toast.makeText(this, "update selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }

        return true;
    }



    public class SectionPagerAdepter extends FragmentPagerAdapter {
        public SectionPagerAdepter(@NonNull FragmentManager fm) {
            super(fm);
        }


        @NonNull
        @Override
        public Fragment getItem(int position) {
            Fragment fragment=null;
             switch (0){

                 case 0:
                     fragment=new Frag1();
                 break;
                 case 1:
                     fragment=new Frag2();
                 break;
                 case 2:
                     fragment=new Frag3();

             }
             return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Sent";
                case 1:
                    return "Received";
                case 2:
                    return "Total";
            }
            return null;
        }


    }

}