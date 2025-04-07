package org.example.DAO;

import org.example.Model.Person;
import org.example.Model.TodoItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemDAOsql implements TodoItemDAO {
    private final Connection connection;

    public TodoItemDAOsql(Connection connection) {
        this.connection = connection;
    }


    @Override
    public TodoItem findById(int id) {

        try {
            String sql = "SELECT * FROM todo_item WHERE item_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new TodoItem(
                        resultSet.getInt("item_id"),
                        resultSet.getString("title"),
                        resultSet.getString("task_description"),
                        resultSet.getDate("deadline").toLocalDate(),
                        resultSet.getBoolean("done"),
                        resultSet.getInt("assignee_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public Collection<TodoItem> findByAssignee(int assigneeId) {
        List<TodoItem> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM todo_item WHERE assignee_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, assigneeId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(new TodoItem(
                        resultSet.getInt("item_id"),
                        resultSet.getString("title"),
                        resultSet.getString("task_description"),
                        resultSet.getDate("deadline").toLocalDate(),
                        resultSet.getBoolean("done"),
                        resultSet.getInt("assignee_id")
                ));
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<TodoItem> findByAssignee(Person assignee) {
        return findByAssignee(assignee.getId());
    }

    @Override
    public Collection<TodoItem> findByUnassignedTodoItems() {
        List<TodoItem> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM todo_item WHERE assignee_id IS NULL";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(new TodoItem(
                        resultSet.getInt("item_id"),
                        resultSet.getString("title"),
                        resultSet.getString("task_description"),
                        resultSet.getDate("deadline").toLocalDate(),
                        resultSet.getBoolean("done"),
                        resultSet.getInt("assignee_id")
                ));
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TodoItem update(TodoItem todoItem) {
        try {
            connection.setAutoCommit(false);
            String sql = "UPDATE todo_item SET title = ?, task_description = ?, deadline = ?, done = ?, assignee_id = ? WHERE item_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, todoItem.getTitle());
            statement.setString(2, todoItem.getTaskDescription());
            statement.setDate(3, Date.valueOf(todoItem.getDeadLine()));
            statement.setBoolean(4, todoItem.isDone());
            statement.setInt(5, todoItem.getCreator());
            statement.setInt(6, todoItem.getId());
            statement.executeUpdate();
            connection.commit();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                todoItem.setId(resultSet.getInt(1));
            }
            return todoItem;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteById(int todoItemId) {
        try {
            connection.setAutoCommit(false);
            String sql = "DELETE FROM todo_item WHERE item_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, todoItemId);
            int rows = statement.executeUpdate();
            connection.commit();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public TodoItem create(TodoItem todoItem) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO todo_item (title, task_description, deadline, done, assignee_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, todoItem.getTitle());
            statement.setString(2, todoItem.getTaskDescription());
            statement.setDate(3, Date.valueOf(todoItem.getDeadLine()));
            statement.setBoolean(4, todoItem.isDone());
            statement.setInt(5, todoItem.getCreator());
            statement.executeUpdate();
            connection.commit();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                todoItem.setId(resultSet.getInt(1));
            }

            return todoItem;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        List<TodoItem> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM todo_item";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(new TodoItem(
                        resultSet.getInt("item_id"),
                        resultSet.getString("title"),
                        resultSet.getString("task_description"),
                        resultSet.getDate("deadline").toLocalDate(),
                        resultSet.getBoolean("done"),
                        resultSet.getInt("assignee_id")
                ));
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<TodoItem> findByDoneStatus(boolean done) {
        List<TodoItem> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM todo_item WHERE done = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBoolean(1, done);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(new TodoItem(
                        resultSet.getInt("item_id"),
                        resultSet.getString("title"),
                        resultSet.getString("task_description"),
                        resultSet.getDate("deadline").toLocalDate(),
                        resultSet.getBoolean("done"),
                        resultSet.getInt("assignee_id")
                ));
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}