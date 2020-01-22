package com.cralos.myrealmapplication.realm1.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cralos.myrealmapplication.R;
import com.cralos.myrealmapplication.realm1.interfaces.Realm1Presenter;
import com.cralos.myrealmapplication.realm1.interfaces.Realm1View;
import com.cralos.myrealmapplication.realm1.presenters.Realm1PresenterImpl;

public class FragmentRealm1 extends Fragment implements View.OnClickListener, Realm1View {
    public static final String TAG = FragmentRealm1.class.getSimpleName();

    private EditText edtName, edtEmail, edtIdDelete, edtIdUpdate;
    private Button btnSaveUser, btnGetUsers, btnDeleteUserById, btnUpdateUserById, btnClear;
    private TextView txvResult;

    private Realm1Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_realm_1, container, false);
        initFragmentRealm1(view);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSaveUser:
                presenter.saveUser(edtName.getText().toString(), edtEmail.getText().toString());
                break;
            case R.id.btnGetUsers:
                presenter.getUsers();
                break;
            case R.id.btnDeleteUserById:
                presenter.deleteUserById(edtIdDelete.getText().toString());
                break;
            case R.id.btnUpdate:
                presenter.updateUserById(edtIdUpdate.getText().toString());
                break;
            case R.id.btnClear:
                txvResult.setText("");
                break;
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUsers(String users) {
        txvResult.setText(users);
    }

    private void initFragmentRealm1(View view) {
        txvResult = view.findViewById(R.id.txvResult);
        edtName = view.findViewById(R.id.edtName);
        edtEmail = view.findViewById(R.id.edtEmail);
        edtIdDelete = view.findViewById(R.id.edtId);
        edtIdUpdate = view.findViewById(R.id.edtIdUpdate);
        btnSaveUser = view.findViewById(R.id.btnSaveUser);
        btnGetUsers = view.findViewById(R.id.btnGetUsers);
        btnDeleteUserById = view.findViewById(R.id.btnDeleteUserById);
        btnUpdateUserById = view.findViewById(R.id.btnUpdate);
        btnClear = view.findViewById(R.id.btnClear);
        btnSaveUser.setOnClickListener(this);
        btnGetUsers.setOnClickListener(this);
        btnDeleteUserById.setOnClickListener(this);
        btnUpdateUserById.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        presenter = new Realm1PresenterImpl(this);
    }

}
