package org.example.DAO;

import org.example.DAO.sequencers.TodoItemTaskIdSequencer;
import org.example.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO {
    private final List<TodoItemTask> todoItemTasks;

    public TodoItemTaskDAOCollection() {
        this.todoItemTasks = new ArrayList<>();
    }

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        todoItemTask.setId(TodoItemTaskIdSequencer.nextId());
        todoItemTasks.add(todoItemTask);
        return todoItemTask;
    }

    @Override
    public TodoItemTask findById(int id) {
        return todoItemTasks.stream()
                .filter(todoItemTask -> todoItemTask.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return new ArrayList<>(todoItemTasks);
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        return todoItemTasks.stream()
                .filter(todoItemTask -> todoItemTask.isAssigned() == status)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        return todoItemTasks.stream()
                .filter(todoItemTask -> todoItemTask.getAssignee() != null && todoItemTask.getAssignee().getId() == personId)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(int id) {
        todoItemTasks.removeIf(todoItemTask -> todoItemTask.getId() == id);
    }
}