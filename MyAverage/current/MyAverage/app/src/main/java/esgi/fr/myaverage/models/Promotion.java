package esgi.fr.myaverage.models;

import java.util.ArrayList;


public class Promotion{
    private String name;
    private ArrayList<Subject> listSubjects;

    public Promotion(String _name){
        name = _name;
        listSubjects = new ArrayList<Subject>();
    }

    public void setSubject(Subject _s){
        listSubjects.add(_s);
    }

    public ArrayList<Subject> getListSubjects() {
		return listSubjects;
	}

	public void setListSubjects(ArrayList<Subject> listSubjects) {
		this.listSubjects = listSubjects;
	}

	public double getGlobalAverage(){
        if(!listSubjects.isEmpty()){
            double sum = 0.0;
            double sumCoeff = 0.0;
            for (Subject subject : listSubjects){
            	if(subject.getAverage() > 1.f)
            		sum += subject.getAverage();
                sumCoeff += subject.getCoefficient();
            }
            if(sumCoeff != 0)
            	return sum / sumCoeff;
            else
            	return 0.0;
        }
        else return 0;
    }

}
