package com.project.todolist.data

import androidx.room.TypeConverter

class Converter {
    // TypeConverter annotation is added here to tell ROOM that this function is used for type
    // conversion. Only primitive data types are allowed hence we use type converters
    @TypeConverter
    fun fromPriority(priority: Priority): String{
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String): Priority{
        return Priority.valueOf(priority)
    }
}