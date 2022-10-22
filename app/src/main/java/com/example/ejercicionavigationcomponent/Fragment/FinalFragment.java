package com.example.ejercicionavigationcomponent.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ejercicionavigationcomponent.R;

public class FinalFragment extends Fragment {

    private TextView tvFinal;
    private Button btFinal;

    public FinalFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_final, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvFinal = view.findViewById(R.id.textView);
        btFinal = view.findViewById(R.id.button3);

        final NavController navController = Navigation.findNavController(view);


        //Nos redirige al fragmento principal
        btFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.inicioFragment);
            }
        });
    }
}