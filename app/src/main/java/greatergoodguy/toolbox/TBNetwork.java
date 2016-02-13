package greatergoodguy.toolbox;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by xuejianyu on 2/10/16.
 */
public class TBNetwork {

    public static boolean isConnectedWifiOrData(Context context) {
        if(context == null) {
            return false;}

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            return true;}
        else {
            return false;}
    }

}
