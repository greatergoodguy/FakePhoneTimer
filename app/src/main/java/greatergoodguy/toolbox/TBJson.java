package greatergoodguy.toolbox;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by xuejianyu on 1/24/16.
 */
public class TBJson {

    public static JSONObject getJSONObject(JSONArray jsonArray, int index) {
        JSONObject result = new JSONObject();

        try {
            result = jsonArray.getJSONObject(index);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String getString(JSONObject jsonObj, String key) {
        String result = "";

        if(jsonObj.has(key) && !jsonObj.isNull(key)) {
            try {
                result = jsonObj.getString(key);}
            catch (JSONException e) {
                e.printStackTrace();}
        }

        return result;
    }

    public static int getInt(JSONObject jsonObj, String key) {
        int result = 0;

        if(jsonObj.has(key) && !jsonObj.isNull(key)) {
            try {
                result = jsonObj.getInt(key);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static JSONArray getJSONArray(JSONObject jsonObj, String key) {
        JSONArray result = new JSONArray();

        if(jsonObj.has(key)) {
            try {
                result = jsonObj.getJSONArray(key);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
