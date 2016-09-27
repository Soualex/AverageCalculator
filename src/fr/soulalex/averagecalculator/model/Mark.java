package fr.soulalex.averagecalculator.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Created by Alexis on 29/04/2016.
 */
public class Mark {
    private DoubleProperty mark;
    private DoubleProperty max;
    private DoubleProperty coeff;

    public Mark(double mark, double max, double coeff) {
        this.mark  = new SimpleDoubleProperty(mark);
        this.max   = new SimpleDoubleProperty(max);
        this.coeff = new SimpleDoubleProperty(coeff);
    }

    public double getMark() {
        return mark.get();
    }

    public double getMax() {
        return max.get();
    }

    public double getCoeff() {
        return coeff.get();
    }

    public double getMarkWithMax(double max) {
        return this.mark.get() / this.max.get() * max;
    }

    public DoubleProperty markProperty() {
        return mark;
    }

    public DoubleProperty maxProperty() {
        return max;
    }

    public DoubleProperty coeffProperty() {
        return coeff;
    }
}
