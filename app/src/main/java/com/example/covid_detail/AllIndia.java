package com.example.covid_detail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AllIndia extends Fragment {
    RecyclerView recyclerView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_all_india, container, false);
        recyclerView=view.findViewById(R.id.allIndialist);
        getJsonObjectData();
        return view;
    }
    public void getJsonObjectData() {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        JsonObjectRequest
                jsonObjectRequest
                = new JsonObjectRequest(
                Request.Method.GET,
                "https://api.covid19india.org/data.json",
                null,
                new Response.Listener() {
                    @Override
                    public void onResponse(Object response) {


                        int size=0;
                        try {
                            JSONObject jsonObject=new JSONObject(response.toString());
                            JSONArray info=jsonObject.getJSONArray("cases_time_series");
                            size=info.length();
                            //   Toast.makeText(getApplicationContext(),size+" size",Toast.LENGTH_LONG).show();





                            ArrayList arrayList=new ArrayList();

                            for(int i=info.length()-1;i>=0;i--)
                            {
                                JSONObject row=info.getJSONObject(i);
                                arrayList.add(row.get("dateymd")+"!@!"+row.get("totaldeceased")+"!@!"+row.get("totalconfirmed"));

                            }
                            arrayList.size();
                            Toast.makeText(getContext(),arrayList.get(0)+"",Toast.LENGTH_LONG).show();
                            Toast.makeText(getContext(),arrayList.size()+" = "+info.length(),Toast.LENGTH_LONG).show();
                            MyAdapter adapter=new MyAdapter(getContext(),arrayList);
                            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
                            recyclerView.setAdapter(adapter);



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {

                    }
                });
        queue.add(jsonObjectRequest);




    }
}