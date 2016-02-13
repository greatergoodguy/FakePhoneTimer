package greatergoodguy.toolbox;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by xuejianyu on 1/24/16.
 */
public class TBToaster {

    public static void showToast(Context context, String text) {
        if(context == null)
            return;

        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void showToastLonger(Context context, String text) {
        if(context == null) {
            return;}

        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}
