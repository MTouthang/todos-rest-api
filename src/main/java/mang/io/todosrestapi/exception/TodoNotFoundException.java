package mang.io.todosrestapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Todo not availble")
public class TodoNotFoundException extends RuntimeException {
    public  TodoNotFoundException(){

    }
    public TodoNotFoundException(String message){
        super(message);
    }
}