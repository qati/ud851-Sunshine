/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.sunshine.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Manages a local database for weather data.
 */
// DONE (11) Extend SQLiteOpenHelper from WeatherDbHelper
public class WeatherDbHelper extends SQLiteOpenHelper{
//  DONE (12) Create a public static final String called DATABASE_NAME with value "weather.db"
    public static final String DATABASE_NAME = "weather.db";
//  DONE (13) Create a private static final int called DATABASE_VERSION and set it to 1
    private static final int DATABASE_VERSION = 1;

//DONE (14) Create a constructor that accepts a context and call through to the superclass constructor
    public WeatherDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
//  DONE (15) Override onCreate and create the weather table from within it
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL = "CREATE TABLE " + WeatherContract.WeatherEntry.TABLE_NAME + " ("
                    + WeatherContract.WeatherEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + WeatherContract.WeatherEntry.COLUMN_DATE + " DATE,"
                    + WeatherContract.WeatherEntry.COLUMN_WEATHER_ID + " INTEGER,"
                    + WeatherContract.WeatherEntry.COLUMN_MIN_TEMP + " DECIMAL(3, 3),"
                    + WeatherContract.WeatherEntry.COLUMN_MAX_TEMP + " DECIMAL(3, 3),"
                    + WeatherContract.WeatherEntry.COLUMN_HUMIDITY + " DECIMAL(15,3),"
                    + WeatherContract.WeatherEntry.COLUMN_DEGREES  + " DECIMAL(15,3),"
                    + WeatherContract.WeatherEntry.COLUMN_PRESSURE + " DECIMAL(15,3),"
                    + WeatherContract.WeatherEntry.COLUMN_WIND_SPEED + " DECIMAL(15,3)"
                +");";
        db.execSQL(SQL);
    }
//  DONE (16) Override onUpgrade, but don't do anything within it yet
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}