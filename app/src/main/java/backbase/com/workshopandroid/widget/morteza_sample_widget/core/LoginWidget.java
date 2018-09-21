package backbase.com.workshopandroid.widget.morteza_sample_widget.core;

import android.content.Context;
import android.view.ViewGroup;

import com.backbase.android.model.Renderable;
import com.backbase.android.rendering.android.NativeRenderer;

import backbase.com.workshopandroid.widget.morteza_sample_widget.core.contract.LoginAuthenticator;
import backbase.com.workshopandroid.widget.morteza_sample_widget.core.contract.LoginContract;
import backbase.com.workshopandroid.widget.morteza_sample_widget.core.contract.LoginResultListener;
import backbase.com.workshopandroid.widget.morteza_sample_widget.view.LoginView;

public class LoginWidget extends NativeRenderer<LoginView> implements LoginContract, LoginResultListener {
    private Context context;
    private LoginView view;
    private LoginResultListener loginListener;

    public LoginWidget(Context context) {
        this.context = context;
    }

    @Override
    public Renderable getRenderable() {
        return null;
    }



    @Override
    public void start(Renderable renderable, ViewGroup viewGroup) {
        view = initializeView(context, renderable, viewGroup, this);
    }

    @Override
    public void onLoginSuccess() {
        loginListener.onLoginSuccess();
        view.lockControls(false);
    }

    @Override
    public void onLoginError() {
        loginListener.onLoginError();
        view.lockControls(true);
    }

    @Override
    public void doLogin(String userName, String password, LoginAuthenticator loginAuthenticator, LoginResultListener loginResultListener) {
        loginListener= loginResultListener ;
        if (loginAuthenticator != null) {
            loginAuthenticator.submitLogin(userName, password, loginResultListener);
        }
    }
}
