package edu.orangecoastcollege.cs273.jcabrera31.book;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller
 */
public class BookListActivity extends AppCompatActivity {

    ListView bookListView;
    Context context = this;
    ArrayList<Book> allbooks;
    BookListAdapter bookListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);





        try {

            allbooks = JSONLoader.loadJSONFromAsset(context);
        } catch (IOException ex) {
            Log.e("OCC Library - BookList", "Error loading JSON data" + ex.getMessage());
        }
        bookListAdapter = new BookListAdapter(this, R.layout.listview_searchresults, allbooks);
        bookListView = (ListView) findViewById(R.id.bookListView);
    }




    protected void onListItemClick(ListView l, View v, int pos, long id)
    {

        Book clickedEvent = allbooks.get(pos);

        String title = clickedEvent.getmTitle();
        String desc = clickedEvent.getmDescription();
        String author = clickedEvent.getmAuthor();
        String isbn = clickedEvent.getmISBN();

        String imageName = clickedEvent.getmImageName();

        Intent intent = new Intent(this, BookDetailsActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("desc", desc);
        intent.putExtra("author", author);
        intent.putExtra("ISBN", isbn);

        intent.putExtra("ImageName", imageName);

        startActivity(intent);

    }
}
