package models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseTest {

    @Test
    void getCategory() {
        Expense cheltuiala = new Expense("1", 100.0, LocalDate.now(), "Prânz la restaurant", "Mâncare");
        assertEquals("Mâncare", cheltuiala.getCategory(), "Categoria ar trebui să fie 'Mâncare'");
    }

    @Test
    void setCategory() {
        Expense cheltuiala = new Expense("1", 100.0, LocalDate.now(), "Prânz la restaurant", "Mâncare");
        cheltuiala.setCategory("Călătorii");
        assertEquals("Călătorii", cheltuiala.getCategory(), "Categoria ar trebui să fie actualizată la 'Călătorii'");
    }

    @Test
    void displayTransactionDetails() {
        Expense cheltuiala = new Expense("1", 100.0, LocalDate.of(2025, 1, 1), "Prânz la restaurant", "Mâncare");
        cheltuiala.displayTransactionDetails();
        // Acest test verifica daca metoda rulează fara erori.
        // Pentru verificari detaliate, folosește un framework care poate captura output-ul din consola (ex. System Rules).
    }

    @Test
    void testToString() {
        Expense cheltuiala = new Expense("1", 100.0, LocalDate.of(2025, 1, 1), "Prânz la restaurant", "Mâncare");
        String asteptat = "Expense{id='1', amount=100.0, date=2025-01-01, description='Prânz la restaurant', category='Mâncare'}";
        assertEquals(asteptat, cheltuiala.toString(), "Reprezentarea text ar trebui să corespundă formatului așteptat");
    }
}
