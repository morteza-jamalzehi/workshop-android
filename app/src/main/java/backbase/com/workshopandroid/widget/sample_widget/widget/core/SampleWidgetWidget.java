package backbase.com.workshopandroid.widget.sample_widget.widget.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.ViewGroup;
import android.os.Bundle;

import com.backbase.android.Backbase;
import com.backbase.android.core.pubsub.PubSubEvent;
import com.backbase.android.core.utils.BBConstants;
import com.backbase.android.model.Renderable;
import com.backbase.android.rendering.android.NativeRenderer;

import backbase.com.workshopandroid.MainActivity;
import backbase.com.workshopandroid.widget.sample_widget.widget.views.SampleWidgetView;
import backbase.com.workshopandroid.widget.sample_widget.widget.core.contract.SampleWidgetContract;

import static backbase.com.workshopandroid.WorkshopApplication.OPEN_SAMPLE_FLOW;

public class SampleWidgetWidget extends NativeRenderer
        <SampleWidgetView> implements SampleWidgetContract {

    private final Context context;
    SampleWidgetView view;
    String data;

    public SampleWidgetWidget(Context context) {
        this.context = context;
    }

    @Override
    public void start(Renderable renderable, ViewGroup viewGroup) {
        view = initializeView(context, renderable, viewGroup, this);

//        Backbase.getInstance().registerObserver(OPEN_SAMPLE_FLOW, new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                 data = intent.getExtras().getString(BBConstants.EVENTBUS_EVTDATA);
//                Log.d("TAGTAG", data);
//            }
//        });
//
//        LocalBroadcastManager localBroadcastManager =
//                LocalBroadcastManager.getInstance(context);
//        BroadcastReceiver receiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                String data =
//                        intent.getExtras().getString(BBConstants.EVENTBUS_EVTDATA);
//            }
//        };
//        Backbase.getInstance().registerObserver(OPEN_SAMPLE_FLOW, receiver);
    }

    @Override
    public Renderable getRenderable() {
        return null;
    }

    public Bundle saveInstanceState(Bundle instanceStateToSave) {
        return null;
    }

    public void restoreInstanceState(Bundle savedInstanceState) {

    }

}