package com.materialdesignstudy.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.materialdesignstudy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HLQ on 2017/9/25
 */
public class MyStaggeredAdapter extends RecyclerView.Adapter<MyStaggeredAdapter.ViewHolder> {

    private final List<String> mStrlist;
    private final List<Integer> mHeightlist;
    private OnItemClickListener mOnItemClickListener;
    private onItemLongClickListener mOnItemLongClickListener;

    public MyStaggeredAdapter(List<String> strList) {
        mStrlist = strList;
        mHeightlist = new ArrayList<>();
        for (int i = 0; i < strList.size(); i++) {
            mHeightlist.add((int) Math.max(200, Math.random() * 550));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_view, parent, false));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) { // 数据绑定
        LayoutParams params = holder.tvShow.getLayoutParams();
        params.height = mHeightlist.get(position);
        holder.tvShow.setBackgroundColor(Color.rgb(100, (int) (Math.random() * 255), (int) (Math.random() * 255)));
        holder.tvShow.setLayoutParams(params);
        holder.tvShow.setText(mStrlist.get(position));
        // 设置点击事件
        if (mOnItemClickListener != null) {
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    mOnItemClickListener.onItemClick(view, position);
//                }
//            });
            // 解决item position错位
            holder.itemView.setOnClickListener(new MyClickListener(position));
        }
        // 设置长按事件
        if (mOnItemLongClickListener != null) {
            holder.itemView.setOnLongClickListener(new MyLongClickListener(position));
        }
    }

    @Override
    public int getItemCount() {
        return mStrlist.size();
    }

    /**
     * 新增item数据
     *
     * @param position
     */
    public void addItemData(int position) {
        mStrlist.add(position, "新增item:" + position);
        // 会影响效率
//      notifyDataSetChanged();
        // 刷新新增数据位置
        notifyItemInserted(position);
        // 更新下方所有item position
        if (position != mStrlist.size()) {
            notifyItemRangeChanged(position, mStrlist.size() - position);
        }
    }

    /**
     * 删除item数据
     *
     * @param position
     */
    public void removeItemData(int position) {
        mStrlist.remove(position);
//        notifyDataSetChanged();
        // 刷新removed位置数据
        notifyItemRemoved(position);
        // 更新下方所有item position
        if (position != mStrlist.size()) {
            notifyItemRangeChanged(position, mStrlist.size() - position);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvShow;

        public ViewHolder(View itemView) {
            super(itemView);
            tvShow = (TextView) itemView.findViewById(R.id.id_item_r);
        }

    }

    /**
     * 单击事件
     */
    public interface OnItemClickListener {

        void onItemClick(View view, int position);

    }

    /**
     * 设置单击事件
     *
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    /**
     * 长按事件
     */
    public interface onItemLongClickListener {

        void onItemLongClick(View view, int position);

    }

    public void setOnItemLongClickListener(onItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    /**
     * 重写OnClick解决item点击时position可能出现错位bug
     */
    class MyClickListener implements View.OnClickListener {

        private int mPosition;

        public MyClickListener(int position) {
            this.mPosition = position;
        }

        @Override
        public void onClick(View v) {
            mOnItemClickListener.onItemClick(v, mPosition);
        }
    }

    class MyLongClickListener implements View.OnLongClickListener {

        private int mPosition;

        public MyLongClickListener(int position) {
            this.mPosition = position;
        }

        @Override
        public boolean onLongClick(View v) {
            mOnItemLongClickListener.onItemLongClick(v, mPosition);
            return true;
        }
    }

}
