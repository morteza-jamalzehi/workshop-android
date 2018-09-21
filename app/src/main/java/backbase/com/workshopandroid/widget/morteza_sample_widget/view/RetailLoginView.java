package backbase.com.workshopandroid.widget.morteza_sample_widget.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import backbase.com.workshopandroid.R;
import backbase.com.workshopandroid.widget.morteza_sample_widget.core.DummyLoginAuthenticator;
import backbase.com.workshopandroid.widget.morteza_sample_widget.core.contract.LoginContract;
import backbase.com.workshopandroid.widget.morteza_sample_widget.core.contract.LoginResultListener;

public class RetailLoginView extends View implements LoginView, View.OnClickListener, LoginResultListener {
    EditText username, password;
    Button login;
    LoginContract loginApi;

    public RetailLoginView(Context context) {
        super(context);
    }

    @Override
    public void init(LoginContract mortezaWidgetContract, ViewGroup viewGroup) {
        this.loginApi = mortezaWidgetContract;
        View inflatedView = inflate(getContext(), R.layout.login_view, viewGroup);
        login = inflatedView.findViewById(R.id.login);
        username = inflatedView.findViewById(R.id.username);
        password = inflatedView.findViewById(R.id.password);
        login.setOnClickListener(this);
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void lockControls(boolean lock) {
        username.setEnabled(!lock);
        password.setEnabled(!lock);
    }

    @Override
    public void onClick(View v) {
        loginApi.doLogin("mori", "pass", new DummyLoginAuthenticator(), this);
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(RetailLoginView.this.getContext(), "Login successful", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginError() {
        Toast.makeText(RetailLoginView.this.getContext(), "Login error", Toast.LENGTH_LONG).show();
    }
}
