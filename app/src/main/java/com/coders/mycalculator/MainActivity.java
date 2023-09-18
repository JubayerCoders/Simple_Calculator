package com.coders.mycalculator;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import soup.neumorphism.NeumorphButton;

public class MainActivity extends AppCompatActivity {


    NeumorphButton btn_ac, btn_parcent, btn_divison, btn_delete, btn_seven, btn_eight, btn_nine, btn_mul, btn_four, btn_five, btn_six, btn_minus,
                   btn_one,btn_two, btn_three, btn_plus, btn_C, btn_zero, btn_dot, btn_equal;
    TextView result_display, input_display;
    Animation PushDown;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------Button Identity------//
        btn_ac = findViewById(R.id.btn_ac);
        btn_parcent = findViewById(R.id.btn_parcent);
        btn_divison = findViewById(R.id.btn_divison);
        btn_delete = findViewById(R.id.btn_delete);
        btn_seven = findViewById(R.id.btn_seven);
        btn_eight = findViewById(R.id.btn_eight);
        btn_nine = findViewById(R.id.btn_nine);
        btn_mul = findViewById(R.id.btn_mul);
        btn_four = findViewById(R.id.btn_four);
        btn_five = findViewById(R.id.btn_five);
        btn_six = findViewById(R.id.btn_six);
        btn_minus = findViewById(R.id.btn_minus);
        btn_one = findViewById(R.id.btn_one);
        btn_two = findViewById(R.id.btn_two);
        btn_three = findViewById(R.id.btn_three);
        btn_plus = findViewById(R.id.btn_plus);
        btn_C = findViewById(R.id.btn_C);
        btn_zero = findViewById(R.id.btn_zero);
        btn_dot = findViewById(R.id.btn_dot);
        btn_equal = findViewById(R.id.btn_equal);
        //------Diaplay Identity------//
        result_display = findViewById(R.id.result_display);
        input_display = findViewById(R.id.input_display);

        PushDown = AnimationUtils.loadAnimation(this, R.anim.push_down);




        btn_ac.setOnClickListener(view -> {

            btn_ac.startAnimation(PushDown);
            sucess();

            data = input_display.getText().toString();
            input_display.setText("");
            result_display.setText("");


        });

        btn_parcent.setOnClickListener(view -> {

            btn_parcent.startAnimation(PushDown);
            sucess();

            data = input_display.getText().toString();
            input_display.setText(data+"%");


        });


        btn_divison.setOnClickListener(view -> {

            btn_divison.startAnimation(PushDown);
            sucess();

            data = input_display.getText().toString();
            input_display.setText(data+"÷");


        });


        btn_delete.setOnClickListener(view -> {

            btn_delete.startAnimation(PushDown);
            sucess();
            oneBYone();
            // input_display.setText("");



        });


        btn_seven.setOnClickListener(view -> {

            btn_seven.startAnimation(PushDown);
            sucess();

            data = input_display.getText().toString();
            input_display.setText(data+"7");


        });


        btn_eight.setOnClickListener(view -> {

            btn_eight.startAnimation(PushDown);
            sucess();

            data = input_display.getText().toString();
            input_display.setText(data+"8");


        });


        btn_nine.setOnClickListener(view -> {

            btn_nine.startAnimation(PushDown);
            sucess();

            data = input_display.getText().toString();
            input_display.setText(data+"9");


        });


        btn_mul.setOnClickListener(view -> {

            btn_mul.startAnimation(PushDown);
            sucess();

            data = input_display.getText().toString();
            input_display.setText(data+"×");


        });


        btn_four.setOnClickListener(view -> {

            btn_four.startAnimation(PushDown);
            sucess();

            data = input_display.getText().toString();
            input_display.setText(data+"4");


        });


        btn_five.setOnClickListener(view -> {

            btn_five.startAnimation(PushDown);
            sucess();

            data = input_display.getText().toString();
            input_display.setText(data+"5");


        });


        btn_six.setOnClickListener(view -> {

            btn_six.startAnimation(PushDown);
            sucess();

            data = input_display.getText().toString();
            input_display.setText(data+"6");


        });


        btn_minus.setOnClickListener(view -> {

            btn_minus.startAnimation(PushDown);
            sucess();

            data = input_display.getText().toString();
            input_display.setText(data+"−");


        });


        btn_one.setOnClickListener(view -> {

            btn_one.startAnimation(PushDown);
            sucess();

            data = input_display.getText().toString();
            input_display.setText(data+"1");


        });


        btn_two.setOnClickListener(view -> {

            btn_two.startAnimation(PushDown);
            sucess();

            data = input_display.getText().toString();
            input_display.setText(data+"2");


        });


        btn_three.setOnClickListener(view -> {

            btn_three.startAnimation(PushDown);
            sucess();

            data = input_display.getText().toString();
            input_display.setText(data+"3");


        });


        btn_plus.setOnClickListener(view -> {

            btn_plus.startAnimation(PushDown);
            sucess();

            data = input_display.getText().toString();
            input_display.setText(data+"+");


        });

        btn_C.setOnClickListener(view -> {

            btn_C.startAnimation(PushDown);
            sucess();

            data = input_display.getText().toString();
            input_display.setText("");


        });


        btn_zero.setOnClickListener(view -> {

            btn_zero.startAnimation(PushDown);
            sucess();

            data = input_display.getText().toString();
            input_display.setText(data+"0");


        });


        btn_dot.setOnClickListener(view -> {

            btn_dot.startAnimation(PushDown);
            sucess();

            data = input_display.getText().toString();
            input_display.setText(data+".");


        });


        btn_equal.setOnClickListener(view -> {

            btn_equal.startAnimation(PushDown);
            sucess();

            data =input_display.getText().toString();


            data = data.replaceAll("×", "*");
            data = data.replaceAll("%", "/100");
            data = data.replaceAll("÷", "/");
            data = data.replaceAll("−", "-");


            Context rhino = Context.enter();
            rhino.setOptimizationLevel(-1);

            String final_result = "";

            try {
                Scriptable scriptable = rhino.initStandardObjects();
                final_result= rhino.evaluateString(scriptable, data, "Javascript", 1, null).toString();

                if (final_result.endsWith(".0")) {
                    final_result = final_result.replace(".0", "");
                }
                result_display.setText(final_result);
            } catch (Exception e) {
                return;
            }



        });





    }



    //-------------------------User Defind Method-------------------------//
    //------Toast--------//
    private void sucess() {


    }


    //----One by One text clear---//
    private void oneBYone() {
        String currentText = input_display.getText().toString();
        if (!TextUtils.isEmpty(currentText)) {
            String newText = currentText.substring(0, currentText.length() - 1);
            input_display.setText(newText);
        }
    }


}