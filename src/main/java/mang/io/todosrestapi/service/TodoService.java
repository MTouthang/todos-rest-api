package mang.io.todosrestapi.service;

import mang.io.todosrestapi.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> retrieveTodos();// get all theTodo
    List<String> retrieveTitleStatus(); // get theTodo by status
    String retrieveTodoStatusById(Long id); // get the status by id
    List<String> retrieveTodoTitle(); // get all the todo title
}
