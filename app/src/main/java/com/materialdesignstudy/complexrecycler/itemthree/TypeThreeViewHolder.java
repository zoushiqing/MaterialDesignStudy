package com.materialdesignstudy.complexrecycler.itemthree;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.materialdesignstudy.R;
import com.materialdesignstudy.complexrecycler.itemone.DataModel;

/**
 * Created by HLQ on 2017/10/22
 */

public class TypeThreeViewHolder extends TypeAbstractViewHolder<DataModelThree> {

    public ImageView avatar, contentImg;
    public TextView name, content;

    public TypeThreeViewHolder(View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
        content = itemView.findViewById(R.id.content);
        contentImg = itemView.findViewById(R.id.contentImg);
        itemView.setBackgroundColor(Color.BLUE);
    }

    @Override
    public void bindHolder(DataModelThree dataModel) {
        avatar.setBackgroundResource(dataModel.avatatColor);
        name.setText(dataModel.name);
        content.setText(dataModel.content);
        contentImg.setBackgroundResource(dataModel.contentColor);
    }

}
