import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import javafx.scene.Node;

public class Graph {

    private String artistsFile;
    private String mentionsFile;

    public Graph(String artistsFile, String mentionsFile) {
        this.artistsFile = artistsFile;
        this.mentionsFile = mentionsFile;
    }

    

    public String trouverCheminLePlusCourt (String artiste, String artiste2){
        Map<String, String> distance = new HashMap<>();
        Map<String, String> precedent = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingDouble(null));
        return null;

        /*for (String artist : adjacencyList.keySet()) {
            distance.put(artist, Double.MAX_VALUE);
        }

        distance.put(artiste, 0.0);
        queue.add(new Node(artiste, 0.0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if(current.artist.equals(artiste2)){
                break;
            }
            for(Edge edge : adjacencyList.getOrDefault(current.artist, new Graph(artiste, artiste2))){
                double newMentions = mentionsFile.get(current.artist) + edge.mentions;
                if(newMentions < mentionsFile.get(edge.artist)){
                    distance.put(edge.artist, newMentions);
                    precedent.put(edge.artist, current.artist);
                    queue.add(new Node(edge.artist, newMentions));
                }



                
            }   
            
        }
        if (!mentionsFile.contains(artiste2) || mentionsFile.get(artiste2) == 0.0) {
            throw new IllegalArgumentException("Aucun chemin entre " + artiste + " et " + artiste2);
            
        }

        printpath(artiste, artiste2, precedent, distance.get(artiste2));*/
        

    
    }

    public String trouverCheminMaxMentions (String artiste, String artiste2){
        return null;
    }


}
