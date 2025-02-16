MeraBills Android Assignment

Problem Statement:
Managing different types of payments efficiently can be challenging, especially when tracking cash, bank transfers, and credit card payments. Users often need a simple interface to record, view, and delete payments while ensuring data persistence. This app provides a seamless solution for managing payments with a user-friendly UI and persistent storage.

Features:
1. Add Payments: Users can add payments of various types (Cash, Bank Transfer, Credit Card) with optional provider details and transaction references.
2. View Payments: Payments are displayed as dynamic chips in a ChipGroup, making them easy to track.
3. Delete Payments: Users can remove payments with a confirmation dialog to prevent accidental deletions.
4. Save Payments: Payments are stored locally in a file "LastPayments.txt" using JSON serialization to ensure data persistence.
5. Load Payments: Previously saved payments are loaded when the app starts, allowing users to continue from where they left off.

Technologies Used:
Programming Language: Java (Android)
UI Design: XML
Material Components: TextView, EditText, Spinner, ChipGroup, Button
Gson: Used for JSON serialization and deserialization
IDE: Android Studio

How it works:
1. Users can add a payment by selecting a payment type and entering an amount.
2. If the selected payment type requires additional details (provider, transaction reference), input fields appear dynamically.
3. The added payment is displayed as a chip with a close icon.
4. Users can delete a payment by clicking the close icon and confirming the deletion.
5. Payments are saved in a local file "LastPayment.txt" when the save button is pressed.
6. When the app restarts, payments are loaded automatically.

File Structure:
1. MainActivity.java: Handles UI updates, payment addition, deletion, and saving functionality.
2. AddPaymentDialog.java: Implements a dialog for adding payments with dynamic input fields.
3. Payment.java: A model class representing payment details.
4. FileHelper.java: Handles saving and loading payments using JSON and file operations.
5. activity_main.xml: UI layout for the main screen.
6. dialog_add_payment.xml: UI layout for the add payment dialog.
