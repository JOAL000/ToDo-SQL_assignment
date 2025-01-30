

import org.example.Person;
import org.example.TodoItem;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TodoItemTest {

    @Test
    public void testSetId() {
        TodoItem todoItem = new TodoItem();
        todoItem.setId(1);
        assertEquals(1, todoItem.getId());
    }

    @Test
    public void testSetTitle() {
        TodoItem todoItem = new TodoItem();
        todoItem.setTitle("Test Title");
        assertEquals("Test Title", todoItem.getTitle());
    }

    @Test
    public void testSetTaskDescription() {
        TodoItem todoItem = new TodoItem();
        todoItem.setTaskDescription("Test Description");
        assertEquals("Test Description", todoItem.getTaskDescription());
    }

    @Test
    public void testSetDeadLine() {
        TodoItem todoItem = new TodoItem();
        LocalDate deadline = LocalDate.now().plusDays(1);
        todoItem.setDeadLine(deadline);
        assertEquals(deadline, todoItem.getDeadLine());
    }

    @Test
    public void testSetDone() {
        TodoItem todoItem = new TodoItem();
        todoItem.setDone(true);
        assertTrue(todoItem.isDone());
    }

    @Test
    public void testSetCreator() {
        TodoItem todoItem = new TodoItem();
        Person creator = new Person(1, "John", "Doe", "john.doe@example.com");
        todoItem.setCreator(creator);
        assertEquals(creator, todoItem.getCreator());
    }

    @Test
    public void testIsOverdue() {
        TodoItem todoItem = new TodoItem();
        todoItem.setDeadLine(LocalDate.now().minusDays(1));
        assertTrue(todoItem.isOverdue());
    }

    @Test
    public void testGetSummary() {
        TodoItem todoItem = new TodoItem();
        todoItem.setId(1);
        todoItem.setTitle("Test Title");
        todoItem.setTaskDescription("Test Description");
        todoItem.setDeadLine(LocalDate.now().plusDays(1));
        todoItem.setDone(false);
        Person creator = new Person(1, "John", "Doe", "john.doe@example.com");
        todoItem.setCreator(creator);

        String expectedSummary = "TodoItem{id=1, title='Test Title', taskDescription='Test Description', deadLine=" + LocalDate.now().plusDays(1) + ", done=false, creator=John Doe}";
        assertEquals(expectedSummary, todoItem.getSummary());
    }
}