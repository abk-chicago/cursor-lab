package org.codeforcoffee.planetssql;

/**
 * Created by andreakim on 6/23/16.
 */
public class Planet {

    public int mId;
    public String mName;
    public int mPosition;
    public String mFact;


    public Planet(int id, String name, int position, String fact) {

        this.mId = id;
        this.mName = name;
        this.mPosition = position;
        this.mFact = fact;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmPosition() {
        return mPosition;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }

    public String getmFact() {
        return mFact;
    }

    public void setmFact(String mFact) {
        this.mFact = mFact;
    }
}