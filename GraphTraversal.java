import java.util.*;

public class GraphTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Prompt for input or quit
            System.out.println("Enter the number of vertices (or 'q' to quit):");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("q")) {
                System.out.println("Exiting program.");
                break;
            }
            
            // Read number of vertices
            int N;
            try {
                N = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or 'q' to quit.");
                continue;
            }
            
            // Read vertices
            Map<Integer, String> nodeNames = new HashMap<>();
            System.out.println("Enter " + N + " vertices in the format 'key:node-name' (e.g., 1:Node-1):");
            for (int i = 0; i < N; i++) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                if (parts.length != 2) {
                    System.out.println("Invalid vertex format. Please use 'key:node-name'.");
                    i--;
                    continue;
                }
                try {
                    int key = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    nodeNames.put(key, name);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid key format. Key must be an integer.");
                    i--;
                }
            }
            
            // Read number of edges
            System.out.println("Enter the number of edges:");
            int M;
            try {
                M = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            
            // Read edges
            Map<Integer, List<Integer>> children = new HashMap<>();
            Map<Integer, Set<Integer>> parents = new HashMap<>();
            System.out.println("Enter " + M + " edges in the format 'source:destination' (e.g., 1:2):");
            for (int i = 0; i < M; i++) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                if (parts.length != 2) {
                    System.out.println("Invalid edge format. Please use 'source:destination'.");
                    i--;
                    continue;
                }
                try {
                    int src = Integer.parseInt(parts[0]);
                    int dest = Integer.parseInt(parts[1]);
                    children.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
                    parents.computeIfAbsent(dest, k -> new HashSet<>()).add(src);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid key format. Keys must be integers.");
                    i--;
                }
            }
            
            // Ensure all nodes have entries in parents map
            for (int key : nodeNames.keySet()) {
                parents.computeIfAbsent(key, k -> new HashSet<>());
            }
            
            // Perform iterative DFS traversal
            System.out.println("Traversal output:");
            Set<Integer> executed = new HashSet<>();
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(1); // Start from root node (key 1)
            
            while (!stack.isEmpty()) {
                int node = stack.pop();
                if (!executed.contains(node)) {
                    System.out.println(nodeNames.get(node));
                    executed.add(node);
                    // Process children in reverse order to match sample DFS order
                    if (children.containsKey(node)) {
                        List<Integer> childList = children.get(node);
                        for (int i = childList.size() - 1; i >= 0; i--) {
                            int child = childList.get(i);
                            // Push child only if all its parents are executed
                            if (parents.get(child).stream().allMatch(p -> executed.contains(p))) {
                                stack.push(child);
                            }
                        }
                    }
                }
            }
            
            // Print total number of nodes
            System.out.println(N);
            System.out.println("--- End of test case ---");
        }
        
        scanner.close();
    }
}