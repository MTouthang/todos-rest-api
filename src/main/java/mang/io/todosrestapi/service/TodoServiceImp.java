package mang.io.todosrestapi.service;


import mang.io.todosrestapi.exceptionhandler.TodoNotFoundException;
import mang.io.todosrestapi.model.Todo;
import mang.io.todosrestapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImp implements TodoService {
    @Autowired
    TodoRepository todoRepository;


    @Override
    public List<Todo> retrieveTodos() {
        return (List<Todo>) todoRepository.findAll();
    }

    @Override
    public List<String> retrieveTitleStatus() {
        return todoRepository.findAllStatus();
    }

    @Override
    public String retrieveTodoStatusById(Long id) {
        Optional<String> optionalTodo = Optional.ofNullable(todoRepository.findStatusById(id));
        System.out.println("OptionalTodo " +optionalTodo );
        return optionalTodo.orElseThrow(TodoNotFoundException::new);
    }


    @Override
    public List<String> retrieveTodoTitle() {
        return todoRepository.findAllTitle();
    }
}
