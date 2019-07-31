package com.example.adoptseedlingfinal;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.os.Bundle;
import com.parse.Parse;
import com.parse.ParseInstallation;

public class App extends Application {


  @Override
  public void onCreate() {
    super.onCreate();

    // Save the current Installation to Back4App
    //ParseInstallation.getCurrentInstallation().saveInBackground();

    //initialize parse
    Parse.initialize(new Parse.Configuration.Builder(this)
      .applicationId(getString(R.string.back4app_app_id))
      // if defined
      .clientKey(getString(R.string.back4app_client_key))
      .server(getString(R.string.back4app_server_url))
      .build()
    );

  }


}
