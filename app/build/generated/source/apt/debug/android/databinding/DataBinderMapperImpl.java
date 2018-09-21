
package android.databinding;
import backbase.com.workshopandroid.BR;
class DataBinderMapperImpl extends android.databinding.DataBinderMapper {
    public DataBinderMapperImpl() {
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.backbase.android.widget.places.R.layout.marker_item_info_window:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/marker_item_info_window_0".equals(tag)) {
                            return new com.backbase.android.widget.places.databinding.MarkerItemInfoWindowBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for marker_item_info_window is invalid. Received: " + tag);
                }
                case com.backbase.android.widget.places.R.layout.empty_locations:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/empty_locations_0".equals(tag)) {
                            return new com.backbase.android.widget.places.databinding.EmptyLocationsBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for empty_locations is invalid. Received: " + tag);
                }
                case com.backbase.android.widget.places.R.layout.places_view_layout:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/places_view_layout_0".equals(tag)) {
                            return new com.backbase.android.widget.places.databinding.PlacesViewLayoutBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for places_view_layout is invalid. Received: " + tag);
                }
                case com.backbase.android.widget.places.R.layout.search_locations_view:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/search_locations_view_0".equals(tag)) {
                            return new com.backbase.android.widget.places.databinding.SearchLocationsViewBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for search_locations_view is invalid. Received: " + tag);
                }
                case com.backbase.android.widget.places.R.layout.location_error:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/location_error_0".equals(tag)) {
                            return new com.backbase.android.widget.places.databinding.LocationErrorBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for location_error is invalid. Received: " + tag);
                }
                case com.backbase.android.widget.places.R.layout.place_item_layout:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/place_item_layout_0".equals(tag)) {
                            return new com.backbase.android.widget.places.databinding.PlaceItemLayoutBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for place_item_layout is invalid. Received: " + tag);
                }
        }
        return null;
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    @Override
    public int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case -674575002: {
                if(tag.equals("layout/marker_item_info_window_0")) {
                    return com.backbase.android.widget.places.R.layout.marker_item_info_window;
                }
                break;
            }
            case -598531080: {
                if(tag.equals("layout/empty_locations_0")) {
                    return com.backbase.android.widget.places.R.layout.empty_locations;
                }
                break;
            }
            case -528138297: {
                if(tag.equals("layout/places_view_layout_0")) {
                    return com.backbase.android.widget.places.R.layout.places_view_layout;
                }
                break;
            }
            case 1751075561: {
                if(tag.equals("layout/search_locations_view_0")) {
                    return com.backbase.android.widget.places.R.layout.search_locations_view;
                }
                break;
            }
            case -985367180: {
                if(tag.equals("layout/location_error_0")) {
                    return com.backbase.android.widget.places.R.layout.location_error;
                }
                break;
            }
            case -1606201238: {
                if(tag.equals("layout/place_item_layout_0")) {
                    return com.backbase.android.widget.places.R.layout.place_item_layout;
                }
                break;
            }
        }
        return 0;
    }
    @Override
    public String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"};
    }
}