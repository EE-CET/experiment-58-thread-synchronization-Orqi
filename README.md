[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/4GxD8PFM)
# Experiment 58: Thread Synchronization

## Problem Statement

Write a program to print the multiplication table of a number using a `synchronized` method.
Create two threads that attempt to print the table of 5 and 100 respectively.

**Requirement:** The output must not be interleaved. One thread should complete printing its table before the other starts.

## Input Format

* No Input.

## Output Format

* Multiplication table of 5 followed by table of 100 (or vice versa).
* Print in the format: `n * i = result` or just the multiples as shown in the example (depending on interpretation, but usually full tables or just numbers).
* **Based on Sample Output in manual:** `5 10 15 20 25 ...`

### Sample Output

```text
5 10 15 20 25
100 200 300 400 500
```
*(Note: This sample shows first 5 multiples. Your program should likely print a standard number, e.g., 5 or 10 multiples).*
