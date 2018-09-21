package sadad.test.test_widget.widget.views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.backbase.android.Backbase;
import com.backbase.android.core.utils.BBConstants;

import sadad.test.R;
import sadad.test.test_widget.widget.core.contract.testWidgetContract;
import sadad.test.test_widget.widget.views.testWidgetView;


public class CustomtestWidgetView extends View implements testWidgetView {
    String data;


    public CustomtestWidgetView(Context context) {
        super(context);
    }

    @Override
    public void init(testWidgetContract testWidgetContract, ViewGroup viewGroup) {
        View inflatedView = inflate(getContext(), R.layout.custom_test_widget_layout, viewGroup);
        final TextView testTextView = inflatedView.findViewById(R.id.testTextView);

        Backbase.getInstance().registerObserver("flow.open.sample", new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                data = intent.getExtras().getString(BBConstants.EVENTBUS_EVTDATA);
                Log.d("TAGTAG", data);
                testTextView.setText(data);
            }
        });

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