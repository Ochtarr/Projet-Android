package src;

import java.util.ArrayList;

/**
 * Created by Dimitri on 20/01/2015.
 */
public class Promotion {
    private String name;
    private ArrayList<Subject> listSubjects;

    public Promotion(String _name){
        name = _name;
    }

    public void setSubject(Subject subject){
        listSubjects.add(subject);
    }

    public double getGlobalAverage(){
        if(!listSubjects.isEmpty()){
            double sum = 0;
            int sumCoeff = 0;
            for (Subject subject : listSubjects){
                sum += subject.getAverage();
                sumCoeff += subject.getCoeff();
            }
            return sum / sumCoeff;
        }
        else return 0;
    }
}
