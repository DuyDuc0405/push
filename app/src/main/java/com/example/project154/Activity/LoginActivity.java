package com.example.project154.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project154.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText loginName,  loginPass;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();
        loginName = findViewById(R.id.loginName);
        loginPass = findViewById(R.id.loginPass);

    }

    public void loginRegister(View view){
        Intent intent  = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void login(View v){
        Intent intent1 = getIntent();
        String name1 = intent1.getStringExtra("name");
        String name = loginName.getText().toString();
        String pass = loginPass.getText().toString();

        if(!name.isEmpty()){
            if(!pass.isEmpty()){
                auth.signInWithEmailAndPassword(name, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("name1", name1);
                        startActivity(intent);
                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }


    }
}