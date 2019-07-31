package com.example.adoptseedlingfinal;

import android.app.Activity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Base64DataException;
import android.view.textclassifier.TextClassification;
import com.google.android.gms.common.api.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class LipaNaMpesa extends Activity {

  // Use base64 to encode the consumer key and secret.
  String app_key = "yTCsdlT47XGNZq5VagZM4cOobrqIOYjM";
  String app_secret = "G4OoJJTj3PTZNNhQ";
  String appKeySecret = app_key + ":" + app_secret;
  byte[] b= appKeySecret.getBytes("ISO-8859-1");
  String auth = String.valueOf(Base64.encode(b,2));


  public LipaNaMpesa() throws UnsupportedEncodingException {
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
      .url("https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials")
      .get()
      .addHeader("authorization", "Basic " + auth)
      .addHeader("cache-control", "no-cache")
      .build();

    try {
      client.newCall(request).execute();
    } catch (IOException e) {
      e.printStackTrace();
    }

/**
    MediaType mediaType = MediaType.parse("application/json");

    RequestBody body = RequestBody.create(mediaType,
      "{" +
        "BusinessShortCode":  174379,
      "Password\": \" ",
      "Timestamp\": \" ",
      "TransactionType\": \"CustomerPayBillOnline",
      "Amount\": \" 1",
      "PartyA\": \"254714739030 ",
      "PartyB\": 174379 ",
      "PhoneNumber\": \"254714739030 ",
      "CallBackURL\": \"http://71cf85a0.ngrok.io/hooks/mpesa",
      "AccountReference\": \" test",
      "TransactionDesc\": \"test \"}");

    Request req = new Request.Builder()
      .url("https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest")
      .post(body)
      .addHeader("authorization", "Bearer ACCESS_TOKEN")
      .addHeader("content-type", "application/json")
      .build();

    try {
      client.newCall(req).execute();
    } catch (IOException e) {
      e.printStackTrace();
    }
*/
  }


}
