package huji.ac.il.tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edBillAmount = (EditText)findViewById(R.id.edtBillAmount);
        final TextView tvTipAmount = (TextView)findViewById(R.id.txtTipResult);
        final CheckBox chkRound = (CheckBox)findViewById(R.id.chkRound);
        final Button b = (Button)
                findViewById(R.id.btnCalculate);
        b.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        double d = Double.valueOf(edBillAmount.getText().toString());
                        double tip = d * 0.12;
                        tip = chkRound.isChecked()?Math.round(tip):tip;
                        tvTipAmount.setText("Tip: $" + Double.toString(tip));
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
