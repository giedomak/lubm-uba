package edu.lehigh.swat.bench.uba.writers.pgraph.json;

import java.io.PrintStream;
import java.util.Map.Entry;

import edu.lehigh.swat.bench.uba.writers.graphml.Edge;
import edu.lehigh.swat.bench.uba.writers.graphml.Node;
import edu.lehigh.swat.bench.uba.writers.graphml.PropertyGraphFormatter;

public class JsonFormatter implements PropertyGraphFormatter {

    @Override
    public void formatNode(Node n, PrintStream output) {
        output.print("{ \"id\" : \"");
        output.print(n.getId());
        output.print('"');
        
        for (Entry<String, String> kvp : n.getProperties().entrySet()) {
            output.print(", \"");
            output.print(kvp.getKey());
            output.print("\" : \"");
            output.print(kvp.getValue());
            output.print('"');
        }
        output.print(" }");
    }

    @Override
    public void formatEdge(Edge e, PrintStream output) {
        output.print("{ \"source\" : \"");
        output.print(e.getSource());
        output.print("\", \"target\" : \"");
        output.print(e.getTarget());
        output.print("\", \"type\" : \"");
        output.print(e.getLabel());
        output.print("\" }");
    }

}
