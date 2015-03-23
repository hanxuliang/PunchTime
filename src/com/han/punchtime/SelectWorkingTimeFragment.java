package com.han.punchtime;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class SelectWorkingTimeFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_working_time, container, false);
		TimePicker workingPicker = (TimePicker)view.findViewById(R.id.workingPicker);
        workingPicker.setIs24HourView(false);
        workingPicker.setCurrentHour(8);
        workingPicker.setOnTimeChangedListener(new OnTimeChangedListener() {
			
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				
			}
		});
        
        Button nextButton = (Button) view.findViewById(R.id.select_working_time);
        nextButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SelectHoursFragment hoursFragment = new SelectHoursFragment();
				getActivity().getFragmentManager().beginTransaction().add(R.id.fragmentContainer, hoursFragment).commit();
			}
		});
        return view;
	}
}
