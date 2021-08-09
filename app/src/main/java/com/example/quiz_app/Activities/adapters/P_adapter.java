package com.example.quiz_app.Activities.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz_app.R;

public class P_adapter extends RecyclerView.Adapter <P_adapter.ProgrammingViewHolder>{

    private  String[] data;

    public P_adapter(String[] data){

        this.data = data;


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

        String text = data[position];
        holder.title.setText(text);


    }

    @Override
    public int getItemCount() {
        return data.length;
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
