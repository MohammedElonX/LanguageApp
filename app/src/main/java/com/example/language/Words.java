package com.example.language;

public class Words {
    private String mEnglish;
    private String mMiwok;
    private int mImageId;
    private static int NO_IMAGE_PROVIDED= -1;

    Words(String english, String miwok){
        mEnglish = english;
        mMiwok = miwok;
    }

    Words(String english, String miwok, int ImageId){
        mEnglish = english;
        mMiwok = miwok;
        mImageId = ImageId;
    }

    public int getImageId () {return mImageId; }

    public String getEnglish(){
        return mEnglish;
    }

    public String getMiwok(){
        return mMiwok;
    }

    public boolean hasImage(){
        return NO_IMAGE_PROVIDED != mImageId;
    }
}
