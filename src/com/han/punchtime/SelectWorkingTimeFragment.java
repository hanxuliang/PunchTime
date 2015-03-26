package com.han.punchtime;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class SelectWorkingTimeFragment extends Fragment {
	
	TimePicker workingPicker;
	TextView titleView;
	Boolean isFree;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_working_time, container, false);
		
		CheckBox freeCheckBox = (CheckBox) view.findViewById(R.id.checkBox_free);
		freeCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					isFree = true;
					workingPicker.setVisibility(View.INVISIBLE);
					titleView.setVisibility(View.INVISIBLE);
				}else {
					workingPicker.setVisibility(View.VISIBLE);
					titleView.setVisibility(View.VISIBLE);
				}
			}
		});
		
		titleView = (TextView) view.findViewById(R.id.textView_select_time);
		
		
		workingPicker = (TimePicker)view.findViewById(R.id.workingPicker);
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
				getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new SelectHoursFragment()).commit();
				//±£´æÊý¾Ý
				SharedPreferences sp = (SharedPreferences) getActivity().getPreferences(Context.MODE_PRIVATE);
				sp.edit().putBoolean("FreeTime", isFree);
				if (!isFree) {
					
				}
			}
		});
        return view;
	}
	
}
