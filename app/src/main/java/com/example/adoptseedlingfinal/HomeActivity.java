package com.example.adoptseedlingfinal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.spark.submitbutton.SubmitButton;

public class HomeActivity extends Activity {

  private RadioGroup radioGroupButton;
  private RadioButton radioLocationButton;
  private Button btnDisplay;
  private EditText numberOfSeedlings;
  private Button adoptBtn;
  private Button cancelBtn;
  public Button btnDisplay2, btnDisplay3, btnDisplay4= radioLocationButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    addListenerOnButton();

  }

  public void addListenerOnButton() {

    radioGroupButton = (RadioGroup) findViewById(R.id.radioLocation);
    btnDisplay = (Button) findViewById(R.id.btnDisplay);
    numberOfSeedlings = (EditText) findViewById(R.id.nu_seedlings);
    adoptBtn = (Button) findViewById(R.id.adopt);
    cancelBtn = (Button) findViewById(R.id.cancel_adopt);




    btnDisplay2 = (Button)findViewById(R.id.location1);
    btnDisplay3 = (Button)findViewById(R.id.location2);
    btnDisplay4 = (Button)findViewById(R.id.location3);





    //when you click adopt button it takes you to maps activity
    adoptBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(HomeActivity.this,MapsActivity.class));
      }
    });

    //when you click on the cancel button it returns you to login
    cancelBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(HomeActivity.this,MainActivity.class));
      }
    });

    //when you click the display button, it will give you a dialog box for displaying the information you have chossen
    btnDisplay.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View v) {


            // get selected radio button from radioGroup
            int selectedId = radioGroupButton.getCheckedRadioButtonId();

            // find the radiobutton by returned id
            radioLocationButton = (RadioButton)findViewById(selectedId);
            /*
            if(btnDisplay2 != null){
              .add(LatLng voi = new LatLng(3.3973,38.5559);)
            }
            else(btnDisplay3 !=null){
              .add()
            }
            else(btnDisplay4){
              .add()
        }*/



                alertDisplayer("LOCATION FOR PLANTING: ", "You have choseen " + radioLocationButton.getText().toString() + "!" + "For " + numberOfSeedlings.getText().toString() + " Seedlings.");

            /*
            Toast.makeText(HomeActivity.this, "You have chossen: "
              + radioLocationButton.getText().

              toString() + " For " + numberOfSeedlings.getText().

              toString() + " Seedlings.", Toast.LENGTH_SHORT).

              show();
              */





      }
      private void alertDisplayer(String sucessful_login, String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this)
          .setTitle(sucessful_login)
          .setMessage(s)
          .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              dialog.cancel();
              // don't forget to change the line below with the names of your Activities
              Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
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
