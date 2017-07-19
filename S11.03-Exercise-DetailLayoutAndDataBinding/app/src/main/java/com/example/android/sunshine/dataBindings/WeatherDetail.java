package com.example.android.sunshine.dataBindings;


import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.example.android.sunshine.BR;
import com.example.android.sunshine.R;
import com.example.android.sunshine.utilities.SunshineDateUtils;
import com.example.android.sunshine.utilities.SunshineWeatherUtils;

/**
 * Created by qati on 7/20/2017.
 */

public class WeatherDetail  extends BaseObservable {
    private Context mContext;
    private long mDate;
    private int mWeatherID;
    private double mHighTemp, mLowTemp;
    private float mWindSpeed, mWindDirection;
    private float mHumidity, mPressure;

    public WeatherDetail(Context context){
        mContext = context;
    }

    public void setDate(long date){
        mDate = date;
        notifyPropertyChanged(BR.date);
    }

    public void setWeatherId(int id){
        mWeatherID = id;
        notifyPropertyChanged(BR.description);
        notifyPropertyChanged(BR.image);
    }

    public void setLowTemp(double lowTemp){
        mLowTemp = lowTemp;
        notifyPropertyChanged(BR.lowTemp);
    }

    public void setHighTemp(double highTemp){
        mHighTemp = highTemp;
        notifyPropertyChanged(BR.highTemp);
    }

    public void setWind(float windSpeed, float windDirection){
        mWindSpeed = windSpeed;
        mWindDirection = windDirection;
        notifyPropertyChanged(BR.wind);
    }

    public void setHumidity(float humidity){
        mHumidity = humidity;
        notifyPropertyChanged(BR.humidity);
    }

    public void setPressure(float pressure){
        mPressure = pressure;
        notifyPropertyChanged(BR.pressure);
    }

    @Bindable
    public String getDate(){
        return SunshineDateUtils.getFriendlyDateString(mContext, mDate, true);
    }

    @Bindable
    public int getImage(){
        return SunshineWeatherUtils.getLargeArtResourceIdForWeatherCondition(mWeatherID);
    }

    @Bindable
    public String getDescription(){
        return SunshineWeatherUtils.getStringForWeatherCondition(mContext, mWeatherID);
    }

    @Bindable
    public String getHighTemp(){
        return SunshineWeatherUtils.formatTemperature(mContext, mHighTemp);
    }

    @Bindable
    public String getLowTemp(){
        return SunshineWeatherUtils.formatTemperature(mContext, mLowTemp);
    }

    @Bindable
    public String getWind(){
        return SunshineWeatherUtils.getFormattedWind(mContext, mWindSpeed, mWindDirection);
    }

    @Bindable
    public String getHumidity(){
        return mContext.getString(R.string.format_humidity, mHumidity);
    }

    @Bindable
    public String getPressure(){
        return mContext.getString(R.string.format_pressure, mPressure);
    }
}
