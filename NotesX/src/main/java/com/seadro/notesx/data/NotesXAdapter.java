package com.seadro.notesx.data;

import android.database.Cursor;
import android.widget.ListAdapter;

public interface NotesXAdapter extends ListAdapter {
    public Cursor   getCursor();
    public void     clearCursor();
    public void     changeCursor(Cursor cursor);
    public void     setFolder(Note.Folder folder, int tagid);
    public void     startActionMode();
}
