package spiffe.api.examples.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import spiffe.api.examples.demo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class TasksController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TasksController.class);

    @Value("${tasks.service}")
    private String tasksService;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/tasks")
    public String index(Model model) {
        model.addAttribute("tasks", getTasks());
        return "tasks";
    }

    @SuppressWarnings("unchecked")
    private List<Task> getTasks() {
        return restTemplate.getForObject(tasksService, List.class);
    }


    @ExceptionHandler(Exception.class)
    public final ModelAndView handleAllExceptions(Exception ex, WebRequest request) {
        LOGGER.error(ex.getMessage());
        ModelAndView view = new ModelAndView();
        view.addObject("error", ex.getMessage());
        view.setViewName("error");
        return view;
    }
}
