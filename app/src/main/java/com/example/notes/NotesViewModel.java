package com.example.notes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {
   private NotesRepository notesRepository;
   private final LiveData<List<Notes>>mAllNotes;
    public NotesViewModel(@NonNull Application application) {
        super(application);
        notesRepository =new NotesRepository(application);
        mAllNotes=notesRepository.getAllNotes();
    }
    LiveData<List<Notes>> getAllNotes(){
        return mAllNotes;
    }
    public void insert(Notes notes){
        notesRepository.insert(notes);
    }
    void deleteNote(Notes notes)
    {
        notesRepository.delete(notes);
    }
    void insertNote(Notes notes)
    {
        notesRepository.insert(notes);
    }
}
