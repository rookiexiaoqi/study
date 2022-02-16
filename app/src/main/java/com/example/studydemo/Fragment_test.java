package com.example.studydemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Fragment_test extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        Button button1 = findViewById(R.id.button_left);
        button1.setOnClickListener(this);
        replaceFragment(new Rightfragment());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_left:
                replaceFragment(new AnotherRightFragment());
                break;
            case R.id.right_fragment:
            default:break;
        }
    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.another_right_fragment,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}




