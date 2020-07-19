package cordova.plugin.readconfig;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.apache.cordova.BuildConfig;

import android.util.Log;


/**
 * This class echoes a string called from JavaScript.
 */
public class ReadConfig extends CordovaPlugin {

    private static final String TAG = "ReadConfig";

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    
        Log.d(TAG, "Initializing result");
      }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("obtenerValorConfig")) {
            this.obtenerValorConfig(args, callbackContext);
            return true;
        }
        return false;
    }

    

    private void obtenerValorConfig(JSONArray args, CallbackContext callbackContext) {
        if (args != null) {
            try {
                String key = args.getString(0);
                if(key.equals("keyApp")) {
                    final PluginResult result = new PluginResult(PluginResult.Status.OK, BuildConfig.keyApp);
                    callbackContext.success(result);
                }
            } catch (Exception e) {
                callbackContext.error("Error UnExpected " + e.getLocalizedMessage());
                e.printStackTrace();
            }
            // callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
