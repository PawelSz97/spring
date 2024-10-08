package pawel.com.example.demo.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    List<Task> findAll();
    Page findAll(Pageable page);
    Task save(Task entity);
    Optional<Task> findById(Integer id);

    List<Task> findByDone(@Param("state") boolean done);



}
