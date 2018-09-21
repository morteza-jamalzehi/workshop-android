package backbase.com.workshopandroid.widget.sample_widget.widget.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import backbase.com.workshopandroid.R;
import backbase.com.workshopandroid.widget.sample_widget.widget.core.contract.SampleWidgetContract;

public class DefaultSampleWidgetWidgetView extends View implements SampleWidgetView {

    public DefaultSampleWidgetWidgetView(Context context) {
        super(context);
    }

    @Override
    public void init(SampleWidgetContract SampleWidgetContract, ViewGroup viewGroup) {
        View inflatedView = inflate(getContext(), R.layout.default_sample_widget_layout, viewGroup);

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