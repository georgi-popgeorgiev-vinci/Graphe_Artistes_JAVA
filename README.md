# Graphe_Artistes_JAVA

Projet de graphe en Java pour le cours de programmation avancée

ProjetGraphe/
│
├── data/
│ ├── artists.txt ← Liste des artistes (nœuds du graphe)
│ └── mentions.txt ← Connexions entre artistes (arêtes avec poids)
│
├── output/
│ └── output.txt ← Résultat attendu du programme (fichier fourni)
│
├── src/
│   ├── Main.java ← Point d’entrée principal (non modifiable)
│   ├── Graph.java <- Classe principale du graphe (à implémenter)
│   ├── Node.java <- Représentation d’un artiste (optionnel)
│   ├── Edge.java <- Représentation d’une arête (optionnel)
│   ├── Algorithmes.java <- Contient les algos de plus court chemin et max connexions
│   └── Utils.java ← Fonctions utilitaires (parser les fichiers, exceptions, etc.)
│
├── tests/
│   └── GraphTest.java ← Classe(s) de test pour vérifier le bon fonctionnement
│
├── README.md ← Explication rapide du projet, instructions de compilation
└── .gitignore ← Fichiers à ignorer si versionné
