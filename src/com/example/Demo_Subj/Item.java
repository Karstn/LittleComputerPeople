package com.example.Demo_Subj;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by johannes on 24.11.2014.
 * modified by Karsten Becker 10.12.2014
 */

public class Item {

    private int active_state = 0; //state: 0= inactive ; 1=active by subject ; 2=active by user

    private int id; //Item-ID
    private float xPos;
    private float yPos;
    private String itemStandBitmapName; //name of resource to draw
    private static int holdAnimationCycles = 20; //time between animation steps

    private List<String> itemAnim;
    private List<String> itemAnimInv;



    //constructor
    public Item(String itemStandBitmapName, int id, float x, float y){ //added id, abfangen, name der resource statt bitmap
        this.itemStandBitmapName = itemStandBitmapName;
        this.id = id;
        //negative Werte für x und y abfangen
        if(x >= 0.0f) {
            xPos = x;
        }
        else{
            xPos = 0.0f;
        }
        if(y >= 0.0f) {
            yPos = x;
        }
        else{
            yPos = 0.0f;
        }
        yPos = y;

     }

    //x-coordinate
    public float getxPos(){
        return this.xPos;
    }
    //y-coordinate
    public float getyPos(){
        return this.yPos;
    }
    //returns name of resource to draw (instead of Bitmap)
    public String getBitmap(){
        return this.itemStandBitmapName;
    }
    //returns item-id
    public int getID(){
        return this.id;
    }

    //item used by Subject
    public void useBySubject(){
        this.active_state = 1;

    }
    //item used by User
    public void useByUser(){
        this.active_state = 2;

    }
    //tick
    public void tick(){

        //TODO: active_state überprüfen
    }
    //adds drawable pictures for animation in a list
    public void addResource(String resourcename){
        itemAnim.add(resourcename);
    }

}
