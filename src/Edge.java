package src;

public class Edge {
    public int to;
    public int mentions;
    public double weight; // = 1.0 / mentions

    public Edge(int to, int mentions) {
        this.to = to;
        this.mentions = mentions;
        this.weight = 1.0 / mentions;
    }
}
