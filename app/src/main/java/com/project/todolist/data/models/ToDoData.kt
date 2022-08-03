package com.project.todolist.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.project.todolist.data.models.Priority

// this class basically represents columns inside the database
@Entity(tableName = "todo_table")
data class ToDoData(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var priority: Priority,
    var description: String
)