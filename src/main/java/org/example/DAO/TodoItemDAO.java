package org.example.DAO;

import org.example.Model.Person;
import org.example.Model.TodoItem;

import java.util.Collection;

public interface TodoItemDAO {

    TodoItem create(TodoItem TodoItem);
    Collection<TodoItem> findAll();
    TodoItem findById(int TodoItemId);
    Collection<TodoItem> findByDoneStatus(boolean done);
    Collection<TodoItem> findByAssignee(int assigneeId);
    Collection<TodoItem> findByAssignee(Person assignee);
    Collection<TodoItem> findByUnassignedTodoItems();
    TodoItem update (TodoItem todoItem);
    boolean deleteById(int todoItemId);
}