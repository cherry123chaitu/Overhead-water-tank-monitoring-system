package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRegisteration extends AppCompatActivity {

    public static final String DB_URL="jdbc:mysql://192.168.0.11/Users";
    public static final String USER="Nobi";
    public static final String PASS="Brocklesnar123@";
    EditText FirstName;
    EditText LastName;
    EditText Email;
    EditText Password;
    String firstname;
    String lastname;
    String email;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registeration);
        FirstName=findViewById(R.id.editTextTextPersonName3);
        LastName=findViewById(R.id.LastNameEditText);
        Email=findViewById(R.id.inputEmail);
        Password=findViewById(R.id.editTextTextPassword);
        firstname= FirstName.getText().toString();

        email= Email.getText().toString();
        pass= Password.getText().toString();

    }
    public void Register(View view){
    new Send().execute("");
    }
        class Send extends AsyncTask<String,String ,String>{
        @Override
        protected String doInBackground(String... params) {
            try {
                Connection connection= DriverManager.getConnection("jdbc:mysql://192.168.0.11/Users","Nobi","Brocklesnar123@");
                try{
                    String query="INSERT INTO Users FirstName Values ('"+firstname+"')";
                    Statement statement=connection.createStatement();
                    statement.executeQuery(query);
                    String query2="INSERT INTO Users LastName Values ('"+lastname+"')";
                    statement.executeQuery(query2);
                    String query3="INSERT INTO Users Email Values ('"+email+"')";
                    statement.executeQuery(query3);
                    String query4="INSERT INTO Users Password Values ('"+pass+"')";
                    statement.executeQuery(query4);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
return null;
        }


    }
    }

