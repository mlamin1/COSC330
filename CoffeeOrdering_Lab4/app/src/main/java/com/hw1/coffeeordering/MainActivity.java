package com.hw1.coffeeordering;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.net.Uri;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int quantity;
    private double price;
    private boolean iscream;
    private boolean ischoco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iscream = false;
        ischoco = false;
        price = 4.00;
        quantity = 1;

        //displaySummary(iscream, ischoco, price);
    }

    public void addQuantity(View view){
        quantity = quantity + 1;
        TextView tv = (TextView) findViewById(R.id.textView3);
        tv.setText(Integer.toString(quantity));
    }

    public void minusQuantity(View view){
        if(quantity > 0) {
            quantity = quantity - 1;
            TextView tv = (TextView) findViewById(R.id.textView3);
            tv.setText(Integer.toString(quantity));
        }
    }

    public void confirm_order(View view){
        CheckBox checkcream = (CheckBox) findViewById(R.id.checkBox);
        CheckBox checkchoco = (CheckBox) findViewById(R.id.checkBox2);
        if(checkcream.isChecked()){
            price = price + 0.5;
            iscream = true;
        }else
            iscream = false;

        if(checkchoco.isChecked()){
            price = price + 1;
            ischoco = true;
        }else
            ischoco = false;

        price = price * quantity;
        displaySummary(iscream, ischoco, price);
        price = 4.00;
    }

    public void displaySummary(boolean cr, boolean choc, double pr){
        //TextView tv1 = (TextView) findViewById(R.id.textView5);
        String bodytext;
        if(cr == false && choc == false) {
            bodytext = "Add whipped cream? no\nAdd chocolate? no\nquantity: " + quantity + "\n\nPrice: $" + pr + "\nTHANK YOU";
            sendEmail(bodytext);
        }if(cr == true && choc == false) {
            bodytext = "Add whipped cream? yes\nAdd chocolate? no\nquantity: " + quantity + "\n\nPrice: $" + pr + "\nTHANK YOU";
            sendEmail(bodytext);
        }if(cr == false && choc == true) {
            bodytext = "Add whipped cream? no\nAdd chocolate? yes\nquantity: " + quantity + "\n\nPrice: $" + pr + "\nTHANK YOU";
            sendEmail(bodytext);
        }if(cr == true && choc == true) {
            bodytext = "Add whipped cream? yes\nAdd chocolate? yes\nquantity: " + quantity + "\n\nPrice: $" + pr + "\nTHANK YOU";
            sendEmail(bodytext);
        }
    }

    public void sendEmail(String text)
    {
        Log.i("Send email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailin = new Intent(Intent.ACTION_SEND);

        emailin.setData(Uri.parse("mailto:"));
        emailin.setType("text/plain");
        emailin.putExtra(Intent.EXTRA_EMAIL, TO);
        emailin.putExtra(Intent.EXTRA_CC, CC);
        emailin.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailin.putExtra(Intent.EXTRA_TEXT, text);


    try{
        startActivity(Intent.createChooser(emailin, "Send Email..."));
        finish();
        Log.i("Finished sending email...", "");
    }catch(android.content.ActivityNotFoundException ex){
        Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
    }
    }

}
