package backbase.com.workshopandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.backbase.android.Backbase;
import com.backbase.android.model.Model;
import com.backbase.android.model.Renderable;
import com.backbase.android.rendering.BBRenderer;

/**
 * PageFragment encapsulating a page for use in the tab layout
 */
public class PageFragment extends Fragment {

    private BBRenderer renderer;
    private String title;

    /**
     * Create a new page fragment instance for pageId
     *
     * @param pageId id of the page to be created
     */
    public static PageFragment newInstance(String pageId) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle(1);
        args.putString("pageId", pageId);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Create the view for the fragment by inflating the page layout. The layout file has to provide
     * a framelayout whose id is to be used as insertion point for the item renderer. The renderable
     * item is then requested from the model and the renderer.start method executed to insert the
     * item renderer into the layout.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Model currentModel = Backbase.getInstance().getCurrentModel();
        View layout = inflater.inflate(R.layout.page_fragment, container, false);

        String pageId = getArguments().getString("pageId");
        Renderable item = currentModel.getAllPages().get(pageId);

        title = item.getName();

        renderer = new BBRenderer(getActivity());
        renderer.start(item, (ViewGroup) layout.findViewById(R.id.insert_point));

        return layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * Make sure to call Backbase renderer lifecycle function in onResume method
     */
    @Override
    public void onResume() {
        super.onResume();
        renderer.resume();
    }

    /**
     * Make sure to call Backbase renderer lifecycle function in onPause method
     */
    @Override
    public void onPause() {
        super.onPause();
        renderer.pause();
    }

    /**
     * Make sure to call Backbase renderer lifecycle function in onDestroyView method
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        renderer.destroy();
    }

}
