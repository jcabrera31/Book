package edu.orangecoastcollege.cs273.jcabrera31.book;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenny on 11/10/2016.
 */

public class BookListAdapter extends ArrayAdapter<Book>{

    private Context mContext;
    private int mResourceId;
    private List<Book> mAllBooksList;

    private ImageView listItemImageView;
    private TextView listItemTitleTextView;
    private TextView listItemDescTextView;

    /**
     * Parameterized constructor for this custom adapter.
     * @param context The context from which the MusicEventAdapter was created.
     * @param resourceId The layout resource id (e.g. R.layout.music_event_list_item)
     * @param allBooks The ArrayList containing all Book objects.
     */
    public BookListAdapter(Context context, int resourceId, ArrayList<Book> allBooks)
    {
        super(context, resourceId, allBooks);
        this.mResourceId = resourceId;
        this.mContext = context;
        this.mAllBooksList = allBooks;
    }

    /**
     * Gets the view associated with the layout (sets ImageView and TextView content).
     * @param pos The position of the MusicEvent selected.
     * @param convertView The converted view.
     * @param parent The parent - ArrayAdapter
     * @return The new view with all content (ImageView and TextView) set.
     */
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        Book book = mAllBooksList.get(pos);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResourceId, null);

        listItemImageView = (ImageView) view.findViewById(R.id.listItemImageView);
        listItemTitleTextView = (TextView) view.findViewById(R.id.listItemTitleTextView);
        listItemDescTextView = (TextView) view.findViewById(R.id.listItemDescTextView);

        AssetManager am = mContext.getAssets();
        try {
            InputStream stream = am.open(book.getmImageName());
            Drawable event = Drawable.createFromStream(stream, book.getmTitle());
            listItemImageView.setImageDrawable(event);
        }
        catch (IOException ex)
        {
            Log.e("OCC Library Book Search", "Error loading " + book.getmImageName(), ex);
        }

        listItemTitleTextView.setText(book.getmTitle());
        listItemDescTextView.setText(book.getmDescription());

        return view;
    }
}
