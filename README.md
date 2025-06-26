# Graph Path Counter – Count Paths Ending at Each Node in a DAG

##  Description

This program processes a **Directed Acyclic Graph (DAG)** and computes, for each node, the number of distinct paths that end at it.

In particular, it:

1. Prints all valid paths in the given DAG that end at node `D` (index 3).
2. Computes, using a **topological sort and dynamic programming**, the number of paths ending at **every** node.

---

### Question 1

> List all paths in the DAG that end at node `D`.

**Answer:**
- A → B → D  
- A → C → D  
- B → C → D  
- B → D  
- C → D  
- D (length 0 path)


The program implements the following:

- Topological sorting 
- For each node `v`, the number of paths ending at `v` is computed by:
  - `dp[v] = dp[v] + dp[u]` for every edge `u → v`
- Initialization: each node starts with `dp[v] = 1` (the path consisting of itself)

---

##  Correctness Justification

- The algorithm traverses the DAG in topological order.
- For each node `v`, every path ending at its predecessors contributes new paths to `v`.
- Ensures no cycles and every `dp[v]` is computed **after** all `dp[u]` for predecessors `u`.

---

##  Time Complexity

- **Topological Sort:** O(|V| + |E|)
- **Path Count Update:** O(|E|) (each edge visited once)
- **Total Runtime:** **O(|V| + |E|)**

---

## Graph Input
![image](https://github.com/user-attachments/assets/7ad1c2ea-1157-4555-9515-6a2f79394e81)

```
        //0->A
        //1->B
        //2->C
        //3->D
        graph.get(0).add(1);
        graph.get(1).add(3);
        graph.get(1).add(2);
        graph.get(2).add(3);
```

##  Example Output
```
Number of paths ending at each node:
A: 1
B: 2
C: 3
D: 6
```

# Question 2

# Even Red Cells Coloring – Dynamic Programming Solution

## 📘 Problem Description

Given an array of size `n`, each cell can be colored in one of three colors: **Red**, **Blue**, or **Green**.  
The task is to count how many different ways we can color the array such that the number of **Red-colored** cells is **even**.

---

## ✅ Section A – Recursive Formula

## Output: 
```
======== Section A ==========
T(0) = 1
T(1) = 2
T(2) = 5
T(3) = 14
T(4) = 41
T(5) = 122
T(6) = 365
T(7) = 1094
T(8) = 3281
T(9) = 9842
T(10) = 29525
======== Section B ==========
T(0) = 1
T(1) = 2
T(2) = 5
T(3) = 14
T(4) = 41
T(5) = 122
T(6) = 365
T(7) = 1094
T(8) = 3281
T(9) = 9842
T(10) = 29525
Total Cost Section B: O(N)

```







