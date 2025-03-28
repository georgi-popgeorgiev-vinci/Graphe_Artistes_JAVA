package src;

import java.util.*;

public class Dijkstra {

    // Chemin le plus court en nombre de noeuds (BFS classique)
    public static List<Integer> findShortestPath(Map<Integer, List<Edge>> adjacencyList, int start, int end) {
        Map<Integer, Integer> prev = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == end) break;

            for (Edge edge : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(edge.to)) {
                    visited.add(edge.to);
                    prev.put(edge.to, current);
                    queue.add(edge.to);
                }
            }
        }

        if (!prev.containsKey(end)) {
            throw new RuntimeException("Aucun chemin entre les artistes.");
        }

        LinkedList<Integer> path = new LinkedList<>();
        for (Integer at = end; at != null; at = prev.get(at)) {
            path.addFirst(at);
        }
        return path;
    }

    // Chemin le plus fortement connecté (poids minimal = 1 / mentions)
    public static List<Integer> findStrongestConnection(Map<Integer, List<Edge>> adjacencyList, int start, int end) {
        Map<Integer, Double> dist = new HashMap<>();
        Map<Integer, Integer> prev = new HashMap<>();

        Comparator<Integer> comparator = Comparator.comparingDouble(dist::get);
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);

        for (Integer node : adjacencyList.keySet()) {
            dist.put(node, Double.POSITIVE_INFINITY);
        }

        dist.put(start, 0.0);
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == end) break;

            for (Edge edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                double cost = 1.0 / edge.mentions; // plus il y a de mentions, plus le lien est fort (coût faible)
                double alt = dist.get(current) + cost;

                if (alt < dist.getOrDefault(edge.to, Double.POSITIVE_INFINITY)) {
                    dist.put(edge.to, alt);
                    prev.put(edge.to, current);
                    queue.add(edge.to);
                }
            }
        }

        if (!prev.containsKey(end)) {
            throw new RuntimeException("Aucun chemin entre les artistes.");
        }

        LinkedList<Integer> path = new LinkedList<>();
        for (Integer at = end; at != null; at = prev.get(at)) {
            path.addFirst(at);
        }
        return path;
    }
}
