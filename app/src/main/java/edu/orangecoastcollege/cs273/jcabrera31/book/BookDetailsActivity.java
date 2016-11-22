package edu.orangecoastcollege.cs273.jcabrera31.book;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
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
        TextView bookISBNView = (TextView) findViewById(R.id.bookISBNTextView);
        TextView bookQtyTextView = (TextView) findViewById(R.id.bookQtyTextView);

        Button buttonReservebook = (Button) findViewById(R.id.buttonReservebook);


        Intent intent = getIntent();

        bookTitleTextView.setText(intent.getStringExtra("Title"));
        bookDescTextView.setText(intent.getStringExtra("Desc"));
        bookAuthorTextView.setText(intent.getStringExtra("Author"));
        bookISBNView.setText(String.valueOf(intent.getIntExtra("ISBN",0)));
        bookQtyTextView.setText(String.valueOf(intent.getIntExtra("Quantity",0)));
        bookImageView.setImageURI(Uri.parse(intent.getStringExtra("ImageUri")));

    }
}
