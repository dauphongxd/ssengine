package search;

import java.util.*;

public class AllSearchStrategy implements SearchStrategy {

    @Override
    public Set<Integer> search(List<Person> people, List<String> queryWords, InvertedIndex index) {
        List<Set<Integer>> querySets = new ArrayList<>();
        for (String word : queryWords) {
            querySets.add(new HashSet<>(index.get(word)));
        }
        if (querySets.isEmpty()) {
            return new HashSet<>();
        }
        Set<Integer> resultSet = new HashSet<>(querySets.get(0));
        for (Set<Integer> set : querySets) {
            resultSet.retainAll(set);
        }
        return resultSet;
    }
}
