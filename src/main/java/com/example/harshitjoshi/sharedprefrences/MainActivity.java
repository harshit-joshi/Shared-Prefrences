package com.example.harshitjoshi.sharedprefrences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editPassword;
    EditText editUserName;
    TextView displayText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUserName=findViewById(R.id.editUserName);
        editPassword=findViewById(R.id.editPassword);
        displayText=findViewById(R.id.DisplayText);
    }
    //Saves the user's Login Info
public void saveInfo(View view)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("userInfo", Context.MODE_PRIVATE);//This File is Private Only This Application can use It
        SharedPreferences.Editor editor=sharedPreferences.edit();//For modifying the value
        editor.putString("username",editUserName.getText().toString());
        editor.putString("password",editPassword.getText().toString());
        editor.apply();//For Submiting data
        Toast.makeText(this,"Save",Toast.LENGTH_SHORT).show();
    }

    public void displayInfo(View view)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String user=sharedPreferences.getString("username","");//for storing value
        String pass=sharedPreferences.getString("password","");
        displayText.setText(user+ " "+ pass);

    }
}
