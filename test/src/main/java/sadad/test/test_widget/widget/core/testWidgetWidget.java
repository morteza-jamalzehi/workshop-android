package sadad.test.test_widget.widget.core;

import android.content.Context;
import android.view.ViewGroup;
import android.os.Bundle;

import com.backbase.android.model.Renderable;
import com.backbase.android.rendering.android.NativeRenderer;

import sadad.test.test_widget.widget.views.testWidgetView;
import sadad.test.test_widget.widget.core.contract.testWidgetContract;

public class testWidgetWidget extends NativeRenderer
        <testWidgetView> implements testWidgetContract {

    private final Context context;
    testWidgetView view;

    public testWidgetWidget(Context context) {
        this.context = context;
    }

    @Override
    public void start(Renderable renderable, ViewGroup viewGroup) {
        view = initializeView(context, renderable, viewGroup, this);
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