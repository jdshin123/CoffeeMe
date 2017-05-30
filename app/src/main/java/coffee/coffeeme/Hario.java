package coffee.coffeeme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Hario extends AppCompatActivity {
    int count = 35;
    int count2 = 45;
    Thread t,t2;
    boolean continueThread = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hario);


    }
    public void onButtonClick3(View view)
    {
        Button clicker = (Button) findViewById(R.id.button15);
        final TextView label = (TextView) findViewById(R.id.textView21);


        t = new Thread() {
            @Override
            public void run() {
                while (continueThread) {
                    try {
                        Thread.sleep(1000); // 1000 = 1 second
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                label.setText(String.valueOf(count));
                                count--;
                                if(count == 0)
                                {
                                    label.setText("Finished");
                                    continueThread = false;

                                }
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        t.start();
    }
    public void onButtonClick4(View view)
    {
        Button clicker = (Button) findViewById(R.id.button16);
        final TextView label = (TextView) findViewById(R.id.textView22);
        continueThread = true;

        t2 = new Thread() {
            @Override
            public void run() {
                while (continueThread) {
                    try {
                        Thread.sleep(1000); // 1000 = 1 second
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                label.setText(String.valueOf(count2));
                                count2--;
                                if(count2 == 0)
                                {
                                    label.setText("Finished");
                                    continueThread = false;
                                }
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        t2.start();
    }



    public void OnButtonClickAndMultiplyDisplay(View view){
        EditText er = (EditText)findViewById(R.id.harioInput);
        String s1;
        s1 = er.getText().toString();
        int n1,n2;
        try{
            n1 = Integer.parseInt(s1);
            n2 = n1 * 15;
            Toast.makeText(this, "The amount of water needed is " + n2, Toast.LENGTH_LONG).show();
        }
        catch(Exception e)
        {
            Toast.makeText(this, "Incorrect Amount, please try again", Toast.LENGTH_LONG).show();
        }
    }

}
