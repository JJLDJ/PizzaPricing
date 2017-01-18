package com.pizzapricing;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

final class PizzaListAdapter extends RecyclerView.Adapter<PizzaListAdapter.ViewHolder> {
    private ArrayList<Pizza> pizzaList = new ArrayList<>();

    /**
     * View holder that holds references to all the views needed to represent a single pizza/entry
     * in the pizza list.
     */
    static class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView pizzaDiameterTextView;
        protected TextView pizzaAreaTextView;
        protected TextView pizzaCostTextView;

        public ViewHolder(View pizzaListItemView) {
            super(pizzaListItemView);
            this.pizzaDiameterTextView = (TextView) pizzaListItemView.findViewById(R.id.pizza_list_diameter);
            this.pizzaAreaTextView = (TextView) pizzaListItemView.findViewById(R.id.pizza_list_area);
            this.pizzaCostTextView = (TextView) pizzaListItemView.findViewById(R.id.pizza_list_cost);
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
        holder.pizzaCostTextView.setText(String.format("%.2f", pizza.getCost()));
    }

    // Return the size of your dataset (invoked by the layout manager).
    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    public void addPizza(Pizza pizza) {
        pizzaList.add(pizza);
    }

    /** Removes the pizza at index {@code pizzaIndex} from this adapter's list. */
    public void removePizza(int pizzaIndex) {
        pizzaList.remove(pizzaIndex);

    }
}
