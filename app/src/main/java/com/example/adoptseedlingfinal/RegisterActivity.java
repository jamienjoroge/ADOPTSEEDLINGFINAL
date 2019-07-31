package com.example.adoptseedlingfinal;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.spark.submitbutton.SubmitButton;

public class RegisterActivity extends Activity {

  private EditText USER_NAME;
  private EditText PASSWORD;
  private EditText EMAIL;
  //private Button btn;
  private SubmitButton btn;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);

    btn =(SubmitButton) findViewById(R.id.btn_register);
    USER_NAME =(EditText)findViewById(R.id.edt_name);
    PASSWORD =(EditText)findViewById(R.id.edt_password);
    EMAIL = (EditText)findViewById(R.id.edt_email);

    btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        try{

        // Set the user's username and password, which can be obtained by a forms
        ParseUser user = new ParseUser();
        user.setUsername(USER_NAME.getText().toString());
        user.setPassword(PASSWORD.getText().toString());
        user.setEmail(EMAIL.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
          @Override
          public void done(ParseException e) {
            if (e == null) {
              ParseUser.logOut();
              alertDisplayer("Sucessful Sign Up!","Please verify your email before login! " ,false);
            } else {
              ParseUser.logOut();
              alertDisplayer("Error Account Creation failed", "Account couldn't be created" + ":" + e.getMessage(), true);
              //Toast.makeText(RegisterActivity.this, "Failed to Login" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
          }
        });


        }catch (Exception e){
          e.printStackTrace();
        }


    }
    });
}

  private void alertDisplayer(String title, String message, final boolean error) {
    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this)
      .setTitle(title)
      .setMessage(message)
      .setPositiveButton("OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
          dialogInterface.cancel();
          if(!error){
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
          }
        }
      });
    AlertDialog ok = builder.create();
    ok.show();
  }
  }
