package pollub.ism.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DrugaAktywnosc extends AppCompatActivity {


    public static String KLUCZ_WIADOMOSCI = "Przekazywana informacja";
    public static int KOD_PROSBY = 123;
    //Uchwyty widoków
    private EditText wiadomoscWychodzaca = null, wiadomoscPrzychodzaca = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_druga_aktywnosc);

        //Dodany kod
        if(savedInstanceState == null) {

            Intent intencja = getIntent();
            String wiadomosc = intencja.getStringExtra(MainActivity.KLUCZ_WIADOMOSCI);

            EditText poleTekstowe = (EditText) findViewById(R.id.wiadomoscOdbieranie1);
            poleTekstowe.setText(wiadomosc);
            poleTekstowe.setEnabled(false);
        }
    }
    public void powrot(View view){

        EditText poleTekstowe = (EditText) findViewById(R.id.wiadomoscWysylanie1);
        String wiadomosc = poleTekstowe.getText().toString();

        Intent intencja = new Intent();
        intencja.putExtra(MainActivity.KLUCZ_WIADOMOSCI, wiadomosc);

        setResult(MainActivity.KOD_PROSBY, intencja);

        finish();

    }
    public void powrotDoGlownej(View view) {

        String wiadomosc = wiadomoscWychodzaca.getText().toString();
        Intent intencja = new Intent(this, MainActivity.class);
        intencja.putExtra(KLUCZ_WIADOMOSCI, wiadomosc);
//        this.startActivityF   orResult(intencja, KOD_PROSBY);
        startActivity(intencja);




    }

}