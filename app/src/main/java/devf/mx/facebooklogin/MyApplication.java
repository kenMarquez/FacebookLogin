package devf.mx.facebooklogin;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by Ken on 27/11/16.
 */

public class MyApplication extends Application {
    /*
     */
    @Override
    public void onCreate() {
        super.onCreate();
        //Inicializamos el SDK de Facebook
        FacebookSdk.sdkInitialize(getApplicationContext());
        /*
         * El AppEventsLogger permite a los desarrolladores capturar
         * el log de algunos tipos de eventos lanzados por Facebook
         */
        AppEventsLogger.activateApp(this);
    }
}
