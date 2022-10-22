package com.example.ejercicionavigationcomponent.Fragment;

import android.os.Bundle;

import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ejercicionavigationcomponent.R;

public class InicioFragment extends Fragment {


    private EditText introducirTexto;
    private EditText introducirNumeros;
    private Button botonSegundo;

    public InicioFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Referenciamos los componentes aqui ya que sabemos que la vista ya esta creada completamente
        introducirTexto = view.findViewById(R.id.editTextTextPersonName);
        introducirNumeros = view.findViewById(R.id.editTextNumber);
        botonSegundo = view.findViewById(R.id.button);

        final NavController navController = Navigation.findNavController(view);//Es bueno utilizarlo asi para cuando tengamos muchos botones

        //Llama a la segunda actividad con los datos introducidos por teclado
        botonSegundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();//Objeto de la clase budle para envia indormacion
                bundle.putString("texto", introducirTexto.getText().toString());//enviamos el texto introducido mediante un key y el contenido
                bundle.putString("numero", introducirNumeros.getText().toString());//enviamos el numero introducido mediante un key y el contenido
                getParentFragmentManager().setFragmentResult("key", bundle);

                //Comprobamos si el contenido es null, si es asi, no nos moveremos al segundo fragmento
                if((introducirTexto.getText().equals("")) || (introducirNumeros.getText().toString().equals(""))){

                }else{
                    Navigation.findNavController(view).navigate(R.id.segundoFragment);

                }


            }
        });

    }
}