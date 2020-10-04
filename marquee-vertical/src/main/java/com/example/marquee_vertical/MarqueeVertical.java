package com.example.marquee_vertical;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.AnimRes;
import java.util.ArrayList;



public class MarqueeVertical extends ViewFlipper {
    private Context context;
    @AnimRes
    private int inAnimResId = R.anim.bottom_in;
    @AnimRes
    private int outAnimResId = R.anim.top_out;
    private int fadeDuration = 1500;
    private int textColor = 0xff000000;
    private float textSize = 14;
    private int textStyle = 0;
    private int interval = 3000;
    private int gravity = 0;
    private static final int GRAVITY_CENTER = 0;
    private static final int GRAVITY_START = 1;
    private static final int GRAVITY_END = 2;
    private static final int GRAVITY_BOTTOM= 3;

    public MarqueeVertical(Context context) {
        super(context);
        this.context = context;
    }

    public MarqueeVertical(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MarqueeVertical, 0, 0);
        textColor = typedArray.getColor(R.styleable.MarqueeVertical_mqvTextColor,textColor);
        textSize = (int)typedArray.getDimension(R.styleable.MarqueeVertical_mqvTextSize,textSize);
        textSize = pixelsToSp(context,textSize);
        textStyle = typedArray.getInt(R.styleable.MarqueeVertical_mqvTextStyle,textStyle);
        fadeDuration = typedArray.getInt(R.styleable.MarqueeVertical_mqvScrollFadeDuration,fadeDuration);
        interval = typedArray.getInt(R.styleable.MarqueeVertical_mqvInterval,interval);
        gravity = typedArray.getInt(R.styleable.MarqueeVertical_mqvTextGravity,gravity);
        switch (gravity){
            case GRAVITY_CENTER :
                gravity = Gravity.CENTER;
                break;
            case GRAVITY_START :
                gravity = Gravity.START | Gravity.CENTER_VERTICAL;
                break;
            case GRAVITY_END :
                gravity = Gravity.END | Gravity.CENTER_VERTICAL;
                break;
            case GRAVITY_BOTTOM:
                gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
                break;
        }
        setScrollBarFadeDuration(fadeDuration);
        setFlipInterval(interval);
        typedArray.recycle();
    }

    private  int pixelsToSp(Context context,float px){
        return (int) (px / context.getResources().getDisplayMetrics().scaledDensity);
    }
    public void setInOutAnimation(@AnimRes int inAnimResId, @AnimRes int outAnimResID){
        this.inAnimResId = inAnimResId;
        this.outAnimResId = outAnimResID;
        setInAnimation(context,inAnimResId);
        setOutAnimation(context,outAnimResID);
        setScrollBarFadeDuration(fadeDuration);
        setFlipInterval(interval);
    }

    public void startWithArray(ArrayList<String> message){
        setInAnimation(context,inAnimResId);
        setOutAnimation(context,outAnimResId);
        if(message.size() > 0) {
            for (int i = 0; i < message.size(); i++) {
                addView(createTextView(message.get(i)));
            }
            startFlipping();
        }else{
            throw  new RuntimeException("ArrayList not to be null");
        }
    }
    private TextView createTextView(String message){
        TextView textView = new TextView(context);
        textView.setText(message);
        textView.setTextSize(textSize);
        textView.setTextColor(textColor);
        textView.setGravity(gravity);
        textView.setTypeface(textView.getTypeface(),textStyle);
        textView.setSingleLine(true);
        return textView;
    }
}
