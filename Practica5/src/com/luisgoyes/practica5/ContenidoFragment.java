package com.luisgoyes.practica5;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContenidoFragment extends Fragment{
	public static final String POSICION = "position";
	int position = -1;
	View myInflatedView;
	TextView tv_Contenido;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		if(savedInstanceState != null){
			position = savedInstanceState.getInt("position");
		}
		myInflatedView = inflater.inflate(R.layout.contenido_fragment,container,false);
		tv_Contenido = (TextView) myInflatedView.findViewById(R.id.tvContenido);
		if(tv_Contenido == null){
			Log.d("debugCheck", "HeadFrag: tv_Contenido is null");
		}
		return myInflatedView;
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState){
		super.onSaveInstanceState(outState);
		outState.putInt(POSICION, position);
	}
	
	@Override
	public void onStart(){
		super.onStart();
		Bundle args = getArguments();
		if( args != null ){
			actualizarContenido(args.getInt(POSICION));
		}else if( position != -1){
			actualizarContenido(position);
		}
	}
	
	public void actualizarContenido(int position){
		tv_Contenido.setText(Contenido.descripcion[position]);
		this.position = position;
	}
}
