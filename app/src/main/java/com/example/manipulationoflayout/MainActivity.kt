package com.example.manipulationoflayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_with_an_adapter_example)

        val departments: ArrayList<String> = arrayListOf()
        for (i in 0 until bretton_department_list.size) {
            val department = bretton_department_list[i]["name_department"] as String
            departments.add(department+" - Bretagne")
        }
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, departments)
        val listView: ListView = findViewById<ListView>(R.id.my_listView)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val department = bretton_department_list[position]["name_department"] as String
            val prefecture = bretton_department_list[position]["prefecture"] as String
            val sub_prefecture = bretton_department_list[position]["sub_prefecture"] as String
            val area = bretton_department_list[position]["area"] as Int
            val population = bretton_department_list[position]["population"] as Int
            val density = bretton_department_list[position]["density"] as Int
            val popup = AlertDialog.Builder(this)
            popup.setTitle("Department : $department")
            popup.setMessage("Prefecture : $prefecture\nSub-prefecture: $sub_prefecture\nArea : $area km2\nPopulation : $population\nDensity : $density")
            popup.setPositiveButton("Cancel", null)
            popup.create().show()
        }
    }

    // list of dictionary with attribute
    // name_department, prefecture, sub_prefecture, area, population, density
    val bretton_department_list: ArrayList<HashMap<String, Any>> = arrayListOf(
        hashMapOf(
            "name_department" to "Côtes-d'Armor",
            "prefecture" to "Saint-Brieuc",
            "sub_prefecture" to "Dinan, Guingamp et Lannion",
            "area" to 6878,
            "population" to 603640,
            "density" to 88,
        ),
        hashMapOf(
            "name_department" to "Finistère",
            "prefecture" to "Quimper",
            "sub_prefecture" to "Brest, Châteaulin et Morlaix",
            "area" to 6733,
            "population" to 917179,
            "density" to 136,
        ),
        hashMapOf(
            "name_department" to "Ille-et-Vilaine",
            "prefecture" to "Rennes",
            "sub_prefecture" to "Fougères, Redon et Saint-Malo",
            "area" to 6775,
            "population" to 1088855,
            "density" to 161,
        ),
        hashMapOf(
            "name_department" to "Morbihan",
            "prefecture" to "Vannes",
            "sub_prefecture" to "Lorient et Pontivy",
            "area" to 6823,
            "population" to 764161,
            "density" to 112,
        )
    )

}