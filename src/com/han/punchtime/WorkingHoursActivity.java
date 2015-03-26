package com.han.punchtime;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class WorkingHoursActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working_hours);
        
        File firstFile = new File(getFilesDir(), "first");
        if (firstFile.exists()) {
			getFragmentManager().beginTransaction().add(R.id.fragmentContainer, new StartTimeFragment()).commit();
		}else {
			SelectWorkingTimeFragment startFragment =  new SelectWorkingTimeFragment();
	        FragmentManager fm = getFragmentManager();
	        fm.beginTransaction().add(R.id.fragmentContainer, startFragment).commit();
	        //创建文件
	        try {
				firstFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("创建失败");
			}
		}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.working_hours, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
