package com.example.notes;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
     void insert(Notes notes);
    @Delete
    void delete(Notes notes);
    @Query("Select * from notes_table order by id asc")
    LiveData<List<Notes>> getAllNotes();
}
