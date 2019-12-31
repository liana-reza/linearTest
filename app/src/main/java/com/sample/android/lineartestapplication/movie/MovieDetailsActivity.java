package com.sample.android.lineartestapplication.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.sample.android.lineartestapplication.Const;
import com.sample.android.lineartestapplication.R;
import com.sample.android.lineartestapplication.movie.pojo.MovieDetailsResult;
import com.sample.android.lineartestapplication.movie.pojo.SearchResult;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MovieDetailsActivity extends AppCompatActivity {
    Intent intent;
    ImageView imageMoviePoster;
    TextView txtMovieTitle, txtMovieBudget, txtMovieGenres, txtMovieRate, txtMovieDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        intent = getIntent();
        initViews();
        if (intent.getIntExtra(Const.TAG_ITEM_ID,0) !=0)
            connectToInternet(intent.getIntExtra(Const.TAG_ITEM_ID,0));
    }

    private void connectToInternet(int ID) {
            AsyncHttpClient client = new AsyncHttpClient();


            String address = "https://api.themoviedb.org/3/movie/" + ID
                    + "?api_key=" + Const.API_KEY + "&language=en-US";


            client.get(address, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    super.onSuccess(statusCode, headers, response);
                    Log.i("Response", response.toString());
                    Gson gson = new Gson();
                    MovieDetailsResult result = gson.fromJson(response.toString(), MovieDetailsResult.class);
                    setViewValue(result);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    super.onFailure(statusCode, headers, throwable, errorResponse);
                }

            });
        }


    private void setViewValue(MovieDetailsResult result) {
        Glide.with(this).load("https://image.tmdb.org/t/p/w600_and_h900_bestv2"
                + result.getPoster_path())
                .into(imageMoviePoster).clearOnDetach();
        txtMovieTitle.setText(result.getTitle());
        txtMovieBudget.setText(String.valueOf(result.getBudget()));
        txtMovieRate.setText(String.valueOf(result.getVote_average()));
        txtMovieDesc.setText(result.getOverview());
    }

    private void initViews() {
        imageMoviePoster = findViewById(R.id.imageMoviePoster);
        txtMovieTitle = findViewById(R.id.txtMovieTitle);
        txtMovieBudget = findViewById(R.id.txtMovieBudget);
        txtMovieGenres = findViewById(R.id.txtMovieGenres);
        txtMovieRate = findViewById(R.id.txtMovieRate);
        txtMovieDesc = findViewById(R.id.txtMovieDesc);
    }


}
