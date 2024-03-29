package com.example.shirley.mobileshopbyw.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shirley.mobileshopbyw.R;
import com.example.shirley.mobileshopbyw.http.entity.GoodsEntity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class GoodsListAdapter extends RecyclerView.Adapter<GoodsListAdapter.LeftViewHolder> implements View.OnClickListener {
    private final List<GoodsEntity> datas;
    private final Activity mContext;
    private OnItemClickListener onItemClickListener;

    public GoodsListAdapter(Activity activity,List<GoodsEntity> data){
        this.datas = data;
        this.mContext = activity;
    }

    public void setOnItemClickListener(OnItemClickListener l){ this.onItemClickListener = l;}

    @NonNull
    @Override
    public LeftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_goods_list,parent,false);
        view.setOnClickListener(this);
        return new LeftViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeftViewHolder holder, int position) {
        GoodsEntity entity = datas.get(position);
        holder.itemView.setTag(position);
        ImageLoader.getInstance().displayImage(entity.getSmail(),holder.goodslist_img);
        holder.goodslist_name.setText(entity.getName());
        holder.goodslist_price.setText("￥" + String.format("%.2f",entity.getPrice()));
    }

    @Override
    public int getItemCount() {
        if(datas != null){
            return datas.size();
        }
        return 0;
    }

    @Override
    public void onClick(View v) {
        if (onItemClickListener != null){
            int position = (int) v.getTag();
            GoodsEntity entity = datas.get(position);
            onItemClickListener.onItemClick(v,position,entity);
        }
    }

    public class LeftViewHolder extends RecyclerView.ViewHolder{
        public final ImageView goodslist_img;
        public final TextView goodslist_name;
        public final TextView goodslist_price;
        public final TextView goodslist_comments;
        public final TextView goodslist_goodstype;

        public LeftViewHolder(View itemView){
            super(itemView);
            goodslist_img = itemView.findViewById(R.id.goodslist_img);
            goodslist_name = itemView.findViewById(R.id.goodslist_name);
            goodslist_price = itemView.findViewById(R.id.goodslist_price);
            goodslist_comments = itemView.findViewById(R.id.goodslist_comments);
            goodslist_goodstype = itemView.findViewById(R.id.goodslist_goodstype);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position,GoodsEntity entity);
    }
}
