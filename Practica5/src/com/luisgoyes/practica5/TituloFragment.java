package com.luisgoyes.practica5;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TituloFragment extends ListFragment{
	onTituloSelectedListener mCallback;
	public interface onTituloSelectedListener {
		public void onTituloSelected(int position);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);;
		setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, Contenido.titulos));
	}
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		try{
			mCallback = (onTituloSelectedListener) activity;
		} catch( ClassCastException e){
			Log.d("ClassCastException","La Activity debe implementar esta Interfaz");
		}
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id){
		super.onListItemClick(l,v,position,id);
		mCallback.onTituloSelected(position);
	}
}