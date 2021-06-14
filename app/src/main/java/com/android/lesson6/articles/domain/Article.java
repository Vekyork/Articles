package com.android.lesson6.articles.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

public class Article implements Parcelable {

    @StringRes
    private final int name;

    @DrawableRes
    private final int coat;

    public Article(int name, int coat) {
        this.name = name;
        this.coat = coat;
    }

    protected Article(Parcel in) {
        name = in.readInt();
        coat = in.readInt();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public int getName() {
        return name;
    }

    public int getCoat() {
        return coat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(name);
        dest.writeInt(coat);
    }
}
