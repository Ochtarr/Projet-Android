package esgi.fr.myaverage;

import java.util.ArrayList;

import esgi.fr.myaverage.models.Test;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class MarksListener implements OnClickListener {
	
	private int subject_id;
	private ArrayList<Test> mySubject;
	
	public MarksListener(int _id, ArrayList<Test> _mySubject)
	{
		subject_id = _id;
		mySubject = _mySubject;
	}
	@Override
	public void onClick(View v) {
		Intent i = new Intent(v.getContext(), TestActivity.class);
		i.putExtra("ID_SUBJECT",new String(""+subject_id));
		switch (v.getId()) 
		{
			case R.id.button_mark1:
				i.putExtra("ID_MARK",new String(""+1));
				i.putExtra("VALUE_MARK", getValueMark(1));
				i.putExtra("COEF_MARK", getCoefMark(1));
				break;
			case R.id.button_mark2:
				i.putExtra("ID_MARK",new String(""+2));
				i.putExtra("VALUE_MARK", getValueMark(2));
				i.putExtra("COEF_MARK", getCoefMark(2));
				break;
			case R.id.button_mark3:
				i.putExtra("ID_MARK",new String(""+3));
				i.putExtra("VALUE_MARK", getValueMark(3));
				i.putExtra("COEF_MARK", getCoefMark(3));
				break;
			case R.id.button_mark4:
				i.putExtra("ID_MARK",new String(""+4));
				i.putExtra("VALUE_MARK", getValueMark(4));
				i.putExtra("COEF_MARK", getCoefMark(4));
				break;
			case R.id.button_mark5:
				i.putExtra("ID_MARK",new String(""+5));
				i.putExtra("VALUE_MARK", getValueMark(5));
				i.putExtra("COEF_MARK", getCoefMark(5));
				break;
			case R.id.button_mark6:
				i.putExtra("ID_MARK",new String(""+6));
				i.putExtra("VALUE_MARK", getValueMark(6));
				i.putExtra("COEF_MARK", getCoefMark(6));
				break;
			case R.id.button_mark7:
				i.putExtra("ID_MARK",new String(""+7));
				i.putExtra("VALUE_MARK", getValueMark(7));
				i.putExtra("COEF_MARK", getCoefMark(7));
				break;
			case R.id.button_mark8:
				i.putExtra("ID_MARK",new String(""+8));
				i.putExtra("VALUE_MARK", getValueMark(8));
				i.putExtra("COEF_MARK", getCoefMark(8));
				break;
			case R.id.button_mark9:
				i.putExtra("ID_MARK",new String(""+9));
				i.putExtra("VALUE_MARK", getValueMark(9));
				i.putExtra("COEF_MARK", getCoefMark(9));
				break;
			case R.id.button_mark10:
				i.putExtra("ID_MARK",new String(""+10));
				i.putExtra("VALUE_MARK", getValueMark(10));
				i.putExtra("COEF_MARK", getCoefMark(10));
				break;
			case R.id.button_mark11:
				i.putExtra("ID_MARK",new String(""+11));
				i.putExtra("VALUE_MARK", getValueMark(11));
				i.putExtra("COEF_MARK", getCoefMark(11));
				break;
			case R.id.button_mark12:
				i.putExtra("ID_MARK",new String(""+12));
				i.putExtra("VALUE_MARK", getValueMark(12));
				i.putExtra("COEF_MARK", getCoefMark(12));
				break;
			case R.id.button_mark13:
				i.putExtra("ID_MARK",new String(""+13));
				i.putExtra("VALUE_MARK", getValueMark(13));
				i.putExtra("COEF_MARK", getCoefMark(13));
				break;
			case R.id.button_mark14:
				i.putExtra("ID_MARK",new String(""+14));
				i.putExtra("VALUE_MARK", getValueMark(14));
				i.putExtra("COEF_MARK", getCoefMark(14));
				break;
			case R.id.button_mark15:
				i.putExtra("ID_MARK",new String(""+15));
				i.putExtra("VALUE_MARK", getValueMark(15));
				i.putExtra("COEF_MARK", getCoefMark(15));
				break;
			case R.id.button_mark16:
				i.putExtra("ID_MARK",new String(""+16));
				i.putExtra("VALUE_MARK", getValueMark(16));
				i.putExtra("COEF_MARK", getCoefMark(16));
				break;
				
			
		}
		v.getContext().startActivity(i);
	}

	private String getValueMark(int _id)
	{
		for(int i =0; i < mySubject.size(); i++)
			if(mySubject.get(i).getId() == _id)
				return new String(""+mySubject.get(i).getMark());
		return new String("0");
	}
	
	private String getCoefMark(int _id)
	{
		for(int i =0; i < mySubject.size(); i++)
			if(mySubject.get(i).getId() == _id)
				return new String(""+mySubject.get(i).getCoefficient());
		return new String("0");
	}
}
