package com.pizzapricing;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import static com.pizzapricing.AddPizzaActivity.PIZZA_SIZE;
import static com.pizzapricing.AddPizzaActivity.PIZZA_PRICE;

public class PizzaListActivity extends AppCompatActivity {

    public static final int ADD_PIZZA_INTENT_ID = 1;

    private RecyclerView recyclerView;
    private PizzaListAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_list);

        recyclerView = (RecyclerView) findViewById(R.id.pizza_list_recycler_view);

        // This setting improves performance when RecyclerView layout size won't change.
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Create the adapter that will store the data behind our recycler (list) view.
        adapter = new PizzaListAdapter();
        recyclerView.setAdapter(adapter);

        // Create the callback that will handle swipe actions on the list.
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int swipedPizzaIndex = viewHolder.getAdapterPosition();
                adapter.removePizza(swipedPizzaIndex);
                adapter.notifyDataSetChanged();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
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
                double pizzaSize = data.getDoubleExtra(PIZZA_SIZE, 100.0);
                double pizzaPrice = data.getDoubleExtra(PIZZA_PRICE, 100.0);
                Pizza newPizza = new Pizza(pizzaSize, pizzaPrice);
                adapter.addPizza(newPizza);
                adapter.notifyDataSetChanged();
                showNotification("Added Pizza");
            } else if (resultCode == Activity.RESULT_CANCELED) {
                showNotification("Cancelled Adding Pizza");
            }
        } else {
            showNotification("Unexpected Result");
        }
    }

    private void showNotification(String notificationText) {
        Snackbar.make(findViewById(R.id.pizza_list_coordinator_layout), notificationText,
                Snackbar.LENGTH_SHORT)
                .show();

    }
}
