package com.example.justjava;



        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.TextView;
        import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText cust_name = (EditText) findViewById(R.id.cust_name);
        String value = cust_name.getText().toString();

        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream);
        boolean hascream = whippedCream.isChecked();

        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate);
        boolean choco = chocolate.isChecked();

        int totalprice = calculatePrice(hascream, choco);

        String priceMessage = createOrderSummary(totalprice, value, hascream, choco);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffe Order For : " + value);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        displayPrice(priceMessage);
    }

    public int calculatePrice(boolean hascream, boolean choco) {
        int price = 5;

        if(hascream) {
            price = price + 1;
        }
        if(choco) {
            price = price + 2;
        }

        return quantity * price;
    }

    public String createOrderSummary(int price, String cust,  boolean hasCream, boolean choco) {
        String priceMessage = "Name : " + cust;
        priceMessage = priceMessage + "\nAdd Whiped Cream?" + hasCream;
        priceMessage = priceMessage + "\nAdd Chocolate?" + choco;
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nTotal: $" + price;
        priceMessage = priceMessage + "\nThank You!";
        return (priceMessage);

    }

    /**
     * This method is called when the increment button is clicked.
     */

    public void incrementQty(View view) {
        quantity = quantity + 1;
        display(quantity);

    }

    /**
     * This method is called when the decrement button is clicked.
     */

    public void decrementQty(View view) {
        if(quantity!=0) {
            quantity = quantity - 1;
        }
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_text_view);
        priceTextView.setText("" + message);
    }

}