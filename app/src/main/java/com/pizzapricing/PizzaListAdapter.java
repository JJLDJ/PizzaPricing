package com.pizzapricing;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

final class PizzaListAdapter extends RecyclerView.Adapter<PizzaListAdapter.ViewHolder> {
    private ArrayList<Pizza> pizzaList = new ArrayList<>();

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView pizzaDiameterTextView;
        protected TextView pizzaAreaTextView;

        public ViewHolder(View v) {
            super(v);
            this.pizzaDiameterTextView = (TextView) v.findViewById(R.id.pizza_list_diameter);
            this.pizzaAreaTextView = (TextView) v.findViewById(R.id.pizza_list_area);
        }
    }

    // Empty constructor since all we need to do is initialize the list.
    PizzaListAdapter() {
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PizzaListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // Create a new view, using the pizza_list_item.xml layout object as a template.
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pizza_list_item, parent, false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager).
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        Pizza pizza = pizzaList.get(position);
        holder.pizzaDiameterTextView.setText(String.format("%.2f", pizza.getDiameter()));
        holder.pizzaAreaTextView.setText(String.format("%.2f", pizza.getArea()));
    }

    // Return the size of your dataset (invoked by the layout manager).
    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    public void addPizza(Pizza pizza) {
        pizzaList.add(pizza);
    }
}
