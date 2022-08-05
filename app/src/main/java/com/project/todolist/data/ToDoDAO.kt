package com.project.todolist.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.todolist.data.models.ToDoData

// this class is responsible for defining the methods to access the database
@Dao
interface ToDoDAO {
    // it will return list of ToDoData wrapped inside live data so we can update in realtime
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllData(): LiveData<List<ToDoData>>

    // OnConflictStrategy handles the situation when same data is entered again
    // here we just ignore that
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(toDoData: ToDoData)

    @Update
    suspend fun updateData(toDoData: ToDoData)
}