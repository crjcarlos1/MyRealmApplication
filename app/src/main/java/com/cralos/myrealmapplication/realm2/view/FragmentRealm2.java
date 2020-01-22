package com.cralos.myrealmapplication.realm2.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cralos.myrealmapplication.R;

public class FragmentRealm2 extends Fragment {
    public static final String TAG = FragmentRealm2.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_realm_2, container, false);
        initFragmentRealm2(view);
        return view;
    }

    private void initFragmentRealm2(View view) {
    }

}
