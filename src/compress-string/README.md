# CompressString

This project provides a simple Java class that compresses a string using a basic run-length encoding approach.

## Description

Given a string consisting of repeated characters, the `CompressString` class compresses it by replacing each run of the same character with the character followed by the number of occurrences.

### Example

```java
String input = "aabbaa";
String result = CompressString.compressString(input);
System.out.println(result);  // Output: a2b2a2
```

## How It Works

- Converts the input string to a character array.
- Traverses the array, counting consecutive characters.
- Appends each character followed by its count to a `StringBuilder`.
- Returns the resulting compressed string.

## Method Signature

```java
public static String compressString(String s)
```

## Edge Cases

- If the input string is empty, it returns the original string.
- Correctly compresses strings with disjoint repeated character groups.

## Example Usage

```java
public class Main {
    public static void main(String[] args) {
        String input = "aabbaa";
        String compressed = CompressString.compressString(input);
        System.out.println(compressed);  // Output: a2b2a2
    }
}
```

## License

This code is provided for educational and illustrative purposes.
