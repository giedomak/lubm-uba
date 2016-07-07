package edu.lehigh.swat.bench.uba.writers.graphml;

import java.io.PrintStream;

import edu.lehigh.swat.bench.uba.GeneratorCallbackTarget;

public abstract class FormattingPropertyGraphWriter extends PropertyGraphWriter {

    protected final PropertyGraphFormatter formatter;

    public FormattingPropertyGraphWriter(GeneratorCallbackTarget callbackTarget, PropertyGraphFormatter formatter) {
        super(callbackTarget);
        if (formatter == null)
            throw new NullPointerException("formatter cannot be null");
        this.formatter = formatter;
    }

    @Override
    protected void writeNode(Node n) {
        this.formatter.formatNode(n, getNodeOutput());
    }

    protected PrintStream getNodeOutput() {
        return this.out;
    }
    
    protected PrintStream getEdgeOutput() {
        return this.out;
    }

    @Override
    protected void writeEdge(Edge e) {
        this.formatter.formatEdge(e, getEdgeOutput());
    }

}
