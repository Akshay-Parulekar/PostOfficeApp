package com.example.postofficeapp.activities.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.postofficeapp.databinding.ActivityCalculatorSsyBinding;
import com.example.postofficeapp.databinding.ActivityCalculatorRdBinding;
import com.example.postofficeapp.helper.Helper;

public class CalculatorSSYActivity extends AppCompatActivity {

    ActivityCalculatorSsyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCalculatorSsyBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);

        getSupportActionBar().hide();

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                calculate();
            }
        };

        binding.tPrincipal.addTextChangedListener(textWatcher);
        binding.tRate.addTextChangedListener(textWatcher);
        binding.tYears.addTextChangedListener(textWatcher);

    }

    public void formatRs(EditText txt)
    {
        txt.setText(Helper.rsFormat(Double.valueOf(txt.getText().toString().replace(",","").trim())).replace(".00",""));
    }

    public void formatRs(TextView txt)
    {
        txt.setText(Helper.rsFormat(Double.valueOf(txt.getText().toString().replace(",","").trim())).replace(".00",""));
    }

    public void calculate()
    {
        double principal = 0, rate = 0, years = 0, cmpYears = 0;

        if(!binding.tPrincipal.getText().toString().isEmpty())
        {
            principal = Double.valueOf(binding.tPrincipal.getText().toString().replace(",","").trim());
        }
        if(!binding.tRate.getText().toString().isEmpty())
        {
            rate = Double.valueOf(binding.tRate.getText().toString().replace(",","").trim()) / 100;
        }
        if(!binding.tYears.getText().toString().isEmpty())
        {
            years = Integer.valueOf(binding.tYears.getText().toString().replace(",","").trim());
        }
        if(!binding.tCmpYears.getText().toString().isEmpty())
        {
            cmpYears = Integer.valueOf(binding.tCmpYears.getText().toString().replace(",","").trim());
        }

        double maturity = principal * Math.pow((1 + rate/years), years * cmpYears);
        binding.tMaturity.setText(String.valueOf(Math.round(maturity)));

        formatRs(binding.tMaturity);

    }
}