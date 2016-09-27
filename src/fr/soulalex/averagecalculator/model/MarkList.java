package fr.soulalex.averagecalculator.model;

import java.util.ArrayList;

/**
 * Created by Alexis on 29/04/2016.
 */
public class MarkList extends ArrayList<Mark> {

    public double getAverage() {
        double sum = 0.0;
        double sumCoeff = 0.0;

        for (Mark m : this) {
            sum += (m.getMarkWithMax(20) * m.getCoeff());
            sumCoeff += m.getCoeff();
        }

        return (sum / sumCoeff);
    }
}
