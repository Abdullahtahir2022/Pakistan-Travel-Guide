package com.example.quiz_app.Activities.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.quiz_app.Activities.adapters.P_adapter;
import com.example.quiz_app.Activities.utils.Tuple;
import com.example.quiz_app.Activities.utils.string_storage;
import com.example.quiz_app.R;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RequiresApi(api = Build.VERSION_CODES.R)
public class cities extends AppCompatActivity {


    ActionBarDrawerToggle actionBarDrawerToggle;

    ArrayList<string_storage> hotels = new ArrayList<>();
    ArrayList<string_storage> land_marks = new ArrayList<>();
    ArrayList<string_storage> transport = new ArrayList<>();


    ArrayList<Tuple> hostel_coordinates = new ArrayList<Tuple>();
    ArrayList<Tuple> land_coordinates = new ArrayList<>();
    ArrayList<Tuple> Transport_cordinates = new ArrayList<>();

//
//    public ArrayList<Tuple> getArray1() {
//        return array1;
//    }











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        setupviews();
        getSupportActionBar().setTitle("Travel Guide");
        ImageView image;
        String city = getIntent().getStringExtra("city");
        image = findViewById(R.id.City_display);
        System.out.println(city);
        if(city.equals("lahore")){

        image.setBackgroundResource(R.drawable.lahore1);}
        if(city.equals("quetta")){
            image.setBackgroundResource(R.drawable.quetta);}
        if(city.equals("peshawar")){
            image.setBackgroundResource(R.drawable.peshawar);}
        if(city.equals("karachi")){
            image.setBackgroundResource(R.drawable.karachi);}
        if(city.equals("islamabad") ){
            image.setBackgroundResource(R.drawable.isb);}
        Toast.makeText(getApplicationContext(),"Please wait...",Toast.LENGTH_LONG).show();
        new api().execute();




    }



        class api extends AsyncTask<Void, Void, Response> {


            Response response;
            @Override
            protected Response doInBackground(Void... voids) {


                Log.e("TAG", "doInBackground: ");

                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url("https://hotels4.p.rapidapi.com/locations/search?query=lahore&locale=en_US")
                        .get()
                        .addHeader("x-rapidapi-key", "f55a7d5474msh3c90a4ac2d6a2f9p1e67b7jsn865ef33b41f5")
                        .addHeader("x-rapidapi-host", "hotels4.p.rapidapi.com")
                        .build();



                try {
                    Response response = client.newCall(request).execute();



                } catch (IOException e) {
                    Log.e("TAG", "fail");
                    e.printStackTrace();
                }
                return response;
            }
            @Override
            protected void onPostExecute(Response response) {


                try {
                    String json;
                    Log.e("TAG",response.body().string() );
                    json = response.body().string();
                    Log.e("TAG", json );

                    JSONObject jsonObj = new JSONObject(json);
                    JSONArray array =(JSONArray)jsonObj.get("suggestions");

                    for(int x=0;x<array.length();x++){

                    String I = array.getString(x);
                    JSONObject index = new JSONObject(I);

                        if(index.getString("group").equals("TRANSPORT_GROUP")){
                            JSONArray array1 =(JSONArray)index.get("entities");
                            for(int j=0;j<array1.length();j++){
                                String v = array1.getString(j);
                                JSONObject values = new JSONObject(v);
                                transport.add(new string_storage(values.getString("name")));
                                Transport_cordinates.add(new Tuple(values.getDouble("longitude"),values.getDouble("latitude")));



                            }

                        }

                    if(index.getString("group").equals("LANDMARK_GROUP")){
                        JSONArray array1 =(JSONArray)index.get("entities");
                        for(int j=0;j<array1.length();j++){
                             String v = array1.getString(j);
                             JSONObject values = new JSONObject(v);
                            land_marks.add(new string_storage(values.getString("name")));
                             land_coordinates.add(new Tuple(values.getDouble("longitude"),values.getDouble("latitude")));



                        }

                        }

                    if(index.getString("group").equals("HOTEL_GROUP")){
                    JSONArray array1 =(JSONArray)index.get("entities");
                        for(int j=0;j<array1.length();j++){

                        String v = array1.getString(j);
                        JSONObject values = new JSONObject(v);
                        hotels.add(new string_storage(values.getString("name")));
                        hostel_coordinates.add(new Tuple(values.getDouble("longitude"),values.getDouble("latitude")));


                        }

                    }

                    }

                    Toast.makeText(getApplicationContext(),"Ready to Use",Toast.LENGTH_SHORT).show();
                    ImageView img;
                    img = (ImageView) findViewById(R.id.restuarant);




                    img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(cities.this, restaurants.class);
                            startActivity(intent);
                        }
                    });














                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }







            }
        }







    private  void setupviews()
    {

        setupdrawer();


    }



    private void setupdrawer(){
        MaterialToolbar bar;
        DrawerLayout drawer;
        drawer = findViewById(R.id.drawer);
        bar = findViewById(R.id.AppBar);
        setSupportActionBar(bar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer,R.string.app_name,R.string.app_name);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}