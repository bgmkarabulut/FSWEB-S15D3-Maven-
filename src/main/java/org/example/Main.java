package org.example;


import org.example.entity.Employee;

import java.util.*;

import static org.example.WordCounter.calculateWord;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "John", "Doe"));
        employees.add(new Employee(2, "Jane", "Doe"));
        employees.add(new Employee(1, "John", "Doe"));
        employees.add(new Employee(3, "Alice", "Smith"));
        employees.add(new Employee(2, "Jane", "Doe"));
        employees.add(new Employee(4, "Bob", "Brown"));

        System.out.println("Duplicate Employees: " + findDuplicates(employees));
        System.out.println("Unique Employees: " + findUniques(employees));
        System.out.println("List after Removing Duplicates: " + removeDuplicates(employees));

        Map<String, Integer> wordCounts = calculateWord();

        // Sonuçları ekrana yazdır
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Employee> uniqueSet = new HashSet<>();
        List<Employee> duplicates = new ArrayList<>();

        for (Employee emp : list) {
            if (!uniqueSet.add(emp)) {
                if (!duplicates.contains(emp)) {
                    duplicates.add(emp);
                }
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        if (list == null) {
            return employeeMap; // Eğer liste null ise boş bir map döndür
        }

        for (Employee emp : list) {
            if (emp != null && !employeeMap.containsKey(emp.getId())) {
                employeeMap.put(emp.getId(), emp);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Employee, Integer> countMap = new HashMap<>();
        if (list == null) {
            return new ArrayList<>();
        }

        for (Employee emp : list) {
            if (emp != null) { // Null Employee kontrolü
                countMap.put(emp, countMap.getOrDefault(emp, 0) + 1);
            }
        }

        List<Employee> result = new ArrayList<>();
        for (Map.Entry<Employee, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}