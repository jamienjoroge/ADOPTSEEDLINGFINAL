package com.example.adoptseedlingfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.parse.LogInCallback;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.widget.Toast;
import com.parse.ParseException;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.spark.submitbutton.SubmitButton;

public class MainActivity extends AppCompatActivity {

  private Button btn;
  private Button btn2;
  private TextView txt;
  private EditText USER_NAME;
  private EditText PASSWORD;
  private EditText EMAIL;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    btn = (Button) findViewById(R.id.btn_login);
    txt = (TextView)findViewById(R.id.txt_create_account);
    btn2 = (Button)findViewById(R.id.btn_logout);
    USER_NAME =(EditText)findViewById(R.id.edt_name);
    PASSWORD =(EditText)findViewById(R.id.edt_password);
    EMAIL = (EditText)findViewById(R.id.edt_email);


    btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        //startActivity(new Intent(MainActivity.this,HomeActivity.class));
        ParseUser.logInInBackground(USER_NAME.getText().toString(), PASSWORD.getText().toString(),
        new LogInCallback() {
          @Override
          public void done(ParseUser parseUser, ParseException e) {
            if (parseUser != null) {
              if (parseUser.getBoolean("emailVerified")) {
                alertDisplayer("Sucessful Login", "Welcome back " + USER_NAME.getText().toString() + "!", false);
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
              } else {
                ParseUser.logOut();
                alertDisplayer("Login Fail", "Please Verify your email first", true);
                //Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
              }
            }else {
              ParseUser.logOut();
              alertDisplayer("Login Fail", e.getMessage()+ " Please re-try",true);
              }
          }
        });

      }

      private void alertDisplayer(String sucessful, String sl,boolean b) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
          .setTitle(sucessful)
          .setMessage(sl)
          .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              dialog.cancel();
              // don't forget to change the line below with the names of your Activities
              Intent intent = new Intent(MainActivity.this, MainActivity.class);



              intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
              startActivity(intent);
            }
          });
        AlertDialog ok = builder.create();
        ok.show();
      }

    });


    //takes you to register page
    txt.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(MainActivity.this,RegisterActivity.class));
      }
    });

    //This is for the logout
    btn2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        // logging out of Parse
        ParseUser.logOut();
        alertDisplayer("So, you're going...", "Ok...Bye-bye then");

      }
      private void alertDisplayer(String sucessful_login, String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
          .setTitle(sucessful_login)
          .setMessage(s)
          .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              dialog.cancel();
              // don't forget to change the line below with the names of your Activities
              Intent intent = new Intent(MainActivity.this, MainActivity.class);
              intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
              startActivity(intent);
            }
          });
        AlertDialog ok = builder.create();
        ok.show();
      }

    });

  }

}
