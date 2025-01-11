package models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsTest {

    @Test
    void testGetId() {
        Transactions tranzactie = new Expense("1", 100.0, LocalDate.now(), "Prânz", "Mâncare");
        assertEquals("1", tranzactie.getId(), "ID-ul ar trebui să fie '1'");
    }

    @Test
    void testSetId() {
        Transactions tranzactie = new Expense("1", 100.0, LocalDate.now(), "Prânz", "Mâncare");
        tranzactie.setId("2");
        assertEquals("2", tranzactie.getId(), "ID-ul ar trebui să fie actualizat la '2'");
    }

    @Test
    void testGetAmount() {
        Transactions tranzactie = new Expense("1", 100.0, LocalDate.now(), "Prânz", "Mâncare");
        assertEquals(100.0, tranzactie.getAmount(), "Suma ar trebui să fie 100.0");
    }

    @Test
    void testSetAmount() {
        Transactions tranzactie = new Expense("1", 100.0, LocalDate.now(), "Prânz", "Mâncare");
        tranzactie.setAmount(200.0);
        assertEquals(200.0, tranzactie.getAmount(), "Suma ar trebui să fie actualizată la 200.0");
    }

    @Test
    void testGetDate() {
        LocalDate data = LocalDate.of(2025, 1, 1);
        Transactions tranzactie = new Expense("1", 100.0, data, "Prânz", "Mâncare");
        assertEquals(data, tranzactie.getDate(), "Data ar trebui să fie 2025-01-01");
    }

    @Test
    void testSetDate() {
        Transactions tranzactie = new Expense("1", 100.0, LocalDate.now(), "Prânz", "Mâncare");
        LocalDate dataNoua = LocalDate.of(2025, 1, 1);
        tranzactie.setDate(dataNoua);
        assertEquals(dataNoua, tranzactie.getDate(), "Data ar trebui să fie actualizată la 2025-01-01");
    }

    @Test
    void testGetDescription() {
        Transactions tranzactie = new Expense("1", 100.0, LocalDate.now(), "Prânz", "Mâncare");
        assertEquals("Prânz", tranzactie.getDescription(), "Descrierea ar trebui să fie 'Prânz'");
    }

    @Test
    void testSetDescription() {
        Transactions tranzactie = new Expense("1", 100.0, LocalDate.now(), "Prânz", "Mâncare");
        tranzactie.setDescription("Cină");
        assertEquals("Cină", tranzactie.getDescription(), "Descrierea ar trebui să fie actualizată la 'Cină'");
    }

    @Test
    void testDisplayTransactionDetails() {
        Transactions tranzactie = new Expense("1", 100.0, LocalDate.of(2025, 1, 1), "Prânz", "Mâncare");
        tranzactie.displayTransactionDetails();
        // Testează dacă metoda rulează fără erori.
        // Pentru capturarea output-ului, folosește un framework precum System Rules.
    }

    @Test
    void testToString() {
        Transactions tranzactie = new Expense("1", 100.0, LocalDate.of(2025, 1, 1), "Prânz", "Mâncare");
        String asteptat = "Transactions{id='1', amount=100.0, date=2025-01-01, description='Prânz'}";
        assertTrue(tranzactie.toString().contains("id='1'") && tranzactie.toString().contains("amount=100.0"),
                "Reprezentarea text ar trebui să includă ID-ul și suma");
    }
}
