package exercise.controller;

import java.util.List;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.mapper.TaskMapper;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.TaskRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    // BEGIN
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toTaskDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public TaskDTO getTask(@PathVariable Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
        return taskMapper.toTaskDTO(task);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO createTask(@Valid @RequestBody TaskCreateDTO taskCreateDTO) {
        var task = taskMapper.toTask(taskCreateDTO);
        var assignee = userRepository.findById(taskCreateDTO.getAssigneeId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + taskCreateDTO.getAssigneeId()));
        task.setAssignee(assignee);
        taskRepository.save(task);
        return taskMapper.toTaskDTO(task);
    }

    @PutMapping("/{id}")
    public TaskDTO updateTask(@PathVariable Long id, @Valid @RequestBody TaskUpdateDTO taskUpdateDTO) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
        taskMapper.updateTaskFromDTO(taskUpdateDTO, task);
        if (taskUpdateDTO.getAssigneeId() != null) {
            var assignee = userRepository.findById(taskUpdateDTO.getAssigneeId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + taskUpdateDTO.getAssigneeId()));
            task.setAssignee(assignee);
        }
        taskRepository.save(task);
        return taskMapper.toTaskDTO(task);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
        taskRepository.delete(task);
    }
    // END
}
