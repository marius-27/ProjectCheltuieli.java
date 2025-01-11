package models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class IncomeTest {

    @Test
    void testGetSource() {
        Income venit = new Income("1", 1500.0, LocalDate.now(), "Salariu lunar", "Job");
        assertEquals("Job", venit.getSource(), "Sursa ar trebui să fie 'Job'");
    }

    @Test
    void testSetSource() {
        Income venit = new Income("1", 1500.0, LocalDate.now(), "Salariu lunar", "Job");
        venit.setSource("Proiect freelance");
        assertEquals("Proiect freelance", venit.getSource(), "Sursa ar trebui să fie actualizată la 'Proiect freelance'");
    }

    @Test
    void testDisplayTransactionDetails() {
        Income venit = new Income("1", 1500.0, LocalDate.of(2025, 1, 1), "Salariu lunar", "Job");
        venit.displayTransactionDetails();
        // Testul verifică dacă metoda rulează fără erori.
        // Pentru verificări detaliate ale textului afișat, se poate utiliza un framework pentru capturarea output-ului din consolă.
    }

    @Test
    void testToString() {
        Income venit = new Income("1", 1500.0, LocalDate.of(2025, 1, 1), "Salariu lunar", "Job");
        String asteptat = "Income{id='1', amount=1500.0, date=2025-01-01, description='Salariu lunar', source='Job'}";
        assertEquals(asteptat, venit.toString(), "Reprezentarea text ar trebui să corespundă formatului așteptat");
    }
}
