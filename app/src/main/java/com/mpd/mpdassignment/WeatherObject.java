// Name                 __Ian Campbell_____
// Student ID           __200507045________
// Programme of Study   ___ITMB____________

// xml data storage template class
// prepares items for parcelling

package com.mpd.mpdassignment;

import android.os.Parcel;
import android.os.Parcelable;

public class WeatherObject implements Parcelable {

    private String title;

    String day;
    String forecast;
    String maxTemp;
    String minTemp;
    String windDirection;
    String windSpeed;
    String vis;
    String pressure;
    String humidity;
    String uvRisk;
    String pollution;
    String sunrise;
    String sunset;

    public WeatherObject() {
    }

    public String getDay() {
        return day;
    }
    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getVis() {
        return vis;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getUvRisk() {
        return uvRisk;
    }

    public String getPollution() {
        return pollution;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setDay(String title) {
        this.day = title;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setVis(String vis) {
        this.vis = vis;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public void setUvRisk(String uvRisk) {
        this.uvRisk = uvRisk;
    }

    public void setPollution(String pollution) {
        this.pollution = pollution;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    // object to be parcelled
    protected WeatherObject(Parcel in) {
        day = in.readString();
        forecast = in.readString();
        maxTemp = in.readString();
        minTemp= in.readString();
        windDirection= in.readString();
        windSpeed= in.readString();
        vis= in.readString();
        pressure= in.readString();
        humidity= in.readString();
        uvRisk= in.readString();
        pollution= in.readString();
        sunrise= in.readString();
        sunset= in.readString();
    }

    // parcel is written to and destination
    @Override
    public void writeToParcel (Parcel dest, int flags) {
        dest.writeString(day);
        dest.writeString(forecast);
        dest.writeString(maxTemp);
        dest.writeString(minTemp);
        dest.writeString(windDirection);
        dest.writeString(windSpeed);
        dest.writeString(vis);
        dest.writeString(pressure);
        dest.writeString(humidity);
        dest.writeString(uvRisk);
        dest.writeString(pollution);
        dest.writeString(sunrise);
        dest.writeString(sunset);

    }

    @Override
    public int describeContents()  {
        return 0;
    }
        // parcel is created from data
        public static final Creator<WeatherObject> CREATOR = new Creator<WeatherObject>() {
        @Override
            public WeatherObject createFromParcel (Parcel in) {return new WeatherObject();}

        @Override
            public WeatherObject[] newArray(int size) {return new WeatherObject[size];}
    };



}
