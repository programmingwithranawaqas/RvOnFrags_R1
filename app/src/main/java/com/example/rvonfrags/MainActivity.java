package com.example.rvonfrags;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity
        implements ContactAdapter.OnContactClicked {

    TextView tvName;
    TextView tvPhone;
    FragmentManager manager;

    TextInputEditText etName, etNumber;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();

        tvName = manager.findFragmentById(R.id.descFrag).getView()
                .findViewById(R.id.tvName);
        tvPhone = manager.findFragmentById(R.id.descFrag).getView()
                .findViewById(R.id.tvNumber);
        etName = manager.findFragmentById(R.id.addNewContactFrag).getView()
                .findViewById(R.id.etName);
        etNumber = manager.findFragmentById(R.id.addNewContactFrag).getView()
                .findViewById(R.id.etContact);
        btnAdd = manager.findFragmentById(R.id.addNewContactFrag).getView()
                .findViewById(R.id.btnAddNewContact);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString().trim();
                String number = etNumber.getText().toString().trim();

                MyApplication.contacts.add(new Contact(name, number));
                ListFrag.cAdapter.notifyDataSetChanged();
                etName.setText("");
                etNumber.setText("");

            }
        });


        onClick(0);

    }

    @Override
    public void onClick(int index) {
        tvName.setText(MyApplication.contacts.get(index).getName());
        tvPhone.setText(MyApplication.contacts.get(index).getNumber());
    }
}