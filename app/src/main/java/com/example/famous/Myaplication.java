package com.example.famous;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.lang.ref.ReferenceQueue;

public class Myaplication extends Application {
    public static final String TAG = Myaplication.class.getSimpleName();
    private RequestQueue mrequestqueue;
    private static Myaplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    public static synchronized Myaplication getInstance() {
        return mInstance;
    }
    public RequestQueue getRequestQueue() {
        if (mrequestqueue == null) {
            mrequestqueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mrequestqueue;
    }
    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }
    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }
    public void cancelPendingRequests(Object tag) {
        if (mrequestqueue != null) {
            mrequestqueue.cancelAll(tag);
        }
    }
}
