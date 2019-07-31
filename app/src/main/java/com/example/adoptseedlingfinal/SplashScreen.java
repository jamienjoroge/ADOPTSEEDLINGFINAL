package com.example.adoptseedlingfinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class SplashScreen extends Activity {

  //splash screen timer
  private static int SPLASH_TIME_OUT = 3000; //this is in milliseconds

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splashscreen);

    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        //after splah screen move to login activity
        Intent i = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(i);

        finish();
      }
    },SPLASH_TIME_OUT);
  }


}
