<In progress>

#### ---In progress---

Introduction:

Bit manipulation involves performing operations on individual bits within a binary representation of data. This guide provides an overview of common bit manipulation techniques and steps along with examples to help you understand and utilize them effectively.

1. Bitwise Operators:
   Bitwise operators are used to perform operations at the bit level. The commonly used bitwise operators are:

   - AND (&): Performs a bitwise AND operation between two operands.
   - OR (|): Performs a bitwise OR operation between two operands.
   - XOR (^): Performs a bitwise XOR (exclusive OR) operation between two operands.
   - NOT (~): Performs a bitwise NOT (complement) operation on a single operand.
   - Left Shift (<<): Shifts the bits of the left operand to the left by a specified number of positions.
   - Right Shift (>>): Shifts the bits of the left operand to the right by a specified number of positions.
2. Common Steps for Bit Manipulation:
   Here are some common steps involved in bit manipulation:

   **a. Accessing a Specific Bit:**
   To access a specific bit in a number, use the bitwise AND operator (&) with a mask that has only that bit set.

   Example:

   ```java
   int number = 13;  // Binary: 00001101
   int mask = 1 << 2;  // Mask for accessing the 2nd bit
   int result = number & mask;  // Accessing the 2nd bit of 'number'
   ```

Intuition behind accessing a specific bit using bitwise AND operator:

To access a specific bit in a number, we can use the bitwise AND operator (&) along with a mask that has only the desired bit set to 1.

In the given example:

```cpp
int number = 13;     // Binary: 00001101
int mask = 1 << 2;   // Mask for accessing the 2nd bit
int result = number & mask;    // Accessing the 2nd bit of 'number'
```

Intuition:

1. Binary Representation:
   The binary representation of the `number` is `00001101`, which consists of 8 bits. We want to access the 2nd bit, which is the third bit from the right.
2. Creating the Mask:
   To access the 2nd bit, we create a mask by shifting the binary digit `1` two positions to the left using the bitwise left shift operator (`<<`). This results in the mask `00000100`, where only the 2nd bit is set to 1.
3. Bitwise AND Operation:
   We perform the bitwise AND operation between the `number` and the `mask` using the `&` operator. This operation sets the bits in the result to 1 only if both corresponding bits in the `number` and `mask` are 1. Otherwise, the result bit is set to 0.

   - When the `number` is ANDed with the `mask`, the result is `00000100`, where only the 2nd bit is set to 1.
4. Accessing the Desired Bit:
   The result of the bitwise AND operation gives us the value of the desired bit. In this case, the result is `00000100`, which indicates that the 2nd bit of the `number` is set to 1.

By performing the bitwise AND operation with the appropriate mask, we can effectively access a specific bit in a number.

**b. Setting a Bit:**

To set a specific bit to 1 in a number, use the bitwise OR operator (|) with a mask that has only that bit set.

Example:

```java
int number = 9;  // Binary: 00001001
int mask = 1 << 3;  // Mask for setting the 4th bit
int result = number | mask;  // Setting the 4th bit of 'number' to 1
```

c. Clearing a Bit:
To clear a specific bit to 0 in a number, use the bitwise AND operator (&) with a mask that has only that bit inverted.

Example:

```java
int number = 15;  // Binary: 00001111
int mask = ~(1 << 1);  // Mask for clearing the 2nd bit
int result = number & mask;  // Clearing the 2nd bit of 'number'
```

d. Flipping a Bit:
To flip a specific bit (change 0 to 1 or 1 to 0) in a number, use the bitwise XOR operator (^) with a mask that has only that bit set.

Example:

```java
int number = 7;  // Binary: 00000111
int mask = 1 << 2;  // Mask for flipping the 3rd bit
int result = number ^ mask;  // Flipping the 3rd bit of 'number'
```

3. Bit Manipulation Techniques:

   - Checking if a number is even or odd using bitwise AND operator:

     ```java
     boolean isEven = (number & 1) == 0;  // Check if 'number' is even
     ```
   - Swapping two numbers without using a temporary variable using XOR operator:

     ```java
     int a = 5;
     int b = 10;
     a ^= b;  // Swapping 'a' and 'b'
     b ^= a;
     a ^= b;
     ```
