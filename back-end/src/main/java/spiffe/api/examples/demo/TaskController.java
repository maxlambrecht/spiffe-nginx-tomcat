package spiffe.api.examples.demo;

import spiffe.api.examples.demo.model.Task;
import spiffe.api.examples.demo.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public List<Task> listAllTasks() {
        return taskRepository.findAll();
    }
}
