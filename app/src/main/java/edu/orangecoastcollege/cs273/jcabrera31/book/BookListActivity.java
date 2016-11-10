package edu.orangecoastcollege.cs273.jcabrera31.book;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller
 */
public class BookListActivity extends ListActivity {

    ListView bookListView;
    Context context = this;
    ArrayList<Book> allbooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_book);


        bookListView = (ListView) findViewById(R.id.bookListView);


        try {

            allbooks = JSONLoader.loadJSONFromAsset(context);
        } catch (IOException ex) {
            Log.e("OCC Library - BookList", "Error loading JSON data" + ex.getMessage());
        }

        setListAdapter(new BookListAdapter(context, R.layout.listview_searchresults, allbooks));
    }

}
