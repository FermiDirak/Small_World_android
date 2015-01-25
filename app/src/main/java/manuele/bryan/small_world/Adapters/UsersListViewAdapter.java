package manuele.bryan.small_world.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import manuele.bryan.small_world.R;
import manuele.bryan.small_world.User;

public class UsersListViewAdapter extends BaseAdapter {
    private Context context;
    private List<User> users;
    private LayoutInflater layoutInflater;

    public UsersListViewAdapter(Context context, List<User> users) {
        if (users == null) {
            throw new IllegalArgumentException("subjects list null");
        }
        this.context = context;
        this.users = users;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View itemView, ViewGroup parent) {
        ViewHolder holder;
        if (itemView == null) {
            itemView = layoutInflater.inflate(R.layout.user_item, null);
            holder = new ViewHolder(itemView);
            itemView.setTag(holder);
        } else {
            holder = (ViewHolder) itemView.getTag();
        }

        User user = users.get(position);

        holder.username.setText(user.username);
        holder.distance.setText(user.distance);

        return itemView;
    }

    public final static class ViewHolder {
        ImageView userImage;
        TextView username;
        TextView distance;

        public ViewHolder(View itemView) {
            userImage = (ImageView) itemView.findViewById(R.id.userImage);
            username = (TextView) itemView.findViewById(R.id.username);
            distance = (TextView) itemView.findViewById(R.id.distance);
        }
    }

}