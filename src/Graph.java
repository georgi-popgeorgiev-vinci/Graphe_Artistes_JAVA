package src;

import java.util.*;
import static src.Utils.*; // Importe les méthodes statiques de Utils

public class Graph {
    // Stocke les artistes : ID → Artist
    private Map<Integer, Artist> artists = new HashMap<>();
    // Pour rechercher l’ID via le nom
    private Map<String, Integer> nameToId = new HashMap<>();
    // Graphe : ID source → liste d’arêtes sortantes
    private Map<Integer, List<Edge>> adjacencyList = new HashMap<>();

    // Constructeur : charge les fichiers
    public Graph(String artistsFile, String mentionsFile) {
        loadArtists(artistsFile);
        loadMentions(mentionsFile);
    }

    // Lecture du fichier artists.txt
    private void loadArtists(String path) {
        List<String> lines = readLines(path);
        for (String line : lines) {
            String[] parts = line.split(",", 3);
            if (parts.length < 3) continue;

            int id = Integer.parseInt(parts[0].trim());
            String name = parts[1].trim();
            String categories = parts[2].trim();

            Artist artist = new Artist(id, name, categories);
            artists.put(id, artist);
            nameToId.put(name, id);
        }
    }

    // Lecture du fichier mentions.txt
    private void loadMentions(String path) {
        List<String> lines = readLines(path);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length != 3) continue;

            int from = Integer.parseInt(parts[0].trim());
            int to = Integer.parseInt(parts[1].trim());
            int mentions = Integer.parseInt(parts[2].trim());

            adjacencyList
                    .computeIfAbsent(from, k -> new ArrayList<>())
                    .add(new Edge(to, mentions));
        }
    }

    public void trouverCheminLePlusCourt(String a, String b) {
        List<Integer> path = Dijkstra.findShortestPath(adjacencyList, getIdOrThrow(a), getIdOrThrow(b));
        afficherChemin(path, artists, adjacencyList);
    }

    public void trouverCheminMaxMentions(String a, String b) {
        List<Integer> path = Dijkstra.findStrongestConnection(adjacencyList, getIdOrThrow(a), getIdOrThrow(b));
        afficherChemin(path, artists, adjacencyList);
    }


    // Si l’artiste n’existe pas, on lève une erreur
    private int getIdOrThrow(String name) {
        Integer id = nameToId.get(name);
        if (id == null) throw new RuntimeException("Artiste introuvable : " + name);
        return id;
    }
}
