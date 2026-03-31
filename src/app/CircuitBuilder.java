package app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import electronique.CircuitParallele;
import electronique.CircuitSerie;
import electronique.Composant;
import electronique.Resistance;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CircuitBuilder {
    private String Chemin;
    public CircuitBuilder(String cheminDuFichier) {
this.Chemin=cheminDuFichier;

    }

    public Composant construireCircuit() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode donneesCircuit = mapper.readTree(new File(Chemin));
            return lireComposant(donneesCircuit);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private Composant lireComposant(JsonNode node) {
        String type = node.get("type").asText();

        if ("resistance".equals(type)) {
            return new Resistance(node.get("valeur").asDouble());
        } else if ("serie".equals(type)) {
            List<Composant> composants = new ArrayList<>();
            for (JsonNode composantNode : node.get("composants")) {
                composants.add(lireComposant(composantNode));
            }
            return new CircuitSerie(composants);
        } else if ("parallele".equals(type)) {
            List<Composant> composants = new ArrayList<>();
            for (JsonNode composantNode : node.get("composants")) {
                composants.add(lireComposant(composantNode));
            }
            return new CircuitParallele(composants);
        }
        throw new IllegalArgumentException("Type de composante inconnu : " + type);
    }
}
