package com.example.manipulationoflayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_with_an_adapter_example)

        val bretton_department_list: ArrayList<String> = arrayListOf(
            "Côtes-d'Armor",
            "Finistère",
            "Ille-et-Vilaine",
            "Morbihan",
        )

        for (i in 0 until bretton_department_list.size) {
            bretton_department_list[i] = "${bretton_department_list[i]} - Bretagne"
        }
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bretton_department_list)
        val listView: ListView = findViewById<ListView>(R.id.my_listView)
        listView.adapter = adapter
    }

    /*
    * N°	Nom_Département    Préfecture      Sous_Préfecture              Superficie   Population  Densité
    * 22	Côtes-d'Armor	  |Saint-Brieuc	|Dinan, Guingamp et Lannion	    |6 878      |603 640	 |88
    * 29	Finistère	      |Quimper	    |Brest, Châteaulin et Morlaix	|6 733	    |917 179	 |136
    * 35	Ille-et-Vilaine	  |Rennes       |Fougères, Redon et Saint-Malo	|6 775	    |1 088 855	 |161
    * 56	Morbihan	      |Vannes	    |Lorient et Pontivy	            |6 823	    |764 161	 |112
    * */
}