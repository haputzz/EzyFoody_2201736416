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
import com.example.ezyfoodyfinal.Models.HistoryModel;
import com.example.ezyfoodyfinal.R;

import java.util.ArrayList;

public class AdapterHistory extends RecyclerView.Adapter<AdapterHistory.viewHolder>{

    ArrayList<HistoryModel> orderlist;
    Context context;
    int totalprices;

    public AdapterHistory(ArrayList<HistoryModel> orderlist, Context context) {
        this.orderlist = orderlist;
        this.context = context;
    }


    @NonNull
    @Override
    public AdapterHistory.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_list,parent,false);
        return new AdapterHistory.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHistory.viewHolder holder, int position) {
        final HistoryModel model = orderlist.get(position);
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

        totalprices = totalprices+totalP;

        String totals = Integer.toString(totalP);
//        String totalprice = Integer.toString(totalprices);

        holder.total.setText(totals);
//        holder.totalprice.setText(totalprice);

        holder.paydate.setText(model.getPaydate());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View view) {
                DBHelper helper = new DBHelper(context);
                if (helper.deletedOrder(model.getOrderNum()) > 0) {
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
        TextView itemname,itemprice,address,qty,total,totalprice,paydate;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            orderimage = itemView.findViewById(R.id.orderimages);
            itemname = itemView.findViewById(R.id.ordername);
            itemprice = itemView.findViewById(R.id.orderprice);
            address = itemView.findViewById(R.id.address);
            qty = itemView.findViewById(R.id.itemqty);
            total = itemView.findViewById(R.id.totalprice);
//            totalprice = itemView.findViewById(R.id.totals);
            paydate = itemView.findViewById(R.id.date);
        }
    }
}
