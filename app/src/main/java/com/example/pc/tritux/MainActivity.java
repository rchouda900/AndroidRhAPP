package com.example.pc.tritux;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

import com.example.pc.tritux.tasks.LoginTask;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    Button btnsignin;
    EditText txtemail, txtpass;
    CheckBox cbcheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsignin = (Button) findViewById(R.id.btnsignin);
        txtemail = (EditText) findViewById(R.id.txtemail);
        txtpass = (EditText) findViewById(R.id.txtpass);
        cbcheckbox=(CheckBox) findViewById(R.id.cbcheckbox);

        cbcheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // checkbox status is changed from uncheck to checked.
                if (!isChecked) {
                    // show password
                    txtpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    txtpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });






        btnsignin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        new LoginTask(this,txtemail.getText().toString(),txtpass.getText().toString()).execute();


    }
}

