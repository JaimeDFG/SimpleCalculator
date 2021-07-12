package lord.apps.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.etInput);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }


    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos +1);
        }
        else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos +1);
        }
    }

    public void BTNzero(View view){
        updateText("0");
    }
    public void BTNone(View view){
        updateText("1");
    }
    public void BTNtwo(View view){
        updateText("2");
    }
    public void BTNthree(View view){
        updateText("3");
    }
    public void BTNfour(View view){
        updateText("4");
    }
    public void BTNfive(View view){
        updateText("5");
    }
    public void BTNsix(View view){
        updateText("6");
    }
    public void BTNseven(View view){
        updateText("7");
    }
    public void BTNeight(View view){
        updateText("8");
    }
    public void BTNnine(View view){
        updateText("9");
    }
    public void BTNpoint(View view){
        updateText(".");
    }
    public void BTNadd(View view){
        updateText("+");
    }
    public void BTNsub(View view){
        updateText("-");
    }
    public void BTNmult(View view){
        updateText("x");
    }
    public void BTNdiv(View view){
        updateText("÷");
    }
    public void BTNres(View view){
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("x", "*");

        Expression exp = new Expression(userExp);

        String results = String.valueOf(exp.calculate());

        display.setText(results);
        display.setSelection(results.length());
    }
    public void BTNclear(View view){
        display.setText("");
    }
    public void BTNsupr(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if(cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder)display.getText();
            selection.replace(cursorPos - 1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }
}
