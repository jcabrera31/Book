package edu.orangecoastcollege.cs273.jcabrera31.book;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    private List<Book> mBookList = new ArrayList<>();


    /**
     *
     * @param context
     * @param resourceId
     * @param allBooks
     */
    public BookListAdapter(Context context, int resourceId, List<Book> allBooks)
    {
        super(context, resourceId, allBooks);
        this.mResourceId = resourceId;
        this.mContext = context;
        this.mBookList = allBooks;
    }

    /**
     *
     * @param pos
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        final Book selectedBook = mBookList.get(pos);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResourceId, null);

        LinearLayout linearLayoutBookListItem = (LinearLayout) view.findViewById(R.id.linearLayoutBookListItem);
        ImageView listItemImageView = (ImageView) view.findViewById(R.id.listItemImageView);
        TextView listItemTitleTextView = (TextView) view.findViewById(R.id.listItemTitleTextView);
        TextView listItemDescTextView = (TextView) view.findViewById(R.id.listItemDescTextView);
        TextView listItemQtyTextView = (TextView) view.findViewById(R.id.listItemQtyTextView);

        linearLayoutBookListItem.setTag(selectedBook);
        listItemTitleTextView.setText(selectedBook.getTitle());
        listItemDescTextView.setText(selectedBook.getDescription());
        listItemQtyTextView.setText(String.valueOf(selectedBook.getQty()));
        listItemImageView.setImageURI(selectedBook.getImageUri());

        return view;
    }
}
