package com.yamikrish.app.mvpapplication.users;
/*
 * Created by Yamini on 24/5/18.
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yamikrish.app.mvpapplication.R;
import com.yamikrish.app.mvpapplication.adapter.UsersAdapter;
import com.yamikrish.app.mvpapplication.users.model.data.User;

import java.util.ArrayList;
import java.util.List;

public class UsersFragment extends Fragment implements UsersConnector.View {
    UsersConnector.Presenter presenter;
    RecyclerView usersRecyclerView;
    LinearLayoutManager layoutManager;
    List<User> userList = new ArrayList<>();
    UsersAdapter adapter;

    public static UsersFragment newInstance() {
        return new UsersFragment();
    }

    @Override
    public void setUsers(List<User> myUserList) {
        userList = myUserList;
        adapter = new UsersAdapter(getActivity(), userList);
        usersRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getActivity(),message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(UsersConnector.Presenter presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.users_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        usersRecyclerView = view.findViewById(R.id.usersRecyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        usersRecyclerView.setLayoutManager(layoutManager);



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (presenter != null) {
            presenter.start();
        }
    }
}
