package edu.orangecoastcollege.cs273.jcabrera31.book;

import android.content.Context;
import android.net.Uri;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by jcabrera31 on 11/22/2016.
 */
public class BookTest {
    private Book mBook;
    private DBHelper db;

    private String mTitle = "Test Title";
    private String mDescription = "Testing Book Description";
    private String mAuthor = "Testing Author Name"
    private int mISBN = 123456789;
    private int qty = 1;
    Context mContext;
    private Uri mImageUri;

    @Before
    public void setUp() throws Exception {
        mTitle = "Test Title";
        mDescription = "Testing Book Description";
        mAuthor = "Testing Author Name"
        mISBN = 123456789;
        qty = 1;
        //TODO: Get a context
        mImageUri = BookListActivity.getUriToResource(, R.drawable.book);
        mContext = ;
        mBook = new Book(mTitle, mDescription, mAuthor, mISBN, qty, mImageUri);
        //TODO: setup dataBase
        db = new DBHelper();
    }

    @After
    public void tearDown() throws Exception {
        //TODO: delete dataBase
    }

    @Test
    public void getQty() throws Exception {

    }

    @Test
    public void setQty() throws Exception {

    }

    @Test
    public void getTitle() throws Exception {

    }

    @Test
    public void setTitle() throws Exception {

    }

    @Test
    public void getDescription() throws Exception {

    }

    @Test
    public void setDescription() throws Exception {

    }

    @Test
    public void getAuthor() throws Exception {

    }

    @Test
    public void setAuthor() throws Exception {

    }

    @Test
    public void getImageUri() throws Exception {

    }

    @Test
    public void setImageUri() throws Exception {

    }

    @Test
    public void getId() throws Exception {

    }

    @Test
    public void getISBN() throws Exception {

    }

    @Test
    public void setISBN() throws Exception {

    }

}