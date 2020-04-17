package com.example.rida.ui.hotspots;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.*;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.model.BitmapDescriptor;

import com.example.rida.R;

public class HotspotsFragment extends Fragment {

    public HotspotsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_hotspots, container,
                false);
        SupportMapFragment mSupportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.frag);

            mSupportMapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap mMap) {
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    mMap.clear();

                    CameraPosition googlePlex = CameraPosition.builder()
                            .target(new LatLng(37.4219999,-122.0862462))
                            .zoom(10)
                            .bearing(0)
                            .tilt(45)
                            .build();

                    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 10000, null);

                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(37.4219999, -122.0862462))
                            .title("Spider Man")
                            .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.ic_notifications_black_24dp)));

                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(37.4629101,-122.2449094))
                            .title("Iron Man")
                            .snippet("His Talent : Plenty of money"));

                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(37.3092293,-122.1136845))
                            .title("Captain America"));
                }
            });

        return v;

    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

}