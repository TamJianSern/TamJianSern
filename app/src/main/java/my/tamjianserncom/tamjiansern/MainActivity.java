package my.tamjianserncom.tamjiansern;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String PREF_NAME = "my.tamjianserncom.tamjiansern" ;
    private Button makeButton, renewButton;
    private TextView priceView, ageView, statusView, passportFeeView, totalPassportFeeView;
    private RadioGroup ageGroup, statusGroup;
    private RadioButton childrenButton, standardButton, seniorButton, hajPButton, studentButton, abroadButton, disableButton, noneButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ageGroup = findViewById(R.id.ageGroup);
        childrenButton = findViewById(R.id.childrenButton);
        standardButton  = findViewById(R.id.standardButton);
        seniorButton = findViewById(R.id.seniorButton);
        statusGroup = findViewById(R.id.statusGroup);
        hajPButton = findViewById(R.id.hajPButton);
        studentButton = findViewById(R.id.studentButton);
        abroadButton = findViewById(R.id.abroadButton);
        disableButton = findViewById(R.id.disabledButton);
        noneButton = findViewById(R.id.noneButton);
        passportFeeView = findViewById(R.id.passportFeeView);
        totalPassportFeeView = findViewById(R.id.passportFeeView);

        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(makeButton.isPressed()) {
            Toast.makeText(this, "Passport ", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePassportFee(View view){

        double totalFee = 0.0;
        double fee = 0.0;
        int age;
        int status;
        int error = 0;
        age = ageGroup.getCheckedRadioButtonId();
        if(age == R.id.childrenButton || age == R.id.seniorButton){
            fee = 100.0;
        }
        else if(age == R.id.standardButton){
            fee = 200.0;
        }
        status = statusGroup.getCheckedRadioButtonId();

        if(status == R.id.hajPButton || status == R.id.studentButton || status == R.id.abroadButton) {
            fee = 100.0;

        }
        else if(status == R.id.disabledButton){
            fee = 0.0;

        }
        else if(status == R.id.noneButton){
            fee += 0.0;

        }
        if(age == R.id.seniorButton && status == R.id.studentButton){
            error = 1;
        }


            if (error == 1) {
                passportFeeView.setText("Invalid Option");
                error = 0;
            } else {
                passportFeeView.setText("Passport Fees " + " " + "RM " + " " + fee);
        }
    }

}
