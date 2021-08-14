package com.example.quiz_app.Activities.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz_app.Activities.utils.Tuple;
import com.example.quiz_app.Activities.utils.string_storage;
import com.example.quiz_app.R;

import java.util.ArrayList;
import java.util.Locale;

public class P_adapter extends RecyclerView.Adapter <P_adapter.ProgrammingViewHolder>{

    private ArrayList<string_storage> data;
    private  ArrayList<Tuple> cor;
    private Context context;
    public P_adapter(Context context, ArrayList<string_storage> data, ArrayList<Tuple> cor){

        this.data = data;
        this.context=context;
        this.cor = cor;

    }

    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.quiz_item,parent,false);
        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, int position) {
        string_storage obj = data.get(position);
        Tuple obj1 = cor.get(position);

        String text = obj.x;
        Double x = obj1.x;
        Double y = obj1.y;
        holder.title.setText(text);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", y, x);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder{
        ImageView icon;
        TextView title;
        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_rec);

        }
    }

}
