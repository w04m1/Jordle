package com.w04m1.jordle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Words {
    private final Map<Integer, List<String>> wordsByLength = new HashMap<>();

    public Words() {
        loadWords();
    }

    public char[] getWord(int length) {
        Random rand = new Random();
        List<String> words = wordsByLength.get(length);
        String word = words.get(rand.nextInt(words.size()));
        return parseWord(word);
    }

    private char[] parseWord(String word) {
        char[] res = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            res[i] = word.charAt(i);
        }
        return res;
    }

    private void putWord(String word) {
        if (!wordsByLength.containsKey(word.length())) {
            wordsByLength.put(word.length(), new ArrayList<>());
        }
        List<String> words = wordsByLength.get(word.length());
        words.add(word);
    }

    private void processLine(String line) {
        Arrays.stream(line.split(" ")).forEach(this::putWord);
    }

    private void loadWords() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("words.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException | NullPointerException e) {
            System.err.println("Failed to load words from resource file.");
        }
    }
}
