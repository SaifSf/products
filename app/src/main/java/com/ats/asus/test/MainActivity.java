package com.ats.asus.test;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ats.asus.test.utilities.NetworkUtils;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    public RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Products> products_List;
    final static String Products_BASE_URL = "http://internal.ats-digital.com:3066/api/products";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        products_List = new ArrayList<>();
        loadUrlData();


    }

    private void loadUrlData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Products_BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jsonObject1 = array.getJSONObject(i);
                        Products product = new Products(jsonObject1.getString("productName"), jsonObject1.getString("basePrice"),
                                jsonObject1.getString("category"));

                        Log.i("selecc", String.valueOf(product));
                        products_List.add(product);
                        adapter = new ProductAdapter(products_List, getApplicationContext());
                        recyclerView.setAdapter(adapter);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();
                Log.e("ettor", String.valueOf(error));

            }


        });
        RequestQueue requestQueue =Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
/*
    private void CategorySearchQuery() {
        String weatherQuery = mSearch.getText().toString();
        URL weatherSearchUrl = NetworkUtils.buildUrl(weatherQuery);
        mtext.setText(weatherSearchUrl.toString());
        new ProductQueryTask().execute(weatherSearchUrl);
    }

    public class ProductQueryTask extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... params) {
            URL searchUrl = params[0];
            String weatherSearchResults = null;
            try {
                weatherSearchResults = NetworkUtils.getResponseFromHttpUrl(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.i("usrl", String.valueOf(weatherSearchResults));
            return weatherSearchResults;
        }

        @Override
        protected void onPostExecute(String weatherSearchResults) {
            if (weatherSearchResults != null && !weatherSearchResults.equals("")) {
                mtext.setText(weatherSearchResults);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_search) {
            CategorySearchQuery();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    */

