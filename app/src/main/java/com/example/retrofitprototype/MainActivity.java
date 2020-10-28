package com.example.retrofitprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    private TextView lyricsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lyricsTextView = findViewById(R.id.lyrics_textView);
    }

    public void showLyrics(View view)
    {
        WebService webService = ServiceBuilder.buildService(WebService.class);

        Call<String> call = webService.getLyrics("kehlani", "gangsta");

        call.enqueue(new Callback<String>()
        {
            @Override
            public void onResponse(Call<String> call, Response<String> response)
            {
                Log.d("MainActivity", response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t)
            {
                lyricsTextView.setText(t.getMessage());
            }
        });
    }
}