package com.ziffytech.ziffydoctor.activities.Login.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.ziffytech.ziffydoctor.activities.Dashboard.activities.DashboardActivity;
import com.ziffytech.ziffydoctor.activities.Login.model.DoctorLoginModel;
import com.ziffytech.ziffydoctor.R;
import com.ziffytech.ziffydoctor.commanclass.AppClass;
import com.ziffytech.ziffydoctor.commanclass.CommonActivity;
import com.ziffytech.ziffydoctor.commanclass.CustomRequestForString;
import com.ziffytech.ziffydoctor.commanclass.MyUtility;
import com.ziffytech.ziffydoctor.commanclass.Preferences;
import com.ziffytech.ziffydoctor.commanclass.Utility;
import com.ziffytech.ziffydoctor.commanclass.Validations;
import com.ziffytech.ziffydoctor.config.URLListner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;

public class LoginActivity extends CommonActivity implements View.OnClickListener {


    private Button forgot,signin;
    private Toolbar toolbar;

    private RelativeLayout parent;
    private EditText eemail,epassword;
    private String email,password;
    private static final String TAG = LoginActivity.class.getSimpleName();
    ArrayList<DoctorLoginModel>arrayList;
    private Boolean saveLogin;
    CheckBox saveLoginCheckBox;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    SharedPreferences sharedPreferences;
    private String id,email1,phone,image ;
    private String clinic_id;
    private String  merge_doctor_id;
    private String  mergeclinic_id ;
    private String Merge_id,username;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        setUpViews();
    }


    private void setUpViews()
    {
        arrayList=new ArrayList<>();
        forgot=(Button)findViewById(R.id.forgot);
        forgot.setOnClickListener(this);
        parent=(RelativeLayout) findViewById(R.id.parent);
        eemail=(EditText)findViewById(R.id.email);
        epassword=(EditText)findViewById(R.id.password);
        signin=(Button)findViewById(R.id.login);
        //  saveLoginCheckBox = (CheckBox) findViewById(R.id.check_remember_me);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginValidation();

            }
        });

        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        sharedPreferences = getSharedPreferences(Preferences.MyPREFERENCES, Context.MODE_PRIVATE);



    }



    private void loginValidation()
    {

        MyUtility.hideKeyboard(epassword,LoginActivity.this);

        email = eemail.getText().toString().trim();
        password = epassword.getText().toString().trim();


        if (email.equalsIgnoreCase(""))
        {

            //eemail.setError("Please Enter Your EmailID ");

            View view = LoginActivity.this.findViewById(android.R.id.content);

            MyUtility.showSnack(view, Validations.ENTER_EMAIL);

        } else if (!email.matches(MyUtility.emailPattern) )
        {

            Toast.makeText(this, "Please Enter Valid EmailID ", Toast.LENGTH_SHORT).show();
            //MyUtility.showSnack(parent, Validations.ENTER_VALID_EMAIL);

        } else if (password.equalsIgnoreCase("") ) {

            View view = LoginActivity.this.findViewById(android.R.id.content);

            MyUtility.showSnack(view, Validations.ENTER_PASSWORD);

        }  else {


            if(MyUtility.isConnected(this))
            {


               /* if (saveLoginCheckBox.isChecked()) {
                    loginPrefsEditor.putBoolean("saveLogin", true);
                    loginPrefsEditor.putString("username", email);
                    loginPrefsEditor.putString("password", password);
                    loginPrefsEditor.commit();
                } else {
                    loginPrefsEditor.clear();
                    loginPrefsEditor.commit();
                }*/
                CallApi();

            }else
            {

                Toast.makeText(this, "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();

                //MyUtility.showSnack(parent,MyUtility.INTERNET_ERROR);
            }

        }

    }

    private void CallApi() {


        HashMap<String, String> params = new HashMap<String, String>();

        params.put("user_email", email);
        params.put("user_password", password);
        Log.e("PARAMS", params.toString());

        CustomRequestForString customRequestForString = new CustomRequestForString(Request.Method.POST, URLListner.BASEURL+URLListner.login, params, this.createRequestSuccessListenerLogin(), this.createRequestErrorListenerLogin());
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(customRequestForString);
        Utility.startProgressDialog(LoginActivity.this);
    }





    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.forgot:

                //startActivity(new Intent(LoginActivity.this,ForgotActivity.class));

                break;


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:

                onBackPressed();

                break;
        }

        return super.onOptionsItemSelected(item);
    }


    private Response.Listener<String> createRequestSuccessListenerLogin() {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Utility.stopProgressDialog();


                Log.e("RESPONSE",response.toString());


                try {
                    JSONObject jsonObject=new JSONObject(response);

                    if (jsonObject.getInt("responce")==1){

                        JSONArray arr = jsonObject.getJSONArray("data");
                        for(int i=0;i<arr.length();i++)
                        {

                            JSONObject json = arr.getJSONObject(i);

                            id = json.getString("doct_id");
                            username = json.getString("doct_name");
                            email1 = json.getString("user_email");
                            phone = json.getString("doct_phone");
                            image = json.getString("doct_photo");
                            clinic_id = json.getString("bus_id");

                        }

                        AppClass.setsession(id,email1,username,phone,image,clinic_id);

                        if (AppClass.getuserId().length()>0)
                        {
                            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);

                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            finish();
                        }


                        else
                        {
                            Utility.showSnackbar(parent,"Failed to store this session");
                        }


                    }else {

                        MyUtility.showAlertMessage(LoginActivity.this,"Invalid email or password");
                    }

                } catch (JSONException e) {
                    Utility.stopProgressDialog();
                    e.printStackTrace();
                }


            }
        };
    }



    private Response.ErrorListener createRequestErrorListenerLogin() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Utility.stopProgressDialog();

                if (error instanceof TimeoutError) {
                    MyUtility.showAlertMessage(LoginActivity.this, "Server is busy.Please try again");
                }
                Log.i("##", "##" + error.toString());

            }
        };
    }


}

