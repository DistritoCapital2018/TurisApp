package com.example.worldskills.turisapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.worldskills.turisapp.R;


public class SitioFragment extends Fragment {

    //Instancio los componentes que nesecito
    View view;
    FloatingActionButton floSitio;
    FragmentManager fragmentManager;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SitioFragment() {
    }

    public static SitioFragment newInstance(String param1, String param2) {
        SitioFragment fragment = new SitioFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Inflo la vista de mi fragment sitio
        view = inflater.inflate(R.layout.fragment_sitio, container, false);

        //Asigno el componente junto con el xml
        floSitio = view.findViewById(R.id.floatingSitio);

        //Asigno el onClick al boton flotante
        floSitio.setOnClickListener(new View.OnClickListener() {
            //Realizo la transición entre fragments para abrir el mapa
            @Override
            public void onClick(View v) {
                MapFragment mapFragment = new MapFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_main, mapFragment)
                        .commit();

            }
        });

        return view;



    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
