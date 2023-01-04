package com.example.postofficeapp.fragments.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.postofficeapp.activities.calculator.CalculatorMISActivity;
import com.example.postofficeapp.activities.calculator.CalculatorNSCActivity;
import com.example.postofficeapp.activities.calculator.CalculatorPPFActivity;
import com.example.postofficeapp.activities.calculator.CalculatorRDActivity;
import com.example.postofficeapp.activities.calculator.CalculatorSCSSActivity;
import com.example.postofficeapp.activities.calculator.CalculatorSSYActivity;
import com.example.postofficeapp.activities.calculator.CalculatorTDActivity;
import com.example.postofficeapp.databinding.FragmentCalculatorBinding;

public class CalculatorFragment extends Fragment {

    private FragmentCalculatorBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCalculatorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnTd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CalculatorTDActivity.class));
            }
        });

        binding.btnRd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CalculatorRDActivity.class));
            }
        });

        binding.btnNsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CalculatorNSCActivity.class));
            }
        });

        binding.btnPpf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CalculatorPPFActivity.class));
            }
        });

        binding.btnPpf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CalculatorSCSSActivity.class));
            }
        });

        binding.btnMis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CalculatorMISActivity.class));
            }
        });

        binding.btnSsy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CalculatorSSYActivity.class));
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}