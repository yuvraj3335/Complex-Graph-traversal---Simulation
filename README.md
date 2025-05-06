Graph Traversal Program
Overview
This Java program implements a complex graph traversal algorithm for a directed graph with a tree-like structure, where nodes may diverge (have multiple children) and converge (have multiple parents). Each node performs a simple task: printing its name. The traversal ensures that a node is executed only after all its parent nodes have been executed, and if a node has multiple children, they are traversed in parallel (simulated sequentially using a stack). The program accepts multiple test cases in a loop until the user decides to quit by entering 'q'.
What It Does

Input Parsing: Reads the graph structure from user input in a specific format.
Graph Construction: Builds a directed graph using adjacency lists for children and sets for parents.
Traversal: Performs an iterative Depth-First Search (DFS) starting from the root node (key 1), ensuring dependency constraints are met.
Output: Prints the names of the nodes in the order they are traversed, followed by the total number of nodes.
Looping: Continues to accept and process test cases until the user enters 'q'.

Logic Explanation
Graph Construction

Vertices: Stored in a Map<Integer, String> mapping node keys to their names.
Edges: 
Children are stored in a Map<Integer, List<Integer>>, where each key maps to a list of its child nodes.
Parents are stored in a Map<Integer, Set<Integer>>, where each key maps to a set of its parent nodes.


This dual representation ensures efficient tracking of dependencies (parents) and successors (children).

Traversal Algorithm

Iterative DFS with Stack: Uses a Deque<Integer> to simulate DFS iteratively, avoiding recursion.
Dependency Check: A node is executed only if all its parents have been executed (checked using the parents map).
Parallel Simulation: When a node has multiple children, they are pushed onto the stack in reverse order (to match the sample output's DFS order). This simulates parallel execution in a sequential environment.
Execution Tracking: A Set<Integer> tracks executed nodes to prevent re-execution.

Program Flow

Prompt the user for the number of vertices or 'q' to quit.
If 'q' is entered, exit the program.
Read the number of vertices ( N ), followed by ( N ) lines of vertex details in the format key:node-name.
Read the number of edges ( M ), followed by ( M ) lines of edge details in the format source:destination.
Construct the graph and perform the traversal.
Print the node names in traversal order, followed by the total number of nodes.
Repeat from step 1.

Setup and Run Instructions
Prerequisites

Java Development Kit (JDK): Ensure you have JDK 8 or higher installed.
Text Editor or IDE: Any text editor (e.g., VS Code) or Java IDE (e.g., IntelliJ IDEA, Eclipse).

Steps to Run

Save the Code:

Copy the Java code into a file named GraphTraversal.java.


Compile the Code:

Open a terminal in the directory containing GraphTraversal.java.
Run the following command:javac GraphTraversal.java


This will compile the code and generate a GraphTraversal.class file.


Run the Program:

Execute the compiled program with:java GraphTraversal


The program will start prompting for input.


Provide Input:

Follow the prompts to enter the number of vertices, vertex details, number of edges, and edge details.
To stop the program, enter q when prompted for the number of vertices.



Input Format

Number of Vertices: An integer ( N ), or q to quit.
Vertices: ( N ) lines, each in the format key:node-name (e.g., 1:Node-1).
Number of Edges: An integer ( M ).
Edges: ( M ) lines, each in the format source:destination (e.g., 1:2).

Output Format

Node names in the order of traversal, one per line.
Total number of nodes (( N )).
A separator line --- End of test case --- after each test case.

Example Test Cases
Test Case 1: Sample Input from Problem
Input:
Enter the number of vertices (or 'q' to quit):
5
Enter 5 vertices in the format 'key:node-name' (e.g., 1:Node-1):
1:Node-1
2:Node-2
3:Node-3
4:Node-4
5:Node-5
Enter the number of edges:
5
Enter 5 edges in the format 'source:destination' (e.g., 1:2):
1:2
1:3
2:4
2:5
3:5

Expected Output:
Traversal output:
Node-1
Node-2
Node-4
Node-3
Node-5
5
--- End of test case ---

Explanation:

Node-1 (key 1) is the root and executed first.
Node-2 and Node-3 are children of Node-1 and can be executed next (simulated in parallel).
Node-4 is a child of Node-2 and executed after Node-2.
Node-5 has parents Node-2 and Node-3, so it waits until both are executed.

Test Case 2: Linear Graph
Input:
Enter the number of vertices (or 'q' to quit):
3
Enter 3 vertices in the format 'key:node-name' (e.g., 1:Node-1):
1:Node-1
2:Node-2
3:Node-3
Enter the number of edges:
2
Enter 2 edges in the format 'source:destination' (e.g., 1:2):
1:2
2:3

Expected Output:
Traversal output:
Node-1
Node-2
Node-3
3
--- End of test case ---

Explanation:

A simple linear graph: 1 → 2 → 3.
Nodes are executed in order: Node-1, Node-2, Node-3.

Test Case 3: Multiple Children from Root
Input:
Enter the number of vertices (or 'q' to quit):
4
Enter 4 vertices in the format 'key:node-name' (e.g., 1:Node-1):
1:Node-A
2:Node-B
3:Node-C
4:Node-D
Enter the number of edges:
3
Enter 3 edges in the format 'source:destination' (e.g., 1:2):
1:2
1:3
1:4

Expected Output:
Traversal output:
Node-A
Node-B
Node-C
Node-D
4
--- End of test case ---

Explanation:

Node-A (key 1) has three children: Node-B, Node-C, and Node-D.
After Node-A is executed, its children are processed in the order they are popped from the stack (simulating parallelism).

Quitting the Program
Input:
Enter the number of vertices (or 'q' to quit):
q

Expected Output:
Exiting program.

Notes

The program assumes the starting node always has the key 1, as specified in the problem.
It handles invalid inputs gracefully by prompting the user to correct their input.
The traversal order may vary for nodes at the same level (e.g., children of the same parent), but the dependency constraint (parents executed before children) is always maintained.

