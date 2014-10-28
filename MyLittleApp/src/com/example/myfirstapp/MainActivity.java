package com.example.myfirstapp;

import java.util.Locale;

import org.apache.http.protocol.HTTP;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnInitListener {

	public final static String EXTRA_MESSAGE = "com.krischke.mylittleapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
      //check for TTS data
        Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void onClickButtonAdd(View view) {
    	Intent intent = new Intent(this, DisplayMessageActivity.class);

    	EditText editText = (EditText) findViewById(R.id.editText1);
    	EditText editText2 = (EditText) findViewById(R.id.editText2);

    	int add = Integer.parseInt(editText.getText().toString()) +
    			Integer.parseInt(editText2.getText().toString());

    	intent.putExtra(EXTRA_MESSAGE, "" + add);
    	startActivity(intent);
    }
    
    public void onClickButtonShow(View view) {
    	Uri webpage = Uri.parse(((EditText)findViewById(R.id.editText3)).getText().toString());
    	Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

    	startActivity(webIntent);
    }
    
    public void onClickButtonSendMail(View view) {
    	Intent emailIntent = new Intent(Intent.ACTION_SEND);
    	// The intent does not have a URI, so declare the "text/plain" MIME type
    	emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
    	emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {((EditText)findViewById(R.id.editText4)).getText().toString()}); // recipients
    	emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
    	emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
    	// You can also attach multiple items by passing an ArrayList of Uris
   
    	startActivity(Intent.createChooser(emailIntent,"Choose an Email client :"));
    }
    
    //TTS object
    private TextToSpeech myTTS;
        //status check code
    private int MY_DATA_CHECK_CODE = 0;
    
    //respond to button clicks
	public void onClickButtonSpeak(View v) {
	        //get the text entered
	        EditText enteredText = (EditText)findViewById(R.id.editText5);
	        String words = enteredText.getText().toString(sd);
	        speakWords(words);
	}
    //speak the user text
	private void speakWords(String speech) {
	        //speak straight away
	        myTTS.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
	}

    //act on result of TTS data check
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == MY_DATA_CHECK_CODE) {
	        if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
	            //the user has the necessary data - create the TTS
	        myTTS = new TextToSpeech(this, this);
	        }
	        else {
	                //no data - install it now
	            Intent installTTSIntent = new Intent();
	            installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
	            startActivity(installTTSIntent);
	        }
	    }
	}
    //setup TTS
	public void onInit(int initStatus) {
	        //check for successful instantiation
	    if (initStatus == TextToSpeech.SUCCESS) {
	        if(myTTS.isLanguageAvailable(Locale.GERMAN)==TextToSpeech.LANG_AVAILABLE)
	            myTTS.setLanguage(Locale.GERMAN);
	    }
	    else if (initStatus == TextToSpeech.ERROR) {
	        Toast.makeText(this, "Sorry! Text To Speech failed...", Toast.LENGTH_LONG).show();
	    }
	}
    
}
