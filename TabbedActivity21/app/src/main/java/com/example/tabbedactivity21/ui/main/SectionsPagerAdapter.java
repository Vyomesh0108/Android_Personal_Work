package com.example.tabbedactivity21.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tabbedactivity21.BatteryFragment;
import com.example.tabbedactivity21.BluetoothFragment;
import com.example.tabbedactivity21.R;
import com.example.tabbedactivity21.WifiFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] mytabs = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        switch (position)
        {
            case 0 : return BluetoothFragment.newInstance("0","Bluetooth");

            case 1 : return WifiFragment.newInstance("1","Wifi");

            case 2 : return BatteryFragment.newInstance("2","Battery");
        }

        return PlaceholderFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(mytabs[position]);
    }

    @Override
    public int getCount() {
        // return how many pages or tabs we have on screen
        return mytabs.length;
    }
}