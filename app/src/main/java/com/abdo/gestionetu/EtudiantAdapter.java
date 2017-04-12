package com.abdo.gestionetu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EtudiantAdapter extends ArrayAdapter<Etudiant> {

	private int resource;
	private LayoutInflater inflater;

	public EtudiantAdapter(Context ctx, int resourceId, List<Etudiant> objects) {
		super( ctx, resourceId, objects );
		resource = resourceId;
		inflater = LayoutInflater.from( ctx );
	}
   
	@Override
	public View getView (int position, View view, ViewGroup parent ) {

		if (view == null){
			view = inflater.inflate(resource, null );
		}

		Etudiant e = getItem( position );

		TextView id = (TextView) view.findViewById(R.id.id);
		id.setText("" + e.getId());

		TextView nom = (TextView) view.findViewById(R.id.nom);
		nom.setText(e.getNom());

		TextView prenom = (TextView) view.findViewById(R.id.email);
		prenom.setText(e.getEmail());

		return view;
       
	}

	public void removeEtudiant(String id){
		EtudiantBDD bdd = new EtudiantBDD(getContext());
		bdd.removeMovie(Integer.parseInt(id), getContext());
		notifyDataSetChanged();
	}
}