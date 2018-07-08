package com.seadro.notesx.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import com.seadro.notesx.data.Note;
import com.seadro.notesx.data.NoteContent;
import com.seadro.notesx.utils.FontCache;
import com.seadro.notesx.utils.PreferenceHandler;

/**
 * View for simple plain text note content.
 */
public class NoteGenericView extends EditText implements NoteView {
    public NoteGenericView(Context context) {
        super(context);
        init();
    }

    public NoteGenericView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NoteGenericView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void init() {
        setTypeface(FontCache.getFont(getContext(), PreferenceHandler.getFontDefault())); //LOOK
    }

    /**
     * Returns NoteContent object with latest valuess
     */
    @Override
    public NoteContent getNoteContent() {
        return NoteContent.fromString(Note.Type.TYPE_GENERIC, getText().toString());
    }

    /**
     * Load values into View from given NoteContent object
     */
    @Override
    public void setNoteContent(NoteContent noteContent) {
        setText(noteContent.toString());
    }
}
