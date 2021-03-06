package com.example.Demo_Subj;

/**
 * 22.11.2014 - File created - JS
 * 29.11.2014 - taken over (refactored) - SB
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

public class HouseView extends View {

    private Paint p;
    private int screenWidth;
    private int numRooms;

    public HouseView(Context c) {
        super(c);

        List <Room> roomList;
        roomList = GlobalInformation.getRoomList();
        numRooms = roomList.size();
        screenWidth = GlobalInformation.getScreenWidth();

        this.p = null;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // resize the View so it is as big as all rooms next to each other
        // could also be done as one view per room, flexibly loading the next one as one goes off screen,
        // effectively only having max. three rooms in memory.
        int width = screenWidth * numRooms;
        int height = GlobalInformation.getScreenHeight();

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        int numRooms;
        int i;
        List <Room> roomList;

        roomList = GlobalInformation.getRoomList();

        i = 0;
        for (Iterator<Room> iter = roomList.iterator(); iter.hasNext(); ) {
            Room room = iter.next();
            canvas.drawBitmap(room.getBitmapRoom(), screenWidth * i, 0, p);
            i++;
        }
    }
}
