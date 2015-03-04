package esgi.fr.myaverage;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class MarksListener implements OnClickListener {

	@Override
	public void onClick(View v) {
		Intent i = new Intent(v.getContext(), TestActivity.class);
		switch (v.getId()) 
		{
			case R.id.button_mark1:
				i.putExtra("ID_MARK",new String(""+1));
				break;
			case R.id.button_mark2:
				i.putExtra("ID_MARK",new String(""+2));
				break;
			case R.id.button_mark3:
				i.putExtra("ID_MARK",new String(""+3));
				break;
			case R.id.button_mark4:
				i.putExtra("ID_MARK",new String(""+4));
				break;
			case R.id.button_mark5:
				i.putExtra("ID_MARK",new String(""+5));
				break;
			case R.id.button_mark6:
				i.putExtra("ID_MARK",new String(""+6));
				break;
			case R.id.button_mark7:
				i.putExtra("ID_MARK",new String(""+7));
				break;
			case R.id.button_mark8:
				i.putExtra("ID_MARK",new String(""+8));
				break;
			case R.id.button_mark9:
				i.putExtra("ID_MARK",new String(""+9));
				break;
			case R.id.button_mark10:
				i.putExtra("ID_MARK",new String(""+10));
				break;
			case R.id.button_mark11:
				i.putExtra("ID_MARK",new String(""+11));
				break;
			case R.id.button_mark12:
				i.putExtra("ID_MARK",new String(""+12));
				break;
			case R.id.button_mark13:
				i.putExtra("ID_MARK",new String(""+13));
				break;
			case R.id.button_mark14:
				i.putExtra("ID_MARK",new String(""+14));
				break;
			case R.id.button_mark15:
				i.putExtra("ID_MARK",new String(""+15));
				break;
			case R.id.button_mark16:
				i.putExtra("ID_MARK",new String(""+16));
				break;
				
			
		}
		v.getContext().startActivity(i);
	}

}
