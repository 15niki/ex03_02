package com.example.ex03_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine,btnZero;
    Button btnChu,btnAdd,btnReduce,btnMul;
    Button btnCLs,btnDel,btnEquals,btnPoint,btn1;
    TextView textResult;
    boolean flag;//标签
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取界面上的各种组件
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnZero = (Button) findViewById(R.id.btnZero);
        btnChu = (Button) findViewById(R.id.btnChu);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnReduce = (Button) findViewById(R.id.btnReduce);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnCLs = (Button) findViewById(R.id.btnCLs);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnEquals = (Button) findViewById(R.id.btnEquals);
        btnPoint = (Button) findViewById(R.id.btnPoint);
        btn1=(Button)findViewById(R.id.btn1);
        textResult = (TextView)findViewById(R.id.textResult);

        //设置监听按钮
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnZero.setOnClickListener(this);

        btnChu.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnReduce.setOnClickListener(this);
        btnMul.setOnClickListener(this);

        btnCLs.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String str = textResult.getText().toString();
        switch (view.getId()) {//判断用户选择的按钮
            case R.id.btnOne:
            case R.id.btnTwo:
            case R.id.btnThree:
            case R.id.btnFour:
            case R.id.btnFive:
            case R.id.btnSix:
            case R.id.btnSeven:
            case R.id.btnEight:
            case R.id.btnNine:
            case R.id.btnZero:
            case R.id.btnPoint:
                //如果flag为TRUE说明已完成一次计算，因此我们就需要将其恢复为FALSE，将文本和字符串str恢复为默认值
                if(flag){
                    flag = false;
                    str = "";
                    textResult.setText("");

                }
                textResult.setText(str + ((Button) view).getText());
                break;

            case R.id.btnChu:
            case R.id.btnAdd:
            case R.id.btnReduce:
            case R.id.btn1:
            case R.id.btnMul:
                if(flag){
                    flag = false;
                    str = "";
                    textResult.setText("");

                }
                textResult.setText(str + " " + ((Button) view).getText() + " ");
                break;

            case R.id.btnCLs:
                if(flag){
                    flag = false;
                    str = "";
                    textResult.setText("");

                }
                textResult.setText("");
                break;

            case R.id.btnDel:
                if(flag){
                    flag = false;
                    str = "";
                    textResult.setText("");

                }

                if(str != null && !str.equals("")){
                    textResult.setText(str.substring(0,str.length()-1));//退位，将字符串的长度减一只显示0到长度减一的字符串
                }
                break;
            case R.id.btnEquals:
                getresult();
        }
    }

    private void getresult() {
        String exp = textResult.getText().toString(); //从textview获取整个文本
        if(exp == null || exp.equals("")){
            return;
        }
        if(!exp.contains(" ")){
            return;
        }
        //在getresult方法内因为没有对str字符串和文本框做出任何修改所以我们只需要将flag的值转变为FALSE即可
        if(flag){
            flag = false;
            return;
        }

        //进入getresult方法代表第一次求值，完成后flag = TRUE
        flag = true;
        //将其中的两个数字和运算符分割出来
        float result = 0;
        String num1 = exp.substring(0,exp.indexOf(" "));
        String ex = exp.substring(exp.indexOf(" ") + 1,exp.indexOf(" ") + 2);
        String num2 = exp.substring(exp.indexOf(" ") + 3);
        //如果两个数字都不为空则判断运算符进行运算

        if(!num1.equals("") && !num2.equals("")) {
            float d1 = Float.parseFloat(num1);
            float d2 = Float.parseFloat(num2);

            if (ex.equals("+")) {
                result = d1 + d2;
            } else if (ex.equals("-")) {
                result = d1 - d2;
            } else if (ex.equals("*")) {
                result = d1 * d2;
            }  else if (ex.equals("÷")) {
                if (d2 == 0) {
                    result = 0;
                } else {
                    result = d1 / d2;
                }
            }
            textResult.setText(result + "");
        }else if(!num1.equals("") && num2.equals("")){
            textResult.setText(exp.substring(0,exp.indexOf(" ")));
        }else if(num1.equals("") && !num2.equals("")){
            float d3 = Float.parseFloat(num2);
            if(ex.equals("√")){
                result = (float) Math.sqrt(d3);
            }
            if(ex.equals("+")){
                result = 0 + d3;
            }else if(ex.equals("-")){
                result = 0 - d3;
            }else if(ex.equals("*")){
                result = 0 * d3;
            }else if(ex.equals("÷")){
                result = 0;
            }
            textResult.setText(result + "");
        } else{
            textResult.setText("");
        }



    }
}




