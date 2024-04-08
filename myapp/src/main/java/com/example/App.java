package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Maven project
 *
 */

public class App {
    public static void main(String[] args) {
        // Создание одного объекта класса Person.
        Person person = new Person("Семен", "Самойлов", 40);
        System.out.println("\nНовый персон: \n" + person);

        //Сериализация объекта в формат JSON.
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String personToGson = gson.toJson(person);
        System.out.println("\nОбект сериализованный в формат GSON:\n" + personToGson);

        //Десериализация объекта класса Person из строки формата JSON
        Person personFromGson = gson.fromJson(personToGson, Person.class);
        System.out.println("\nДесериализованный персон:\n" + personFromGson);

        // Сравнение объектов и их хэшей до и после сериализации
        boolean isEqual = person.equals(personFromGson);
        System.out.println("\nОбъекты до и после сериализации равны: " + isEqual);
        isEqual = person.hashCode() == personFromGson.hashCode();
        System.out.println("\nХэшкоды объектов до и после сериализации равны: " + isEqual);
    }
}
