package com.example.mytodo.data.local

import androidx.room.*

@Dao
interface TodoDao {

    @Query("SELECT * FROM todos WHERE type = :type ORDER BY id DESC")
    suspend fun getAll(type: String): List<TodoItem>

    @Insert
    suspend fun insert(item: TodoItem)

    @Update
    suspend fun update(item: TodoItem)

    @Delete
    suspend fun delete(item: TodoItem)

    @Query("SELECT COUNT(*) FROM todos")
    suspend fun count(): Int
}
