package devf.mx.facebooklogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

public class SessionActivity extends AppCompatActivity {

    private static final String TAG = "SessionActivity";
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);
        /*
         * Podemos comprobar que un usuario ya tiene sesión mediante
         * el AccessToken y el perfil de usuario
         */

        //1 - El access token es único por lo que podemos solo se puede tener una sesión
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        Log.i(TAG, currentAccessToken.getToken());


        //2 - La segunda opción es verificar los datos de perfil
        Profile profile = Profile.getCurrentProfile();
        Log.i(TAG, profile.getId());
        Log.i(TAG, profile.getName());
        Log.i(TAG, profile.getLastName());
        Log.i(TAG, "Picture: " + profile.getProfilePictureUri(70, 70));


    }
}
