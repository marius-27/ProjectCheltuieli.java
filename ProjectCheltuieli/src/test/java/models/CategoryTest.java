package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void testGetId() {
        Category categorie = new Category("1", "Mâncare", "Cheltuieli pentru mâncare");
        assertEquals("1", categorie.getId(), "ID-ul ar trebui să fie '1'");
    }

    @Test
    void testSetId() {
        Category categorie = new Category("1", "Mâncare", "Cheltuieli pentru mâncare");
        categorie.setId("2");
        assertEquals("2", categorie.getId(), "ID-ul ar trebui să fie actualizat la '2'");
    }

    @Test
    void testGetName() {
        Category categorie = new Category("1", "Mâncare", "Cheltuieli pentru mâncare");
        assertEquals("Mâncare", categorie.getName(), "Numele ar trebui să fie 'Mâncare'");
    }

    @Test
    void testSetName() {
        Category categorie = new Category("1", "Mâncare", "Cheltuieli pentru mâncare");
        categorie.setName("Călătorii");
        assertEquals("Călătorii", categorie.getName(), "Numele ar trebui să fie actualizat la 'Călătorii'");
    }

    @Test
    void testGetDescription() {
        Category categorie = new Category("1", "Mâncare", "Cheltuieli pentru mâncare");
        assertEquals("Cheltuieli pentru mâncare", categorie.getDescription(), "Descrierea ar trebui să corespundă");
    }

    @Test
    void testSetDescription() {
        Category categorie = new Category("1", "Mâncare", "Cheltuieli pentru mâncare");
        categorie.setDescription("Cheltuieli pentru călătorii");
        assertEquals("Cheltuieli pentru călătorii", categorie.getDescription(), "Descrierea ar trebui să fie actualizată");
    }

    @Test
    void testToString() {
        Category categorie = new Category("1", "Mâncare", "Cheltuieli pentru mâncare");
        String asteptat = "Category{id='1', name='Mâncare', description='Cheltuieli pentru mâncare'}";
        assertEquals(asteptat, categorie.toString(), "Reprezentarea text ar trebui să corespundă formatului așteptat");
    }

    @Test
    void testEquals() {
        Category categorie1 = new Category("1", "Mâncare", "Cheltuieli pentru mâncare");
        Category categorie2 = new Category("1", "Mâncare", "Cheltuieli pentru mâncare");
        assertEquals(categorie1, categorie2, "Cele două categorii ar trebui să fie egale");
    }

    @Test
    void testHashCode() {
        Category categorie1 = new Category("1", "Mâncare", "Cheltuieli pentru mâncare");
        Category categorie2 = new Category("1", "Mâncare", "Cheltuieli pentru mâncare");
        assertEquals(categorie1.hashCode(), categorie2.hashCode(), "Codurile hash ar trebui să fie egale pentru obiecte egale");
    }
}
