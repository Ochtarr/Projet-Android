package esgi.fr.myaverage.models;

public class Test {
	private int id;
    private String name;
    private String details;
    private double mark;
    private double coefficient;

    public Test(double _mark){
        name = "A simple test.";
        details = "No details.";
        mark = _mark;
        coefficient = 1.0;
    }

    public Test(int _id, String _name, String _details, double _mark, double _coefficient){
    	id = _id;
        name = _name;
        details = _details;
        mark = _mark;
        coefficient = _coefficient;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String _name){
        name = _name;
    }

    public void setDetails(String _details){
        details = _details;
    }

    public void setMark(double _mark){
        mark = _mark;
    }

    public void setCoeff(double _coefficient){
        coefficient = _coefficient;
    }

    public String getName(){
        return name;
    }

    public String getDetails(){
        return details;
    }

    public double getMark(){
        return mark;
    }

    public double getCoefficient(){
        return coefficient;
    }
}
