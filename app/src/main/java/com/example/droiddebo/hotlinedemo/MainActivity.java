package com.example.droiddebo.hotlinedemo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.freshdesk.hotline.Hotline;
import com.freshdesk.hotline.HotlineConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HotlineConfig hlConfig=new HotlineConfig("27dbce4e-322d-4a90-9e71-5e456405a75f","6a305381-54bd-42fd-aab2-b1f5af0c6610");
        Hotline.getInstance(getApplicationContext()).init(hlConfig);

        hlConfig.setVoiceMessagingEnabled(true);
        hlConfig.setCameraCaptureEnabled(true);
        hlConfig.setPictureMessagingEnabled(true);

        Button mConversationButton = (Button) findViewById(R.id.convo_button);
        Typeface font = Typeface.createFromAsset(getAssets(),"Roboto-Thin.ttf");
        mConversationButton.setTypeface(font);
        mConversationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hotline.showConversations(getApplicationContext());
            }
        });
    }
}
