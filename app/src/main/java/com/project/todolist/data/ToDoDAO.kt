package com.project.todolist.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// this class is responsible for defining the methods to access the database
@Dao
interface ToDoDAO {
    // it will return list of ToDoData wrapped inside live data so we can update in realtime
    @Query("SELECT * FROM todo_table ORDER_BY id ASC")
    fun getAllData(): LiveData<List<ToDoData>>

    // OnConflictStrategy handles the situation when same data is entered again
    // here we just ignore that
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(toDoData: ToDoData)
}