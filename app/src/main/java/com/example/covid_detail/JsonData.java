package com.example.covid_detail;

import android.content.Context;
import android.database.Cursor;
import android.telecom.StatusHints;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.ArrayList;

public class JsonData {
    Context context;
    String data;


    public JsonData(Context context)
    {
        this.context=context;

    }



}
