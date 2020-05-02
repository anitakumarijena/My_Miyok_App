package com.example.android.miwok;

public class Word {

    private String mDefaultTranslation;
    private  String mMiaowTranslation;
    private int mImageResourceId=NO_IMAGE_PROVIDED;
    private  static final int NO_IMAGE_PROVIDED = -1;


    public Word(String defaultTranslation, String miwokTranslation,int ImageResourceId) {
        mDefaultTranslation=defaultTranslation;
        mMiaowTranslation =miwokTranslation;
        mImageResourceId=ImageResourceId;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiaowTranslation() {

        return mMiaowTranslation;
    }

    public int getmImageResourceId(){
        return mImageResourceId;
    }

    public  boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;

    }
}
