package com.example.go4lunch.fragments;




import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public abstract class BaseFragment extends Fragment implements EasyPermissions.PermissionCallbacks {

    private final String TAG = BaseFragment.class.getSimpleName();



    protected abstract void configureFragmentOnCreateView(View view);

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fetchUserLocation();


    }

    private void fetchUserLocation() {
    }


    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        Log.d(TAG, "onRequestPermissionsResult");

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        Log.d(TAG, "onPermissionsGranted: " + perms.size());
        fetchUserLocation();
    }



    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Log.d(TAG, "onPermissionsDenied: " + perms.size());
    }
}