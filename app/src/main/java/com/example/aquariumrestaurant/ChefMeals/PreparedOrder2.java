package com.example.aquariumrestaurant.ChefMeals;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aquariumrestaurant.R;
import java.util.List;

public class PreparedOrder2 extends RecyclerView.Adapter<PreparedOrder2.ViewHolder> {

    private Context context;
    private List<ChefFinalOrderMeals2> chefFinalOrders1list;

    public PreparedOrder2(Context context, List<ChefFinalOrderMeals2> chefFinalOrders1list) {
        this.chefFinalOrders1list = chefFinalOrders1list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chef_preparedorder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ChefFinalOrderMeals2 chefFinalOrders1 = chefFinalOrders1list.get(position);
        holder.Address.setText(chefFinalOrders1.getAddress());
        holder.grandtotalprice.setText("Grand Total: ₹ " + chefFinalOrders1.getGrandTotalPrice());
        final String random = chefFinalOrders1.getRandomUID();
        holder.Vieworder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PreparedOrderView1.class);
                intent.putExtra("RandomUID", random);
                context.startActivity(intent);
                ((PreparedOrder1) context).finish();
            }
        });

    }

    @Override
    public int getItemCount() {
        return chefFinalOrders1list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Address, grandtotalprice;
        Button Vieworder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Address = itemView.findViewById(R.id.customer_address);
            grandtotalprice = itemView.findViewById(R.id.customer_totalprice);
            Vieworder = itemView.findViewById(R.id.View);
        }
    }
}
