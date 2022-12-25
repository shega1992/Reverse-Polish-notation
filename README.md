# Reverse-Polish-notation
The idea for the mini - project is taken from **Crafting Interpreters** book(see Challenge 3 from Chapter 5) https://craftinginterpreters.com. This is my first attempt to write a Java project, so my code is probably not perfect.
## What is in this program?
Basically this program does two things:
1. Сonverts an  arithmetic expression from infix to postfix notation.
2. Calculates the result of a postfix expression.
## How to use this program?
To compile: **javac RpnTest.java**

There are several operators that you can use in an expression:

1. **(** **)**  grouping

2. **^**  exponentiation

3. **\***  multiplication

4. **\\**  division

5. **+**  addition

6. **-**  subtraction

Unary operators are not available in this project. Respectively
```
-34 + 15
```
is not correct expression. Use
```
15 - 34 
```
The program has an interactive menu that will help you when using it.
## Footnotes
There are a few things I would like to mention here:

1. I use two different approaches when handling errors: something similar to the **C** style with a null value return when translating an expression from infix to postfix notation and an exception mechanism when calculating the result of an expression.

2. The **C** style mechanism handles cases of inconsistent parentheses in the expression, as well as the appearance of unexpected characters in the expression. In such cases, the null value is returned instead of the resulting string and the result of the expression is not evaluated.

3. The exception mechanism is used to handle the case of a unary operator appearing in an expression, as well as the case of division by zero.  The evaluation function returns **-1** in such cases. I did not implement an exception handling mechanism for the case when the user enters something other than a digit in the program menu.
