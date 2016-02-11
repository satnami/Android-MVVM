package satnami.com.mvvm.utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by satnami on 12/2/2016.
 */
public class NetworkUtils {
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }
}
