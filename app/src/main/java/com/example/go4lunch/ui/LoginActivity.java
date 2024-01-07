package com.example.go4lunch.ui;

import static com.example.go4lunch.viewModel.LoginViewModel.RC_SIGN_IN;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.go4lunch.viewModel.LoginViewModel;
import com.example.go4lunch.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

        viewModel = new LoginViewModel(); // Initialisez votre viewModel ici

        initListener();
    }



    private void initView() {
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    private void initListener() {
        binding.emailLoginButton.setOnClickListener(v -> {
            Log.d("LoginActivity", "Email Login Button Clicked");
            viewModel.startLoginActivityEmail(LoginActivity.this);
        });

        binding.gmailLoginButton.setOnClickListener(v -> {
            Log.d("LoginActivity", "Google Login Button Clicked");
            viewModel.startLoginActivityGoogle(LoginActivity.this);
        });

        binding.twitterLoginButton.setOnClickListener(v -> {
            Log.d("LoginActivity", "Twitter Login Button Clicked");
            viewModel.startLoginActivityTwitter(LoginActivity.this);
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                viewModel.updateCurrentUser();
                Intent loginIntent = new Intent(this, MainActivity.class);
                startActivity(loginIntent);
            } else {
                Toast.makeText(this, "sign in error ", Toast.LENGTH_SHORT).show();

            }
        }
    }





}