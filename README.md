<h2>MeraBills Android Assignment</h2>

<h3>Problem Statement:</h3>
Managing different types of payments efficiently can be challenging, especially when tracking cash, bank transfers, and credit card payments. Users often need a simple interface to record, view, and delete payments while ensuring data persistence. This app provides a seamless solution for managing payments with a user-friendly UI and persistent storage.

<h3>Features:</h3>
<b>Add Payments:</b> 
Users can add payments of various types (Cash, Bank Transfer, Credit Card) with optional provider details and transaction references.
<b>View Payments:</b> 
Payments are displayed as dynamic chips in a ChipGroup, making them easy to track.
<b>Delete Payments:</b> 
Users can remove payments with a confirmation dialog to prevent accidental deletions.
<b>Save Payments:</b> 
Payments are stored locally in a file "LastPayments.txt" using JSON serialization to ensure data persistence.
<b>Load Payments:</b> 
Previously saved payments are loaded when the app starts, allowing users to continue from where they left off.

<h3>Technologies Used:</h3>
<b>Programming Language:</b> Java (Android)
<b>UI Design:</b> XML
<b>Material Components:</b> TextView, EditText, Spinner, ChipGroup, Button
<b>Gson:</b> Used for JSON serialization and deserialization
<b>IDE:</b> Android Studio

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
