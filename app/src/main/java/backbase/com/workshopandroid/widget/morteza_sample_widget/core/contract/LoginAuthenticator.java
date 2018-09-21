package backbase.com.workshopandroid.widget.morteza_sample_widget.core.contract;

public interface LoginAuthenticator {
    void submitLogin(String  login, String  password, LoginResultListener loginResultListener);
}
