package cordova.plugin.readconfig;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.cordova.BuildConfig;

/**
 * This class echoes a string called from JavaScript.
 */
public class ReadConfig extends CordovaPlugin {

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
                    callbackContext.success(BuildConfig.keyApp);
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
