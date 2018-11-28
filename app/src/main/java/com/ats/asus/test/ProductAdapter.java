package com.ats.asus.test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    public static final String Product_Name = "name";
    public static final String Product_Cat = "cat";
    public static final String Product_Price = "url";

    // we define a list from the DevelopersList java class

    private List<Products> products;
    private Context context;

    public ProductAdapter(List<Products> productsLists, Context context) {

        // generate constructors to initialise the List and Context objects

        this.products = productsLists;
        this.context = context;
    }
    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.products_list, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder viewHolder, int i) {

         Products productsList= products.get(i);
         viewHolder.mProduct_Name.setText(productsList.getProductName());
         viewHolder.mProduct_Cat.setText(productsList.getCategory());
         viewHolder.mProduct_Price.setText(productsList.getBasePrice());
         viewHolder.mLinear_layout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Log.i("clickeeed","clllik");
             }
         });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mProduct_Name;
        public TextView mProduct_Cat;
        public TextView mProduct_Price;
        public LinearLayout mLinear_layout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mProduct_Name =(TextView) itemView.findViewById(R.id.product_name);
            mProduct_Cat=(TextView) itemView.findViewById(R.id.product_cat);
            mProduct_Price=(TextView) itemView.findViewById(R.id.product_price);
            mLinear_layout=(LinearLayout) itemView.findViewById(R.id.linear_layout);
        }
    }
}
