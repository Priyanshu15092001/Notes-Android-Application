package com.example.notes;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(
        entities = {Notes.class},
        version = 1,
        exportSchema = false
)
public abstract class NotesDatabase extends RoomDatabase {
    public abstract NotesDao getNotesDao();
    private static volatile NotesDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static NotesDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NotesDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    NotesDatabase.class, "notes_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
