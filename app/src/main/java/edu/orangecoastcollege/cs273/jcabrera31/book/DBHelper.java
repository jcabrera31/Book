package edu.orangecoastcollege.cs273.jcabrera31.book;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import java.util.ArrayList;

/**
 * Created as a helper class to assist with database management using SQLite.
 */
class DBHelper extends SQLiteOpenHelper {

    //TASK 1: DEFINE THE DATABASE VERSION, NAME AND TABLE NAME
    static final String DATABASE_NAME = "LibraryBooks";
    private static final String DATABASE_TABLE = "Books";
    private static final int DATABASE_VERSION = 1;


    //TASK 2: DEFINE THE FIELDS (COLUMN NAMES) FOR THE TABLE
    private static final String KEY_FIELD_ID = "id";
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_DESCRIPTION = "description";
    private static final String FIELD_AUTHOR = "author";
    private static final String FIELD_ISBN = "isbn";
    private static final String FIELD_AVAILABLE = "available";
    private static final String FIELD_IMAGE_URI = "image_uri";


    public DBHelper(Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase database){
        String table = "CREATE TABLE " + DATABASE_TABLE + "("
                + KEY_FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FIELD_TITLE + " TEXT, "
                + FIELD_DESCRIPTION + " TEXT, "
                + FIELD_AUTHOR + " TEXT, "
                + FIELD_ISBN + " INTEGER, "
                + FIELD_AVAILABLE + " INTEGER, "
                + FIELD_IMAGE_URI + " TEXT" + ")";
        database.execSQL (table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database,
                          int oldVersion,
                          int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(database);
    }

    //********** DATABASE OPERATIONS:  ADD, GETALL, EDIT, DELETE

    public void addBook(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //ADD KEY-VALUE PAIR INFORMATION FOR THE TABLE
        values.put(FIELD_TITLE, book.getTitle());
        values.put(FIELD_DESCRIPTION, book.getDescription());
        values.put(FIELD_AUTHOR, book.getAuthor());
        values.put(FIELD_ISBN, book.getISBN());
        values.put(FIELD_AVAILABLE, (book.isAvailable())? 1:0);
        values.put(FIELD_IMAGE_URI, book.getImageUri().toString());

        // INSERT THE ROW IN THE TABLE
        db.insert(DATABASE_TABLE, null, values);

        // CLOSE THE DATABASE CONNECTION
        db.close();
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> bookList = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        //Cursor cursor = database.rawQuery(queryList, null);
        Cursor cursor = database.query(
                DATABASE_TABLE,
                new String[]{KEY_FIELD_ID, FIELD_TITLE, FIELD_DESCRIPTION, FIELD_AUTHOR, FIELD_ISBN, FIELD_AVAILABLE, FIELD_IMAGE_URI},
                null,
                null,
                null, null, null, null );

        //COLLECT EACH ROW IN THE TABLE
        if (cursor.moveToFirst()){
            do {
                Book book =
                        new Book(cursor.getInt(0), //iD
                                cursor.getString(1),//title
                                cursor.getString(2),//desc
                                cursor.getString(3),//author
                                cursor.getInt(4),//isbn
                                (cursor.getInt(5) ==1),//available
                                Uri.parse(cursor.getString(4))//imageUri
                        );
                bookList.add(book);
            } while (cursor.moveToNext());
        }
        return bookList;
    }

    public void deleteTask(Book book){
        SQLiteDatabase db = this.getWritableDatabase();

        // DELETE THE TABLE ROW
        db.delete(DATABASE_TABLE, KEY_FIELD_ID + " = ?",
                new String[] {String.valueOf(book.getId())});
        db.close();
    }

    public void deleteAllBooks()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE, null, null);
        db.close();
    }

    public void updateBook(Book book){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIELD_TITLE, book.getTitle());
        values.put(FIELD_DESCRIPTION, book.getDescription());
        values.put(FIELD_AUTHOR, book.getAuthor());
        values.put(FIELD_ISBN, book.getISBN());
        values.put(FIELD_AVAILABLE, (book.isAvailable())? 1:0);
        values.put(FIELD_IMAGE_URI, book.getImageUri().toString());

        db.update(DATABASE_TABLE, values, KEY_FIELD_ID + " = ?",
                new String[]{String.valueOf(book.getId())});
        db.close();
    }

    public Book getBook(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                DATABASE_TABLE,
                new String[]{KEY_FIELD_ID, FIELD_TITLE, FIELD_DESCRIPTION, FIELD_AUTHOR, FIELD_ISBN, FIELD_AVAILABLE, FIELD_IMAGE_URI},
                KEY_FIELD_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null );

        if (cursor != null)
            cursor.moveToFirst();

        Book book = new Book(
                        cursor.getInt(0), //iD
                        cursor.getString(1),//title
                        cursor.getString(2),//desc
                        cursor.getString(3),//author
                        cursor.getInt(4),//isbn
                        (cursor.getInt(5) ==1),//available
                        Uri.parse(cursor.getString(4))//imageUri
                );

        db.close();
        return book;
    }





}
