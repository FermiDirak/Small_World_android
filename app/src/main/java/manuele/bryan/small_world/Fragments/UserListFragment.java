package manuele.bryan.small_world.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import manuele.bryan.small_world.Activities.LogInActivity;
import manuele.bryan.small_world.Activities.UserActivity;
import manuele.bryan.small_world.Adapters.UsersListViewAdapter;
import manuele.bryan.small_world.ParseConstants;
import manuele.bryan.small_world.R;
import manuele.bryan.small_world.User;

public class UserListFragment extends Fragment {
    View view;
    ListView userListView;
    UsersListViewAdapter listAdapter;

    protected List<ParseUser> mUsers;
    protected ParseUser mCurrentUser;

    List<User> users;

    public static UserListFragment newInstance() {
        UserListFragment fragment = new UserListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        mCurrentUser = ParseUser.getCurrentUser();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_user_list, null);
        userListView = (ListView) view.findViewById(R.id.userListView);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        mCurrentUser = ParseUser.getCurrentUser();

        ParseQuery<ParseUser> query = ParseUser.getQuery();
        query.orderByAscending(ParseConstants.KEY_USERNAME);
        query.setLimit(1000);

        query.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> parseUsers, ParseException e) {
                if (e == null) {
                    //success
                    mUsers = parseUsers;

                    users = new ArrayList<>();

                    System.out.println(mUsers.size());

                    for (int i = 0; i < mUsers.size(); i++) {
                        ParseUser parseUser = mUsers.get(i);

                        System.out.println(parseUser.getUsername());

                        User user = new User(parseUser.getUsername(), "1 mile", 2);

                        users.add(user);

                    }

                    listAdapter = new UsersListViewAdapter(getActivity().getBaseContext(), users);
                    userListView.setAdapter(listAdapter);

                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity().getBaseContext());
                    builder.setTitle("connectivity error");
                    builder.setMessage(e.getMessage());
                    builder.setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

        userListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), UserActivity.class);
                startActivity(intent);
            }
        });

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
