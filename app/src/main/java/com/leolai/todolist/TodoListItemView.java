package com.leolai.todolist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class  TodoListItemView extends TextView {

    private Paint marginPaint;
    private Paint linePaint;
    private int PaperColor;
    private float marginGap;

    public TodoListItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public TodoListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TodoListItemView(Context context) {
        super(context);
        init();
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawColor(PaperColor);

        canvas.drawLine(0, 0, 0, getMeasuredHeight(), linePaint);
        canvas.drawLine(0, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(),linePaint);
        //canvas.drawLine(0, 0, getMeasuredWidth(), getMeasuredHeight(), linePaint);
        //canvas.drawLine(getMeasuredWidth(), 0, getMeasuredWidth(), getMeasuredHeight(), linePaint);

        canvas.drawLine(marginGap, 0, marginGap, getMeasuredHeight(), marginPaint);

        canvas.save();
        canvas.translate(marginGap, 0);
        super.onDraw(canvas);
        canvas.restore();
    }

    public void init() {
        Resources mResource = getResources();

        marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        marginPaint.setColor(mResource.getColor(R.color.notepad_margin));

        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(mResource.getColor(R.color.notepad_lines));

        PaperColor = mResource.getColor(R.color.notepad_paper);
        marginGap = mResource.getDimension(R.dimen.notepad_margin);
    }
}