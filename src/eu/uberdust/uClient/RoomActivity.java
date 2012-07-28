package eu.uberdust.uClient;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TabPageIndicator;

import eu.uberdust.myfragment.TestFragment;
import eu.uberdust.myfragment.TestFragmentAdapter;

public class RoomActivity extends FragmentActivity {
	
	private static final String[] CONTENT = new String[] { "Capabilities", "Commands" };
    TestFragmentAdapter mAdapter;
    ViewPager mPager;
    PageIndicator mIndicator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        
        /*Intent i = getIntent();
        Room room = (Room)i.getSerializableExtra("MyRoom");*/
        
        mAdapter = new GoogleMusicAdapter(getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (TabPageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        
    }
    
  
    class GoogleMusicAdapter extends TestFragmentAdapter {
        public GoogleMusicAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TestFragment.newInstance(RoomActivity.CONTENT[position % RoomActivity.CONTENT.length]);
        }

        @Override
        public int getCount() {
            return RoomActivity.CONTENT.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return RoomActivity.CONTENT[position % RoomActivity.CONTENT.length].toUpperCase();
        }
    }
    
}