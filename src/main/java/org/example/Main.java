package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    // LinkedList tanımlıyorum ve tekrar eden Employee'lar ekliyorum
    private static final LinkedList<Employee> employees = new LinkedList<>();

    static {
        employees.add(new Employee("Dogancan", 1, "Kinik"));
        employees.add(new Employee("Dogancan", 1, "Kinik")); // Tekrar eden
        employees.add(new Employee("Seyyit Battal", 2, "Arvas"));
        employees.add(new Employee("Seyyit Battal", 2, "Arvas")); // Tekrar eden
        employees.add(new Employee("Seyyit Battal", 3, "Ensari"));
        employees.add(new Employee("Anil", 3, "Ensari")); // Tekrar eden ID
        employees.add(new Employee("Burak", 4, "Cevizli"));
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        // Tekrar eden elemanları bulmak için bir HashMap kullanıyoruz
        Map<Integer, Integer> idCount = new HashMap<>();
        List<Employee> duplicates = new LinkedList<>();

        // Her elemanın ID'sini say
        for (Employee emp : list) {
            if (emp == null) continue; // Null elemanları atla
            idCount.put(emp.getId(), idCount.getOrDefault(emp.getId(), 0) + 1);
        }

        // Tekrar edenleri bul ve listeye ekle
        Set<Integer> addedIds = new HashSet<>(); // Aynı ID'nin birden fazla eklenmesini önlemek için
        for (Employee emp : list) {
            if (emp == null) continue;
            int id = emp.getId();
            if (idCount.get(id) > 1 && !addedIds.contains(id)) {
                duplicates.add(emp);
                addedIds.add(id);
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        // Tekrar edenlerden bir tane ve tekrar etmeyenleri bulmak için HashMap kullanıyoruz
        Map<Integer, Employee> uniqueMap = new HashMap<>();
        Map<Integer, Integer> idCount = new HashMap<>();

        // Her elemanın ID'sini say
        for (Employee emp : list) {
            if (emp == null) continue;
            idCount.put(emp.getId(), idCount.getOrDefault(emp.getId(), 0) + 1);
        }

        // Tekrar edenlerden bir tane ve tekrar etmeyenleri ekle
        for (Employee emp : list) {
            if (emp == null) continue;
            int id = emp.getId();
            if (!uniqueMap.containsKey(id)) {
                uniqueMap.put(id, emp);
            }
        }

        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        // Tekrar eden elemanları tamamen silip sadece tek geçenleri döndüreceğiz
        Map<Integer, Integer> idCount = new HashMap<>();
        List<Employee> result = new LinkedList<>();

        // Her elemanın ID'sini say
        for (Employee emp : list) {
            if (emp == null) continue;
            idCount.put(emp.getId(), idCount.getOrDefault(emp.getId(), 0) + 1);
        }

        // Sadece tek geçen elemanları ekle
        for (Employee emp : list) {
            if (emp == null) continue;
            if (idCount.get(emp.getId()) == 1) {
                result.add(emp);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test için çalışanları yazdır
        System.out.println("Tüm çalışanlar:");
        System.out.println(employees);

        System.out.println("\nTekrar eden çalışanlar:");
        System.out.println(findDuplicates(employees));

        System.out.println("\nUnique çalışanlar (tekrar edenlerden bir tane ve tekrar etmeyenler):");
        System.out.println(findUniques(employees));

        System.out.println("\nTekrar edenler çıkarıldıktan sonra kalanlar:");
        System.out.println(removeDuplicates(employees));
    }
}