package greatergoodguy.toolbox;

import android.content.Context;
import android.provider.Settings.Secure;

/**
 * Created by xuejianyu on 2/1/16.
 */
public class TBAndroid {

    public static String getId() {
        return android.os.Build.ID;
    }

    public static String getSecureId(Context context) {
        String android_id = Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);
        return android_id;
    }
}
