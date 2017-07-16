package com.example.android.sunshine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

/**
 * Created by qati on 7/16/2017.
 */

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener{
    private void setPreferenceSummary(Preference p, String value){
        if (p instanceof ListPreference){
            ListPreference lp = (ListPreference)p;
            int i = lp.findIndexOfValue(value);
            if (i>=0){
                lp.setSummary(lp.getEntries()[i]);
            }
            return;
        }
        p.setSummary(value);

    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.pref_general);
        int count = getPreferenceScreen().getPreferenceCount();
        for(int i=0;i<count;i++){
            Preference p = getPreferenceScreen().getPreference(i);
            if (!(p instanceof CheckBoxPreference)){
                setPreferenceSummary(p, getPreferenceScreen().getSharedPreferences().getString(p.getKey(), ""));
            }
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference p = findPreference(key);
        if (p!=null && !(p instanceof CheckBoxPreference)){
            setPreferenceSummary(p, sharedPreferences.getString(key, ""));
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onDestroy() {
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }
}
