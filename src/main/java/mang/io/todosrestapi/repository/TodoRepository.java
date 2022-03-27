package mang.io.todosrestapi.repository;

import mang.io.todosrestapi.model.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

    //retrieve status
    @Query("select d.id, d.status from Todo d where d.id=:id")
    String findStatusById(Long id);

    //retrieve all status
    @Query("select d.id, d.status from Todo d")
    List<String> findAllStatus();

    //retrieve all the title
    @Query("select d.id, d.title from Todo d")
    List<String> findAllTitle();
}
