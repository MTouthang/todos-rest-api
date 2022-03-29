package mang.io.todosrestapi.web;

import mang.io.todosrestapi.config.SpringSecurityConfig;
import mang.io.todosrestapi.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;

import javax.net.ssl.SSLEngineResult;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // this define the runner clas to run test cases

@WebMvcTest(value = TodoController.class, excludeAutoConfiguration = {SpringSecurityConfig.class}) // specific controller to be test
//WebMvcTest auto configure
public class TodoControllerUnitTest {

    @Autowired
    private MockMvc mockMvc; // power way to quickly test without needing to start full http server

    @MockBean // create mockito of the service which are  dependency for the Todo controller
    TodoController todoController;

    @Test
    public void getAllTodo() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/Todos/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

    }
}
