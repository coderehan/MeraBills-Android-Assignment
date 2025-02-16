package com.rehan.merabillassignment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView totalAmountValue, addPayment;
    private ChipGroup chipGroup;
    private MaterialButton saveButton;
    private List<Payment> paymentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalAmountValue = findViewById(R.id.tvTotalAmountValue);
        chipGroup = findViewById(R.id.chipGroupPayments);
        addPayment = findViewById(R.id.tvAddPayment);
        saveButton = findViewById(R.id.btnSave);
        paymentList = FileHelper.loadPayments(this);
        updateUI();

        addPayment.setOnClickListener(v -> openAddPaymentDialog());

        saveButton.setOnClickListener(v -> {
            if (!paymentList.isEmpty()) {
                FileHelper.savePayments(this, paymentList);
                Toast.makeText(this, "Payments saved successfully!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No payments to save!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void updateUI() {
        chipGroup.removeAllViews();
        double totalAmount = 0;
        for (Payment payment : paymentList) {
            totalAmount += payment.getAmount();
            addChip(payment);
        }
        totalAmountValue.setText(String.valueOf(totalAmount));
    }

    private void addChip(Payment payment) {
        Chip chip = new Chip(this);
        chip.setText(payment.getType() + " - Rs. " + payment.getAmount());
        chip.setTextSize(18);
        chip.setCloseIconVisible(true);
        chip.setOnCloseIconClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Delete Payment")
                    .setMessage("Are you sure you want to delete this payment?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        paymentList.remove(payment);
                        FileHelper.savePayments(this, paymentList);
                        updateUI();
                        Toast.makeText(this, "Payment deleted", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                    .show();
        });
        chipGroup.addView(chip);
    }

    private void openAddPaymentDialog() {
        AddPaymentDialog dialog = new AddPaymentDialog(this, paymentList, newPayment -> {
            paymentList.add(newPayment);
            FileHelper.savePayments(this, paymentList);
            updateUI();
        });
        dialog.show();
    }

    public void onSaveClicked(View view) {
        FileHelper.savePayments(this, paymentList);
    }
}
