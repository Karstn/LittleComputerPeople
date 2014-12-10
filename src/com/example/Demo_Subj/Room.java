package com.example.Demo_Subj;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johannes on 24.11.2014.
 * Graphical adapations - 04.12.2014
 * Karsten Becker: added parameter in instancing of object Item (line 36) - 10.12.2014
 */
public class Room {

    private Bitmap bitmapRoom;
    private int roomID;

    private List<Item> itemList;

    public Room (Bitmap bitmapRoomR, int ID, Context ctx) { //später noch x und y koordinaten
        bitmapRoom = Bitmap.createScaledBitmap(bitmapRoomR,
                GlobalInformation.getScreenWidth(),
                GlobalInformation.getScreenHeight(),
                false);

        roomID = ID;
        itemList = new ArrayList<Item>();

        Resources resources = ctx.getResources();

        //TODO populate this object list from XML information instead
        if (ID == 2) {
            //itemList.add(new Item(BitmapFactory.decodeResource(resources, R.drawable.pflanze),1, 180, 40));
        }
    }

    public int getRoomID() {
        return roomID;
    }

    public Bitmap getBitmapRoom(){
        return bitmapRoom;
    }

    public List<Item> getItemList() {
        return itemList;
    }
}
