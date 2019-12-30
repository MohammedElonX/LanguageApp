package com.example.language;

public class Words {
    private String mEnglish;
    private String mMiwok;
    private int mImageId;

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
}
