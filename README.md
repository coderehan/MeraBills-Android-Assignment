<h2>MeraBills Android Assignment</h2>

<h3>Problem Statement:</h3>
Managing different types of payments efficiently can be challenging, especially when tracking cash, bank transfers, and credit card payments. Users often need a simple interface to record, view, and delete payments while ensuring data persistence. This app provides a seamless solution for managing payments with a user-friendly UI and persistent storage.

<h3>Features:</h3>
<b>Add Payments:</b> <br>
Users can add payments of various types (Cash, Bank Transfer, Credit Card) with optional provider details and transaction references. <br>
<b>View Payments:</b> <br>
Payments are displayed as dynamic chips in a ChipGroup, making them easy to track. <br>
<b>Delete Payments:</b> <br>
Users can remove payments with a confirmation dialog to prevent accidental deletions. <br>
<b>Save Payments:</b> <br>
Payments are stored locally in a file "LastPayments.txt" using JSON serialization to ensure data persistence. <br>
<b>Load Payments:</b> <br>
Previously saved payments are loaded when the app starts, allowing users to continue from where they left off. <br>

<h3>Technologies Used:</h3>
<b>Programming Language:</b> Java (Android) <br>
<b>UI Design:</b> XML <br>
<b>Material Components:</b> TextView, EditText, Spinner, ChipGroup, Button <br>
<b>Gson:</b> Used for JSON serialization and deserialization <br>
<b>IDE:</b> Android Studio <br>

<h3>How it works:</h3>
1. Users can add a payment by selecting a payment type and entering an amount.
2. If the selected payment type requires additional details (provider, transaction reference), input fields appear dynamically.
3. The added payment is displayed as a chip with a close icon.
4. Users can delete a payment by clicking the close icon and confirming the deletion.
5. Payments are saved in a local file "LastPayment.txt" when the save button is pressed.
6. When the app restarts, payments are loaded automatically.

<h3>File Structure:</h3>
1. <b>MainActivity.java:</b> Handles UI updates, payment addition, deletion, and saving functionality.
2. <b>AddPaymentDialog.java:</b> Implements a dialog for adding payments with dynamic input fields.
3. <b>Payment.java:</b> A model class representing payment details.
4. <b>FileHelper.java:</b> Handles saving and loading payments using JSON and file operations.
5. <b>activity_main.xml:</b> UI layout for the main screen.
6. <b>dialog_add_payment.xml:</b> UI layout for the add payment dialog.
