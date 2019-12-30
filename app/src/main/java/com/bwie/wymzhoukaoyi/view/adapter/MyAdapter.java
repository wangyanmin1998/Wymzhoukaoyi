package com.bwie.wymzhoukaoyi.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.wymzhoukaoyi.R;
import com.bwie.wymzhoukaoyi.model.bean.ShopBean;
import com.bwie.wymzhoukaoyi.util.NetUtil;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王彦敏
 *@Date: 2019/12/29
 *@Time:19:56
 *@Description:
 * */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<ShopBean.DataBean> list;

    public MyAdapter(List<ShopBean.DataBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ShopBean.DataBean dataBean = list.get(position);
        holder.name.setText(dataBean.getGoods_english_name());
        holder.price.setText(dataBean.getCurrency_price()+"");
        NetUtil.getInstance().getPhoto(dataBean.getGoods_thumb(),holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTagClicklistner.onTagClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView price;
        TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            price = itemView.findViewById(R.id.tv_price);
            img = itemView.findViewById(R.id.img);

        }
    }

    public void setOnTagClicklistner(MyAdapter.onTagClicklistner onTagClicklistner) {
        this.onTagClicklistner = onTagClicklistner;
    }

    onTagClicklistner onTagClicklistner;
    public interface onTagClicklistner{
        void onTagClick (int position);
    }
}
