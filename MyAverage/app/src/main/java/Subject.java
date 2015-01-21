import java.util.ArrayList;

/**
 * Created by Dimitri on 20/01/2015.
 */
public class Subject {
    private String name;
    private ArrayList<Double> listMarks;
    private float coefficient;

    public Subject(String _name, float _coefficient){
        name = _name;
        coefficient = _coefficient;
    }

    public void setMark(double mark){
        listMarks.add(mark);
    }

    public float getCoefficient(){
        return coefficient;
    }

    public double getAverage(){
        if (!listMarks.isEmpty()){
            double sum = 0.0;
            for (double mark : listMarks){
                sum += mark;
            }
            return sum / listMarks.size();
        }
        else return -1.0;
    }
}
