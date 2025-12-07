package com.example.mytodo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytodo.data.local.TodoItem
import com.example.mytodo.viewmodel.TodoViewModel

@Composable
fun ShoppingListScreen(viewModel: TodoViewModel = viewModel()) {

    var newItemText by remember { mutableStateOf("") }

    // Загружаем список покупок
    LaunchedEffect(Unit) {
        viewModel.load("shopping")
    }

    val items by viewModel.todos.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Список покупок", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            TextField(
                value = newItemText,
                onValueChange = { newItemText = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Введите товар") }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                if (newItemText.isNotBlank()) {
                    viewModel.add(newItemText, "shopping")
                    newItemText = ""
                }
            }) {
                Text("Добавить")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(items) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = if (item.done) "✅ ${item.text}" else item.text,
                        modifier = Modifier.weight(1f)
                    )
                    Row {
                        IconButton(onClick = { viewModel.toggle(item) }) {
                            Text(if (item.done) "↩" else "✔")
                        }
                        IconButton(onClick = { viewModel.delete(item) }) {
                            Text("❌")
                        }
                    }
                }
            }
        }
    }
}
