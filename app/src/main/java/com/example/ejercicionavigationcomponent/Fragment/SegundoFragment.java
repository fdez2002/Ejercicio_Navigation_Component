package com.example.ejercicionavigationcomponent.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ejercicionavigationcomponent.R;

public class SegundoFragment extends Fragment {

    private TextView tv1;
    private TextView tv2;
    private Button btFinal;

    public SegundoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("key", this, new FragmentResultListener() {//objeto de escucha
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
               tv1.setText(bundle.getString("texto"));//asignamos el cotenido introducido en el textview mediante el keuy de referencai
                tv2.setText(bundle.getString("numero"));
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_segundo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv1 = view.findViewById(R.id.textViewTexto);
        tv2 = view.findViewById(R.id.textView2Numero);
        btFinal = view.findViewById(R.id.button2);

        final NavController navController = Navigation.findNavController(view);


        //El boton nos redirige al fragment final
        btFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.finalFragment);

            }
        });
    }
}