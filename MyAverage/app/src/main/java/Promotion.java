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
        if(listSubjects != null){
            double sum = 0;
            int sumCoefficient = 0;
            for (Subject subject : listSubjects){
                sum += subject.getAverage();
                sumCoefficient += subject.getCoefficient();
            }
            return sum / sumCoefficient;
        }
        else return 0;
    }
}
