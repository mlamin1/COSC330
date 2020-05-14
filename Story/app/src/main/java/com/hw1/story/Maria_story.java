package com.hw1.story;

public class Maria_story {

    private String mDescription;
    private int mId;   //DRAWABLE IDENTIFICATION

    public Maria_story (String description, int id){
        mDescription = description;
        mId = id;
    }

    public String getDescription() {
        return mDescription;
    }
    public void setDescription(String description){
        mDescription = description;
    }

    public int getId() {
        return mId;
    }
    public void setId(int id){
        mId = id;
    }

}
