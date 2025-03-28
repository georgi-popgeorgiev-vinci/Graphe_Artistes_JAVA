package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utils {

    public static List<String> readLines(String path) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier : " + path);
            e.printStackTrace();
        }
        return lines;
    }



    public static void afficherChemin(List<Integer> path, Map<Integer, Artist> artistMap, Map<Integer, List<Edge>> adjacencyList) {
        System.out.println("Longueur du chemin : " + (path.size() - 1));

        double totalCost = 0.0;
        for (int i = 0; i < path.size() - 1; i++) {
            int from = path.get(i);
            int to = path.get(i + 1);
            double weight = adjacencyList.get(from).stream()
                    .filter(e -> e.to == to)
                    .map(e -> e.weight)
                    .findFirst().orElse(0.0);
            totalCost += weight;
        }

        System.out.println("Coût total du chemin : " + totalCost);
        System.out.println("Chemin :");
        for (int id : path) {
            System.out.println(artistMap.get(id));
        }
    }


}
