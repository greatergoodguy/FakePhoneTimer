package greatergoodguy.toolbox;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by xuejianyu on 1/24/16.
 */
public class TBLogger {

    public static void log(String tag, String info) {
        if (info.length() > 4000) {
            Log.d(tag, info.substring(0, 4000));
            log(tag, info.substring(4000));
        } else {
            Log.d(tag, info);
        }
    }

    public static void log(String tag, JSONObject jsonObj) {
        if(jsonObj == null) {
            log(tag, "jsonObj is null");
            return;}

        try {
            log(tag, jsonObj.toString(4));
        } catch (JSONException e) {
            log(tag, "JSONException: JSONObject cannot be logged");
            e.printStackTrace();
        }
    }


    public static void log(String tag, JSONArray jsonArray) {
        if(jsonArray == null) {
            log(tag, "jsonArray is null");
            return;}

        try {
            log(tag, jsonArray.toString(4));
        } catch (JSONException e) {
            log(tag, "JSONException: JSONObject cannot be logged");
            e.printStackTrace();
        }
    }
}
