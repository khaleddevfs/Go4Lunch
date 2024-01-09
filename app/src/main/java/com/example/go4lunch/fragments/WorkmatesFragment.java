package com.example.go4lunch.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.go4lunch.databinding.FragmentWorkmatesBinding;
import com.example.go4lunch.viewModel.WorkMatesViewModel;


public class WorkmatesFragment extends Fragment {

    private FragmentWorkmatesBinding binding;

    private WorkMatesViewModel viewModel;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWorkmatesBinding.inflate(inflater, container ,false);
        View view = binding.getRoot();
        configureFragmentOnCreateView();
        return view;
    }


    protected void configureFragmentOnCreateView() {
        viewModel = obtainViewModel();
        initRecyclerView();
        setupWorkMateList();

    }

    private WorkMatesViewModel obtainViewModel() {
        return null;
    }

    private void initRecyclerView() {
    }

    private void setupWorkMateList() {
    }
}