package com.example.myapppro;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class FriendListAdapter extends BaseAdapter {
    FriendListActivity context;
    List<Friend> friends;

    public FriendListAdapter(FriendListActivity context, List<Friend> friends) {
        this.context = context;
        this.friends = friends;
    }

    @Override
    public int getCount() {
        return friends.size();
    }

    @Override
    public Object getItem(int position) {
        return friends.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.row_friend, null);

        TextView tvName = convertView.findViewById(R.id.row_friend_tv_name);
        TextView tvDob = convertView.findViewById(R.id.row_friend_tv_dob);
        TextView tvGender = convertView.findViewById(R.id.row_friend_tv_gender);
        TextView tvAddress = convertView.findViewById(R.id.row_friend_tv_address);
        Button btnDelete = convertView.findViewById(R.id.row_friend_btn_delete);

        tvName.setText(friends.get(position).getName());
        tvDob.setText(friends.get(position).getDob());
        tvGender.setText(friends.get(position).isGender() ? "Female" : "Male");
        tvAddress.setText(friends.get(position).getAddress());

        FriendListAdapter adapter = this;

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.deleteFriend(friends.get(position).getId());
                friends = MainActivity.getUserFriend();
                adapter.notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
