# Graph Traversal Program

## 📝 Overview
This Java program implements a complex graph traversal for a directed graph with a tree-like structure, where nodes may diverge (multiple children) and converge (multiple parents).  
Each node performs a simple task: **printing its name**.

The program:
- Ensures nodes execute **only after all parent nodes are executed**.
- Simulates **parallel execution of child nodes** using a **stack (DFS)**.
- Runs in a loop, accepting multiple test cases until the user enters `'q'` to quit.

---

## ⚙️ What It Does

- **Input Parsing:** Reads number of vertices, vertex details, number of edges, and edge details.
- **Graph Construction:** Builds a directed graph using maps for node names, children, and parents.
- **Traversal:** Iterative DFS starting from root node (`key = 1`), respecting parent dependencies.
- **Output:** Prints traversal order and node count.
- **Looping:** Continues until user enters `'q'`.

---

## 🧠 Logic Explanation

### 🔧 Graph Construction

- **Vertices:**  
  `Map<Integer, String>` — e.g., `{1: "Node-1"}`  
- **Edges:**
  - **Children:** `Map<Integer, List<Integer>>` — e.g., `{1: [2, 3]}`
  - **Parents:** `Map<Integer, Set<Integer>>` — e.g., `{5: {2, 3}}`  

This structure supports efficient dependency and successor tracking.

---

### 🔁 Traversal Algorithm

- **Iterative DFS with Stack:**
  - Uses `Deque<Integer>` to simulate DFS.
  - Starts from the root node (`key = 1`).

- **Dependency Check:**
  - Node executes **only if all its parents have been executed**.

- **Parallel Simulation:**
  - Multiple children pushed onto the stack **in reverse order** to simulate DFS.

- **Execution Tracking:**
  - A `Set<Integer>` ensures each node executes **only once**.

---

## 🔄 Program Flow

1. Prompt user for number of vertices or `'q'` to quit.
2. If `'q'` is entered, exit.
3. Read `N` vertices: `key:node-name`.
4. Read `M` edges: `source:destination`.
5. Construct the graph and perform traversal.
6. Print node names in order + total node count.
7. Repeat for next test case.

---

## 🚀 Setup and Run Instructions

### ✅ Prerequisites
- **Java Development Kit (JDK)**: Version 8 or higher.
- **Text Editor / IDE**: VS Code, IntelliJ, Eclipse, etc.

---

### 📦 Steps to Run

#### 1. Save the Code
- Save Java code as: `GraphTraversal.java`.

#### 2. Compile the Code
```bash
javac GraphTraversal.java


java GraphTraversal

Traversal output:
<Node-Names in DFS order>
<Total number of nodes>
--- End of test case ---

5
1:Node-1
2:Node-2
3:Node-3
4:Node-4
5:Node-5
5
1:2
1:3
2:4
2:5
3:5

Traversal output:
Node-1
Node-2
Node-4
Node-3
Node-5
5
--- End of test case ---
