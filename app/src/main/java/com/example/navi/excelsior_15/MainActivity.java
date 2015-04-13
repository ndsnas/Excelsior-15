package com.example.navi.excelsior_15;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
//import com.example.navi.excelsior_15.Fragments.FragmentBoxOffice;
import com.example.navi.excelsior_15.Fragments.FragmentEvents;
import com.example.navi.excelsior_15.Fragments.FragmentGallery;
import com.example.navi.excelsior_15.Fragments.FragmentLive;
//import com.example.navi.excelsior_15.Fragments.FragmentSearch;
//import com.example.navi.excelsior_15.Fragments.FragmentUpcoming;
import com.example.navi.excelsior_15.Network.VolleySingleton;
import com.example.navi.excelsior_15.tabs.SlidingTabLayout;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;


public class MainActivity extends ActionBarActivity implements MaterialTabListener {
    private Toolbar toolbar;
    private ViewPager mPager;
    private SlidingTabLayout mTabs;
    private MaterialTabHost tabHost;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    public static final int LIVE = 1;
    public static final int EVENTS = 0;
    public static final int GALLERY = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        tabHost = (MaterialTabHost) findViewById(R.id.materialTabHost);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                tabHost.setSelectedNavigationItem(position);
            }
        });

        for(int i=0; i<adapter.getCount(); i++){

            tabHost.addTab(
                    tabHost.newTab()
                            .setIcon(adapter.getIcon(i))
                            .setTabListener(this));
        }
        /*mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        mTabs.setDistributeEvenly(true);
        mTabs.setCustomTabView(R.layout.custom_tab_view, R.id.tabText);*/
        /*mTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.colorAccent);
            }
        });*/
        /*mTabs.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        mTabs.setBackgroundColor(getResources().getColor(R.color.primaryColor));
        mTabs.setViewPager(mPager);*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.layout.aboutus) {
            Intent i = new Intent(MainActivity.this, AboutUs.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(MaterialTab materialTab) {
        viewPager.setCurrentItem(materialTab.getPosition());

    }

    @Override
    public void onTabReselected(MaterialTab materialTab) {

    }

    @Override
    public void onTabUnselected(MaterialTab materialTab) {

    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        int icons[] = {R.drawable.ic_action_home, R.drawable.ic_action_articles, R.drawable.ic_action_personal};
        /*String[] tabText = getResources().getStringArray(R.array.tabs);*/

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            /*tabText = getResources().getStringArray(R.array.tabs);*/
        }

        @Override
        public Fragment getItem(int num) {

            Fragment fragment=null;
            switch (num){
                case LIVE:
                    fragment= FragmentLive.newInstance("", "");
                    break;
                case EVENTS:
                    fragment= FragmentEvents.newInstance("", "");
                    break;
                case GALLERY:
                    fragment= FragmentGallery.newInstance("", "");
                    break;


            }
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            /*Drawable drawable=getResources().getDrawable(icons[position]);
            drawable.setBounds(0, 0, 36, 36);
            ImageSpan imageSpan= new ImageSpan(drawable);
            SpannableString spannableString= new SpannableString(" ");
            spannableString.setSpan(imageSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            return spannableString;*/
            return getResources().getStringArray(R.array.tabs)[position];
        }

        @Override
        public int getCount() {
            return 3;
        }
        private Drawable getIcon(int position){
            return getResources().getDrawable(icons[position]);
        }
    }

    public static class MyFragment extends Fragment {
        private TextView textView;

        public static MyFragment getInstance(int position) {
            MyFragment myFragment = new MyFragment();
            Bundle args = new Bundle();
            args.putInt("position", position);
            myFragment.setArguments(args);
            return myFragment;
        }

        /*@Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragment_my, container, false);
            textView = (TextView) layout.findViewById(R.id.position);
            Bundle bundle = getArguments();
            if (bundle != null) {
                textView.setText("The Page Currently Selected is " + bundle.getInt("position"));
            }
            RequestQueue requestQueue= VolleySingleton.getsInstance().getRequestQueue();
            StringRequest request= new StringRequest(Request.Method.GET, "http://php.net/", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getActivity(), "RESPONSE "+response, Toast.LENGTH_SHORT).show();

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getActivity(), "ERROR "+error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            requestQueue.add(request);
            return layout;
        }*/
    }


}
