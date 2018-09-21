package backbase.com.workshopandroid.widget.morteza_sample_widget.core;

import backbase.com.workshopandroid.widget.morteza_sample_widget.core.contract.LoginAuthenticator;
import backbase.com.workshopandroid.widget.morteza_sample_widget.core.contract.LoginResultListener;

public class DummyLoginAuthenticator implements LoginAuthenticator {
    private LoginResultListener loginListener;

    @Override
    public void submitLogin(String login, String password, LoginResultListener loginListener) {
        this.loginListener = loginListener;
        if (login.equals("mori")) {
            loginListener.onLoginSuccess();
        } else
            loginListener.onLoginError();
    }
}
