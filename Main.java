package search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (args.length != 2 || !args[0].equals("--data")) {
            return;
        }

        String filePath = args[1];
        List<Person> people = new ArrayList<>();
        InvertedIndex invertedIndex = new InvertedIndex();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineIndex = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split(" ");
                String firstName = parts[0];
                String lastName = parts.length > 1 ? parts[1] : null;
                String email = parts.length > 2 ? parts[2] : null;

                people.add(new Person(firstName, lastName, email));

                for (String word : parts) {
                    invertedIndex.add(word, lineIndex);
                }

                lineIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            menu();
            int input = sc.nextInt();
            sc.nextLine();
            if (input == 1) {
                System.out.println();
                System.out.println("Select a matching strategy: ALL, ANY, NONE");
                String strategyInput = sc.nextLine().toUpperCase();

                System.out.println("Enter a name or email to search all suitable people:");
                String query = sc.nextLine().toLowerCase();
                List<String> queryWords = Arrays.asList(query.split("\\s+"));

                SearchStrategy strategy;
                switch (strategyInput) {
                    case "ALL":
                        strategy = new AllSearchStrategy();
                        break;
                    case "ANY":
                        strategy = new AnySearchStrategy();
                        break;
                    case "NONE":
                        strategy = new NoneSearchStrategy();
                        break;
                    default:
                        System.out.println("Invalid strategy!");
                        continue;
                }

                Set<Integer> foundIndices = strategy.search(people, queryWords, invertedIndex);

                if (foundIndices.isEmpty()) {
                    System.out.println("No matching people found.");
                } else {
                    for (Integer index : foundIndices) {
                        System.out.println(people.get(index));
                    }
                }

            } else if (input == 2) {
                System.out.println();
                System.out.println("=== List of people ===");
                for (Person person : people) {
                    System.out.println(person);
                }
            } else if (input == 0) {
                System.out.println();
                System.out.println("Bye!");
                break;
            } else {
                System.out.println();
                System.out.println("Incorrect option! Try again.");
            }
        }
    }

    public static void menu() {
        System.out.println();
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }
}
