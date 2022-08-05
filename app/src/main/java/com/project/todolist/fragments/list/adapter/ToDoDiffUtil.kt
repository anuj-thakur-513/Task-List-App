package com.project.todolist.fragments.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.project.todolist.data.models.ToDoData

class ToDoDiffUtil(private val oldList: List<ToDoData>, private val newList: List<ToDoData>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // === means strict equal to which is used to strictly compare. 2 == "2" is true
        // but 2 === "2" isn't
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
                && oldList[oldItemPosition].title == newList[newItemPosition].title
                && oldList[oldItemPosition].description == newList[newItemPosition].description
                && oldList[oldItemPosition].priority == newList[newItemPosition].priority
    }

}