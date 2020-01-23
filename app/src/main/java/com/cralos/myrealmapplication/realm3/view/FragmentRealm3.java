package com.cralos.myrealmapplication.realm3.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cralos.myrealmapplication.R;
import com.cralos.myrealmapplication.realm3.interfaces.Realm3Presenter;
import com.cralos.myrealmapplication.realm3.interfaces.Realm3View;
import com.cralos.myrealmapplication.realm3.models.Person;
import com.cralos.myrealmapplication.realm3.presenters.Realm3PresenterImpl;

import java.util.List;

public class FragmentRealm3 extends Fragment implements View.OnClickListener, Realm3View {
    public static final String TAG = FragmentRealm3.class.getSimpleName();

    private EditText edtPersonName, edtId;
    private Button btnAddPerson, btnGetPersonById, btnGetAllPersons, btnAddDogsById, btnDeleteDogByUserId;

    private Realm3Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_realm_3, container, false);
        initFragmentRealm3(view);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddPerson:
                presenter.addNewPerson(edtPersonName.getText().toString());
                break;
            case R.id.btnGetPersonById:
                presenter.getPersonById(edtId.getText().toString());
                break;
            case R.id.btnGetAllPersons:
                presenter.getAllPersons();
                break;
            case R.id.btnAddDogsById:
                presenter.addDogsById(edtId.getText().toString());
                break;
            case R.id.btnDeleteDogByUserId:
                presenter.deleteDogByUserId(edtId.getText().toString());
                break;
        }
    }

    private void initFragmentRealm3(View view) {
        edtPersonName = view.findViewById(R.id.edtName);
        edtId = view.findViewById(R.id.edtId);
        btnAddPerson = view.findViewById(R.id.btnAddPerson);
        btnGetPersonById = view.findViewById(R.id.btnGetPersonById);
        btnGetAllPersons = view.findViewById(R.id.btnGetAllPersons);
        btnAddDogsById = view.findViewById(R.id.btnAddDogsById);
        btnDeleteDogByUserId = view.findViewById(R.id.btnDeleteDogByUserId);
        btnAddPerson.setOnClickListener(this);
        btnGetPersonById.setOnClickListener(this);
        btnGetAllPersons.setOnClickListener(this);
        btnAddDogsById.setOnClickListener(this);
        btnDeleteDogByUserId.setOnClickListener(this);
        presenter = new Realm3PresenterImpl(this);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        edtId.setText("");
        edtPersonName.setText("");
    }

    @Override
    public void showPerson(Person person) {
        Log.e("REALM", person.getName() + ", dogs: " + person.getDogs().size());
        edtId.setText("");
        edtPersonName.setText("");
    }

    @Override
    public void showAllPersons(List<Person> personList) {
        for (Person person : personList) {
            Log.e("REALM", "ID: " + person.getId() + ", NAME: " + person.getName() + ", PERROS: " + person.getDogs().size());
        }
        edtId.setText("");
        edtPersonName.setText("");
    }

}
