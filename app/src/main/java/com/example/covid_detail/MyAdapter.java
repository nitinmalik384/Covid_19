package com.example.covid_detail;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    Context context;
    ArrayList list;
    public MyAdapter(Context context, ArrayList list)
    {  this.context=context;
        this.list=list;}

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.row,parent,false);

        return new MyAdapter.MyHolder(view);

    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        String[] row=(list.get(position)+"").split("!@!");
        String date=row[0];
        String tdeath=row[1];
        String  tcase=row[2];
        holder.dateTV.setText(date);
        holder.tdeathTV.setText(tdeath);
        holder.tcaseTV.setText(tcase);
 }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView dateTV,tcaseTV,tdeathTV;
        LinearLayout row;


        public MyHolder(View itemView) {
            super(itemView);
            dateTV=itemView.findViewById(R.id.date);
            tcaseTV=itemView.findViewById(R.id.tcase);
            tdeathTV=itemView.findViewById(R.id.tdeath);
            row=itemView.findViewById(R.id.row);



        }
    }
}
