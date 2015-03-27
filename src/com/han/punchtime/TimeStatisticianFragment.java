package com.han.punchtime;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TimeStatisticianFragment extends Fragment {
	TextView time_View;
	Handler handler;
	int hour;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_time_statistician, container, false);
		time_View = (TextView) view.findViewById(R.id.textView_lefttime);
		
		handler = new Handler(){
			public void handleMessage(Message msg) {
				time_View.setText(getLeftTimeString());
				super.handleMessage(msg);
			};
		};
		//¶ÁÈ¡Êý¾Ý
		SharedPreferences sp = getActivity().getPreferences(Context.MODE_PRIVATE);
		hour = sp.getInt("WorkingTime", 8);
		time_View.setText(String.valueOf(hour) + ":" + "00" + ":" + "00");
		
		new Thread(new TimeThread()).start();
		return view;
	}
	
	private String getLeftTimeString() {
		int hour = 8;
		int minute = 0;
		int second = 0;
		second ++ ;
		if (second > 0) {
			second = 60 - second;
		}else if (second == 0) {
			minute--;
		}
		
		if (minute > 0) {
			minute = 60 - minute;
		}else if (minute == 0) {
			hour--;
		}
		
		if (hour > 0) {
			hour = 8 - hour;
		}
		
		return String.valueOf(hour) + ":" + String.valueOf(minute) + ":" + String.valueOf(second);
	}
	
	public class TimeThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				try {
					Thread.sleep(1000);
					Message message = new Message();
					message.what = 100;
					handler.sendMessage(message);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
