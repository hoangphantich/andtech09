package westjourney.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PartnerAdapter extends ArrayAdapter<String>{

	private Context context;
	private String[] values;

	/**
	 * constructor for adapter
	 * 
	 * @param context
	 * @param values
	 */
	public PartnerAdapter(Context context, String[] values) {
		super(context, R.layout.custom_list, values);
		this.context = context;
		this.values = values;	
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//Viewgroup 1 line of list view
		
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(R.layout.custom_list, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
		
		// Change icon based on name
		/**
		 * string[] = [tonngokhong, trubatgioi, satang]
		 */
		textView.setText(values[position]);
		String s = values[position];
		System.out.println(s);
 
		if (s.equals("ton ngo khong")) {
			imageView.setImageResource(R.drawable.tnk);
		} else if (s.equals("tru bat gioi")) {
			imageView.setImageResource(R.drawable.tbg);
		} else {
			imageView.setImageResource(R.drawable.st);
		}
 
		return rowView;
	}	

}
