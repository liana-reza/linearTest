package com.sample.android.lineartestapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.sample.android.lineartestapplication.pojo.AladhanModel;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class ShowAdhanTiming extends AppCompatActivity implements View.OnClickListener {
    TextView txtFajrValue,txtSunriseValue,txtDhuhrValue,txtAsrValue,txtSunsetValue,txtMaghribValue,txtIshaValue,txtImsakValue,txtMidnightValue;
    EditText edtIranCityName;
    Button btnSendCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_adhan_timing);

        txtFajrValue = findViewById(R.id.txtFajrValue);
        txtSunriseValue = findViewById(R.id.txtSunriseValue);
        txtDhuhrValue = findViewById(R.id.txtDhuhrValue);
        txtAsrValue = findViewById(R.id.txtAsrValue);
        txtSunsetValue = findViewById(R.id.txtSunsetValue);
        txtMaghribValue = findViewById(R.id.txtMaghribValue);
        txtIshaValue = findViewById(R.id.txtIshaValue);
        txtImsakValue = findViewById(R.id.txtImsakValue);
        txtMidnightValue = findViewById(R.id.txtMidnightValue);
        edtIranCityName = findViewById(R.id.edtIranCityName);
        btnSendCity = findViewById(R.id.btnSendCity);
        btnSendCity.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSendCity:
                AsyncHttpClient client = new AsyncHttpClient();
                String address = "https://api.aladhan.com/v1/timingsByCity?city=" + edtIranCityName.getText().toString() + "&country=Iran&method=8";


                client.get(address, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        Log.i("Response", response.toString());
                        Gson gson = new Gson();
                        AladhanModel pray = gson.fromJson(response.toString(), AladhanModel.class);
                        txtFajrValue.setText(pray.getData().getTimings().getFajr());
                        txtSunriseValue.setText(pray.getData().getTimings().getSunrise());
                        txtDhuhrValue.setText(pray.getData().getTimings().getDhuhr());
                        txtAsrValue.setText(pray.getData().getTimings().getAsr());
                        txtSunsetValue.setText(pray.getData().getTimings().getSunset());
                        txtMaghribValue.setText(pray.getData().getTimings().getMaghrib());
                        txtIshaValue.setText(pray.getData().getTimings().getIsha());
                        txtImsakValue.setText(pray.getData().getTimings().getImsak());
                        txtMidnightValue.setText(pray.getData().getTimings().getMidnight());
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                    }

                });
                break;
        }
    }
}
