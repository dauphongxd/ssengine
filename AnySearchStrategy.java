package search;

import java.util.*;

public class AnySearchStrategy implements SearchStrategy {

    @Override
    public Set<Integer> search(List<Person> people, List<String> queryWords, InvertedIndex index) {
        Set<Integer> resultSet = new HashSet<>();
        for (String word : queryWords) {
            resultSet.addAll(index.get(word));
        }
        return resultSet;
    }
}
