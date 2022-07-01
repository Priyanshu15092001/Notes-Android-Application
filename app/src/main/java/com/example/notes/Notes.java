package com.example.notes;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes_table")
public class Notes {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")int id=0;
    @ColumnInfo(name = "text")String text;
    public Notes(String text)
    {
        this.text=text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
