package com.myreactnative;


import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.Toast;
import com.enparadigm.sharpsell.sdk.ErrorListener;
import com.enparadigm.sharpsell.sdk.Sharpsell;
import com.enparadigm.sharpsell.sdk.SuccessListener;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class SharpSellSDK extends ReactContextBaseJavaModule {
    
    //constructor
    public SharpSellSDK(ReactApplicationContext reactContext) {
        super(reactContext);
    }
    //Mandatory function getName that specifies the module name
    @Override
    public String getName() {
        return "SharpSellSDK";
    };

    public String getData(String obj){
    try{
        JSONObject objData = new JSONObject(obj);
        JSONObject data = new JSONObject();
        data.put("company_code", objData.getString("company_unique_id"));
        data.put("user_unique_id", objData.getString("user_unique_id"));
        data.put("user_group_id", objData.getString("user_group_id"));
        data.put("country_code", null); 
        data.put("name", objData.getString("firstName"));
        data.put("mobile_number", objData.getString("contactNumberPrimary"));
        data.put("fcm_token", objData.getString("fcmToken"));
        data.put("email", objData.getString("email"));

        return data.toString();
    } catch(Exception e){
        e.printStackTrace();
    };
    return "";
    };

    //Custom function that we are going to export to JS
    // Home Screen
    @ReactMethod
    public void getHomeScreen(String data) {
         try{
            Sharpsell.INSTANCE.enableLogsInProductionSdk(getReactApplicationContext(),true);
            String objData = getData(data);
            Sharpsell.INSTANCE.initialize(
                getReactApplicationContext(),
                objData,
                new SuccessListener() {
                    @Override
                    public void onSuccess() {
                        Sharpsell.INSTANCE.open(getReactApplicationContext(), null);
                    }
                },
                new ErrorListener<String>() {
                    @Override
                    public void onError(@Nullable String error) {
                    }
                }
            );
         } catch (Exception e){
         }
        
    };

    // Presentation Screen
    @ReactMethod
    public void getPresentationScreen(String data) {
        try{
            String objData = getData(data);
            Sharpsell.INSTANCE.initialize(
                getReactApplicationContext(),
                objData,
                new SuccessListener() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onSuccess() {
                        try{
                            JSONObject dataPS = new JSONObject();
                            dataPS.put("route", "product_presentation_input");
                            Sharpsell.INSTANCE.open(getReactApplicationContext(), dataPS.toString());
                        } catch (Exception e){
                        }
                    }
                },
                new ErrorListener<String>() {
                    @Override
                    public void onError(@Nullable String error) {
                    }
                }
            );
        } catch (Exception e){
        };

    };

    // Launchpad Screen
    @ReactMethod
    public void getLaunchpadScreen(String data) {
         try{
            String objData = getData(data);
            Sharpsell.INSTANCE.initialize(
                getReactApplicationContext(),
                objData,
                new SuccessListener() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onSuccess() {
                        try{
                            JSONObject dataLS = new JSONObject();
                            dataLS.put("route", "launchpad");
                            Sharpsell.INSTANCE.open(getReactApplicationContext(), dataLS.toString());
                        } catch (Exception e){
                        }
                    }
                },
                new ErrorListener<String>() {
                    @Override
                    public void onError(@Nullable String error) {
                    }
                }
            );
        } catch (Exception e){
        }

    }

    // Marketing Colletral Screen
    @ReactMethod
    public void getMarketingColletral(String data) {
         try{
            String objData = getData(data);
            Sharpsell.INSTANCE.initialize(
                getReactApplicationContext(),
                objData,
                new SuccessListener() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onSuccess() {
                        try {
                            JSONObject dataLS = new JSONObject();
                            dataLS.put("route", "mc_directory");
                            Sharpsell.INSTANCE.open(getReactApplicationContext(), dataLS.toString());
                        } catch (Exception e){
                        }
                    }
                },
                new ErrorListener<String>() {
                    @Override
                    public void onError(@Nullable String error) {
                    }
                }
            );
        } catch (Exception e){
        }

    }


    // Digital visiting card
    @ReactMethod
    public void getDigitalVc(String data) {
         try{
            String objData = getData(data);
            Sharpsell.INSTANCE.initialize(
                getReactApplicationContext(),
                objData,
                new SuccessListener() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onSuccess() {
                        try {
                            JSONObject dataLS = new JSONObject();
                            dataLS.put("route", "dvc");
                            Sharpsell.INSTANCE.open(getReactApplicationContext(), dataLS.toString());
                        } catch (Exception e){
                        }
                    }
                },
                new ErrorListener<String>() {
                    @Override
                    public void onError(@Nullable String error) {
                    }
                }
            );
        } catch (Exception e){
        }

    }

    // Timer challenge
    @ReactMethod
    public void getTimerChallenge(String data) {
         try{
            String objData = getData(data);
            Sharpsell.INSTANCE.initialize(
                getReactApplicationContext(),
                objData,
                new SuccessListener() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onSuccess() {
                        try {
                            JSONObject dataLS = new JSONObject();
                            dataLS.put("route", "tc_home");
                            Sharpsell.INSTANCE.open(getReactApplicationContext(), dataLS.toString());
                        } catch (Exception e){
                        }
                    }
                },
                new ErrorListener<String>() {
                    @Override
                    public void onError(@Nullable String error) {
                    }
                }
            );
        } catch (Exception e){
        }

    }

    // Product bundle
    @ReactMethod
    public void getProductBundle(String data) {
         try{
            String objData = getData(data);
            Sharpsell.INSTANCE.initialize(
                getReactApplicationContext(),
                objData,
                new SuccessListener() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onSuccess() {
                        try {
                            JSONObject dataLS = new JSONObject();
                            dataLS.put("route", "product_bundle");
                            Sharpsell.INSTANCE.open(getReactApplicationContext(), dataLS.toString());
                        } catch (Exception e){
                        }
                    }
                },
                new ErrorListener<String>() {
                    @Override
                    public void onError(@Nullable String error) {
                    }
                }
            );
        } catch (Exception e){
        }

    }

    // Poster Of The Day
    @ReactMethod
    public void getPotd(String data) {
         try{
            String objData = getData(data);
            Sharpsell.INSTANCE.initialize(
                getReactApplicationContext(),
                objData,
                new SuccessListener() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onSuccess() {
                        try {
                            JSONObject dataLS = new JSONObject();
                            dataLS.put("route", "potd");
                            Sharpsell.INSTANCE.open(getReactApplicationContext(), dataLS.toString());
                        } catch (Exception e){
                        }
                    }
                },
                new ErrorListener<String>() {
                    @Override
                    public void onError(@Nullable String error) {
                    }
                }
            );
        } catch (Exception e){
        }

    }

    // Quick links
    @ReactMethod
    public void getQuickLinks(String data) {
         try{
            String objData = getData(data);
            Sharpsell.INSTANCE.initialize(
                getReactApplicationContext(),
                objData,
                new SuccessListener() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onSuccess() {
                        try {
                            JSONObject dataLS = new JSONObject();
                            dataLS.put("route", "quick_links");
                            Sharpsell.INSTANCE.open(getReactApplicationContext(), dataLS.toString());
                        } catch (Exception e){
                        }
                    }
                },
                new ErrorListener<String>() {
                    @Override
                    public void onError(@Nullable String error) {
                    }
                }
            );
        } catch (Exception e){
        }

    }

    // Profile
    @ReactMethod
    public void getProfile(String data) {
         try{
            String objData = getData(data);
            Sharpsell.INSTANCE.initialize(
                getReactApplicationContext(),
                objData,
                new SuccessListener() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onSuccess() {
                        try {
                            JSONObject dataLS = new JSONObject();
                            dataLS.put("route", "profile");
                            Sharpsell.INSTANCE.open(getReactApplicationContext(), dataLS.toString());
                        } catch (Exception e){
                        }
                    }
                },
                new ErrorListener<String>() {
                    @Override
                    public void onError(@Nullable String error) {
                    }
                }
            );
        } catch (Exception e){
        }

    }

    @ReactMethod
    public void clearSharpSellSdkData() {
         Sharpsell.INSTANCE.clearData(getReactApplicationContext());
    }

}