package com.project.todolist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ToDoData::class], version = 1, exportSchema = true)
abstract class ToDoDatabase: RoomDatabase() {
    abstract fun toDoDao(): ToDoDAO

    // we create this as companion object because we do not want to create more than one instance
    // for our application
    companion object{
        @Volatile
        private var INSTANCE: ToDoDatabase? = null

        fun getDatabase(context: Context): ToDoDatabase{
            val tempInstance = INSTANCE
            // check if instance is not null then return the instance
            if (tempInstance != null){
                return tempInstance
            }
            // if there is no instance then we create instance inside synchronized block
            // this block is used because we don't want multiple threads to create multiple instances
            // hence only one thread can access this block at once
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ToDoDatabase::class.java,
                    "todo_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}