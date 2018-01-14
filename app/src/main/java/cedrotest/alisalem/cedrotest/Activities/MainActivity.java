package cedrotest.alisalem.cedrotest.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

import cedrotest.alisalem.cedrotest.R;

public class MainActivity extends AppCompatActivity {
    TextView txtStatus;
    LoginButton login_button;
    CallbackManager callbackManager;
    public Button button2;

    public void init(){
        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this, CedroCounties.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        init();
        //initializeControls();
        //loginViaFB();


    }
    /*private void initializeControls(){
        callbackManager =CallbackManager.Factory.create();
        txtStatus = (TextView)findViewById(R.id.txtStatus);
        login_button= (LoginButton)findViewById(R.id.login_button);
    }*/

    /*private void loginViaFB(){
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                txtStatus.setText("Login Saccess\n"+loginResult.getAccessToken());

            }

            @Override
            public void onCancel() {
                txtStatus.setText("Login Cancelled !");

            }

            @Override
            public void onError(FacebookException error) {
                txtStatus.setText("Login Error: "+error.getMessage());

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }*/
}
