package greatergoodguy.toolbox;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by xuejianyu on 1/24/16.
 */
public class TBKeyboard {

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

}
