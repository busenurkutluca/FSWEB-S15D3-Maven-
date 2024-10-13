package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("John",1 , "Doe"));
        employees.add(new Employee("Jane", 2, "Doe"));
        employees.add(new Employee("John",3 , "Doe")); // Duplicate
        employees.add(new Employee("Mark", 4, "Twain"));

        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("Duplicates: " + duplicates);

        Map<Integer, Employee> uniqueMap = findUniques(employees);
        System.out.println("Unique Employees: " + uniqueMap);

        List<Employee> filteredList = removeDuplicates(employees);
        System.out.println("Filtered List (without duplicates): " + filteredList);
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        List<Employee> duplicates = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicatesSet = new HashSet<>();

        for (Employee employee : list) {
            if (!seen.add(employee.getId())) {
                duplicatesSet.add(employee.getId());
            }
        }

        for (Employee employee : list) {
            if (duplicatesSet.contains(employee.getId())) {
                duplicates.add(employee);
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicatesSet = new HashSet<>();

        for (Employee employee : list) {
            if (!seen.add(employee.getId())) {
                duplicatesSet.add(employee.getId());
            }
        }

        for (Employee employee : list) {
            if (!duplicatesSet.contains(employee.getId())) {
                uniqueMap.put(employee.getId(), employee);
            } else if (!uniqueMap.containsKey(employee.getId())) {
                uniqueMap.put(employee.getId(), employee);
            }
        }

        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        List<Employee> filteredList = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Employee employee : list) {
            countMap.put(employee.getId(), countMap.getOrDefault(employee.getId(), 0) + 1);
        }

        for (Employee employee : list) {
            if (countMap.get(employee.getId()) == 1) {
                filteredList.add(employee);
            }
        }

        return filteredList;
    }
}
