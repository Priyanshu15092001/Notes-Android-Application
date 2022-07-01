package com.example.notes;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NotesRepository {
    private NotesDao notesDao;
    private LiveData<List<Notes>> mAllNotes
            ;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    NotesRepository(Application application) {
        NotesDatabase db = NotesDatabase.getDatabase(application);
        notesDao = db.getNotesDao();
        mAllNotes = notesDao.getAllNotes();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Notes>> getAllNotes() {
        return mAllNotes;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Notes notes) {
        NotesDatabase.databaseWriteExecutor.execute(() -> {
            notesDao.insert(notes);
        });
    }
    void delete(Notes note)
    {
        NotesDatabase.databaseWriteExecutor.execute(() ->
                {
                    notesDao.delete(note);
                }
        );
    }
}
