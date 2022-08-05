package com.project.todolist.data.repository

import androidx.lifecycle.LiveData
import com.project.todolist.data.ToDoDAO
import com.project.todolist.data.models.ToDoData

// The repository class provides a clean API for data access to the rest of the app as it separates
// data sources from the app
class ToDoRepository(private val toDoDAO: ToDoDAO) {
    val getAllData: LiveData<List<ToDoData>> = toDoDAO.getAllData()

    suspend fun insertData(toDoData: ToDoData) {
        toDoDAO.insertData(toDoData)
    }

    suspend fun updateData(toDoData: ToDoData){
        toDoDAO.updateData(toDoData)
    }

    suspend fun deleteData(toDoData: ToDoData){
        toDoDAO.deleteItem(toDoData)
    }

    suspend fun deleteAll(){
        toDoDAO.deleteAll()
    }

    fun searchDatabase(searchQuery: String): LiveData<List<ToDoData>>{
        return toDoDAO.searchDatabase(searchQuery)
    }
}