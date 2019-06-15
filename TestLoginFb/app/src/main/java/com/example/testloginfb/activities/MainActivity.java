package com.example.testloginfb.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.testloginfb.R;
import com.example.testloginfb.presenters.MainPresenter;
import com.example.testloginfb.views.MainView;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.util.Arrays;

public class MainActivity extends BaseActivity implements MainView {
    private static final int RC_SIGN_IN = 99;
    private CallbackManager mCallbackManager;
    private LoginButton mButton;
    private FrameLayout mFmlFb, mFmlGg;
    private SignInButton mBtnSignIn;
    private MainPresenter mPresenter;
    private GoogleSignInClient mGoogleSignInClient;
    private static final String EMAIL = "email";
    private static final String USER_POSTS = "user_posts";
    private static final String BASIC_INFO = "basic_info";
    private static final String AUTH_TYPE = "rerequest";

    public static void moveToMainActivity(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialData();
    }

    private void initialData() {
        mPresenter = new MainPresenter(this, getApplication(), this);
    }

    private void initialView() {
        mCallbackManager = CallbackManager.Factory.create();

        mButton = findViewById(R.id.login_button);
        mBtnSignIn = findViewById(R.id.sign_in_button);
        mFmlFb = findViewById(R.id.lnl_facebook);
        mFmlGg = findViewById(R.id.lnl_google);
//        mBtnSignIn.setSize(SignInButton.SIZE_STANDARD);


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        //dành cho app
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        mFmlFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginFb();
            }
        });

        mFmlGg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void onLoginFb() {
        mButton.performClick();
        //LoginManager.getInstance().logInWithReadPermissions(SignInActivity.this, Arrays.asList("public_profile"));
        // Set the initial permissions to request from the user while logging in
        mButton.setReadPermissions(Arrays.asList(EMAIL, USER_POSTS, BASIC_INFO));
        mButton.setAuthType(AUTH_TYPE);
        mButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                if (loginResult != null) {
                    setResult(RESULT_OK);
                    System.out.println("Access Token: " + loginResult.getAccessToken());
                    String fbId = loginResult.getAccessToken().getUserId();
                    //parse fbId to Int to suitable for API
                    Long intFbId = Long.parseLong(fbId);
                    Toast.makeText(MainActivity.this, "ID:  " + fbId, Toast.LENGTH_LONG).show();
                    System.out.println("" + fbId);
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("face", "Login by facebook :   " + fbId);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    mPresenter.handleLoginWithFacebook(intFbId);
                }
            }

            @Override
            public void onCancel() {
                setResult(RESULT_CANCELED);
                LoginManager.getInstance().logOut();
                finish();
            }

            @Override
            public void onError(FacebookException e) {
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            String email = account.getEmail();
            Toast.makeText(MainActivity.this, "Email : " + email, Toast.LENGTH_LONG).show();
            mPresenter.handleLoginWithGoogle(email);
        } catch (ApiException e) {
        }
    }

    @Override
    public void goToHomeActivity() {
//        HomeScreenActivity.moveToHomeScreenActivity(MainActivity.this);
        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
