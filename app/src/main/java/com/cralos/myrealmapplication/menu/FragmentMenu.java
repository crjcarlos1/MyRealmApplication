package com.cralos.myrealmapplication.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cralos.myrealmapplication.R;
import com.cralos.myrealmapplication.realm1.view.FragmentRealm1;
import com.cralos.myrealmapplication.realm2.view.FragmentRealm2;
import com.cralos.myrealmapplication.realm3.view.FragmentRealm3;

public class FragmentMenu extends Fragment implements View.OnClickListener {
    public static final String TAG = FragmentMenu.class.getSimpleName();

    private Button btnRealm1, btnRealm2, btnRealm3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        initFragmentMenu(view);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRealm1:
                showFragmentRealm1();
                break;
            case R.id.btnRealm2:
                showFragmentRealm2();
                break;
            case R.id.btnRealm3:
                showFragmentRealm3();
                break;
        }
    }

    private void initFragmentMenu(View view) {
        btnRealm1 = view.findViewById(R.id.btnRealm1);
        btnRealm2 = view.findViewById(R.id.btnRealm2);
        btnRealm3 = view.findViewById(R.id.btnRealm3);
        btnRealm1.setOnClickListener(this);
        btnRealm2.setOnClickListener(this);
        btnRealm3.setOnClickListener(this);
    }

    private void showFragmentRealm1() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.addToBackStack(FragmentRealm1.TAG);
        transaction.replace(R.id.containerFragments, new FragmentRealm1(), FragmentRealm1.TAG).commit();
    }

    private void showFragmentRealm2() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.addToBackStack(FragmentRealm2.TAG);
        transaction.replace(R.id.containerFragments, new FragmentRealm2(), FragmentRealm2.TAG).commit();
    }

    private void showFragmentRealm3() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.addToBackStack(FragmentRealm3.TAG);
        transaction.replace(R.id.containerFragments, new FragmentRealm3(), FragmentRealm3.TAG).commit();
    }

}
