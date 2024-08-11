package graph;

import java.util.*;
import java.util.stream.Collectors;

public class Graph<T> {
    List<Edge<T>> allEdges;
    Map<T, Vertex<T>> allVertices;
    boolean isDirected;


    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
        this.allVertices = new HashMap<>();
        this.allEdges = new ArrayList<>();
    }

    public List<Edge<T>> getAllEdges() {
        return allEdges;
    }

    public Collection<Vertex<T>> getAllVertices() {
        return allVertices.values();
    }

    public boolean isDirected() {
        return isDirected;
    }

    public void addEdge(T from, T to, int weight) {
        Vertex<T> vertex1 = addVertex(from);
        Vertex<T> vertex2 = addVertex(to);
        Edge edge = new Edge(vertex1, vertex2, isDirected, weight);
        allEdges.add(edge);
        if (!vertex1.adjacentVertices.contains(vertex2)) {
            vertex1.adjacentVertices.add(vertex2);
            vertex1.edgeList.add(edge);
        }
        if (!isDirected) {
            if (!vertex2.adjacentVertices.contains(vertex1)) {
                vertex2.adjacentVertices.add(vertex1);
                vertex2.edgeList.add(edge);
            }
        }
    }

    public Vertex<T> addVertex(T data) {
        Vertex<T> vertex = null;
        if (allVertices.containsKey(data)) {
            vertex = allVertices.get(data);
        } else {
            vertex = new Vertex<T>(data);
        }
        allVertices.put(vertex.data, vertex);
        return vertex;
    }

    public boolean containsVertex(T data) {
        return allVertices.containsKey(data);
    }

    public void bfs(T source) {
        Vertex<T> root = null;
        if (allVertices.containsKey(source)) {
            root = allVertices.get(source);
        }
        Queue<Vertex<T>> qu = new LinkedList<>();
        qu.offer(root);
        Set<Vertex> visited = new HashSet<>();
        while (!qu.isEmpty()) {
            Vertex<T> curr = qu.poll();
            if (visited.contains(curr)) {
                continue;
            }
            visited.add(curr);
            System.out.println("Parent " + curr.data + " ");
            for (Vertex adjacentVertex : curr.adjacentVertices) {
                if (!visited.contains(adjacentVertex)) {
                    qu.offer(adjacentVertex);
                    System.out.print(adjacentVertex.data + " ");
                }
            }
            System.out.println();
        }
    }

    public void dfs(T source) {
        if (!allVertices.containsKey(source)) {
            return;
        }
        Set<Vertex<T>> visited = new HashSet<>();
        Stack<Vertex<T>> stack = new Stack<>();
        stack.add(allVertices.get(source));
        dfs(visited, stack);
    }

    private void dfs(Set<Vertex<T>> visited, Stack<Vertex<T>> stack) {
        Vertex<T> curr = stack.pop();
        if (visited.contains(curr)) {
            return;
        }
        System.out.println("curr " + curr.data);
        visited.add(curr);
        for (Vertex<T> v : curr.adjacentVertices) {
            stack.push(v);
            System.out.println(v.data + " ");
            dfs(visited, stack);
        }
        System.out.println();
    }

    public Set<T> getAdjacencentVertices(T vertex) {
        if (allVertices.containsKey(vertex)) {
            return allVertices.get(vertex).adjacentVertices.stream().map(e -> e.data).collect(Collectors.toSet());
        } else {
            return new HashSet<>();
        }
    }

    public <T> boolean containsEdge(Edge<T> edge) {
        return allEdges.contains(edge);
    }

    public Vertex<T> getVertex(T data) {
        if (allVertices.containsKey(data)) {
            return allVertices.get(data);
        }
        return null;
    }
}
