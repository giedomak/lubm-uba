package edu.lehigh.swat.bench.uba.writers.graphml;

import java.io.PrintStream;
import java.util.Map.Entry;

public class GraphMLFormatter implements PropertyGraphFormatter {

    @Override
    public void formatNode(Node n, PrintStream output) {
        output.print("  <node id=\"");
        output.print(n.getId());
        output.print('"');
        output.print(" labels=\"");
        for (int i = 0; i < n.getLabels().size(); i++) {
            if (i > 0)
                output.print(',');
            output.print(n.getLabels().get(i));
        }
        output.println("\">");

        for (Entry<String, String> kvp : n.getProperties().entrySet()) {
            output.print("    <data key=\"");
            output.print(kvp.getKey());
            output.print("\">");
            output.print(kvp.getValue());
            output.println("</data>");
        }

        output.println("  </node>\n");
    }

    @Override
    public void formatEdge(Edge e, PrintStream output) {
        output.print("  <edge source=\"");
        output.print(e.getSource());
        output.print("\" target=\"");
        output.print(e.getTarget());
        output.print("\" label=\"");
        output.print(e.getLabel());
        output.println("\"></edge>");
    }

}
