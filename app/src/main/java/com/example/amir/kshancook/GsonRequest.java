package com.example.amir.kshancook;

import android.net.http.HttpResponseCache;
import android.support.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class GsonRequest<T> extends Request<T> {

    private Response.Listener<T> responseListener;
    private Gson gson=new Gson();
    private Type clazz;
  //private Class<T> clazz;

    public GsonRequest(int method, String url,Type clazz, Response.Listener<T> responseListener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.responseListener=responseListener;
        this.clazz=clazz;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {

        try {
            String json = new String(response.data);

            return (Response<T>) Response.success(gson.fromJson(json,clazz), HttpHeaderParser.parseCacheHeaders(response));

        }catch (Exception e){
           return Response.error(new VolleyError(e));

        }



    }

    @Override
    protected void deliverResponse(T response) {

        responseListener.onResponse(response);

    }














    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {

        /*
        Map<String,String> map=new HashMap<>();
        map.put("Authorization","Bearer Your Token");
        return map;
        */
        return super.getHeaders();
    }

    @Override
    public byte[] getBody() throws AuthFailureError {

        /*
        JSONObject requestBody=new JSONObject();
        try {
            requestBody.put("email","test@gmail.com");
            requestBody.put("pass","1234");
        } catch (JSONException e) {

        }

        return requestBody.toString().getBytes();
        */
        return super.getBody();
    }

}
