package backbase.com.workshopandroid.widget.sample_widget.widget.views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.backbase.android.Backbase;
import com.backbase.android.core.utils.BBConstants;

import backbase.com.workshopandroid.R;
import backbase.com.workshopandroid.widget.sample_widget.widget.core.contract.SampleWidgetContract;

import static backbase.com.workshopandroid.WorkshopApplication.OPEN_SAMPLE_FLOW;

public class CustomSampleWidgetView extends View implements SampleWidgetView {

    public CustomSampleWidgetView(Context context) {
        super(context);
    }
    String data;
    @Override
    public void init(SampleWidgetContract SampleWidgetContract, ViewGroup viewGroup) {
        View inflatedView = inflate(getContext(), R.layout.custom_sample_widget_layout, viewGroup);
        final TextView sample_text = inflatedView.findViewById(R.id.sample_text);


//
        Backbase.getInstance().registerObserver(OPEN_SAMPLE_FLOW, new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                data = intent.getExtras().getString(BBConstants.EVENTBUS_EVTDATA);
                Log.d("TAGTAG", data);
            }
        });

        sample_text.setText(data);
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