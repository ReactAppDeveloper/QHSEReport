package comsol.com.qhse;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

public class U_Images extends AppCompatActivity implements View.OnClickListener {



    protected Button btnCamera;
    private ImageView capturedImage;
    private Button btnCamera1;
    private ImageView capturedImage1;
    private Button btnCamera2;
    private ImageView capturedImage2;
    private Button btnCamera3;
    private ImageView capturedImage3;
    private Button btnCamera4;
    private ImageView capturedImage4;
    private Button btnCamera5;
    private ImageView capturedImage5;
    private Button btnCamera6;
    private ImageView capturedImage6;
    private Button btnCamera7;
    private ImageView capturedImage7;





    private Button buttonUpload;
    private EditText editText;



    private Bitmap bitmap;
    private Bitmap bitmap1;
    private Bitmap bitmap2;
    private Bitmap bitmap3;
    private Bitmap bitmap4;
    private Bitmap bitmap5;
    private Bitmap bitmap6;
    private Bitmap bitmap7;


    public static final String KEY_IMAGE = "image";
    public static final String KEY_IMAGE1 = "image1";
    public static final String KEY_IMAGE2 = "image2";
    public static final String KEY_IMAGE3 = "image3";
    public static final String KEY_IMAGE4 = "image4";
    public static final String KEY_IMAGE5 = "image5";
    public static final String KEY_IMAGE6 = "image6";
    public static final String KEY_IMAGE7 = "image7";

    public static final String KEY_TEXT = "name";

    public static final String UPLOAD_URL = "http://www.comsol.net.pk/qhse/qhse_images.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_images);
        this.setTitle("Insert Images");



        buttonUpload = (Button) findViewById(R.id.buttonUpload);
        editText = (EditText) findViewById(R.id.editText);
        editText.setTextColor(Color.parseColor("#FFFFFF"));

        btnCamera = (Button) findViewById(R.id.btnCamera);
        capturedImage = (ImageView) findViewById(R.id.capturedImage);
        btnCamera1 = (Button) findViewById(R.id.btnCamera1);
        capturedImage1 = (ImageView) findViewById(R.id.capturedImage1);
        btnCamera2 = (Button) findViewById(R.id.btnCamera2);
        capturedImage2 = (ImageView) findViewById(R.id.capturedImage2);
        btnCamera3 = (Button) findViewById(R.id.btnCamera3);
        capturedImage3 = (ImageView) findViewById(R.id.capturedImage3);
        btnCamera4 = (Button) findViewById(R.id.btnCamera4);
        capturedImage4 = (ImageView) findViewById(R.id.capturedImage4);
        btnCamera5 = (Button) findViewById(R.id.btnCamera5);
        capturedImage5 = (ImageView) findViewById(R.id.capturedImage5);
        btnCamera6 = (Button) findViewById(R.id.btnCamera6);
        capturedImage6 = (ImageView) findViewById(R.id.capturedImage6);
        btnCamera7 = (Button) findViewById(R.id.btnCamera7);
        capturedImage7 = (ImageView) findViewById(R.id.capturedImage7);




        btnCamera.setOnClickListener(this);
        btnCamera1.setOnClickListener(this);
        btnCamera2.setOnClickListener(this);
        btnCamera3.setOnClickListener(this);
        btnCamera4.setOnClickListener(this);
        btnCamera5.setOnClickListener(this);
        btnCamera6.setOnClickListener(this);
        btnCamera7.setOnClickListener(this);

