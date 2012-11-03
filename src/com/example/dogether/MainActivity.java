package com.example.dogether;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void onResume(){
    	
    }
    
	public Object getTasks() {
		URL text;
		Object taskob= null;
		String task= "";
		try {
			text = new URL(
					"http://pastie.org/pastes/5174733/text");//url

			URLConnection tc = text.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					tc.getInputStream()));
			String line;
			String str = "";
			while ((line = in.readLine()) != null) {
				str += line;
			}

			JSONObject jo = new JSONObject(str);//cast to string 

			taskob = jo.get("Task");
		
			if (taskob instanceof String){
				task= (String) taskob ;
			}
			return task;

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return task;
	}

    
}
