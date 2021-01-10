package com.example.ezyfoodyfinal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfoodyfinal.DBHelper;
import com.example.ezyfoodyfinal.HistoryDBHelper;
import com.example.ezyfoodyfinal.Models.HistoryModel;
import com.example.ezyfoodyfinal.Models.OrderModel;
import com.example.ezyfoodyfinal.R;

import java.util.ArrayList;

public class AdapterOrder extends RecyclerView.Adapter<AdapterOrder.viewHolder>{

    ArrayList<OrderModel> orderlist;
    ArrayList<HistoryModel> historylist;
    Context context;

    public AdapterOrder(ArrayList<OrderModel> orderlist, Context context) {
        this.orderlist = orderlist;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_list,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final OrderModel model = orderlist.get(position);

        holder.orderimage.setImageResource(model.getOrderImage());
        holder.itemname.setText(model.getOrdername());
        holder.itemprice.setText(model.getOrderprice());
        holder.address.setText(model.getAddress());
        holder.qty.setText(model.getQuantity());

        String price = model.getOrderprice();
        String quantity = model.getQuantity();

        int p = Integer.parseInt(price);
        int q = Integer.parseInt(quantity);
        int totalP = (p*q);

        String totals = Integer.toString(totalP);

        holder.total.setText(totals);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View view) {
//                final HistoryModel models = historylist.get(position);
                DBHelper helper = new DBHelper(context);
                HistoryDBHelper history = new HistoryDBHelper(context);
                if (helper.deletedOrder(model.getOrderNum()) > 0){ //&& history.deletedHistory(models.getOrderNum()) > 0) {
                    Toast.makeText(context,"deleted",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context,"error",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }


    @Override
    public int getItemCount() {
        return orderlist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView orderimage;
        TextView itemname,itemprice,address,qty,total;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            orderimage = itemView.findViewById(R.id.orderimages);
            itemname = itemView.findViewById(R.id.ordername);
            itemprice = itemView.findViewById(R.id.orderprice);
            address = itemView.findViewById(R.id.address);
            qty = itemView.findViewById(R.id.itemqty);
            total = itemView.findViewById(R.id.totalprice);
        }
    }
}