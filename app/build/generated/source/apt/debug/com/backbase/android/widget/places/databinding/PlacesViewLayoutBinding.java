package com.backbase.android.widget.places.databinding;
import com.backbase.android.widget.places.R;
import com.backbase.android.widget.places.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class PlacesViewLayoutBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(9);
        sIncludes.setIncludes(1, 
            new String[] {"search_locations_view", "empty_locations", "location_error"},
            new int[] {2, 3, 4},
            new int[] {R.layout.search_locations_view, R.layout.empty_locations, R.layout.location_error});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.mapViewParent, 5);
        sViewsWithIds.put(R.id.map, 6);
        sViewsWithIds.put(R.id.myLocation, 7);
        sViewsWithIds.put(R.id.buttonSearchArea, 8);
    }
    // views
    @NonNull
    public final android.widget.Button buttonSearchArea;
    @Nullable
    public final com.backbase.android.widget.places.databinding.EmptyLocationsBinding contentEmptyView;
    @Nullable
    public final com.backbase.android.widget.places.databinding.LocationErrorBinding contentErrorView;
    @Nullable
    public final com.backbase.android.widget.places.databinding.SearchLocationsViewBinding contentRecyclerView;
    @NonNull
    public final com.google.android.gms.maps.MapView map;
    @NonNull
    public final android.support.v4.widget.SwipeRefreshLayout mapViewParent;
    @NonNull
    public final android.widget.ImageButton myLocation;
    @NonNull
    public final android.support.constraint.ConstraintLayout rootLayout;
    @NonNull
    public final android.widget.FrameLayout searchViewParent;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public PlacesViewLayoutBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 3);
        final Object[] bindings = mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds);
        this.buttonSearchArea = (android.widget.Button) bindings[8];
        this.contentEmptyView = (com.backbase.android.widget.places.databinding.EmptyLocationsBinding) bindings[3];
        setContainedBinding(this.contentEmptyView);
        this.contentErrorView = (com.backbase.android.widget.places.databinding.LocationErrorBinding) bindings[4];
        setContainedBinding(this.contentErrorView);
        this.contentRecyclerView = (com.backbase.android.widget.places.databinding.SearchLocationsViewBinding) bindings[2];
        setContainedBinding(this.contentRecyclerView);
        this.map = (com.google.android.gms.maps.MapView) bindings[6];
        this.mapViewParent = (android.support.v4.widget.SwipeRefreshLayout) bindings[5];
        this.myLocation = (android.widget.ImageButton) bindings[7];
        this.rootLayout = (android.support.constraint.ConstraintLayout) bindings[0];
        this.rootLayout.setTag(null);
        this.searchViewParent = (android.widget.FrameLayout) bindings[1];
        this.searchViewParent.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        contentRecyclerView.invalidateAll();
        contentEmptyView.invalidateAll();
        contentErrorView.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (contentRecyclerView.hasPendingBindings()) {
            return true;
        }
        if (contentEmptyView.hasPendingBindings()) {
            return true;
        }
        if (contentErrorView.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable android.arch.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        contentRecyclerView.setLifecycleOwner(lifecycleOwner);
        contentEmptyView.setLifecycleOwner(lifecycleOwner);
        contentErrorView.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeContentErrorView((com.backbase.android.widget.places.databinding.LocationErrorBinding) object, fieldId);
            case 1 :
                return onChangeContentRecyclerView((com.backbase.android.widget.places.databinding.SearchLocationsViewBinding) object, fieldId);
            case 2 :
                return onChangeContentEmptyView((com.backbase.android.widget.places.databinding.EmptyLocationsBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeContentErrorView(com.backbase.android.widget.places.databinding.LocationErrorBinding ContentErrorView, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeContentRecyclerView(com.backbase.android.widget.places.databinding.SearchLocationsViewBinding ContentRecyclerView, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeContentEmptyView(com.backbase.android.widget.places.databinding.EmptyLocationsBinding ContentEmptyView, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
        executeBindingsOn(contentRecyclerView);
        executeBindingsOn(contentEmptyView);
        executeBindingsOn(contentErrorView);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static PlacesViewLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static PlacesViewLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<PlacesViewLayoutBinding>inflate(inflater, com.backbase.android.widget.places.R.layout.places_view_layout, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static PlacesViewLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static PlacesViewLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.backbase.android.widget.places.R.layout.places_view_layout, null, false), bindingComponent);
    }
    @NonNull
    public static PlacesViewLayoutBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static PlacesViewLayoutBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/places_view_layout_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new PlacesViewLayoutBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): contentErrorView
        flag 1 (0x2L): contentRecyclerView
        flag 2 (0x3L): contentEmptyView
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}