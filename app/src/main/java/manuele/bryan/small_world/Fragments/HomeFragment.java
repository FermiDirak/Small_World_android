package manuele.bryan.small_world.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import manuele.bryan.small_world.Activities.MainActivity;
import manuele.bryan.small_world.R;

public class HomeFragment extends Fragment {
    View rootView;

    TextView locationField;
    TextView userCounterField;

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //inflate variables with bundle contents
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        locationField = (TextView) rootView.findViewById(R.id.locationDisplay);
        userCounterField = (TextView) rootView.findViewById(R.id.userCountDisplay);

        locationField.setText(MainActivity.longitude + " " + MainActivity.latitude);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
