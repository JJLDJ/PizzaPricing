package com.pizzapricing;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.pizzapricing.AddPizzaActivity.PIZZA_SIZE;

public class PizzaListActivity extends AppCompatActivity {

    public static final int ADD_PIZZA_INTENT_ID = 1;

    private RecyclerView mRecyclerView;
    private PizzaListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_list);


        mRecyclerView = (RecyclerView) findViewById(R.id.pizza_list_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        mAdapter = new PizzaListAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    /** Called when the user wants to add a new pizza. */
    public void newPizza(View view) {
        // Make a sort-of pop up for the user...
        Intent intent = new Intent(this, AddPizzaActivity.class);
        startActivityForResult(intent, ADD_PIZZA_INTENT_ID);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ADD_PIZZA_INTENT_ID) {
            if(resultCode == Activity.RESULT_OK){
                Double pizzaSize = data.getDoubleExtra(PIZZA_SIZE, 100.0);

                TextView textView = new TextView(this);
                textView.setTextSize(40);
                textView.setText(String.format("Pizza Size = %.2f", pizzaSize));

                ViewGroup layout = (ViewGroup) findViewById(R.id.activity_pizza_list);
                layout.addView(textView);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                TextView textView = new TextView(this);
                textView.setTextSize(40);
                textView.setText(String.format("Cancel"));

                ViewGroup layout = (ViewGroup) findViewById(R.id.activity_pizza_list);
                layout.addView(textView);
            }
        }
    }
}
