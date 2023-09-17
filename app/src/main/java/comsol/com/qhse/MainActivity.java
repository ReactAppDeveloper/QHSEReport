package comsol.com.qhse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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


public class MainActivity extends Activity implements View.OnClickListener{
    EditText ET_NAME,ET_PASS;
    ImageView image;
    private Button btnCheck;
    private boolean loggedIn = false;
    TextView signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ET_NAME = (EditText)findViewById(R.id.user_name);
        ET_NAME.setTextColor(Color.parseColor("#FFFFFF"));
        ET_PASS = (EditText)findViewById(R.id.user_pass);
        ET_PASS.setTextColor(Color.parseColor("#FFFFFF"));

        btnCheck = (Button) findViewById(R.id.buttonLogin);
        btnCheck.setOnClickListener(this);

       signup = (TextView) findViewById(R.id.signup);
        signup.setOnClickListener(this);

//for chk network
        ConnectivityManager cManager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cManager.getActiveNetworkInfo();
        if (nInfo != null && nInfo.isConnected())
        {
            //  Toast.makeText(this, "Network is available", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Network is not available", Toast.LENGTH_LONG).show();
        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        //In onresume fetching value from sharedpreference
        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

        //Fetching the boolean value form sharedpreferences
        loggedIn = sharedPreferences.getBoolean(Config.LOGGEDIN_SHARED_PREF, false);

        //If we will get true
        if(loggedIn){
            //We will start the Profile Activity
            Intent intent = new Intent(MainActivity.this, U_Images.class);
            startActivity(intent);
        }
    }
    private void login(){
        //Getting values from edit texts
        final String user_name = ET_NAME.getText().toString().trim();
        final String user_pass = ET_PASS.getText().toString().trim();

        /**
         //         * Validation
         //
         //         */
        boolean invalid = false;
        if (user_name.equals("")) {
            invalid = true;
            ET_NAME.requestFocus();
            ET_NAME.setError("USER EMAIL CANNOT BE EMPTY");

        }
        else if (!user_name.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
            ET_NAME.requestFocus();
            ET_NAME.setError("Invalid Email Address");
        }
        else if (user_pass.equals("")) {
            invalid = true;
            ET_PASS.requestFocus();
            ET_PASS.setError("USER EMAIL ADDRESS CANNOT BE EMPTY");

        }




        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //If we are getting success from server
                        if(response.trim().equalsIgnoreCase(Config.LOGIN_SUCCESS)){
                            //Creating a shared preference
                            SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                            //Creating editor to store values to shared preferences
                            SharedPreferences.Editor editor = sharedPreferences.edit();

                            //Adding values to editor
                            editor.putBoolean(Config.LOGGEDIN_SHARED_PREF, true);
                            editor.putString(Config.EMAIL_SHARED_PREF, user_name);

                            //Saving values to editor
                            editor.commit();

                            //Starting profile activity
                            Intent intent = new Intent(MainActivity.this, U_Images.class);
                            startActivity(intent);
                        }else{
                            //If the server response is not success
                            //Displaying an error message on toast
                            Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_LONG).show();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                //Adding parameters to request
                params.put(Config.KEY_MAIL, user_name);
                params.put(Config.KEY_PASSWORD, user_pass);

                //returning parameter
                return params;
            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        final String user_name = ET_NAME.getText().toString().trim();
        final String user_pass = ET_PASS.getText().toString().trim();
         if (v == btnCheck) {


             /**
              //         * Validation
              //
              //         */
             boolean invalid = false;
             if (user_name.equals("")) {
                 invalid = true;
                 ET_NAME.requestFocus();
                 ET_NAME.setError("USER EMAIL CANNOT BE EMPTY");

             }
             else if (!user_name.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
            ET_NAME.requestFocus();
            ET_NAME.setError("Invalid Email Address");
        }
             else if (user_pass.equals("")) {
                 invalid = true;
                 ET_PASS.requestFocus();
                 ET_PASS.setError("USER EMAIL ADDRESS CANNOT BE EMPTY");

             }
        //Calling the login function
             else {
                 login();
                 Toast.makeText(getApplicationContext(), "Redirecting please wait...", Toast.LENGTH_SHORT).show();
             }
    }
    if (v==signup){

        Intent i=new Intent(this,Signup.class);
        startActivity(i);
    }

    }

}