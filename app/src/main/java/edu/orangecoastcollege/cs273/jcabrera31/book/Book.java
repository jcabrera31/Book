package edu.orangecoastcollege.cs273.jcabrera31.book;

import android.net.Uri;

/**
 * Model
 */

public class Book {


    private int mId;
    private String mTitle;
    private String mDescription;
    private String mAuthor;
    private int mISBN;
    private int qtyAvail;
    private Uri mImageUri;


    public Book(int mId, String mTitle, String mDescription, String mAuthor, int mISBN, int qty, Uri mImageUri) {
        this(mTitle,  mDescription,  mAuthor,  mISBN,  qty,  mImageUri);
        this.mId = mId;
    }

    public Book(String mTitle, String mDescription, String mAuthor, int mISBN, int qty, Uri mImageUri) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mAuthor = mAuthor;
        this.mISBN = mISBN;
        this.qtyAvail = qty;
        this.mImageUri = mImageUri;
    }

    public int getQty() {
        return qtyAvail;
    }

    public void setQty(int qtyAvail) {
        this.qtyAvail = qtyAvail;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }


    public Uri getImageUri() {
        return mImageUri;
    }

    public void setImageUri(Uri mImageUri) {
        this.mImageUri = mImageUri;
    }
    public int getId() {
        return mId;
    }

    public int getISBN() {
        return mISBN;
    }

    public void setISBN(int mISBN) {
        this.mISBN = mISBN;
    }


}
