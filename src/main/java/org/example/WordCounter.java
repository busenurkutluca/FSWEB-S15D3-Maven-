package org.example;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private static final String TEXT = "When the offensive resumed, the Turks received their first victory when the Greeks encountered stiff resistance in the battles of First and Second İnönü," +
            " due to İsmet Pasha's organization of an irregular militia into a regular army. " +
            "The two victories led to Allied proposals to amend the Treaty of Sèvres where both Ankara and Istanbul were represented, but Greece refused." +
            " With the conclusion of the Southern and Eastern fronts, Ankara was able to concentrate more forces on the West against the Greeks." +
            " They also began to receive support from Soviet Union, as well as France and Italy, who sought to check British influence in the Near East.\n" +
            "June–July 1921 saw heavy fighting in the Battle of Kütahya-Eskişehir. While it was an eventual Greek victory, the Turkish army withdrew in good order to the Sakarya river, their last line of defence." +
            " Mustafa Kemal Pasha replaced İsmet Pasha after the defeat as commander in chief as well as his political duties." +
            " The decision was made in the Greek military command to march on the nationalist capital of Ankara to force Mustafa Kemal to the negotiating table." +
            " For 21 days, the Turks and Greeks fought a pitched battle at the Sakarya river, which ended in Greek withdrawal." +
            " Almost of year of stalemate without much fighting followed, during which Greek moral and discipline faltered while Turkish strength increased." +
            " French and Italian forces evacuated from Anatolia. The Allies offered an armistice to the Turks, which Mustafa Kemal refused.";

    public static Map<String, Integer> calculatedWord() {
        // Metni kelimelere ayır ve her kelimenin sayısını hesapla
        Map<String, Integer> wordCount = new HashMap<>();

        // Noktalama işaretlerini ve özel karakterleri temizle, metni küçük harfe çevir
        String cleanedText = TEXT.replaceAll("[.,!?\"—-]", "").toLowerCase();
        String[] words = cleanedText.split("\\s+");

        // Her kelimeyi say (O(n) time complexity)
        for (String word : words) {
            if (word.isEmpty()) continue;
            // Özel karakterleri normalize et
            word = word.replace("ınönü", "inonu")
                    .replace("ismet", "ismet")
                    .replace("sèvres", "sevres")
                    .replace("kütahya-eskişehir", "kutahya-eskisehir");
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }
}