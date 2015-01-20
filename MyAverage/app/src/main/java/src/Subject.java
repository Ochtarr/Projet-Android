package src;

import java.util.ArrayList;

/**
 * Created by Dimitri on 20/01/2015.
 */
public class Subject {
    private String name;
    private ArrayList<Double> listMarks;
    private int coeff;

    public Subject(String _name, int _coeff){
        name = _name;
        coeff = _coeff;
    }

    public void setMark(double mark){
        listMarks.add(mark);
    }

    public int getCoeff(){
        return coeff;
    }

    public double getAverage(){
        if (!listMarks.isEmpty()){
            double sum = 0;
            for (double mark : listMarks){
                sum += mark;
            }
            return sum / listMarks.size();
        }
        else return 0;
    }
}
