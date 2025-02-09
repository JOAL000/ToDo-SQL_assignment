
import org.example.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testConstructor() {
        Person person = new Person(1, "John", "Doe", "john.doe@example.com");
        assertEquals(1, person.getId());
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals("john.doe@example.com", person.getEmail());
    }

    @Test
    public void testSetFirstName() {
        Person person = new Person(1, "John", "Doe", "john.doe@example.com");
        person.setFirstName("Jane");
        assertEquals("Jane", person.getFirstName());
    }

    @Test
    public void testSetLastName() {
        Person person = new Person(1, "John", "Doe", "john.doe@example.com");
        person.setLastName("Smith");
        assertEquals("Smith", person.getLastName());
    }

    @Test
    public void testSetEmail() {
        Person person = new Person(1, "John", "Doe", "john.doe@example.com");
        person.setEmail("jane.doe@example.com");
        assertEquals("jane.doe@example.com", person.getEmail());
    }

    @Test
    public void testToString() {
        Person person = new Person(1, "John", "Doe", "john.doe@example.com");
        String expected = "Person{id=1, firstName='John', lastName='Doe', email='john.doe@example.com'}";
        assertEquals(expected, person.toString());
    }

    @Test
    public void testEquals() {
        Person person1 = new Person(1, "John", "Doe", "john.doe@example.com");
        Person person2 = new Person(1, "John", "Doe", "john.doe@example.com");
        Person person3 = new Person(2, "Jane", "Doe", "jane.doe@example.com");

        assertEquals(person1, person2);
        assertNotEquals(person1, person3);
    }

    @Test
    public void testHashCode() {
        Person person1 = new Person(1, "John", "Doe", "john.doe@example.com");
        Person person2 = new Person(1, "John", "Doe", "john.doe@example.com");
        Person person3 = new Person(2, "Jane", "Doe", "jane.doe@example.com");

        assertEquals(person1.hashCode(), person2.hashCode());
        assertNotEquals(person1.hashCode(), person3.hashCode());
    }
}
