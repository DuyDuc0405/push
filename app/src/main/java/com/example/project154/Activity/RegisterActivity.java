package com.example.project154.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project154.Domain.UserModel;
import com.example.project154.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText registerName, registerEmail, registerPass, registerReEnter;
    FirebaseAuth auth;
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerName = findViewById(R.id.registerName);
        registerEmail = findViewById(R.id.registerEmail);
        registerPass = findViewById(R.id.registerPass);
        registerReEnter = findViewById(R.id.registerRePass);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
    }

    public void register(View view) {
        String userName = registerName.getText().toString();
        String userEmail = registerEmail.getText().toString();
        String userPassword = registerPass.getText().toString();
        String userRepass = registerReEnter.getText().toString();

        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(this, "Vui lòng điền tên đăng nhập", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(userEmail)) {
            Toast.makeText(this, "Vui lòng điền email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(userPassword)) {
            Toast.makeText(this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
            return;
        }
        if (userPassword.length() < 8) {
            Toast.makeText(this, "Mật khẩu phải chứa ít nhất 8 ký tự", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!userPassword.equals(userRepass)) {
            Toast.makeText(this, "Mật khẩu và Mật khẩu nhập lại không trùng khớp", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    UserModel userModel = new UserModel(userName, userEmail, userPassword);
                    String id = task.getResult().getUser().getUid();
                    database.getReference().child("User").child(id).setValue(userModel);
                    Toast.makeText(RegisterActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.putExtra("name", userName);
                    startActivity(intent);
                }else{
                    Toast.makeText(RegisterActivity.this, "Đăng kí không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
