# ReverseString

This Java program demonstrates two methods for reversing the order of words in a sentence:

1. **In-place reversal** using a `char[]` array.
2. *(Optional)* String-based reversal using a helper method (commented out in this version).

## 🔧 How It Works

The in-place method follows these steps:

1. Reverse the entire character array.
2. Reverse each word individually within the array.

This avoids using extra space for word arrays or string splitting — everything is done in-place, character by character.

## ✅ Example Output

```
Input:  "hello world here"
Output: "here world hello"

Input:  "one two three four"
Output: "four three two one"

Input:  "singleword"
Output: "singleword"

Input:  "  leading and  multiple   spaces  "
Output: "  spaces   multiple  and leading  "
```

> ⚠️ *Note:* Extra spacing is preserved — no trimming or collapsing is performed. This is intentional to keep the method purely in-place and non-destructive.

## 🧪 Testing

All functionality is tested with:
- Multi-word sentences
- Single-word input
- Sentences with leading, trailing, and multiple spaces

You can add unit tests via JUnit in a separate test file to validate edge cases and spacing behavior.

## 📁 Files

- `ReverseString.java` — main logic with test cases printed to console
- `ReverseStringTest.java` — contains unit tests using JUnit
