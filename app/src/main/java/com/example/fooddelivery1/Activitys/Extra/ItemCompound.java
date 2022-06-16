package com.example.fooddelivery1.Activitys.Extra;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.example.fooddelivery1.R;


public class ItemCompound extends LinearLayout {

    private ImageView itemImageView;
    private TextView itemViewTitel1;
    private TextView itemViewTitel2;
    private TextView itemViewTitel3;
    private TextView itemViewText1;
    private TextView itemViewText2;
    private TextView itemViewText3;

    public ItemCompound(Context context) {
        super(context);
        init();
    }

    public ItemCompound(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ItemCompound(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ItemCompound(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init(){
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.itemview,this);

        itemViewTitel1 = findViewById(R.id.itemViewTitel1);
        itemViewTitel2 = findViewById(R.id.itemViewTitel2);
        itemViewTitel3 = findViewById(R.id.itemViewTitel3);
        itemViewText1 = findViewById(R.id.itemViewText1);
        itemViewText2 = findViewById(R.id.itemViewText2);
        itemViewText3 = findViewById(R.id.itemViewText3);
        itemImageView = findViewById(R.id.itemViewImage);
    }

    public void setItem(String title1, String title2, String title3, String restaurant, String Kitchen, String Address){

        this.itemViewTitel1.setText(title1+"");
        this.itemViewTitel2.setText(title2+"");
        this.itemViewTitel3.setText(title3+"");

        this.itemViewText1.setText(": "+restaurant);
        this.itemViewText2.setText(": "+Kitchen);
        this.itemViewText3.setText(": "+Address);


    }
}
