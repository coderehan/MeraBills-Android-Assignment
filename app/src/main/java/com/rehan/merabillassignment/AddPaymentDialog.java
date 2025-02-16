package com.rehan.merabillassignment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class AddPaymentDialog extends Dialog {
    private EditText amountInput, providerInput, transactionRefInput;
    private Spinner paymentTypeSpinner;
    private MaterialButton cancelButton, okButton;
    private List<Payment> existingPayments;
    private OnPaymentAddedListener listener;

    public AddPaymentDialog(@NonNull Context context, List<Payment> existingPayments, OnPaymentAddedListener listener) {
        super(context);
        this.existingPayments = existingPayments;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_add_payment);

        amountInput = findViewById(R.id.etAmount);
        paymentTypeSpinner = findViewById(R.id.spinnerPaymentType);
        providerInput = findViewById(R.id.etProvider);
        transactionRefInput = findViewById(R.id.etTransactionRef);
        cancelButton = findViewById(R.id.btnCancel);
        okButton = findViewById(R.id.btnOK);

        setupSpinner();
        setupListeners();
    }

    private void setupSpinner() {
        List<String> availablePayments = new ArrayList<>();
        if (!isPaymentAdded("Cash")) availablePayments.add("Cash");
        if (!isPaymentAdded("Bank Transfer")) availablePayments.add("Bank Transfer");
        if (!isPaymentAdded("Credit Card")) availablePayments.add("Credit Card");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, availablePayments);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paymentTypeSpinner.setAdapter(adapter);
    }

    private boolean isPaymentAdded(String type) {
        for (Payment payment : existingPayments) {
            if (payment.getType().equals(type)) return true;
        }
        return false;
    }

    private void setupListeners() {
        paymentTypeSpinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) parent.getItemAtPosition(position);
                if (selected.equals("Cash")) {
                    providerInput.setVisibility(View.GONE);
                    transactionRefInput.setVisibility(View.GONE);
                } else {
                    providerInput.setVisibility(View.VISIBLE);
                    transactionRefInput.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {
            }
        });

        cancelButton.setOnClickListener(v -> dismiss());

        okButton.setOnClickListener(v -> {
            String paymentAmount = amountInput.getText().toString().trim();

            if (paymentAmount.isEmpty()) {
                Toast.makeText(getContext(), "Please enter an amount", Toast.LENGTH_SHORT).show();
                return;
            }

            if (paymentTypeSpinner.getSelectedItem() == null) {
                Toast.makeText(getContext(), "No payment type available", Toast.LENGTH_SHORT).show();
                return;
            }

            String type = paymentTypeSpinner.getSelectedItem().toString();
            double amount = Double.parseDouble(amountInput.getText().toString());
            String provider = providerInput.getVisibility() == View.VISIBLE ? providerInput.getText().toString() : "";
            String transactionRef = transactionRefInput.getVisibility() == View.VISIBLE ? transactionRefInput.getText().toString() : "";

            Payment newPayment = new Payment(type, amount, provider, transactionRef);
            listener.onPaymentAdded(newPayment);
            dismiss();
        });
    }

    public interface OnPaymentAddedListener {
        void onPaymentAdded(Payment payment);
    }
}
