package mang.io.todosrestapi.web;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import mang.io.todosrestapi.model.Todo;
import mang.io.todosrestapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(responseCode="400", description ="This is a bad request, please follow the API documentation for the proper request format." ),
        @ApiResponse(responseCode = "401", description = "Due to security constraints, your access request cannot be authorized."),
        @ApiResponse(responseCode = "500", description = "The server is down. Please make sure that the Location microservice is running.")
})
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/Todos")
    public ResponseEntity<List<Todo>> getAllTodo(){
        List<Todo> list = todoService.retrieveTodos();
        return new ResponseEntity<List<Todo>>(list, HttpStatus.OK);
    }

    @GetMapping("/todo/status")
    public ResponseEntity<List<String>> getAllStatus(){
        List<String> list = todoService.retrieveTitleStatus();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/todo/{id}/status")
    public ResponseEntity<String> getTodoStatusById(@PathVariable Long id){
        String str = todoService.retrieveTodoStatusById(id);
        return new ResponseEntity<String>(str, HttpStatus.OK);
    }

    @GetMapping("/todo/title")
    public ResponseEntity<List<String>> getAllTitle(){
        List<String> title = todoService.retrieveTodoTitle();
        return new ResponseEntity<List<String>>(title, HttpStatus.OK);
    }
}
