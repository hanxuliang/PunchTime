package com.han.punchtime;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class StartTimeFragment extends Fragment implements OnClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_start_time, container, false);
		Button startButton = (Button) view.findViewById(R.id.start_button);
		startButton.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//±£´æÊý¾Ý
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss",java.util.Locale.getDefault());
		String string = sf.format(date);
		String[] array = string.split(":");
		SharedPreferences sp = getActivity().getPreferences(Context.MODE_PRIVATE);
		sp.edit().putInt("StartHour", Integer.valueOf(array[0]));
		sp.edit().putInt("StartMinute", Integer.valueOf(array[1]));
		sp.edit().putInt("StartSecond", Integer.valueOf(array[2]));
		getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new TimeStatisticianFragment()).commit();
	}
}
