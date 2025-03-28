package src;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph("data/artists.txt", "data/mentions.txt");

        System.out.println("Chemin le moins long :");
        graph.trouverCheminLePlusCourt("The Beatles", "Kendji Girac");

        System.out.println("--------------------------");

        System.out.println("Chemin le plus fortement connecté :");
        graph.trouverCheminMaxMentions("The Beatles", "Kendji Girac");

    }
}

