package com.example.go4lunch.fragments;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.go4lunch.R;
import com.example.go4lunch.databinding.FragmentMapsBinding;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

import pub.devrel.easypermissions.EasyPermissions;

public class MapsFragment extends BaseFragment implements OnMapReadyCallback, EasyPermissions.PermissionCallbacks {

    private FragmentMapsBinding binding;


    private GoogleMap googleMap;

    private MapView mapView;

    private Location userLocation;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMapsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        configureFragmentOnCreateView(view);
        configureMapView(savedInstanceState);
        return view;
    }

    private void configureMapView(Bundle savedInstanceState) {
        mapView = binding.mapView;
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.googleMap = googleMap;
        googleMap.setIndoorEnabled(false);
        updateLocationUI();
        googleMap.setOnCameraMoveListener(this::onMarkerClick);
    }

    private void updateLocationUI() {
    }

    private void onMarkerClick() {

    }

    @Override
    protected void configureFragmentOnCreateView(View view) {
        
    }
}