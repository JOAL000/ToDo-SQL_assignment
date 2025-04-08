package org.example;

import org.example.DAO.PersonDAO;
import org.example.DAO.PersonDAOsql;
import org.example.DAO.TodoItemDAO;
import org.example.DAO.TodoItemDAOsql;
import org.example.DB.DatabaseConnection;
import org.example.Model.Person;
import org.example.Model.TodoItem;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        try {
            TodoItemDAO todoItemDAO = new TodoItemDAOsql(DatabaseConnection.getConnection());
            PersonDAO personDAO = new PersonDAOsql(DatabaseConnection.getConnection());

            //UI ui = new UI();
            //ui.start();

            // Create new Person instances
            Person person1 = new Person("John", "Doe", "john.doe@example.com");
            Person person2 = new Person("Ann", "Lee", "ann.lee@example.com");

            // Test create method
            System.out.println("Creating persons:");
            System.out.println(personDAO.create(person1));
            System.out.println(personDAO.create(person2));

            // Test read method
            System.out.println("Reading persons:");
            System.out.println(personDAO.findById(50));
            System.out.println(personDAO.findById(person2.getId()));

            // Test update method
            person1.setLastName("Smith");
            System.out.println(person1.getLastName());
            System.out.println("Updating person:");
            System.out.println(personDAO.update(person1));


            // Test delete method
            System.out.println("Deleting person:");
            System.out.println(personDAO.deleteById(person2.getId()));

            // Test findAll method
            System.out.println("Finding all persons:");
            Collection<Person> all = personDAO.findAll();
            for (Person person : all) {
                System.out.println(person);
            }

            // Create new TodoItem instances
             TodoItem todoItem1 = new TodoItem("Buy groceries", "Buy milk, eggs, and bread", LocalDate.of (2025,6,12),false,1);
             TodoItem todoItem2 = new TodoItem("Finish homework", "Complete math assignment", LocalDate.of (2025,6,15),false,1);

            // Test create method
            System.out.println("Creating TodoItems:");
            System.out.println(todoItemDAO.create(todoItem1));
            System.out.println(todoItemDAO.create(todoItem2));

            // Test read method
            System.out.println("Reading TodoItems:");
            System.out.println(todoItemDAO.findById(todoItem1.getId()));
            System.out.println(todoItemDAO.findById(todoItem2.getId()));

            // Test update method
            todoItem1.setTaskDescription("Buy milk, eggs, bread, and butter");

            //Test Delete method
            System.out.println("Deleting TodoItem:");
            System.out.println(todoItemDAO.deleteById(todoItem2.getId()));


            // Test findByAssignee method
            System.out.println("Finding TodoItems by assignee:");
            Collection<TodoItem> todoItemsByAssignee = todoItemDAO.findByAssignee(5);
            for (TodoItem todoItem : todoItemsByAssignee) {
                System.out.println(todoItem);
            }
            

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        }




    }
}