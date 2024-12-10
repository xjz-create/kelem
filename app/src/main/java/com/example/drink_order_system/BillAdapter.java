package com.example.drink_order_system;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class BillAdapter extends RecyclerView.Adapter {
    private final ArrayList<Order> mList;
    private final LayoutInflater mLayoutInflater;


    //creat a new view window
    BillAdapter(LayoutInflater layoutInflater, ArrayList<Order> list) {
        this.mList = list;
        mLayoutInflater = layoutInflater;
        System.out.println("BillAdapter used");
    }


    //bind the statustics to the new window
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BillAdapter.BillViewHolder(
                mLayoutInflater.inflate(R.layout.order_item, viewGroup, false));
    }

    private Order getItem(int position) {
        return mList.get(position);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Order target = getItem(position);
        if (holder instanceof BillAdapter.BillViewHolder) {
            ((BillAdapter.BillViewHolder) holder).bindBean(target);
        } else {
            throw new IllegalStateException("Illegal state Exception onBindviewHolder");
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    private class BillViewHolder extends RecyclerView.ViewHolder {
        private final TextView TV_number;
        private final TextView TV_time;
        private final TextView TV_takeAway;
        private final TextView TV_cost;

        private final TextView TV_flavorDetails;
        private final TextView TV_drinksDetails;


        BillViewHolder(View itemView) {
            super(itemView);
            TV_number = (TextView) itemView.findViewById(R.id.textView_number);
            TV_time = (TextView) itemView.findViewById(R.id.textView_time);
            TV_takeAway = (TextView) itemView.findViewById(R.id.textView_takeAway);
            TV_cost = (TextView) itemView.findViewById(R.id.textView_cost);
            TV_flavorDetails = itemView.findViewById(R.id.textView_flavorDetails);  // 绑定新的 TextView
            TV_drinksDetails = itemView.findViewById(R.id.textView_drinksDetails);
        }

        void bindBean(final Order bean) {
            TV_number.setText("订单编号：" + bean.getOrder_number());
            TV_time.setText(bean.getTime());
            TV_takeAway.setText(bean.getTakeAway().equals("1") ? "外带" : "堂食");
            TV_cost.setText("总价：￥ " + bean.getCost());


            Flavor flavor = bean.getFlavor();  // 获取与订单关联的 Flavor 对象
            Drinks drinks = bean.getDrink();  // 获取与订单关联的 Flavor 对象
            System.out.println("Flavor: " + flavor);
            System.out.println("Drinks: " + drinks);

            if (flavor != null) {
                TV_flavorDetails.setText("规格: " + flavor.getSize() + ", 糖量: " + flavor.getSugar() + ", 温度: " + flavor.getTemperature());

            }
            if (drinks != null) {
                TV_drinksDetails.setText("奶茶 :"+ drinks.get_name());

            }
        }

    }
}



