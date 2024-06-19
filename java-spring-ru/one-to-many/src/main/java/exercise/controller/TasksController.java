package exercise.controller;

import java.util.List;
import java.util.stream.Collectors;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.mapper.TaskMapper;
import exercise.model.Task;
import exercise.model.User;
import exercise.repository.TaskRepository;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import exercise.exception.ResourceNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    //BEGIN
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskMapper taskMapper;

    // GET /tasks – просмотр списка всех задач
    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(taskMapper::map) // Используем метод map для преобразования Task в TaskDTO
                .collect(Collectors.toList());
    }

    // GET /tasks/{id} – просмотр конкретной задачи
    @GetMapping("/{id}")
    public TaskDTO getTaskById(@PathVariable long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
        return taskMapper.map(task);
    }

    // POST /tasks – создание новой задачи
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO createTask(@Valid @RequestBody TaskCreateDTO taskCreateDTO) {
        User assignee = userRepository.findById(taskCreateDTO.getAssigneeId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + taskCreateDTO.getAssigneeId()));
        Task task = taskMapper.map(taskCreateDTO);
        task.setAssignee(assignee);
        return taskMapper.map(taskRepository.save(task));
    }

    // PUT /tasks/{id} – редактирование задачи
    @PutMapping("/{id}")
    public TaskDTO updateTask(@PathVariable long id, @Valid @RequestBody TaskUpdateDTO taskUpdateDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));

        User assignee = userRepository.findById(taskUpdateDTO.getAssigneeId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + taskUpdateDTO.getAssigneeId()));

        // Используем метод update маппера для обновления Task
        taskMapper.update(taskUpdateDTO, task);
        task.setAssignee(assignee);
        return taskMapper.map(taskRepository.save(task));
    }

    // DELETE /tasks/{id} – удаление задачи
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
        taskRepository.delete(task);
    }
    //END
}
