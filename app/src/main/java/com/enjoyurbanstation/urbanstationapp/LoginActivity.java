package com.enjoyurbanstation.urbanstationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.enjoyurbanstation.urbanstationapp.controller.AppPrepagas;

public class LoginActivity extends AppCompatActivity {
    private AppPrepagas app = null;

    private TextView txtEmail, txtPassword, txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        app = AppPrepagas.getInstancia();
    }

    public void btnLoginOnClick(View vista) {

    }
}
