package esgi.fr.myaverage.models;

import java.util.ArrayList;

public class Subject {
	private int id;
    private String name;
    private ArrayList<Test> listTests;
    private double coefficient;

    public Subject(String _name){
        name = _name;
        coefficient = 1.0;
    }

    public Subject(int _id, String _name, double _coefficient){
    	id = _id;
        name = _name;
        coefficient = _coefficient;
        listTests = new ArrayList<Test>();
    }

    public ArrayList<Test> getListTests() {
		return listTests;
	}

	public void setListTests(ArrayList<Test> listTests) {
		this.listTests = listTests;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMark(double mark){
        listTests.add(new Test(mark));
    }

    public void setTest(int _id, String name, String details, double mark, double coefficient){
        listTests.add(new Test(_id, name, details, mark, coefficient));
    }

    public double getCoefficient(){
        return coefficient;
    }

    public double getAverage(){
        if (!listTests.isEmpty()){
            double sumCoeff = 0.0;
            double sum = 0;
            for (Test test : listTests){
                sum += (test.getMark() * test.getCoefficient());
                sumCoeff += test.getCoefficient();
            }
            if(sumCoeff != 0)
            	return sum / sumCoeff;
            else
            	return 0.0;
        }
        else return 0.0;
    }
}
