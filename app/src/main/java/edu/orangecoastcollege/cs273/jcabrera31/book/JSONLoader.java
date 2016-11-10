package edu.orangecoastcollege.cs273.jcabrera31.book;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Class loads MusicEvent data from a formatted JSON (JavaScript Object Notation) file.
 * Populates data model (MusicEvent) with data.
 */

public class JSONLoader {

    /**
     * Loads JSON data from a file in the assets directory.
     * @param context The activity from which the data is loaded.
     * @throws IOException If there is an error reading from the JSON file.
     */
    public static ArrayList<Book> loadJSONFromAsset(Context context) throws IOException {
        ArrayList<Book> allBooks = new ArrayList<>();
        String json = null;
            InputStream is = context.getAssets().open("Books.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        try {
            JSONObject jsonRootObject = new JSONObject(json);
            JSONArray allBooksInJSON = jsonRootObject.getJSONArray("Books");
            int numberOfEvents = allBooksInJSON.length();

            for (int i = 0; i < numberOfEvents; i++) {
                JSONObject bookDataJSON = allBooksInJSON.getJSONObject(i);

                Book book = new Book();
                book.setmTitle(bookDataJSON.getString("Title"));
                book.setmAuthor(bookDataJSON.getString("Author"));
                book.setmDescription(bookDataJSON.getString("Desc"));
                book.setmISBN(bookDataJSON.getString("ISBN"));
                book.setmImageName(bookDataJSON.getString("ImageName"));
                //book.setAvailable(musicEventJSON.getString("IsAvail"));

                allBooks.add(book);
        }
        }
        catch (JSONException e)
        {
            Log.e("BookEvents JSON", e.getMessage());
        }

        return allBooks;
    }
}
