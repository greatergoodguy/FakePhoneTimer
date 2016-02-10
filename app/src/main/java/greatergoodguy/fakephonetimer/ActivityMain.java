package greatergoodguy.fakephonetimer;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class ActivityMain extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.activity_main_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    EditText editText = (EditText) findViewById(R.id.activity_main_et);
                    String strNumSeconds = editText.getText().toString();
                    int numSeconds = Integer.parseInt(strNumSeconds);
                    if(numSeconds <= 0) { return;}
                    startFakePhone(numSeconds);
                    finish();
                } catch (NumberFormatException e) {
                }

            }
        });

    }

    private void startFakePhone(int numSeconds) {
        if(numSeconds > 60) {
            Toast.makeText(this, "Number of seconds is invalid", Toast.LENGTH_SHORT).show();}

        final Handler handler = new Handler();
        final Runnable runnableStartFakePhone = new Runnable() {
            public void run() {
                Intent intent = new Intent(ActivityMain.this, ActivityFakePhone.class);
                startActivity(intent);
            }
        };

        int numMilli = numSeconds * 1000;
        handler.postDelayed(runnableStartFakePhone, numMilli);
    }
}
