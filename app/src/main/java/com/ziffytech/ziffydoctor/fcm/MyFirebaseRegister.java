package com.ziffytech.ziffydoctor.fcm;

import android.app.Activity;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.ziffytech.ziffydoctor.commanclass.CommonClass;
import com.ziffytech.ziffydoctor.commanclass.VJsonRequest;
import com.ziffytech.ziffydoctor.config.ApiParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;




public class MyFirebaseRegister {
    Activity _context;
    CommonClass common;
    public MyFirebaseRegister(Activity context) {
        this._context = context;
        common = new CommonClass(_context);

    }

    public void RegisterUser(String user_id){

        String token = FirebaseInstanceId.getInstance().getToken();
        //FirebaseMessaging.getInstance().subscribeToTopic("doctappo");
        //    Log.e("FCM:",token);
        String str = android.os.Build.MODEL;
        HashMap<String,String> params = new HashMap<>();
        params.put("delivery_boy_id",user_id);
        params.put("fcm_token",token);
        params.put("mobile_model",str);

        VJsonRequest vJsonRequest = new VJsonRequest(_context, ApiParams.FCM_INSERT_URL,params,
                new VJsonRequest.VJsonResponce(){
                    @Override
                    public void VResponce(String responce)
                    {
                        Log.e("RESPONSE LOGIN", responce);

                        JSONObject userdata = null;
                        try {
                            userdata = new JSONObject(responce);
                            if (userdata.getInt("status") == 1) {

                                //Toast.makeText(_context, "Token uploaded", Toast.LENGTH_SHORT).show();

                            } else
                            {
                                //Toast.makeText(_context, "Token Not uploaded", Toast.LENGTH_SHORT).show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    @Override
                    public void VError(String responce) {
//                     Log.e("ERROR",responce);
                    }
                });
    }


}
