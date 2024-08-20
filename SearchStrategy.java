package search;

import java.util.List;
import java.util.Set;

public interface SearchStrategy {
    Set<Integer> search(List<Person> people, List<String> queryWords, InvertedIndex index);
}
