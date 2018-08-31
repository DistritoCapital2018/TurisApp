package com.example.worldskills.turisapp.interfaces;

import com.example.worldskills.turisapp.fragments.HotelFragment;
import com.example.worldskills.turisapp.fragments.InicioFragment;
import com.example.worldskills.turisapp.fragments.MapFragment;
import com.example.worldskills.turisapp.fragments.RestauranteFragment;
import com.example.worldskills.turisapp.fragments.SitioFragment;

public interface InterfaceFragments extends HotelFragment.OnFragmentInteractionListener, InicioFragment.OnFragmentInteractionListener,
        MapFragment.OnFragmentInteractionListener, RestauranteFragment.OnFragmentInteractionListener, SitioFragment.OnFragmentInteractionListener{
}
