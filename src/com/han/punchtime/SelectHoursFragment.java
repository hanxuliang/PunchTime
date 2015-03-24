package com.han.punchtime;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

public class SelectHoursFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_select_hours, container, false);
		
		NumberPicker numberPicker = (NumberPicker) view.findViewById(R.id.hours_picker);
		numberPicker.setMinValue(6);
		numberPicker.setMaxValue(12);
		numberPicker.setValue(8);
		
		Button nextButton = (Button)view.findViewById(R.id.select_hours);
        nextButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				StartTimeFragment start = new StartTimeFragment();
				getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, start).commit();
			}
		});
		return view;
	}
}
