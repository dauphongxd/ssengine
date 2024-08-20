package search;

import java.util.*;

public class NoneSearchStrategy implements SearchStrategy {

    @Override
    public Set<Integer> search(List<Person> people, List<String> queryWords, InvertedIndex index) {
        Set<Integer> allIndices = new HashSet<>();
        for (int i = 0; i < people.size(); i++) {
            allIndices.add(i);
        }
        Set<Integer> querySet = new HashSet<>();
        for (String word : queryWords) {
            querySet.addAll(index.get(word));
        }
        allIndices.removeAll(querySet);
        return allIndices;
    }
}
