package com.uysys.vollyepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.JarException;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView totalCase,totaldeath,totaltest,totalrecoverd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        totalCase = findViewById(R.id.totalcase);
        totaldeath = findViewById(R.id.totdeath);
        totaltest = findViewById(R.id.totaltest);
        totalrecoverd = findViewById(R.id.totalrecoverd);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });



    }

    private void getData() {
        String url = "https://corona.lmao.ninja/v2/all";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    totalCase.setText(jsonObject.getString("cases"));
                    totaldeath.setText(jsonObject.getString("deaths"));
                    totalrecoverd.setText(jsonObject.getString("recovered"));
                    totaltest.setText(jsonObject.getString("tests"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);





    }
}