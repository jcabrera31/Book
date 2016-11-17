package edu.orangecoastcollege.cs273.jcabrera31.book;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class BookDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        ImageView bookImageView = (ImageView) findViewById(R.id.bookImageView);
        TextView bookTitleTextView = (TextView) findViewById(R.id.bookTitleTextView);
        TextView bookDescTextView = (TextView) findViewById(R.id.bookDescTextView);
        TextView bookAuthorTextView = (TextView) findViewById(R.id.bookAuthorTextView);
        TextView  bookISBNView = (TextView) findViewById(R.id.bookISBNTextView);
        TextView isAvailTextView = (TextView) findViewById(R.id.bookIsAvailTextView);


        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        String desc = intent.getStringExtra("Desc");
        String author = intent.getStringExtra("Author");
        String isbn = intent.getStringExtra("ISBN");
        bookTitleTextView.setText(title);
        bookDescTextView.setText(desc);
        bookAuthorTextView.setText(author);
        bookISBNView.setText(isbn);
        //isAvailTextView.setText();
        bookImageView.setImageURI(Uri.parse(intent.getStringExtra("ImageUri")));

    }
}
