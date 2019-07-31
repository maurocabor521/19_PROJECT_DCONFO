package com.example.asus.dconfo_app.presentation.view.activity.docente.notas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.asus.dconfo_app.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PorcentNotasActivity extends AppCompatActivity {

    PieChart pieChart;
    ArrayList<Entry> entries;
    ArrayList<String> PieEntryLabels;
    PieDataSet pieDataSet;
    PieData pieData;

    BarChart chart ;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA ;

    int fonico;
    int lexico;
    int silabico;
    String nameEst;
    TextView txt_nameEst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porcent_notas);

        Bundle datos = this.getIntent().getExtras();
        fonico = datos.getInt("fonico");
        lexico = datos.getInt("lexico");
        silabico = datos.getInt("silabico");
        nameEst = datos.getString("nameEst");

        System.out.println("nameEst: " + nameEst);

        txt_nameEst = (TextView) findViewById(R.id.txt_nameEst);
        txt_nameEst.setText(nameEst);

        showToolbar("Global notas" + " - " + nameEst, true);

        pieChart = (PieChart) findViewById(R.id.piechart);

        entries = new ArrayList<>();

        PieEntryLabels = new ArrayList<String>();

        AddValuesToPIEENTRY();

        AddValuesToPieEntryLabels();

        pieDataSet = new PieDataSet(entries, "");

        pieData = new PieData(PieEntryLabels, pieDataSet);

        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        pieChart.setData(pieData);

        pieChart.animateY(3000);
        //******************************************************************************************
        chart = (BarChart) findViewById(R.id.chart1);

        BARENTRY = new ArrayList<>();

        BarEntryLabels = new ArrayList<String>();

        AddValuesToBARENTRY();

        AddValuesToBarEntryLabels();

        Bardataset = new BarDataSet(BARENTRY, "Projects");

        BARDATA = new BarData(BarEntryLabels, Bardataset);

        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

        chart.setData(BARDATA);

        chart.animateY(3000);

    }

    public void AddValuesToPIEENTRY() {
        if ((fonico != 0) && (lexico != 0) && (silabico != 0)) {
            entries.add(new BarEntry(fonico, 0));
            entries.add(new BarEntry(lexico, 1));
            entries.add(new BarEntry(silabico, 2));
        }
        if ((fonico != 0) && (lexico != 0) && (silabico == 0)) {
            entries.add(new BarEntry(fonico, 0));
            entries.add(new BarEntry(lexico, 1));
        }
        if ((fonico != 0) && (lexico == 0) && (silabico != 0)) {
            entries.add(new BarEntry(fonico, 0));
            entries.add(new BarEntry(silabico, 1));
        }
        if ((fonico == 0) && (lexico != 0) && (silabico != 0)) {
            entries.add(new BarEntry(lexico, 0));
            entries.add(new BarEntry(silabico, 1));
        }
        if ((fonico != 0) && (lexico == 0) && (silabico == 0)) {
            entries.add(new BarEntry(fonico, 0));
        }
        if ((fonico == 0) && (lexico != 0) && (silabico == 0)) {
            entries.add(new BarEntry(lexico, 0));
        }
        if ((fonico == 0) && (lexico == 0) && (silabico != 0)) {
            entries.add(new BarEntry(silabico, 0));
        }
    }

    public void AddValuesToPieEntryLabels() {

        PieEntryLabels.add("Fónica");
        PieEntryLabels.add("Léxica");
        PieEntryLabels.add("Silábica");

    }

    public void showToolbar(String tittle, boolean upButton) {
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_ejercicio);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        //getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    //**********************************************************************************************
    public void AddValuesToBARENTRY(){

        if ((fonico != 0) && (lexico != 0) && (silabico != 0)) {
            BARENTRY.add(new BarEntry(fonico, 0));
            BARENTRY.add(new BarEntry(lexico, 1));
            BARENTRY.add(new BarEntry(silabico, 2));
        }
        if ((fonico != 0) && (lexico != 0) && (silabico == 0)) {
            BARENTRY.add(new BarEntry(fonico, 0));
            BARENTRY.add(new BarEntry(lexico, 1));
        }
        if ((fonico != 0) && (lexico == 0) && (silabico != 0)) {
            BARENTRY.add(new BarEntry(fonico, 0));
            BARENTRY.add(new BarEntry(silabico, 1));
        }
        if ((fonico == 0) && (lexico != 0) && (silabico != 0)) {
            BARENTRY.add(new BarEntry(lexico, 0));
            BARENTRY.add(new BarEntry(silabico, 1));
        }
        if ((fonico != 0) && (lexico == 0) && (silabico == 0)) {
            BARENTRY.add(new BarEntry(fonico, 0));
        }
        if ((fonico == 0) && (lexico != 0) && (silabico == 0)) {
            BARENTRY.add(new BarEntry(lexico, 0));
        }
        if ((fonico == 0) && (lexico == 0) && (silabico != 0)) {
            BARENTRY.add(new BarEntry(silabico, 0));
        }

    }

    public void AddValuesToBarEntryLabels(){

        BarEntryLabels.add("Fónica");
        BarEntryLabels.add("Léxica");
        BarEntryLabels.add("Silábica");

    }

    //método que permite volver al padre conservando las variables
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
