package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email= findViewById(R.id.inputEmail);
        pass=findViewById(R.id.inputPassword);

    }
    public void headToRegistration(View view){
        Intent intent=new Intent(MainActivity.this,UserRegisteration.class);
        startActivity(intent);
        finish();
    }
    public void Login(View view){
        if(email.getText().toString().equalsIgnoreCase("170030342@kluniversity.in")&& pass.getText().toString().equalsIgnoreCase("1234"));
        { Intent intent=new Intent(MainActivity.this,WaveView.class);
            startActivity(intent);
        }



    }
}