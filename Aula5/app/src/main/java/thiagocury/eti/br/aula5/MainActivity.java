package thiagocury.eti.br.aula5;

import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private Button btnKitana;
    private Button btnBaraka;

    //MediaPlayer
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias
        btnBaraka = (Button) findViewById(R.id.btn_baraka);
        btnKitana  = (Button) findViewById(R.id.btn_kitana);

        btnBaraka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Baraka",Toast.LENGTH_LONG).show();
                play(view, R.raw.baraka);
            }
        });

        btnBaraka.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                msg.setTitle("bla");
                msg.setMessage("História do baraka");
                msg.setIcon(R.mipmap.ic_launcher);
                msg.setNeutralButton("OK",null);
                msg.show();
                return true;
            }
        });

        btnKitana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Kitana",Toast.LENGTH_LONG).show();
		stop(view);
		play(view,R.raw.kitana);
            }
        });
    }//fecha onCreate

    public void play(View v, int som){
        try {
            mp = MediaPlayer.create(getBaseContext(), som);
            mp.start();
        }catch (Exception e){
        }
    }

    public void stop(View v){
        try {
            mp.stop();
        }catch (Exception e){
        }
    }

}//fecha MainActivity
