package search;

import java.util.*;

public class InvertedIndex {
    private final Map<String, List<Integer>> index = new HashMap<>();

    public void add(String word, int lineIndex) {
        index.putIfAbsent(word.toLowerCase(), new ArrayList<>());
        index.get(word.toLowerCase()).add(lineIndex);
    }

    public List<Integer> get(String word) {
        return index.getOrDefault(word.toLowerCase(), Collections.emptyList());
    }
}
