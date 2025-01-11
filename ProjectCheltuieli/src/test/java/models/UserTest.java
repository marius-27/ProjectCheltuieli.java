package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testGetId() {
        User utilizator = new User("1", "John Doe", "john.doe@example.com");
        assertEquals("1", utilizator.getId(), "ID-ul ar trebui să fie '1'");
    }

    @Test
    void testSetId() {
        User utilizator = new User("1", "John Doe", "john.doe@example.com");
        utilizator.setId("2");
        assertEquals("2", utilizator.getId(), "ID-ul ar trebui să fie actualizat la '2'");
    }

    @Test
    void testGetName() {
        User utilizator = new User("1", "John Doe", "john.doe@example.com");
        assertEquals("John Doe", utilizator.getName(), "Numele ar trebui să fie 'John Doe'");
    }

    @Test
    void testSetName() {
        User utilizator = new User("1", "John Doe", "john.doe@example.com");
        utilizator.setName("Jane Smith");
        assertEquals("Jane Smith", utilizator.getName(), "Numele ar trebui să fie actualizat la 'Jane Smith'");
    }

    @Test
    void testGetEmail() {
        User utilizator = new User("1", "John Doe", "john.doe@example.com");
        assertEquals("john.doe@example.com", utilizator.getEmail(), "Email-ul ar trebui să fie 'john.doe@example.com'");
    }

    @Test
    void testSetEmail() {
        User utilizator = new User("1", "John Doe", "john.doe@example.com");
        utilizator.setEmail("jane.smith@example.com");
        assertEquals("jane.smith@example.com", utilizator.getEmail(), "Email-ul ar trebui să fie actualizat la 'jane.smith@example.com'");
    }

    @Test
    void testToString() {
        User utilizator = new User("1", "John Doe", "john.doe@example.com");
        String asteptat = "User{id='1', name='John Doe', email='john.doe@example.com'}";
        assertEquals(asteptat, utilizator.toString(), "Reprezentarea text ar trebui să corespundă formatului așteptat");
    }

    @Test
    void testEquals() {
        User utilizator1 = new User("1", "John Doe", "john.doe@example.com");
        User utilizator2 = new User("1", "John Doe", "john.doe@example.com");
        assertEquals(utilizator1, utilizator2, "Utilizatorii cu aceleași atribute ar trebui să fie egali");
    }

    @Test
    void testHashCode() {
        User utilizator1 = new User("1", "John Doe", "john.doe@example.com");
        User utilizator2 = new User("1", "John Doe", "john.doe@example.com");
        assertEquals(utilizator1.hashCode(), utilizator2.hashCode(), "Codurile hash ar trebui să fie egale pentru utilizatori egali");
    }
}
