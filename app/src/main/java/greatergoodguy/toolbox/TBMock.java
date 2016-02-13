package greatergoodguy.toolbox;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by xuejianyu on 1/24/16.
 */
public class TBMock {

    public static final int integer = 0;
    public static final String string = "";

    public static JSONObject jsonObject = null;
    public static JSONArray jsonArray = null;

    static {
        try {
            jsonObject = new JSONObject("{}");
            jsonArray = new JSONArray("[]");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
