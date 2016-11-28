package devf.mx.facebooklogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity implements FacebookCallback<LoginResult> {

    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //El CallbackManager de Facebook crea un administrador de la devolución de llamadas
        callbackManager = CallbackManager.Factory.create();

        //Referenciamos el boton de facebook creado en el layout
        loginButton = (LoginButton) findViewById(R.id.login_button);

        //Los permisos sirven para soliciatrle al usuario acceso a ciertos datos de su cuenta de Facebook
        loginButton.setReadPermissions("email");

        /**
         * Le indicamos el callbackManager para
         */
        loginButton.registerCallback(callbackManager, this);
    }

    /**
     * Resultado de la respuesta de Facebook
     *
     * @param loginResult
     */
    @Override
    public void onSuccess(LoginResult loginResult) {
        Log.i("success", "success");
    }

    /**
     * Se ejecuta cuando se interrumpe el proceso de inicio de sesión con Facebook
     */
    @Override
    public void onCancel() {
        Log.i("error", "cancel");
    }

    /*
     * @param error
     */
    @Override
    public void onError(FacebookException error) {
        /**
         * Implementación de código en caso de que halla ocurrido algún error
         */
        Log.e("facebookError", error.getMessage());
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * Redireccionamos el resultado de la respuesta de Facebook para que el
         * CallbackManager se encargue de llamar los metodos indicados
         */
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
