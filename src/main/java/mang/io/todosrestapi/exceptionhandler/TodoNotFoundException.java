package mang.io.todosrestapi.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Todo not available")
public class TodoNotFoundException extends RuntimeException{

    public TodoNotFoundException(){
    }

    public TodoNotFoundException(String message){
        super(message);
    }
}
