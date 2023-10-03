package com.example.emiassignment1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.emiassignment1.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {


    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //This block of code will listen for the "Calculate EMI" button to be pressed.
        binding.button.setOnClickListener(new View.OnClickListener() {
            //When it is pressed it will do and display the equations for Calculating the EMI
            @Override
            public void onClick(View view) {
                int amount = Integer.valueOf(binding.mortgageAmount.getText().toString());
                double interest = (Double.valueOf(binding.interestRate.getText().toString()) / 12) / 100;
                int length = Integer.valueOf(binding.mortgageLength.getText().toString());

                double total = Math.pow(1 + interest, length) / (Math.pow(1 + interest,length)-1);
                double payment = amount * interest * total;
                double rounded = Math.round(payment*100.0)/100.0;

                binding.textView2.setText("$"+rounded);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}