package com.example.weatherapplication;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.weatherapplication.Retrofit.IOpenWeatherMap;
import com.example.weatherapplication.Retrofit.RetrofitClient;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class CityFragment extends Fragment {

    private List<String> lstCities;
    private MaterialSearchBar searchBar;

    ImageView img_weather;
    TextView txt_city_name,txt_humidity,txt_sunrise,txt_sunset,txt_pressure,txt_temprature,txt_description,txt_date_time,txt_wind,txt_geo_coordinates;
    LinearLayout weather_panel;
    ProgressBar loading;

    CompositeDisposable compositeDisposable;
    IOpenWeatherMap mService;

    static CityFragment instance;


    public static CityFragment getInstance() {
        if (instance == null)
            instance = new CityFragment();
        return instance;
    }


    public CityFragment() {
        // Required empty public constructor

        compositeDisposable = new CompositeDisposable();
        Retrofit retrofit = RetrofitClient.getInstance();
        mService = retrofit.create(IOpenWeatherMap.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_city, container, false);
        img_weather = (ImageView)itemView.findViewById(R.id.img_weather);
        txt_city_name = (TextView)itemView.findViewById(R.id.txt_city_name);
        txt_date_time = (TextView)itemView.findViewById(R.id.txt_date_time);
        txt_description = (TextView)itemView.findViewById(R.id.txt_description);
        txt_geo_coordinates = (TextView)itemView.findViewById(R.id.txt_geo_coordinates);
        txt_humidity = (TextView)itemView.findViewById(R.id.txt_humadity);
        txt_pressure = (TextView)itemView.findViewById(R.id.txt_pressure);
        txt_sunrise = (TextView)itemView.findViewById(R.id.txt_sunrise);
        txt_sunset = (TextView)itemView.findViewById(R.id.txt_sunset);
        txt_temprature = (TextView)itemView.findViewById(R.id.txt_temprature);
        txt_wind = (TextView)itemView.findViewById(R.id.txt_wind);
        weather_panel = (LinearLayout)itemView.findViewById(R.id.weather_panel);
        loading = (ProgressBar)itemView.findViewById(R.id.loading);

        searchBar = (MaterialSearchBar)itemView.findViewById(R.id.searchBar);
        searchBar.setEnabled(false);

        new execute(); //Async class to load Cities.

        return itemView;
    }

    private class execute {

    }
}
