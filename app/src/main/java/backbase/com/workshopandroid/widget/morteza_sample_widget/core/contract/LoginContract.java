package backbase.com.workshopandroid.widget.morteza_sample_widget.core.contract;

import com.backbase.android.rendering.android.NativeContract;

public interface LoginContract extends NativeContract {
    void doLogin(String userName, String password, LoginAuthenticator loginAuthenticator, LoginResultListener loginResultListener);
}
