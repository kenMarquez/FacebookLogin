package devf.mx.facebooklogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {

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


    }


}
