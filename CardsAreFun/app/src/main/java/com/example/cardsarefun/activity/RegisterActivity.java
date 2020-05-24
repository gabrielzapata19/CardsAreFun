package com.example.cardsarefun.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cardsarefun.util.FirebaseDatabaseManager;
import com.example.cardsarefun.pojos.User;
import com.example.cardsarefun.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText emailId, passwordId;
    Button registerBtn;
    FirebaseAuth myFirebaseAuth;
    TextView loginHere;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.emailEditText);
        passwordId = findViewById(R.id.passwordEditText);
        registerBtn = findViewById(R.id.registerBtn);
        loginHere = findViewById(R.id.loginHereTextView);


        //When user clicks register
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailId.getText().toString();
                String password = passwordId.getText().toString();

                //check if email and password fields are empty
                if(email.isEmpty()){
                    emailId.setError("Please provide an email, k bye.");
                    emailId.requestFocus();
                }
                else if (password.isEmpty()) {
                    passwordId.setError("Yo ... enter a password, Ya fool");
                    passwordId.requestFocus();
                }
                else if(email.isEmpty() && password.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Both Email and Password fields are empty", Toast.LENGTH_SHORT).show();
                }
                //now set fields in firebaseAuth object
                else if (!(email.isEmpty() && password.isEmpty())){
                    myFirebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                FirebaseDatabaseManager.getInstance()
                                        .addUser(myFirebaseAuth.getCurrentUser().getUid(), User.getCurrentUser());
                                startActivity(new Intent(RegisterActivity.this,HomeActivity.class));
                            }else{
                                Toast.makeText(RegisterActivity.this, "User Creation was unsuccessfull", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Oh no! Registeration failed! But its ok.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }


}
