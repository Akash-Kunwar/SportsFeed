package com.company.dell_pc.football;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawer;
    ViewPager Pager;
    NavigationView navigationView;
    private AdView mAdView;
    private InterstitialAd interstital;
    int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdView = (AdView) findViewById(R.id.adView);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.Drawer_open, R.string.Drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        SectionPagerAdapter pagerAdapter=new SectionPagerAdapter(getSupportFragmentManager());
        Pager=(ViewPager)findViewById(R.id.pager);
        Pager.setAdapter(pagerAdapter);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(Pager);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        tabLayout.getTabAt(0).setIcon(R.drawable.cricketicon2);
        tabLayout.getTabAt(1).setIcon(R.drawable.soccerdrawable);
        tabLayout.getTabAt(2).setIcon(R.drawable.soccerdrawable);
        tabLayout.getTabAt(3).setIcon(R.drawable.bskimg);
        tabLayout.getTabAt(4).setIcon(R.drawable.cricketicon2);
        //banner ad
        /*FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        Fragment fragment=new cricket_frag();
        ft.add(R.id.mainfrag,fragment);
        ft.commit();
        */
        ad();
    }


    private class SectionPagerAdapter extends FragmentPagerAdapter {
        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new cricket_frag();

                case 1:
                    return new basketball_frag();//All football Events


                case 2:


                    return new FootballnewsFrag();//Selected Events
                case 3:
                    return new fantasy_frag();
                case 4:
                    return new football_frag();

            }
            return null;
        }

        @Override
        public int getCount() {
            return 5 ;
        }
//suraj1234
      /*  @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position)
            {
                case 0:
                    return getResources().getText(R.string.Cric_fragment);
                case 1:
                    return getResources().getText(R.string.Football_fragment);
                case 2:
                    return getDrawable(R.drawable.soccerdrawable).toString();
                case 3:
                    return "BSK";
                case 4:return "PRE";

            }
            return null;
        }*/
    }





    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        int i=0;
       // Fragment fragment = null;
        Intent intent = null;
        switch (id) {
            case R.id.cricket:
                //  fragment=new cricket_frag();
                i=0;

                break;
            case R.id.basketball://All Football Football
                // fragment=new football_frag();
                i=1;
                ad();
                break;
            case R.id.fnews:
                //  fragment=new FootballnewsFrag();

                i=2;
                break;
            case R.id.football://Selected Events
                //  fragment=new basketball_frag();
                i=4;
                ad();
                break;
            case R.id.fantasy:
                // fragment=new fantasy_frag();
                i=3;

                break;
            case R.id.help:
                intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"trioindia697@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "User Help");
                intent.setType("plain/text");
                break;
            case R.id.feedback:
                intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"akshayanand771@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "User Fedback");
                intent.setType("plain/text");
                break;


        }
        if (intent== null) {
            ViewPager pager=(ViewPager)findViewById(R.id.pager);
            pager.setCurrentItem(i);
            /*FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainfrag,fragment);
            ft.commit();*/
        } else {
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (i==1){

                Toast.makeText(this, " Press once more to exit..", Toast.LENGTH_SHORT).show();
                i++;
            }

            else if(i==2){
                finish();
            }
        }

    }
    public void ad() {    //Intersial ad

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        interstital = new InterstitialAd(MainActivity.this);
        interstital.setAdUnitId("ca-app-pub-2702096336547459/6133926029");
        interstital.loadAd(adRequest1);
        interstital.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                displayInterstial();
            }
        });
    }
    private void displayInterstial() {
        if (interstital.isLoaded()) {
            interstital.show();
        }
    }
}


//ca-app-pub-2702096336547459/9329390410-my adds
//i-ca-app-pub-2702096336547459/6133926029