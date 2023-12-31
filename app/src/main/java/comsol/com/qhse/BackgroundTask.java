package comsol.com.qhse;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Zeeshan on 6/01/2017.
 */
public class BackgroundTask extends AsyncTask<String,Void,String> {
  AlertDialog alertDialog;
    Context ctx;
    BackgroundTask(Context ctx)
    {
      this.ctx =ctx;
    }
    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information....");
    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://www.comsol.net.pk/qhse/index.php";
        String login_url = "http://www.comsol.net.pk/qhse/login.php";
        String method = params[0];
        if (method.equals("index")) {
            String site_id = params[1];
            String site_type = params[2];
            String sub_con = params[3];
            String team_lead = params[4];
            String date = params[5];
            String email = params[6];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                //httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("site_id", "UTF-8") + "=" + URLEncoder.encode(site_id, "UTF-8") + "&" +
                        URLEncoder.encode("site_type", "UTF-8") + "=" + URLEncoder.encode(site_type, "UTF-8") + "&" +
                        URLEncoder.encode("sub_con", "UTF-8") + "=" + URLEncoder.encode(sub_con, "UTF-8") + "&" +
                        URLEncoder.encode("team_lead", "UTF-8") + "=" + URLEncoder.encode(team_lead, "UTF-8")+ "&" +
                        URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode(date, "UTF-8")+ "&" +
                       URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
               InputStream IS = httpURLConnection.getInputStream();
               IS.close();
                //httpURLConnection.connect();
                httpURLConnection.disconnect();
                return "Report Sent Successfully...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(method.equals("login"))
        {
            String login_name = params[1];
            String login_pass = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String data = URLEncoder.encode("login_name","UTF-8")+"="+ URLEncoder.encode(login_name,"UTF-8")+"&"+
                    URLEncoder.encode("login_pass","UTF-8")+"="+ URLEncoder.encode(login_pass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line  = "";
                while ((line = bufferedReader.readLine())!=null)
                {
                    response+= line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if(result == null)
        {
            // do what you want to do
        }
        else if(result.equals("Report Sent Successfully..."))
        {


            Intent i = new Intent(ctx,thanks.class);
            ctx.startActivity(i);
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else if(result.contains("Success")) // msg you get from success like "Login Success"
        {
            Intent i = new Intent(ctx,U_Images.class);
            ctx.startActivity(i);
           // alertDialog.setMessage(result);
           // alertDialog.show();
        }

    }
}
