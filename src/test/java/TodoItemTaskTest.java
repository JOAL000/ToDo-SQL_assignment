
import org.example.Person;
import org.example.TodoItem;
import org.example.TodoItemTask;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TodoItemTaskTest {

    @Test
    public void testSetTodoItem() {
        TodoItemTask task = new TodoItemTask();
        TodoItem todoItem = new TodoItem();
        todoItem.setId(1);
        todoItem.setTitle("Test Title");
        todoItem.setTaskDescription("Test Description");
        todoItem.setDeadLine(LocalDate.now().plusDays(1));
        todoItem.setDone(false);
        Person creator = new Person(1, "John", "Doe", "john.doe@example.com");
        todoItem.setCreator(creator);

        task.setTodoItem(todoItem);

        assertEquals(todoItem, task.getTodoItem());
        assertTrue(task.isAssigned());
    }

    @Test
    public void testSetAssignee() {
        TodoItemTask task = new TodoItemTask();
        Person assignee = new Person(2, "Jane", "Doe", "jane.doe@example.com");

        task.setAssignee(assignee);

        assertEquals(assignee, task.getAssignee());
    }

    @Test
    public void testSetId() {
        TodoItemTask task = new TodoItemTask();
        task.setId(1);

        assertEquals(1, task.getId());
    }

    @Test
    public void testSetAssigned() {
        TodoItemTask task = new TodoItemTask();
        task.setAssigned(true);

        assertTrue(task.isAssigned());
    }

    @Test
    public void testGetSummary() {
        TodoItemTask task = new TodoItemTask();
        task.setId(1);
        task.setAssigned(true);

        TodoItem todoItem = new TodoItem();
        todoItem.setId(1);
        todoItem.setTitle("Test Title");
        todoItem.setTaskDescription("Test Description");
        todoItem.setDeadLine(LocalDate.now().plusDays(1));
        todoItem.setDone(false);
        Person creator = new Person(1, "John", "Doe", "john.doe@example.com");
        todoItem.setCreator(creator);
        task.setTodoItem(todoItem);

        Person assignee = new Person(2, "Jane", "Doe", "jane.doe@example.com");
        task.setAssignee(assignee);

        String expectedSummary = "TodoItemTask{id=1, assigned=true, todoItem=Test Description, assignee=Jane  Doe}";
        assertEquals(expectedSummary, task.getSummary());
    }
}