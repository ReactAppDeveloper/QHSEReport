package comsol.com.qhse;

/**
 * Created by Xhanii on 2/7/2017.
 */

public class Config {
    //Address of our scripts of the CRUD

    public static final String LOGIN_URL ="http://www.comsol.net.pk/qhse/user_login.php";
    public static final String URL_CREATE_USER = "http://www.comsol.net.pk/qhse/signup.php";



    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_MAIL = "user_id";
    public static final String KEY_PASSWORD = "user_pass";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "myloginapp";

    //This would be used to store the email of current logged in user
    public static final String EMAIL_SHARED_PREF = "emp_id";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";




// for signup


    public static final String SU_USER_NAME = "user_name";
    public static final String SU_USER_EMAIL  = "user_id";
    public static final String SU_USER_MOBILE  = "user_mbl_no";
    public static final String SU_USER_PASS = "user_pass";


    //Keys that will be used to send the request to php scripts
    public static final String KEY_USER_ID = "cus_id";
    public static final String KEY_USER_NAME = "cus_name";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_CELL = "cell_no";
    public static final String KEY_IP = "ip_address";
    public static final String KEY_PKG = "net_package";
    public static final String KEY_AMOUNT  = "total_amount";
    public static final String KEY_RC_AMOUNT  = "recieved_amount";
    public static final String KEY_RM_AMOUNT  = "balance";
    public static final String KEY_LM_AMOUNT  = "lineman";



public static final String TAG_USER_ID = "user_id";
    public static final String TAG_USER_NAME = "user_fname";
    public static final String TAG_ADDRESS = "user_address";
    public static final String TAG_EMAIL = "user_email";
    public static final String TAG_CELL = "user_number";
    public static final String TAG_IP = "ip_address";
    public static final String TAG_PKG = "user_package";
    public static final String TAG_AMOUNT = "user_price";



    public static final String JSON_ARRAY = "result";
    //employee id to pass with intent
    public static final String EMP_ID = "emp_id";
}
