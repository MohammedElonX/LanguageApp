package com.example.language;

public class Words {
    private String mEnglish;
    private String mMiwok;

    Words(String english, String miwok){
        mEnglish = english;
        mMiwok = miwok;
    }

    public String getEnglish(){
        return mEnglish;
    }

    public String getMiwok(){
        return mMiwok;
    }
}
