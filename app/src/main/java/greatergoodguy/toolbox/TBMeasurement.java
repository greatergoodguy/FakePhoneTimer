package greatergoodguy.toolbox;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by xuejianyu on 1/24/16.
 */
public class TBMeasurement {

    // =========================
    // Density
    // =========================
    public static float getScreenDensity(Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        return density;
    }

    // =========================
    // Orientation
    // =========================
    public static boolean isOrientationPortrait(Context context) {
        int orientation = context.getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_PORTRAIT) {
            return true;}
        else {
            return false;}
    }

    public static boolean isOrientationLandscape(Context context) {
        int orientation = context.getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return true;}
        else {
            return false;}
    }

    // =========================
    // Screen Dimension
    // =========================
    public static int getWidthInPx(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);
        int width = size.x;

        return width;
    }

    public static float getWidthInDp(Context context) {
        int screenWidthInPx = getWidthInPx(context);
        float screenWidthInDp = convertPxToDp(context, screenWidthInPx);
        return screenWidthInDp;
    }

    public static int getHeightInPx(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);
        int height = size.y;

        return height;
    }


    public static float getHeightInDp(Context context) {
        int screenHeightInPx = getHeightInPx(context);
        float screenHeightInDp = convertPxToDp(context, screenHeightInPx);
        return screenHeightInDp;
    }

    // =========================
    // Conversion
    // =========================
    public static int convertDpToPx(Context context, float dp) {
        Resources resources = context.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());

        int pxAsInt = (int) px;

        return pxAsInt;
    }

    public static float convertPxToDp(Context context, int px) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return dp;
    }

}
