package tcg.com.mvppattern.Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionDetector {

    private Context _context;

    public ConnectionDetector(Context context) {
        this._context = context;
    }

    public final boolean isInternetOn() {

        try {
            // get Connectivity Manager object to check connection
            ConnectivityManager connec = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo info = connec.getActiveNetworkInfo();

            // Check for network connections
            if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
                    connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING ||
                    connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING ||
                    connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {

                /*if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                    Toast.makeText(_context, "Wifi Connwected..", Toast.LENGTH_SHORT).show();
                } else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                    // check NetworkInfo subtype
                    Toast.makeText(_context, "Mobile Data  Connwected..", Toast.LENGTH_SHORT).show();

                    if (info.getSubtype() == TelephonyManager.NETWORK_TYPE_GPRS) {
                        // Bandwidth between 100 kbps and below
                        Toast.makeText(_context, "Mobile Data Poor Connwected..", Toast.LENGTH_SHORT).show();
                    } else if (info.getSubtype() == TelephonyManager.NETWORK_TYPE_EDGE) {
                        // Bandwidth between 50-100 kbps
                        Toast.makeText(_context, "Mobile Data Poor Connwected..", Toast.LENGTH_SHORT).show();
                    } else if (info.getSubtype() == TelephonyManager.NETWORK_TYPE_EVDO_0) {
                        // Bandwidth between 400-1000 kbps
                        Toast.makeText(_context, "Mobile Data  Connwected..", Toast.LENGTH_SHORT).show();
                    } else if (info.getSubtype() == TelephonyManager.NETWORK_TYPE_EVDO_A) {
                        // Bandwidth between 600-1400 kbps
                        Toast.makeText(_context, "Mobile Data  Connwected..", Toast.LENGTH_SHORT).show();
                    }

                    // Other list of various subtypes you can check for and their bandwidth limits
                    // TelephonyManager.NETWORK_TYPE_1xRTT       ~ 50-100 kbps
                    // TelephonyManager.NETWORK_TYPE_CDMA        ~ 14-64 kbps
                    // TelephonyManager.NETWORK_TYPE_HSDPA       ~ 2-14 Mbps
                    // TelephonyManager.NETWORK_TYPE_HSPA        ~ 700-1700 kbps
                    // TelephonyManager.NETWORK_TYPE_HSUPA       ~ 1-23 Mbps
                    // TelephonyManager.NETWORK_TYPE_UMTS        ~ 400-7000 kbps
                    // TelephonyManager.NETWORK_TYPE_UNKNOWN     ~ Unknown

                }*/

                return true;

            } else if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED ||
                    connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}



