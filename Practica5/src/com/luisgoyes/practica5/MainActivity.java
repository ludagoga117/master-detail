package com.luisgoyes.practica5;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.luisgoyes.practica5.ContenidoFragment;
import com.luisgoyes.practica5.TituloFragment;

public class MainActivity extends FragmentActivity implements TituloFragment.onTituloSelectedListener{
	//private boolean onLand = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//onLand = true;
		if( findViewById(R.id.fragment_container)!= null ){
			//onLand = false;
			if(savedInstanceState != null){
				return;
			}
			TituloFragment fragment = new TituloFragment();
			getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment,null).commit();
		}
	}

	public void onTituloSelected(int position){
		ContenidoFragment contFragment = (ContenidoFragment) getSupportFragmentManager().findFragmentById(R.id.contenidoFragment);
		
		//if((contFragment != null)&&(onLand=true)){
		if(contFragment != null){
			contFragment.actualizarContenido(position);
		}else{
			contFragment = new ContenidoFragment();
			Bundle args = new Bundle();
			args.putInt(ContenidoFragment.POSICION,  position);
			contFragment.setArguments(args);
			getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, contFragment).addToBackStack(null).commit();
		}
	}
/*
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
			onLand = true;
			setContentView(R.layout.activity_main);
		}else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
			onLand = false;
			setContentView(R.layout.activity_main);
			TituloFragment fragment = new TituloFragment();
			getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment,null).commit();
			
		}
	}*/
}
