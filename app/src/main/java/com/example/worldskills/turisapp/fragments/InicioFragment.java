package com.example.worldskills.turisapp.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.sqliteHelper.ConexionSQLiteOpenHelper;
import com.example.worldskills.turisapp.utilidades.Tablas;


public class InicioFragment extends Fragment {

    //Instancio los componentes que nesecito
    View view;
    Typeface typeface;
    TextView tvDescription;

    ConexionSQLiteOpenHelper conexionSQLiteOpenHelper;

    private OnFragmentInteractionListener mListener;

    public InicioFragment() {
        // Required empty public constructor
    }

    public static InicioFragment newInstance(String param1, String param2) {
        InicioFragment fragment = new InicioFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }


        conexionSQLiteOpenHelper = new ConexionSQLiteOpenHelper(getContext(), Tablas.DATABASE,null,1);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_inicio, container, false);

        tvDescription = view.findViewById(R.id.tvDescription);
        try {

            typeface = Typeface.createFromAsset(getContext().getAssets(),"fonts/poorich.ttf");
            tvDescription.setTypeface(typeface);
        }catch (Exception e)
        {
            Toast.makeText(getContext(),"Error en la Tipografia",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }


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
