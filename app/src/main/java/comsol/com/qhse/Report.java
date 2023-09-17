package comsol.com.qhse;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Calendar;

public class Report extends Activity {


    Spinner ET_SITE_TYPE;
    EditText ET_ID,ET_SUB_CON,ET_TEAM_LEAD,txtDate,ET_EMAIL;
    Button btnDatePicker;
    String site_id,site_type,sub_con,team_lead,date,email;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

//FOR ADD
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        ET_ID = (EditText)findViewById(R.id.id);
        ET_ID.setTextColor(Color.parseColor("#FFFFFF"));
        ET_SITE_TYPE = (Spinner) findViewById(R.id.site_type);
//        ET_SITE_TYPE.setTextColor(Color.parseColor("#FFFFFF"));
        ET_SUB_CON = (EditText)findViewById(R.id.sub_con);
        ET_SUB_CON.setTextColor(Color.parseColor("#FFFFFF"));
        ET_TEAM_LEAD = (EditText)findViewById(R.id.team_lead);
        ET_TEAM_LEAD.setTextColor(Color.parseColor("#FFFFFF"));
        ET_EMAIL = (EditText)findViewById(R.id.email);
        ET_EMAIL.setTextColor(Color.parseColor("#FFFFFF"));

        btnDatePicker=(Button)findViewById(R.id.btn_date);

        txtDate=(EditText)findViewById(R.id.edtDate);


        ET_SITE_TYPE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {


                TextView tmpView = (TextView) ET_SITE_TYPE.getSelectedView().findViewById(android.R.id.text1);
                tmpView.setTextColor(Color.WHITE);
                // TODO Auto-generated method stub

                //   Toast.makeText(getBaseContext(), ET_SITE_TYPE.getSelectedItem().toString(),
                //      Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
    }


    public void userReg(View view)
    {

        site_id = ET_ID.getText().toString();
        site_type = ET_SITE_TYPE.getSelectedItem().toString();
        sub_con =ET_SUB_CON.getText().toString();
        team_lead =ET_TEAM_LEAD.getText().toString();
        date = txtDate.getText().toString();
        email=ET_EMAIL.getText().toString();

        /**
         * Validation
         */
        boolean invalid = false;
        if (site_id.equals("")) {
            invalid = true;
            ET_ID.requestFocus();
            ET_ID.setError("SITE ID CANNOT BE EMPTY");
        }


        else if (sub_con.equals("")) {
            invalid = true;
            ET_SUB_CON.requestFocus();
            ET_SUB_CON.setError("SUB CON CANNOT BE EMPTY");
        }
        else if (team_lead.equals("")) {
            invalid = true;
            ET_TEAM_LEAD.requestFocus();
            ET_TEAM_LEAD.setError("TEAM LEAD CANNOT BE EMPTY");

        }

        else if (date.equals("")) {
            invalid = true;
            txtDate.requestFocus();
            txtDate.setError("DATE CANNOT BE EMPTY");
        }
        else if (email.equals("")) {
            invalid = true;
            ET_EMAIL.requestFocus();
            ET_EMAIL.setError("EMAIL CANNOT BE EMPTY");
        }
        else if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
            ET_EMAIL.requestFocus();
            ET_EMAIL.setError("Invalid Email Address");
        }
        else if (invalid == false) {

            String method = "index";
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute(method, site_id, site_type, sub_con, team_lead, date,email);
            Toast.makeText(getApplicationContext(),
                    "Sending please wait...", Toast.LENGTH_SHORT).show();

        }

    }
    public void onClick(View v) {
        if (v == btnDatePicker) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            txtDate.setText(year + "-" +(monthOfYear + 1) + "-" + dayOfMonth);
                            txtDate.setTextColor(Color.parseColor("#FFFFFF"));
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }

}