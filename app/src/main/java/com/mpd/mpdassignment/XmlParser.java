// Name                 __Ian Campbell_____
// Student ID           __200507045________
// Programme of Study   ___ITMB____________
//

package com.mpd.mpdassignment;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class XmlParser {
    private static final String TAG = "XMLParser";

    public ArrayList<WeatherObject> weatherObjects;
    public ArrayList<ListItemObjects> listItemObjects;
    public String text;
    private String title = null;
    private String day = null;
    private String forecast = null;
    private String maxTemp = null;
    private String minTemp = null;
    private String windDirection = null;
    private String windSpeed = null;
    private String vis = null;
    private String pressure = null;
    private String humidity = null;
    private String uvRisk = null;
    private String pollution = null;
    private String sunrise = null;
    private String sunset = null;

    public void ProcessData(XmlPullParser xmlPullParser) throws XmlPullParserException,
            IOException {

        weatherObjects = new ArrayList<>();
        listItemObjects = new ArrayList<>();

        //xmlPullParser
        int eventType = xmlPullParser.getEventType();

        //check for the end of the document
        while (eventType != XmlPullParser.END_DOCUMENT) {

            WeatherObject weatherObjects = new WeatherObject();
            ListItemObjects listItemObjects = new ListItemObjects();

            //getting tag name in XmlPullParser
            String tagName = xmlPullParser.getName();

            //check if eventType is true
            switch (eventType) {
                case XmlPullParser.START_TAG:
                    //nothing for start tag of each element in the document
                    break;

                case XmlPullParser.TEXT:
                    //get the text from title element in rss feed
                    text = xmlPullParser.getText();
                    break;

                case XmlPullParser.END_TAG:
                    //check if getting the correct title
                    if (!text.equals("(C) British Broadcasting Corporation, see http://www.bbc.co." +
                            "uk/terms/additional_rss.shtml for more details")
                            && !text.equals("BBC Weather - Forecast for  Glasgow, GB")) {
                        if (tagName.equalsIgnoreCase("title")) {
                            text = text.split(", ")[0];
                            text = text.replace(" ,", "");
                            text = text.replaceAll("()", "");
                            text = text.replace("()", "");
                            break;
                        }
                    }

            }

        }

    }
}
