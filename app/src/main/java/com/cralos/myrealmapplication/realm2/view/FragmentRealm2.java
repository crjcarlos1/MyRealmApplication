package com.cralos.myrealmapplication.realm2.view;

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
import com.cralos.myrealmapplication.realm2.interfaces.Realm2Presenter;
import com.cralos.myrealmapplication.realm2.interfaces.Realm2View;
import com.cralos.myrealmapplication.realm2.presenters.Realm2PresenterImpl;

public class FragmentRealm2 extends Fragment implements Realm2View, View.OnClickListener {
    public static final String TAG = FragmentRealm2.class.getSimpleName();

    private EditText edtNameProfessor, edtAgeProfessor, edtIdProfesorSearch, edtIdUpdate, edtNewName, edtIdDelete;
    private Button btnAddProfessor, btnGetOnlyProfessors, btnGetProfessorById, btnUpdate, btnDelete, btnDeleteAllProfessors;
    private TextView txvResult;
    private Realm2Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_realm_2, container, false);
        initFragmentRealm2(view);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddProfessor:
                presenter.addProfessor(edtNameProfessor.getText().toString(), edtAgeProfessor.getText().toString());
                break;
            case R.id.btnGetOnlyProfessors:
                presenter.getOnlyProfessors();
                break;
            case R.id.btnGetProfessorById:
                presenter.getProfessorById(edtIdProfesorSearch.getText().toString());
                break;
            case R.id.btnUpdateProfesor:
                presenter.updateProfesorById(edtIdUpdate.getText().toString(), edtNewName.getText().toString());
                break;
            case R.id.btnDeleteProfesor:
                presenter.deleteProfessorById(edtIdDelete.getText().toString());
                break;
            case R.id.btnDeleteAllProfessors:
                presenter.deleteAllProfessors();
                break;
        }
    }

    private void initFragmentRealm2(View view) {
        edtAgeProfessor = view.findViewById(R.id.edtAgeProfessor);
        edtNameProfessor = view.findViewById(R.id.edtNameProfessor);
        edtIdProfesorSearch = view.findViewById(R.id.edtIdProfesorSearch);
        edtIdUpdate = view.findViewById(R.id.edtIdUpdate);
        edtNewName = view.findViewById(R.id.edtNewName);
        edtIdDelete = view.findViewById(R.id.edtIdDelete);
        btnAddProfessor = view.findViewById(R.id.btnAddProfessor);
        btnGetOnlyProfessors = view.findViewById(R.id.btnGetOnlyProfessors);
        btnGetProfessorById = view.findViewById(R.id.btnGetProfessorById);
        btnUpdate = view.findViewById(R.id.btnUpdateProfesor);
        btnDelete = view.findViewById(R.id.btnDeleteProfesor);
        btnDeleteAllProfessors = view.findViewById(R.id.btnDeleteAllProfessors);
        txvResult = view.findViewById(R.id.txvResult);
        btnAddProfessor.setOnClickListener(this);
        btnGetOnlyProfessors.setOnClickListener(this);
        btnGetProfessorById.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnDeleteAllProfessors.setOnClickListener(this);
        presenter = new Realm2PresenterImpl(this, getActivity());
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProfessorList(String professors) {
        txvResult.setText(professors);
    }

    @Override
    public void showProfessor(String professorString) {
        txvResult.setText(professorString);
    }

}
