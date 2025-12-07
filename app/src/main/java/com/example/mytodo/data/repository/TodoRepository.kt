package com.example.mytodo.data.repository

import android.content.Context
import com.example.mytodo.data.local.AppDatabase
import com.example.mytodo.data.local.TodoItem

class TodoRepository(context: Context) {

    private val todoDao = AppDatabase.getInstance(context).todoDao()

    // Получить все элементы определённого типа ("todo" или "shopping")
    suspend fun getAll(type: String): List<TodoItem> {
        return todoDao.getAll(type)
    }

    // Добавить новый элемент
    suspend fun add(text: String, type: String) {
        val item = TodoItem(text = text, type = type)
        todoDao.insert(item)
    }

    // Обновить существующий элемент
    suspend fun update(item: TodoItem) {
        todoDao.update(item)
    }

    // Удалить элемент
    suspend fun delete(item: TodoItem) {
        todoDao.delete(item)
    }
}
