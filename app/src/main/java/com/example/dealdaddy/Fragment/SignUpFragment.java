package com.example.dealdaddy.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dealdaddy.Activity.MainActivity;
import com.example.dealdaddy.Model.Users;
import com.example.dealdaddy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {


    private TextView alreadyHaveAnAccount;
    private FrameLayout parentFrameLayout;
    private Button SignUpButton;
    private EditText email;
    private EditText password;
    private EditText fullName;
    private EditText confirmPassword;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;
    private FirebaseDatabase mDatabase;
    private FirebaseUser mUser;
    private String currentUserName = null;


    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";



    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_sign_up, container, false);
        alreadyHaveAnAccount = view.findViewById(R.id.have_an_account_text);
        parentFrameLayout = getActivity().findViewById(R.id.RegisterFrameLayout);
        SignUpButton = view.findViewById(R.id.signup);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);
        fullName = view.findViewById(R.id.username);
        confirmPassword = view.findViewById(R.id.confirmPassword);


        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        mDatabase = FirebaseDatabase.getInstance();
        databaseReference = mDatabase.getReference();

        currentUserName = fullName.getText().toString();



      /*  SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                getActivity().startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
            }
        });*/
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        alreadyHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setFragment(new LoginFragment());
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                checkInputs();



            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        fullName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                checkInputs();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                checkInputs();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        confirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                checkInputs();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkEmailAndPassword();

            }
        });

    }

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_right);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();

    }

    private void checkInputs(){

        if(!TextUtils.isEmpty(fullName.getText())){
            if(!TextUtils.isEmpty(email.getText())){
                if(!TextUtils.isEmpty(password.getText()) && password.length()>=8){
                    if(!TextUtils.isEmpty(confirmPassword.getText())){
                        SignUpButton.setEnabled(true);
                    }else {
                        SignUpButton.setEnabled(false);
                    }
                }else {
                    SignUpButton.setEnabled(false);
                }
            }else{
                SignUpButton.setEnabled(false);
            }
        }else {
            SignUpButton.setEnabled(false);
        }

    }

    private void checkEmailAndPassword(){

        final String emailId = email.getText().toString().trim();
        final String passwordd = password.getText().toString().trim();
        final String confirm = confirmPassword.getText().toString().trim();
        final String username = fullName.getText().toString();

        if(email.getText().toString().matches(emailPattern)){
            if(password.getText().toString().equals(confirmPassword.getText().toString())){

                SignUpButton.setEnabled(false);

                mAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){

                                    String userId = mAuth.getCurrentUser().getUid();
                                    DatabaseReference currentUserDb = databaseReference.child("Users").push();
                                    String pushId = currentUserDb.getKey();

                                    Users users = new Users("userName","userEmailId","userProfilePic");

                                    Map<String,String> DatatoSave = new HashMap<>();

                                    DatatoSave.put("userName",username);
                                    DatatoSave.put("userEmailId",emailId);
                                    DatatoSave.put("userProfilePic",passwordd);
                                    currentUserDb.setValue(DatatoSave);

                                    Intent intent = new Intent(getActivity(),MainActivity.class);
                                    startActivity(intent);
                                    getActivity().finish();
                                    getActivity().overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                                }else {
                                    SignUpButton.setEnabled(true);
                                    String error =  task.getException().getMessage();
                                    Toast.makeText(getActivity(),error,Toast.LENGTH_LONG).show();
                                }
                            }
                        });

            }else{
                confirmPassword.setError("Password doesn't match!");
            }
        }else{
            email.setError("Invalid Email!");
        }

    }
}
