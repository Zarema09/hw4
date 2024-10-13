package com.example.secondapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText email = findViewById(R.id.et_email);
        EditText password = findViewById(R.id.et_password);
        TextView entry = findViewById(R.id.tv_entry);
        TextView welcome = findViewById(R.id.tv_welcome);
        TextView description = findViewById(R.id.tv_description);
        TextView forgotPassword = findViewById(R.id.tv_forgotPassword);
        Button button = findViewById(R.id.btn_sign);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (email.getText().length() > 0 && password.getText().length() > 0) {
                    button.setBackgroundResource(R.drawable.bg_orange);
                } else {
                    button.setBackgroundResource(R.drawable.bg_gray);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };
        email.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);

        button.setOnClickListener(v -> {
            String emailText = email.getText().toString();
            String passwordText = password.getText().toString();
            if ("admin".equals(emailText) && "admin".equals(passwordText)) {
                Toast.makeText(this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();

                welcome.setText("ДОбро пожаловать, " + emailText);
                welcome.setVisibility(View.VISIBLE);
                entry.setVisibility(View.GONE);
                description.setVisibility(View.GONE);
                forgotPassword.setVisibility(View.GONE);
                email.setVisibility(View.GONE);
                password.setVisibility(View.GONE);
                button.setVisibility(View.GONE);

            } else  {
                Toast.makeText(this, "Вы неправильно ввели данные!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}