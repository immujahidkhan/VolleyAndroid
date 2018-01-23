package com.apptrends.volleyandroid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddProductsActivity extends AppCompatActivity {
    EditText name, email, gender, city, country;
    Button addBtn;
    ProgressDialog progressDialog;
    String nametxt, emailtxt, gendertxt, citytxt, countrytxt, insert,update;
    String getIdtxt, getNametxt, getEmailtxt, getGendertxt, getCitytxt, getCountrytxt;

    String AddUrl = "https://volleyandroid.000webhostapp.com/abdulrehmanvolley/insert.php";
    String UpdateUrl = "https://volleyandroid.000webhostapp.com/abdulrehmanvolley/update.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_products);
        name = findViewById(R.id.nameAdd);
        email = findViewById(R.id.emailAdd);
        gender = findViewById(R.id.genderAdd);
        city = findViewById(R.id.cityAdd);
        country = findViewById(R.id.countryAdd);
        progressDialog = new ProgressDialog(this);
        addBtn = findViewById(R.id.addBtn);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            getIdtxt = bundle.getString("id");
            getNametxt = bundle.getString("name");
            getEmailtxt = bundle.getString("email");
            getGendertxt = bundle.getString("gender");
            getCitytxt = bundle.getString("city");
            getCountrytxt = bundle.getString("country");
            int n, e, g, c, k;
            n = getNametxt.length();
            e = getEmailtxt.length();
            g = getGendertxt.length();
            c = getCitytxt.length();
            k = getCountrytxt.length();

            update = "update";
            name.setText(getNametxt);
            email.setText(getEmailtxt);
            gender.setText(getGendertxt);
            city.setText(getCitytxt);
            country.setText(getCountrytxt);
            name.setSelection(n);
            email.setSelection(e);
            gender.setSelection(g);
            city.setSelection(c);
            country.setSelection(k);
            addBtn.setText("Update");
        }
        if (bundle == null) {

            addBtn.setText("Add New Data");
        }


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nametxt = name.getText().toString().trim();
                emailtxt = email.getText().toString().trim();
                gendertxt = gender.getText().toString().trim();
                citytxt = city.getText().toString().trim();
                countrytxt = country.getText().toString().trim();

                if (TextUtils.isEmpty(nametxt) || TextUtils.isEmpty(emailtxt) || TextUtils.isEmpty(gendertxt) || TextUtils.isEmpty(citytxt) || TextUtils.isEmpty(countrytxt)) {
                    Toast.makeText(AddProductsActivity.this, "Required.", Toast.LENGTH_SHORT).show();
                } else {

                    String test = "Update";
                    if (test.equals(addBtn.getText())) {
                        UpdateData();
                    } else {
                        AddData();
                    }
                }
            }
        });
    }

    private void AddData() {
        // Showing progress dialog at user registration time.
        progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
        progressDialog.show();

        insert = "insert";
        nametxt = name.getText().toString().trim();
        emailtxt = email.getText().toString().trim();
        gendertxt = gender.getText().toString().trim();
        citytxt = city.getText().toString().trim();
        countrytxt = country.getText().toString().trim();

        // Creating string request with post method.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AddUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();
                        // Showing response message coming from server.
                        Toast.makeText(AddProductsActivity.this, ServerResponse, Toast.LENGTH_LONG).show();
                        startActivity(new Intent(AddProductsActivity.this, MainActivity.class));
                        finish();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();
                        // Showing error message if something goes wrong.
                        Toast.makeText(AddProductsActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                // Adding All values to Params.
                params.put("insert", insert);
                params.put("name", nametxt);
                params.put("email", emailtxt);
                params.put("gender", gendertxt);
                params.put("city", citytxt);
                params.put("country", countrytxt);

                return params;
            }

        };

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);
    }
    private void UpdateData() {
        // Showing progress dialog at user registration time.
        progressDialog.setMessage("Please Wait, We are Updating Your Data on Server");
        progressDialog.show();

        insert = "insert";
        nametxt = name.getText().toString().trim();
        emailtxt = email.getText().toString().trim();
        gendertxt = gender.getText().toString().trim();
        citytxt = city.getText().toString().trim();
        countrytxt = country.getText().toString().trim();

        // Creating string request with post method.
        StringRequest UpdateDatastringRequest = new StringRequest(Request.Method.POST, UpdateUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();
                        // Showing response message coming from server.
                        Toast.makeText(AddProductsActivity.this, ServerResponse, Toast.LENGTH_LONG).show();
                        startActivity(new Intent(AddProductsActivity.this, MainActivity.class));
                        finish();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();
                        // Showing error message if something goes wrong.
                        Toast.makeText(AddProductsActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                // Adding All values to Params.
                params.put("id",getIdtxt);
                params.put("update", update);
                params.put("name", nametxt);
                params.put("email", emailtxt);
                params.put("gender", gendertxt);
                params.put("city", citytxt);
                params.put("country", countrytxt);
                return params;
            }

        };

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        // Adding the StringRequest object into requestQueue.
        requestQueue.add(UpdateDatastringRequest);
    }
}