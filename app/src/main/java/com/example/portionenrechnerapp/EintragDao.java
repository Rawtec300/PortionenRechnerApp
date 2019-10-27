package com.example.portionenrechnerapp;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EintragDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    public void insert(Eintrag eintrag);

    @Query("SELECT * FROM Eintrag")
    public List<Eintrag> getAll();

    @Delete
    public void delete(Eintrag eintrag);
}
