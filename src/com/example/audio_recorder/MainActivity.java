package com.example.audio_recorder;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnClickListener{

	MediaRecorder rec = null;
	ToggleButton tbtn_rec = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tbtn_rec = (ToggleButton)findViewById(R.id.toggleButton1);
        tbtn_rec.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(tbtn_rec.isChecked()){			
			try {
				rec = new MediaRecorder();
				rec.setAudioSource(MediaRecorder.AudioSource.MIC);
				rec.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
				rec.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
				
				rec.setOutputFile("audio.mp3");
				rec.prepare();
				rec.start();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block				
			}
		}
		
		else{
			rec.stop();
			rec.release();
			rec = null;
		}		
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		try {
			rec.stop();
			rec.release();
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
}
