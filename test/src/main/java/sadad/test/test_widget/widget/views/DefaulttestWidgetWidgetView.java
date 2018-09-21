package sadad.test.test_widget.widget.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import sadad.test.R;
import sadad.test.test_widget.widget.core.contract.testWidgetContract;

public class DefaulttestWidgetWidgetView extends View implements testWidgetView {

    public DefaulttestWidgetWidgetView(Context context) {
        super(context);
    }

    @Override
    public void init(testWidgetContract testWidgetContract, ViewGroup viewGroup) {
        View inflatedView = inflate(getContext(), R.layout.default_test_widget_layout, viewGroup);

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
}