package com.example.formulas;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PythagoreanFragment extends Fragment {

    private EditText editTextA, editTextB;
    private TextView textViewC;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // inflate the fragment_pythagorean layout
        View rootView = inflater.inflate(R.layout.fragment_pythagorean, container, false);

        // wire the widgets using that layout
        // call findViewByID by the rootView
        // since we need rootView, send it as a parameter if you want a separate method
        wireWidgets(rootView);

        // set any listeners for those widgets
        editTextA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Integer.parseInt() will convert a string to an int
                // Double.parseDouble() will convert a string to a double
                // call a calculate method that reads
                // the values of a and b, returns the values of c
                // editTextA.getText().toString() gets the text for a
                // have some kind of error checking to make sure
                // that id you have an empty string, you don't crash
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editTextA.getText().toString() != null && editTextB.getText().toString() != null) {
                    if (editTextA.getText().toString().length() > 0 && editTextB.getText().toString().length() > 0) {
                        textViewC.setText(String.valueOf(calculate(Double.parseDouble(editTextA.getText().toString()),
                                Double.parseDouble(editTextB.getText().toString()))));
                    }
            }
            }
        });

        editTextB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editTextA.getText().toString() != null && editTextB.getText().toString() != null) {
                    if (editTextA.getText().toString().length() > 0 && editTextB.getText().toString().length() > 0) {
                        textViewC.setText(String.valueOf(calculate(Double.parseDouble(editTextA.getText().toString()),
                                Double.parseDouble(editTextB.getText().toString()))));
                    }
                }
            }
        });

        // return the inflated view

        return rootView;
    }

    public void wireWidgets(View rootView) {
        // make sure to call findViewById on rootView
        editTextA = rootView.findViewById(R.id.editText_pythag_a);
        editTextB = rootView.findViewById(R.id.editText_pythag_b);
        textViewC = rootView.findViewById(R.id.textView_pythag_c);
    }

    public double calculate(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
}
