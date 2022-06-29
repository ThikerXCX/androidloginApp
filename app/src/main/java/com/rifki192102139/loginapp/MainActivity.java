package com.rifki192102139.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private Button _loginBtn;
    private EditText _idEditText,_passwordEditText;
    private Intent _menuIntent;
    private String _id,_password,_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _loginBtn = (Button) findViewById(R.id.loginBtn);
        _loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncHttpClient asyncHttpClient;

                _idEditText = (EditText) findViewById(R.id.idEditText);
                _passwordEditText = (EditText) findViewById(R.id.passwordEditText);

                _id = _idEditText.getText().toString();
                _password = _passwordEditText.getText().toString();

                _url = "https://tonywijaya.000webhostapp.com/011100862/login.php?id=" + _id + "&password="+_password;

                asyncHttpClient = new AsyncHttpClient();
                asyncHttpClient.get(_url, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        String hasil = new String(responseBody);

                        if (!hasil.equals("[{\"idCount\":\"1\"}]")){
                            Toast.makeText(getApplicationContext(),"ID dan Passweod tidak cocok",Toast.LENGTH_LONG).show();
                            return;
                        }
                        Toast.makeText(getApplicationContext(),"Selamat Datang "+_id,Toast.LENGTH_LONG).show();
                        _menuIntent = new Intent(getApplicationContext(),MenuActivity.class);
                        startActivity(_menuIntent);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}