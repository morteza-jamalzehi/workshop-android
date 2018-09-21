package backbase.com.workshopandroid.widget.morteza_sample_widget.view;

import com.backbase.android.rendering.android.NativeView;

import backbase.com.workshopandroid.widget.morteza_sample_widget.core.contract.LoginContract;

public interface LoginView extends NativeView<LoginContract> {
    void lockControls(boolean lock);
}
