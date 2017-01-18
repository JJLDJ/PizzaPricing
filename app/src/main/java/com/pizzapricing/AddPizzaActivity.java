package com.pizzapricing;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class AddPizzaActivity extends AppCompatActivity {

    public final static String PIZZA_SIZE = "com.pizzapricing.SIZE";
    public final static String PIZZA_PRICE = "com.pizzapricing.PRICE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pizza);
        // Intent intent = getIntent();
    }

    /** Called when the user adds a new pizza. */
    public void addPizza(View view) {
        // Make a sort-of pop up for the user...
        Intent intent = new Intent(this, PizzaListActivity.class);
        EditText editTextSize = (EditText) findViewById(R.id.edit_pizza_size);
        EditText editTextPrice = (EditText) findViewById(R.id.edit_pizza_price);
        double pizzaDiameter = Double.parseDouble(editTextSize.getText().toString());
        double pizzaPrice = Double.parseDouble(editTextPrice.getText().toString());
        intent.putExtra(PIZZA_SIZE, pizzaDiameter);
        intent.putExtra(PIZZA_PRICE, pizzaPrice);


        // Send data back to the parent call.
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
