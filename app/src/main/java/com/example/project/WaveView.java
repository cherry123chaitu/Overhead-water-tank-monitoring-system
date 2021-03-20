package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import me.itangqi.waveloadingview.WaveLoadingView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WaveView extends AppCompatActivity {
    WaveLoadingView waveLoadingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave_view);
        Retrofit retrofit;
        retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Api api = retrofit.create(Api.class);

        waveLoadingView=findViewById(R.id.WaveLoadingview);
       Call<List<WaveLevel>> call =api.getLevel();
       call.enqueue(new Callback<List<WaveLevel>>() {
           @Override
           public void onResponse(Call<List<WaveLevel>> call, Response<List<WaveLevel>> response) {List<WaveLevel> list = response.body();
               String[] distances = new String[list.size()];

               for (int i = 0; i < list.size(); i++) {
                   distances[i] = list.get(i).getDistance();
                   Float x=Float.parseFloat(distances[i]);
                   int y=Math.round(x);
                   waveLoadingView.setProgressValue(y);
                   if (x<=50){
                       waveLoadingView.setBottomTitle(String.format("%d%%",y));
                       waveLoadingView.setCenterTitle("");
                       waveLoadingView.setTopTitle("");
                   }
                   else if (x<80){
                       waveLoadingView.setBottomTitle("");
                       waveLoadingView.setCenterTitle(String.format("%d%%",y));
                       waveLoadingView.setTopTitle("");
                   }
                   else{
                       waveLoadingView.setBottomTitle("");
                       waveLoadingView.setTopTitle(String.format("%d%%",y));
                       waveLoadingView.setCenterTitle("");
                   }
               }



           }

           @Override
           public void onFailure(Call<List<WaveLevel>> call, Throwable t) {
               Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();
           }

       });


    }
    public void Reload(View view){
        Intent intent;
        intent = new Intent(WaveView.this,WaveView.class);
        startActivity(intent);
        finish();
    }
}
