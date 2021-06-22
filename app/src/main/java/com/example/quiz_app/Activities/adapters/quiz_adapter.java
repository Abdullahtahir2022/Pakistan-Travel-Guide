package com.example.quiz_app.Activities.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz_app.Activities.models.Quiz;
import com.example.quiz_app.R;

public class quiz_adapter extends RecyclerView.Adapter<quiz_adapter.QuizViewHolder> {
    String[] quizzes_data;

    public quiz_adapter(String[]  quizzes){

        quizzes_data = quizzes;


    }


    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.quiz_item,parent,false);
        return new QuizViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        String title1 = quizzes_data[position];
        holder.title.setText(title1);


    }

    @Override
    public int getItemCount() {
        return quizzes_data.length;
    }

    public  class QuizViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public CardView card;
        public ImageView icon;


        public QuizViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.quiz_title);
            card = (CardView) itemView.findViewById(R.id.card);
            icon = (ImageView) itemView.findViewById(R.id.quizicon);
        }
    }


}
