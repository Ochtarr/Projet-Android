package src;

import java.util.ArrayList;

public class Promotion {
    private String name;
    private ArrayList<Subject> listSubjects;

    public Promotion(String _name){
        name = _name;
    }

    public void setSubject(String name){
        listSubjects.add(new Subject(name));
    }

    public double getGlobalAverage(){
        if(!listSubjects.isEmpty()){
            double sum = 0.0;
            double sumCoeff = 0.0;
            for (Subject subject : listSubjects){
                sum += subject.getAverage();
                sumCoeff += subject.getCoefficient();
            }
            return sum / sumCoeff;
        }
        else return 0;
    }
}
