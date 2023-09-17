package comsol.com.qhse;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by ubiad on 05/06/2017.
 */
public class Signup extends Activity implements View.OnClickListener {

    private Button buttonCreate;
    private EditText name,email,mobile,password,retype;
    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        name = (EditText) findViewById(R.id.user_name);
        name.setTextColor(Color.parseColor("#FFFFFF"));
        email = (EditText) findViewById(R.id.user_id);
        email.setTextColor(Color.parseColor("#FFFFFF"));
        mobile = (EditText) findViewById(R.id.user_mbl);
        mobile.setTextColor(Color.parseColor("#FFFFFF"));
        password = (EditText) findViewById(R.id.user_pass);
        password.setTextColor(Color.parseColor("#FFFFFF"));
        retype = (EditText) findViewById(R.id.re_type);
        retype.setTextColor(Color.parseColor("#FFFFFF"));
        imageView= (ImageView) findViewById(R.id.imageView3);


        buttonCreate = (Button) findViewById(R.id.btn_signup);
        buttonCreate.setOnClickListener(this);

    }

    private void CreateUser() {
        final String user_name = name.getText().toString().trim();
        final String user_id = email.getText().toString().trim();
        final String user_mobile = mobile.getText().toString().trim();
        final String user_pass = password.getText().toString().trim();



        class UpdateEmployee extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Signup.this, "User Creating...", "Please Wait...", false, false);

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if(s.equals("Successfully Register")){
                    Toast.makeText(Signup.this, "Signup Successfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Signup.this,MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Signup.this, s, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(Config.SU_USER_NAME, user_name);
                hashMap.put(Config.SU_USER_EMAIL, user_id);
                hashMap.put(Config.SU_USER_MOBILE, user_mobile);
                hashMap.put(Config.SU_USER_PASS, user_pass);
                RequestHandler rh = new RequestHandler();
                String s = rh.sendPostRequest(Config.URL_CREATE_USER, hashMap);
                return s;

            }
        }

        UpdateEmployee ue = new UpdateEmployee();
        ue.execute();
    }

    @Override
    public void onClick(View v) {

        final String user_id = email.getText().toString().trim();
        /**
         //         * Validation
         //
         //         */
        boolean invalid = false;
        if (name.getText().length()==0) {
            name.setError("Please Enter Your Name");
        }
       else if (email.getText().length()==0) {
            email.setError("Please Enter Your Emai Address");
        }
        else if (!user_id.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
            email.requestFocus();
            email.setError("Invalid Email Address");
        }
       else if (password.getText().length()==0) {
            password.setError("Please Enter A Password");
        }
       else if (retype.getText().length()==0) {
            retype.setError("Retype Password");
        }
        else if (mobile.getText().length() < 11) {
            invalid = true;
            mobile.requestFocus();
            mobile.setError("Please Enter Valid Mobile No");
        }
        else if (mobile.getText().length() > 11) {
            invalid = true;
            mobile.requestFocus();
            mobile.setError("Please Enter Valid Mobile No");
        }

        else if (v == buttonCreate) {
            if (password.getText().toString().equals(retype.getText().toString())) {
                CreateUser();

            }
            else{
                //Toast is the pop up message
                Toast.makeText(getApplicationContext(), "Password does not match!",
                        Toast.LENGTH_LONG).show();
            }

        }

    }
}