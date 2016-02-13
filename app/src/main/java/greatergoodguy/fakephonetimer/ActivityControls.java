package greatergoodguy.fakephonetimer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import greatergoodguy.toolbox.TBLogger;
import greatergoodguy.toolbox.TBMeasurement;
import greatergoodguy.toolbox.TBToaster;

public class ActivityControls extends Activity {

    protected final String TAG = getClass().getSimpleName();

    int numSecondsUntilEvent = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controls);

        int width = TBMeasurement.getWidthInPx(getContext());
        int height = TBMeasurement.getHeightInPx(getContext());
        TBLogger.log(TAG, "width, height: " + width + ", " + height);

        LinearLayout llBase = (LinearLayout) findViewById(R.id.activity_controls_base);

        ViewGroup.LayoutParams layoutParams = llBase.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        llBase.setLayoutParams(layoutParams);

        findViewById(R.id.activity_controls_view_1_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numSecondsUntilEvent *= 2;
            }
        });

        findViewById(R.id.activity_controls_view_1_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numSecondsUntilEvent = 1;
            }
        });

        findViewById(R.id.activity_controls_view_2_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TBToaster.showToast(getContext(), "numSecondsUntilEvent: " + numSecondsUntilEvent);
            }
        });

        findViewById(R.id.activity_controls_view_2_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFakePhone();
                finish();
            }
        });
    }

    private void startFakePhone() {
        if(numSecondsUntilEvent > 60) {
            TBToaster.showToast(getContext(), "Number of seconds is invalid");}

        final Handler handler = new Handler();
        final Runnable runnableStartFakePhone = new Runnable() {
            public void run() {
                Intent intent = new Intent(ActivityControls.this, ActivityFakePhone.class);
                startActivity(intent);
            }
        };

        int numMilli = numSecondsUntilEvent * 1000;
        handler.postDelayed(runnableStartFakePhone, numMilli);
    }

    private Context getContext() {
        return this;
    }
}
