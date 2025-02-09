
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
    public void testToString() {
        TodoItemTask task = new TodoItemTask();
        TodoItem todoItem = new TodoItem();
        todoItem.setId(1);
        todoItem.setTitle("Test Title");
        todoItem.setTaskDescription("Test Description");
        todoItem.setDeadLine(LocalDate.now().plusDays(1));
        todoItem.setDone(false);
        task.setTodoItem(todoItem);
        task.setId(1);
        task.setAssigned(true);

        String expected = "TodoItemTask{id=1, assigned=true, todoItem=Test Description}";
        assertEquals(expected, task.toString());
    }


    @Test
    public void testEquals() {
        TodoItemTask task1 = new TodoItemTask();
        TodoItemTask task2 = new TodoItemTask();
        TodoItemTask task3 = new TodoItemTask();

        TodoItem todoItem1 = new TodoItem();
        todoItem1.setId(1);
        todoItem1.setTitle("Test Title");
        todoItem1.setTaskDescription("Test Description");
        todoItem1.setDeadLine(LocalDate.now().plusDays(1));
        todoItem1.setDone(false);

        TodoItem todoItem2 = new TodoItem();
        todoItem2.setId(1);
        todoItem2.setTitle("Test Title");
        todoItem2.setTaskDescription("Test Description");
        todoItem2.setDeadLine(LocalDate.now().plusDays(1));
        todoItem2.setDone(false);

        TodoItem todoItem3 = new TodoItem();
        todoItem3.setId(2);
        todoItem3.setTitle("Another Title");
        todoItem3.setTaskDescription("Another Description");
        todoItem3.setDeadLine(LocalDate.now().plusDays(2));
        todoItem3.setDone(true);

        task1.setId(1);
        task1.setAssigned(true);
        task1.setTodoItem(todoItem1);

        task2.setId(1);
        task2.setAssigned(true);
        task2.setTodoItem(todoItem2);

        task3.setId(2);
        task3.setAssigned(false);
        task3.setTodoItem(todoItem3);

        assertEquals(task1, task2);
        assertNotEquals(task1, task3);
    }

    @Test
    public void testHashCode() {
        TodoItemTask task1 = new TodoItemTask();
        TodoItemTask task2 = new TodoItemTask();
        TodoItemTask task3 = new TodoItemTask();

        TodoItem todoItem1 = new TodoItem();
        todoItem1.setId(1);
        todoItem1.setTitle("Test Title");
        todoItem1.setTaskDescription("Test Description");
        todoItem1.setDeadLine(LocalDate.now().plusDays(1));
        todoItem1.setDone(false);

        TodoItem todoItem2 = new TodoItem();
        todoItem2.setId(1);
        todoItem2.setTitle("Test Title");
        todoItem2.setTaskDescription("Test Description");
        todoItem2.setDeadLine(LocalDate.now().plusDays(1));
        todoItem2.setDone(false);

        TodoItem todoItem3 = new TodoItem();
        todoItem3.setId(2);
        todoItem3.setTitle("Another Title");
        todoItem3.setTaskDescription("Another Description");
        todoItem3.setDeadLine(LocalDate.now().plusDays(2));
        todoItem3.setDone(true);

        task1.setId(1);
        task1.setAssigned(true);
        task1.setTodoItem(todoItem1);

        task2.setId(1);
        task2.setAssigned(true);
        task2.setTodoItem(todoItem2);

        task3.setId(2);
        task3.setAssigned(false);
        task3.setTodoItem(todoItem3);

        assertEquals(task1.hashCode(), task2.hashCode());
        assertNotEquals(task1.hashCode(), task3.hashCode());
    }
}