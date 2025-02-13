package org.example.DAO;

import org.example.TodoItem;
import org.example.DAO.sequencers.TodoItemIdSequencer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TodoItemDAOCollection implements TodoItemDAO {
    private final List<TodoItem> todoItems;

    public TodoItemDAOCollection() {
        this.todoItems = new ArrayList<>();
    }

    @Override
    public TodoItem persist(TodoItem todoItem) {
        todoItem.setId(TodoItemIdSequencer.nextId());
        todoItems.add(todoItem);
        return todoItem;
    }

    @Override
    public TodoItem findById(int id) {
        return todoItems.stream()
                .filter(todoItem -> todoItem.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<TodoItem> findAll() {
        return new ArrayList<>(todoItems);
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        return todoItems.stream()
                .filter(todoItem -> todoItem.isDone() == done)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        return todoItems.stream()
                .filter(todoItem -> todoItem.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        return todoItems.stream()
                .filter(todoItem -> todoItem.getCreator() != null && todoItem.getCreator().getId() == personId)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        return todoItems.stream()
                .filter(todoItem -> todoItem.getDeadLine().isBefore(date))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        return todoItems.stream()
                .filter(todoItem -> todoItem.getDeadLine().isAfter(date))
                .collect(Collectors.toList());
    }

    @Override
    public void remove(int id) {
        todoItems.removeIf(todoItem -> todoItem.getId() == id);
    }
}