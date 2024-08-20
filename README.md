# Java Search Application

This Java application implements a simple search engine that allows users to search for people based on their names or email addresses using different search strategies.

## Table of Contents
- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Search Strategies](#search-strategies)
- [File Structure](#file-structure)
- [Contributing](#contributing)
- [License](#license)

## Features

- Search for people using different strategies (ALL, ANY, NONE)
- Print all people in the database
- Inverted index for efficient searching
- Command-line interface

## Requirements

- Java Development Kit (JDK) 8 or higher
- A text file containing people's information (name and email)

## Installation

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/java-search-application.git
   ```

2. Navigate to the project directory:
   ```
   cd java-search-application
   ```

3. Compile the Java files:
   ```
   javac search/*.java
   ```

## Usage

To run the application, use the following command:

```
java search.Main --data <path_to_data_file>
```

Replace `<path_to_data_file>` with the path to your text file containing people's information.

### Example Usage

1. Start the application:
   ```
   java search.Main --data data.txt
   ```

2. The main menu will be displayed:
   ```
   === Menu ===
   1. Find a person
   2. Print all people
   0. Exit
   ```

3. To search for a person, enter `1` and follow the prompts:
   ```
   Select a matching strategy: ALL, ANY, NONE
   ALL
   Enter a name or email to search all suitable people:
   Erick
   ```

4. The application will display the search results based on the chosen strategy.

5. To print all people in the database, enter `2` at the main menu.

6. To exit the application, enter `0` at the main menu.

### Example Output

Here's an example of what the output might look like when using different search strategies:

1. Using the ALL strategy:
   ```
   === Menu ===
   1. Find a person
   2. Print all people
   0. Exit
   1

   Select a matching strategy: ALL, ANY, NONE
   ALL
   Enter a name or email to search all suitable people:
   Erick Harrington
   Erick Harrington harrington@gmail.com
   ```

2. Using the ANY strategy:
   ```
   === Menu ===
   1. Find a person
   2. Print all people
   0. Exit
   1

   Select a matching strategy: ALL, ANY, NONE
   ANY
   Enter a name or email to search all suitable people:
   Erick
   Erick Harrington harrington@gmail.com
   Erick Burgess
   ```

3. Using the NONE strategy:
   ```
   === Menu ===
   1. Find a person
   2. Print all people
   0. Exit
   1

   Select a matching strategy: ALL, ANY, NONE
   NONE
   Enter a name or email to search all suitable people:
   Erick Dwight
   Rene Webb webb@gmail.com
   Katie Jacobs
   Myrtle Medina
   ```

4. Printing all people:
   ```
   === Menu ===
   1. Find a person
   2. Print all people
   0. Exit
   2

   === List of people ===
   Dwight Joseph djo@gmail.com
   Rene Webb webb@gmail.com
   Katie Jacobs
   Erick Harrington harrington@gmail.com
   Myrtle Medina
   Erick Burgess
   ```

## Search Strategies

The application supports three search strategies:

1. ALL: Returns people who match all the query words.
2. ANY: Returns people who match any of the query words.
3. NONE: Returns people who don't match any of the query words.

## File Structure

- `Main.java`: Contains the main application logic and user interface.
- `Person.java`: Defines the Person class to store individual's information.
- `InvertedIndex.java`: Implements the inverted index for efficient searching.
- `SearchStrategy.java`: Defines the interface for search strategies.
- `AllSearchStrategy.java`: Implements the ALL search strategy.
- `AnySearchStrategy.java`: Implements the ANY search strategy.
- `NoneSearchStrategy.java`: Implements the NONE search strategy.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is open source and available under the [MIT License](LICENSE).
