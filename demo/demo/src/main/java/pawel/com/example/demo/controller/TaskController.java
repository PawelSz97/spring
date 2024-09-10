package pawel.com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pawel.com.example.demo.model.Task;
import pawel.com.example.demo.model.TaskRepository;


import java.util.List;


@RestController
public class TaskController {
    private final TaskRepository repository;
    private final Logger logger = LoggerFactory.getLogger(TaskController.class);

    TaskController(final TaskRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tasks", params = {"!sort"})
    ResponseEntity<List<Task>> readAllTask(){
        logger.warn("reading all tasks");
        return ResponseEntity.ok(repository.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tasks")
    ResponseEntity<?> readAllTask(Pageable pageable){
        logger.info("Custom page");
        return ResponseEntity.ok(repository.findAll(pageable));
    }

    @PutMapping("/tasks/{id}")
    ResponseEntity<?> upadateTask (@RequestBody Task toUpdate, @PathVariable int id){
        toUpdate.setId(id);
        repository.save(toUpdate);
        return ResponseEntity.noContent().build();

    }
}
