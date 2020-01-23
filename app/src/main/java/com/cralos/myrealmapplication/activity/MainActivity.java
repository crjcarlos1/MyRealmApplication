package com.cralos.myrealmapplication.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cralos.myrealmapplication.R;
import com.cralos.myrealmapplication.menu.FragmentMenu;
import com.cralos.myrealmapplication.realm1.view.FragmentRealm1;
import com.cralos.myrealmapplication.realmConstants.RealmConstants;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRealm();
        showFragmentMenu();
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count > 1) {
            super.onBackPressed();
        } else {
            finish();
        }
    }

    private void showFragmentMenu() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.addToBackStack(FragmentRealm1.TAG);
        transaction.replace(R.id.containerFragments, new FragmentMenu(), FragmentMenu.TAG).commit();
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name(RealmConstants.REALM_DATA_BASE_NAME)
                .schemaVersion(RealmConstants.REALM_DATA_BASE_VERSION)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);
    }

}
