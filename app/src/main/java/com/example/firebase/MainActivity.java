package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText uname,email,password,cpassword;
    Button reg;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference().child("users");


        uname=findViewById(R.id.name);
        email=findViewById(R.id.emailid);
        password=findViewById(R.id.pas);
        cpassword=findViewById(R.id.cpass);
        reg=findViewById(R.id.register);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username=uname.getText().toString();
                String emailid=email.getText().toString().trim();
                String pass=password.getText().toString().trim();
                final String cpass=cpassword.getText().toString();
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(getApplicationContext(), "Enter User name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(emailid)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(getApplicationContext(), "Enter Password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cpass)) {
                    Toast.makeText(getApplicationContext(), "Enter Confirm password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!pass.equals(cpass)) {
                    Toast.makeText(getApplicationContext(), "Password and confirm password should be same!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!TextUtils.isEmpty(emailid)) {
                    String id = databaseReference.push().getKey();
                    User user = new User(id,username,emailid,pass,cpass);
                    databaseReference.child(id).setValue(user);
//                    user.setUname(username);
//                    user.setUemail(emailid);
//                    user.setUpass(pass);
//                    user.setuConfirmpass(cpass);
//                    databaseReference.push().setValue(user);
                    Toast.makeText(MainActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
