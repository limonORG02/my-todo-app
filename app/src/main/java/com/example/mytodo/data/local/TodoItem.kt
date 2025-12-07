package com.example.mytodo.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class TodoItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val text: String,
    val type: String,  // "todo" или "shopping"
    val done: Boolean = false
)
