

import org.example.Model.Person;
import org.example.Model.TodoItem;
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
    public void testToString() {
        TodoItem todoItem = new TodoItem();
        todoItem.setId(1);
        todoItem.setTitle("Test Title");
        todoItem.setTaskDescription("Test Description");
        todoItem.setDeadLine(LocalDate.now().plusDays(1));
        todoItem.setDone(false);

        String expected = "TodoItem{id=1, title='Test Title', taskDescription='Test Description', deadLine=" + LocalDate.now().plusDays(1) + ", done=false}";
        assertEquals(expected, todoItem.toString());
    }

    @Test
    public void testEquals() {
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

        assertEquals(todoItem1, todoItem2);
        assertNotEquals(todoItem1, todoItem3);
    }

    @Test
    public void testHashCode() {
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

        assertEquals(todoItem1.hashCode(), todoItem2.hashCode());
        assertNotEquals(todoItem1.hashCode(), todoItem3.hashCode());
    }
}