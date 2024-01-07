package com.example.go4lunch.viewModel;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.firebase.ui.auth.AuthUI;

import java.util.Collections;

public class LoginViewModel extends ViewModel {
    public static final int RC_SIGN_IN = 100;



    public void startLoginActivityEmail(Activity activity) {
        Log.d("LoginActivity", "Starting Email Login Activity");

        activity.startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(Collections.singletonList(new
                                AuthUI.IdpConfig.EmailBuilder().build()))
                        .setIsSmartLockEnabled(false, true)
                        .build(),
                RC_SIGN_IN);
    }


    public void startLoginActivityGoogle(Activity activity) {
        Log.d("LoginActivity", "Starting Google Login Activity");

        activity.startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(Collections.singletonList(new
                                AuthUI.IdpConfig.GoogleBuilder().build()))
                        .setIsSmartLockEnabled(false,true)
                        .build(),
                RC_SIGN_IN);
    }

    public void startLoginActivityTwitter(Activity activity) {
        Log.d("LoginActivity", "Starting Twitter Login Activity");

        activity.startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(Collections.singletonList(new
                                AuthUI.IdpConfig.TwitterBuilder().build()))
                        .setIsSmartLockEnabled(false, true)
                        .build(),
                RC_SIGN_IN);
    }

    public void updateCurrentUser(){}




}
