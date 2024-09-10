package pawel.com.example.demo.model;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    List<Task> findAll();
    Pageable findAll(Pageable page);
    Task save(Task entity);
    Optional<org.springframework.scheduling.config.Task> findById(Integer id);

    List<org.springframework.scheduling.config.Task> findByDone(@Param("state") boolean done);



}