        buttonUpload.setOnClickListener(this);
    }



    public void onClick(View x) {
        // TODO Auto-generated method stub
        if (x == buttonUpload) {
            uploadImages();

        }


        else  {
            switch (x.getId()) {

                case R.id.btnCamera:
                    Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(i, 1);
                    break;
                case R.id.btnCamera1:
                    Intent ii = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(ii, 2);
                    break;
                case R.id.btnCamera2:
                    Intent iii = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(iii, 3);
                    break;
                case R.id.btnCamera3:
                    Intent iv = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(iv, 4);
                    break;
                case R.id.btnCamera4:
                    Intent v = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(v, 5);
                    break;
                case R.id.btnCamera5:
                    Intent vi = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(vi, 6);
                    break;
                case R.id.btnCamera6:
                    Intent vii = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(vii, 7);
                    break;
                case R.id.btnCamera7:
                    Intent viii = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(viii, 8);

            }
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Bundle extras = data.getExtras();
                    bitmap = (Bitmap) extras.get("data");
                    capturedImage.setImageBitmap(bitmap);
                }
                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    Bundle extras = data.getExtras();
                    bitmap1 = (Bitmap) extras.get("data");
                    capturedImage1.setImageBitmap(bitmap1);
                }
                break;
            case 3:
                if (resultCode == RESULT_OK) {
                    Bundle extras = data.getExtras();
                    bitmap2 = (Bitmap) extras.get("data");
                    capturedImage2.setImageBitmap(bitmap2);
                }
                break;
            case 4:
                if (resultCode == RESULT_OK) {
                    Bundle extras = data.getExtras();
                    bitmap3 = (Bitmap) extras.get("data");
                    capturedImage3.setImageBitmap(bitmap3);
                }
                break;
            case 5:
                if (resultCode == RESULT_OK) {
                    Bundle extras = data.getExtras();
                    bitmap4 = (Bitmap) extras.get("data");
                    capturedImage4.setImageBitmap(bitmap4);
                }
                break;
            case 6:
                if (resultCode == RESULT_OK) {
                    Bundle extras = data.getExtras();
                    bitmap5 = (Bitmap) extras.get("data");
                    capturedImage5.setImageBitmap(bitmap5);
                }
                break;
            case 7:
                if (resultCode == RESULT_OK) {
                    Bundle extras = data.getExtras();
                    bitmap6 = (Bitmap) extras.get("data");
                    capturedImage6.setImageBitmap(bitmap6);
                }
                break;
            case 8:
                if (resultCode == RESULT_OK) {
                    Bundle extras = data.getExtras();
                    bitmap7 = (Bitmap) extras.get("data");
                    capturedImage7.setImageBitmap(bitmap7);
                }
                break;

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {

            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Logout function
    private void logout(){
        //Creating an alert dialog to confirm logout
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to logout?");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        //Getting out sharedpreferences
                        SharedPreferences preferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                        //Getting editor
                        SharedPreferences.Editor editor = preferences.edit();

                        //Puting the value false for loggedin
                        editor.putBoolean(Config.LOGGEDIN_SHARED_PREF, false);

                        //Putting blank value to email
                        editor.putString(Config.EMAIL_SHARED_PREF, "");

                        //Saving the sharedpreferences
                        editor.commit();

//                        Starting login activity
                        finish();
                    }
                });

        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        //Showing the alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }





//   ./////////////// for upload//////////////////

    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public String getStringImage1(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public String getStringImage2(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public String getStringImage3(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public String getStringImage4(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public String getStringImage5(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public String getStringImage6(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public String getStringImage7(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }


    private void uploadImages() {

        final String text = editText.getText().toString().trim();
        final String image = getStringImage(bitmap);
        final String image1 = getStringImage1(bitmap1);
        final String image2 = getStringImage2(bitmap2);
        final String image3 = getStringImage3(bitmap3);
        final String image4 = getStringImage4(bitmap4);
        final String image5 = getStringImage5(bitmap5);
        final String image6 = getStringImage6(bitmap6);
        final String image7 = getStringImage7(bitmap7);



            class UploadImages extends AsyncTask<Bitmap, Void, String> {

                ProgressDialog loading;
                //   RequestHandler rh = new RequestHandler();

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    loading = ProgressDialog.show(U_Images.this, "Uploading Image", "Please wait...", false, false);
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    loading.dismiss();
                    Toast.makeText(U_Images.this, s, Toast.LENGTH_LONG).show();
                    Intent i = new Intent(U_Images.this, Report.class);
                    startActivity(i);
                }

                @Override
                protected String doInBackground(Bitmap... params) {
                    RequestHandler rh = new RequestHandler();
                    HashMap<String, String> param = new HashMap<String, String>();
                    param.put(KEY_TEXT, text);
                    param.put(KEY_IMAGE, image);
                    param.put(KEY_IMAGE1, image1);
                    param.put(KEY_IMAGE2, image2);
                    param.put(KEY_IMAGE3, image3);
                    param.put(KEY_IMAGE4, image4);
                    param.put(KEY_IMAGE5, image5);
                    param.put(KEY_IMAGE6, image6);
                    param.put(KEY_IMAGE7, image7);
                    String result = rh.sendPostRequest(UPLOAD_URL, param);
                    return result;
                }
            }
            UploadImages u = new UploadImages();
            u.execute();
        }
    }

