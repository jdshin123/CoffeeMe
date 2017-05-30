package coffee.coffeeme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.CountDownTimer;

public class FrenchPress extends AppCompatActivity {
    int count = 35;
    int count2 = 240;
    Thread t,t2;
    boolean continueThread = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_french_press);
    }

    public void onButtonClick3(View view)
    {
        Button clicker = (Button) findViewById(R.id.button13);
        final TextView label = (TextView) findViewById(R.id.textView19);


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
        Button clicker = (Button) findViewById(R.id.button14);
        final TextView label = (TextView) findViewById(R.id.textView20);
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
        EditText er = (EditText)findViewById(R.id.frenchPressInput);
        String s1;
        s1 = er.getText().toString();
        int n1,n2;
        try{
            n1 = Integer.parseInt(s1);
            n2 = n1 * 12;
            Toast.makeText(this, "The amount of water needed is " + n2, Toast.LENGTH_LONG).show();
        }
        catch(Exception e)
        {
            Toast.makeText(this, "Incorrect Amount, please try again", Toast.LENGTH_LONG).show();
        }
    }
}
