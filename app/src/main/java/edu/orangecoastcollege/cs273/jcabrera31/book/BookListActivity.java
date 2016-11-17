package edu.orangecoastcollege.cs273.jcabrera31.book;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.AnyRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class BookListActivity extends AppCompatActivity {


    Context context = this;
    ArrayList<Book> allbooks;


    //newStuff

    private DBHelper db;
    BookListAdapter bookListAdapter;
    List<Book> bookList;
    ListView bookListView;
    private Uri imageURI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        imageURI = getUriToResource(this, R.drawable.none);

        //this.deleteDatabase(DBHelper.DATABASE_NAME);
        db = new DBHelper(this);

        //testing
        db.addBook(new Book("Calculus: Derivatives and More", "Textbook for learning Calculus", "Gary Coleman", 123456798, true, imageURI));

        bookList = db.getAllBooks();

        //instantiate the ListAdapter object with context, layout and List info
        //connect the listView to the correct widget
        //connect the adapter to the listView
        bookListAdapter = new BookListAdapter(this, R.layout.book_list_item, bookList);
        bookListView = (ListView) findViewById(R.id.bookListView);
        bookListView.setAdapter(bookListAdapter);


    }


    public void viewDetails(View view)
    {
        if(view instanceof LinearLayout)
        {
            LinearLayout selectedLayout = (LinearLayout) view;
            Book selected = (Book) selectedLayout.getTag();
            Log.i("Pet Protector", selected.toString()); //to log object

            Intent detailsIntent = new Intent(this, BookDetailsActivity.class);
            detailsIntent.putExtra("Title", selected.getTitle());
            detailsIntent.putExtra("Author", selected.getAuthor());
            detailsIntent.putExtra("Desc", selected.getDescription());
            detailsIntent.putExtra("ISBN", selected.getISBN());
            detailsIntent.putExtra("Avail", selected.isAvailable());

            detailsIntent.putExtra("ImageUri", selected.getImageUri().toString());

            startActivity(detailsIntent);

        }
    }


    /**
     *
     * @param context
     * @param resId
     * @return Uri to resource by given id
     * @throws Resources.NotFoundException
     */
    public static Uri getUriToResource(@NonNull Context context, @AnyRes int resId)
            throws Resources.NotFoundException{
        /**
         * Return a Resource instance for your application's package.
         */
        Resources res = context.getResources();

        /**
         * Return Uri
         */
        return Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE
                +"://" + res.getResourcePackageName(resId)
                +'/' + res.getResourceTypeName(resId)
                +'/' + res.getResourceEntryName(resId));
    }
}
