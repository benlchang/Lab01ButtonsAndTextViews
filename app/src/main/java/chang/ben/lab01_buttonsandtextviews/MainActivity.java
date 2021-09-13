package chang.ben.lab01_buttonsandtextviews;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button increment, decrement, square, sqrt, trunc, reset;
    TextView greetingDisplay;
    double count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greetingDisplay = findViewById(R.id.greeting_textview);
        DecimalFormat dfint = new DecimalFormat("0");
        DecimalFormat dfdoub = new DecimalFormat("0.00");
        increment = findViewById(R.id.increment);
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count % 1 != 0)
                    greetingDisplay.setText(getString(R.string.numiscount) + dfdoub.format(++count));
                else
                    greetingDisplay.setText(getString(R.string.numiscount) + dfint.format(++count));
                Log.i("incrementing","" + count);
            }
        });
        decrement = findViewById(R.id.decrement);
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count % 1 != 0)
                    greetingDisplay.setText(getString(R.string.numiscount) + dfdoub.format(--count));
                else
                    greetingDisplay.setText(getString(R.string.numiscount) + dfint.format(--count));
                Log.i("decrementing","" + count);
            }
        });
        square = findViewById(R.id.square);
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = Math.pow(count, 2);
                if(count % 1 != 0)
                    greetingDisplay.setText(getString(R.string.numiscount) + dfdoub.format(count));
                else
                    greetingDisplay.setText(getString(R.string.numiscount) + dfint.format(count));
                Log.i("squaring", "" + count);

            }
        });
        sqrt = findViewById(R.id.sqrt);
        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = Math.sqrt(count);
                if(count % 1 != 0)
                    greetingDisplay.setText(getString(R.string.numiscount) + dfdoub.format(count));
                else
                    greetingDisplay.setText(getString(R.string.numiscount) + dfint.format(count));
                Log.i("rooting", "" + count);
            }
        });
        trunc = findViewById(R.id.trunc);
        trunc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = (int)count;
                greetingDisplay.setText(getString(R.string.numiscount) + dfint.format(count));
                Log.i("truncating", "" + count);
            }
        });
        reset = findViewById(R.id.reset);
        reset.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                greetingDisplay.setText(getString(R.string.numiscount) + dfint.format(count));
                Log.i("back to ", "" + count + "!");
            }
        }));

    }
}