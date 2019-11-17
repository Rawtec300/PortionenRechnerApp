package com.example.portionenrechnerapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Eintrag.class}, version = 1, exportSchema = false)
public abstract class EintragDatabase extends RoomDatabase {

    public abstract EintragDao eintragDao();

    private static EintragDatabase INSTANCE;

    static EintragDatabase getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), EintragDatabase.class, "eintrag_database").build();
        }
        return INSTANCE;
    }
}
