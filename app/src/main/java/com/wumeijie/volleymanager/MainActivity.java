package com.wumeijie.volleymanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.wumeijie.volleymanager.http.VolleyManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_string_request).setOnClickListener(this);
        findViewById(R.id.btn_jsonobject_request).setOnClickListener(this);
    }

    private void excuteStringRequest() {
        //使用StringRequest
        VolleyManager.sendStringRequest(Request.Method.GET,
                "http://api.wumeijie.net/list?page=1&pageSize=10", null,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //TODO 处理响应数据
                        Log.d("response = ", response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //TODO 处理请求失败情况
                        Log.d("error = ", error.toString());
                    }
                });
    }

    private void excuteJsonObjectRequest() {
        //使用JsonObjectRequest
        JSONObject params = new JSONObject();
        try {
            params.put("params1", "xixi");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        VolleyManager.sendJsonObjectRequest(Request.Method.POST,
                "http://api.wumeijie.net/addsomething", params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //TODO 处理响应数据
                        Log.d("response = ", response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //TODO 处理请求失败情况
                        Log.d("error = ", error.toString());
                    }
                });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_string_request:
                excuteStringRequest();
                break;
            case R.id.btn_jsonobject_request:
                excuteJsonObjectRequest();
                break;
        }
    }
}
