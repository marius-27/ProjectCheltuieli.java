package persistence;

import models.Expense;
import models.Income;

import javax.json.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataPersistence {

    public static void saveExpenses(List<Expense> expenses, String fileName) throws IOException {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        for (Expense expense : expenses) {
            arrayBuilder.add(Json.createObjectBuilder()
                    .add("id", expense.getId())
                    .add("amount", expense.getAmount())
                    .add("date", expense.getDate().toString())
                    .add("description", expense.getDescription())
                    .add("category", expense.getCategory()));
        }

        try (Writer writer = new FileWriter(fileName)) {
            Json.createWriter(writer).writeArray(arrayBuilder.build());
        }

        System.out.println("The expense was saved in " + fileName);
    }

    public static List<Expense> loadExpenses(String fileName) throws IOException {
        List<Expense> expenses = new ArrayList<>();

        try (Reader reader = new FileReader(fileName)) {
            JsonArray jsonArray = Json.createReader(reader).readArray();

            for (JsonValue value : jsonArray) {
                JsonObject jsonObject = value.asJsonObject();
                String id = jsonObject.getString("id");
                double amount = jsonObject.getJsonNumber("amount").doubleValue();
                LocalDate date = LocalDate.parse(jsonObject.getString("date"));
                String description = jsonObject.getString("description");
                String category = jsonObject.getString("category");
                expenses.add(new Expense(id, amount, date, description, category));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found. The list will be initialized empty.");
        }

        return expenses;
    }

    public static void saveIncomes(List<Income> incomes, String fileName) throws IOException {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        for (Income income : incomes) {
            arrayBuilder.add(Json.createObjectBuilder()
                    .add("id", income.getId())
                    .add("amount", income.getAmount())
                    .add("date", income.getDate().toString())
                    .add("description", income.getDescription())
                    .add("source", income.getSource()));
        }

        try (Writer writer = new FileWriter(fileName)) {
            Json.createWriter(writer).writeArray(arrayBuilder.build());
        }

        System.out.println("The income was saved in " + fileName);
    }

    public static List<Income> loadIncomes(String fileName) throws IOException {
        List<Income> incomes = new ArrayList<>();

        try (Reader reader = new FileReader(fileName)) {
            JsonArray jsonArray = Json.createReader(reader).readArray();

            for (JsonValue value : jsonArray) {
                JsonObject jsonObject = value.asJsonObject();
                String id = jsonObject.getString("id");
                double amount = jsonObject.getJsonNumber("amount").doubleValue();
                LocalDate date = LocalDate.parse(jsonObject.getString("date"));
                String description = jsonObject.getString("description");
                String source = jsonObject.getString("source");
                incomes.add(new Income(id, amount, date, description, source));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found. The list will be initialized empty.");
        }

        return incomes;
    }
}
