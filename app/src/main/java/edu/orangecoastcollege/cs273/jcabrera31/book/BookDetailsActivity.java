package edu.orangecoastcollege.cs273.jcabrera31.book;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class BookDetailsActivity extends AppCompatActivity {


    private ImageView bookImageView;
    private TextView bookTitleTextView;
    private TextView bookDescTextView;
    private TextView bookAuthorTextView;
    private TextView bookISBNView;
    private TextView isAvailTextView;
    private Context context = (Context) this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String desc = intent.getStringExtra("desc");
        String author = intent.getStringExtra("author");
        String isbn = intent.getStringExtra("ISBN");

        String imageFileName = intent.getStringExtra("ImageName");

        bookImageView = (ImageView) findViewById(R.id.bookImageView);
        bookTitleTextView = (TextView) findViewById(R.id.bookTitleTextView);
        bookDescTextView = (TextView) findViewById(R.id.bookDescTextView);
        bookAuthorTextView = (TextView) findViewById(R.id.bookAuthorTextView);
        bookISBNView = (TextView) findViewById(R.id.bookISBNTextView);
        isAvailTextView = (TextView) findViewById(R.id.bookIsAvailTextView);

        bookTitleTextView.setText(title);
        bookDescTextView.setText(desc);
        bookAuthorTextView.setText(author);
        bookISBNView.setText(isbn);
        //isAvailTextView.setText(address1);

        //load the image from the Assets folder using the AssetManager class
        AssetManager am = context.getAssets();
        try {
            InputStream stream = am.open(intent.getStringExtra("ImageName"));
            Drawable event = Drawable.createFromStream(stream, title);
            bookImageView.setImageDrawable(event);
        }
        catch (IOException ex)
        {
            Log.e("OC Library - Books", "Error loading " + imageFileName, ex);
        }
    }
}
