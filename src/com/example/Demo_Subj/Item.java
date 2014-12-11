package com.example.Demo_Subj;



import java.util.List;

/**
 * Created by johannes on 24.11.2014.
 * modified by Karsten Becker 11.12.2014
 */
//TODO: bei use evtl. subject ausblenden lassen
public class Item {
    //active or inactive
    private enum actstate {inactive,user,subject};
    private actstate active_state = actstate.inactive;

    private int id; //Item-ID
    private float xPos;
    private float yPos;
    private int default_graphics_id; //default
    private int akt_graphics_id; //name of resource to draw
    private static int holdAnimationCycles = 20; //time between animation steps

    //Lists contain graphics-ids for the animations
    private List<Integer> itemAnimbySubject;
    private List<Integer> itemAnimbyUser;



    //constructor
    public Item(String graphicsname, int id, float x, float y){

        this.default_graphics_id = resNameToResID(graphicsname);
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
    //get resource-id from resource-name
    private int resNameToResID(String resourcename){
        return GlobalInformation.context.getResources().getIdentifier(resourcename , "drawable", GlobalInformation.context.getPackageName());
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
    public int getAktGraphics(){
        return this.akt_graphics_id;
    }
    //returns item-id
    public int getID(){
        return this.id;
    }
    //item used by Subject
    public void useBySubject(){
        this.active_state = actstate.subject;
    }
    //item used by User
    public void useByUser(){
        this.active_state = actstate.user;
    }
    //tick
    public void tick(){
        //sets the graphic-id for the renderer
        if (this.active_state == actstate.subject){
            //TODO: animation caused by subjekt
        }
        else if (this.active_state == actstate.user){
            //TODO: animation caused by user
        }
        //if item is inactive
        else{
            this.akt_graphics_id = this.default_graphics_id;
        }
    }
    //adds drawable picture-ids for subject caused animation  in a list
    public void addGraphicsforSubjectUse(String graphicsname){
        itemAnimbySubject.add(resNameToResID(graphicsname));
    }
    //adds drawable picture-id for user caused  animation in a list
    public void addGraphicsforUserUse(String graphicsname){
        itemAnimbyUser.add(resNameToResID(graphicsname));
    }

}
