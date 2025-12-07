package com.example.mytodo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytodo.data.local.TodoItem
import com.example.mytodo.data.repository.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TodoRepository(application)

    private val _todos = MutableStateFlow<List<TodoItem>>(emptyList())
    val todos: StateFlow<List<TodoItem>> = _todos

    // Загрузка элементов определённого типа ("todo" или "shopping")
    fun load(type: String) {
        viewModelScope.launch {
            _todos.value = repository.getAll(type)
        }
    }

    // Добавление новой задачи/товара
    fun add(text: String, type: String) {
        viewModelScope.launch {
            repository.add(text, type)
            load(type)
        }
    }

    // Переключение статуса выполнения
    fun toggle(item: TodoItem) {
        viewModelScope.launch {
            repository.update(item.copy(done = !item.done))
            load(item.type)
        }
    }

    // Удаление элемента
    fun delete(item: TodoItem) {
        viewModelScope.launch {
            repository.delete(item)
            load(item.type)
        }
    }
}
