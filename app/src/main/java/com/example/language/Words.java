package com.example.language;

public class Words {
    private String mEnglish;
    private String mMiwok;
    private int mImageId;
    private static int NO_IMAGE_PROVIDED= -1;
    private int mAudioResourceId;

    Words(String english, String miwok, int audioResourceId){
        mEnglish = english;
        mMiwok = miwok;
        mAudioResourceId = audioResourceId;
    }

    Words(String english, String miwok, int ImageId, int audioResourceId){
        mEnglish = english;
        mMiwok = miwok;
        mImageId = ImageId;
        mAudioResourceId = audioResourceId;
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

    public int getAudioResourceId(){return mAudioResourceId;}
}
