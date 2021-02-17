package com.atta.myappdilog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.forget_password);

        btn.setOnClickListener(view -> showDialog());
    }

    private void showDialog(){
        Dialog phoneDialog = new Dialog(this);
        phoneDialog.setContentView(R.layout.change_password_dialog);

        TextInputEditText phoneTv = phoneDialog.findViewById(R.id.phone_tv);
        Button sendBtn = phoneDialog.findViewById(R.id.send_btn);
        ImageView closeImg = phoneDialog.findViewById(R.id.close_img);

        closeImg.setOnClickListener(view -> phoneDialog.dismiss());

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = phoneTv.getText().toString().trim();
                if(phone.length() != 11){
                    phoneTv.setError("Enter a valid phone number");
                    phoneTv.requestFocus();
                }else {
                    Toast.makeText(MainActivity.this, phone, Toast.LENGTH_SHORT).show();
                    phoneDialog.dismiss();
                }
            }
        });

        phoneDialog.setCancelable(false);
        phoneDialog.show();
    }
}