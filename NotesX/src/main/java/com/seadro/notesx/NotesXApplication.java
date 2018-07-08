package com.seadro.notesx;

import android.app.Application;
import android.view.ViewConfiguration;
import com.seadro.notesx.data.DatabaseHandler;
import net.sqlcipher.database.SQLiteDatabase;

import java.lang.reflect.Field;

public class NotesXApplication extends Application {
    public final static String TAG = "NotesXApplication";

    private static DatabaseHandler mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        // load sqlite-cipher native libraries
        SQLiteDatabase.loadLibs(this);
        mDatabase = new DatabaseHandler(this);

        // Force show overflow button on Action Bar
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");

            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        }
        catch (Exception e) {
            // presumably, not relevant
        }
    }

    public static DatabaseHandler getDatabase() {
        return mDatabase;
    }
}
