package com.example.spaceinvaders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.RectF;

public class buttonreplay {
    RectF rect;
    private static Bitmap bitmap;
    private float length;
    private float height;
    private static float x;
    private float y;

    public buttonreplay(Context context, int screenX, int screenY) {
        length = screenX/4;
        height = screenY/2;

        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.przycisk2);
        bitmap = Bitmap.createScaledBitmap(bitmap,
                (int) (length),
                (int) (height),
                false);

    }

    public static Bitmap getBitmap(){
        return bitmap;
    }

    public static float getX(){
        return x;
    }

    public float getLength(){
        return length;
    }


}
