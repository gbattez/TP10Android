package com.example.admin.tp10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class ActivityMain extends AppCompatActivity
{
    TextView textInput;
    TextView[] textStack = new TextView[4];

    Stack<String> stack = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInput = (TextView) findViewById(R.id.textInput);

        textStack[0] = (TextView) findViewById(R.id.textStack1);
        textStack[1] = (TextView) findViewById(R.id.textStack2);
        textStack[2] = (TextView) findViewById(R.id.textStack3);
        textStack[3] = (TextView) findViewById(R.id.textStack4);
    }

    public void onClick1(View view)
    {
        final String text = textInput.getText() + "1";
        textInput.setText(text);
    }

    public void onClick2(View view)
    {
        final String text = textInput.getText() + "2";
        textInput.setText(text);
    }

    public void onClick3(View view)
    {
        final String text = textInput.getText() + "3";
        textInput.setText(text);
    }

    public void onClick4(View view)
    {
        final String text = textInput.getText() + "4";
        textInput.setText(text);
    }

    public void onClick5(View view)
    {
        final String text = textInput.getText() + "5";
        textInput.setText(text);
    }

    public void onClick6(View view)
    {
        final String text = textInput.getText() + "6";
        textInput.setText(text);
    }

    public void onClick7(View view)
    {
        final String text = textInput.getText() + "7";
        textInput.setText(text);
    }

    public void onClick8(View view)
    {
        final String text = textInput.getText() + "8";
        textInput.setText(text);
    }

    public void onClick9(View view)
    {
        final String text = textInput.getText() + "9";
        textInput.setText(text);
    }

    public void onClickPlus(View view)
    {
        doOperation('+');
    }

    public void onClickMinus(View view)
    {
        doOperation('-');
    }

    public void onClickDivide(View view)
    {
        doOperation('/');
    }

    public void onClickPop(View view)
    {
        if(stack.size() > 0)
        {
            stack.pop();
            updateStack();
        } else
        {
            Toast.makeText(this, R.string.stackAlreadyEmpty, Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickSwap(View view)
    {
        if(stack.size() >= 2)
        {
            String stack1 = stack.pop();
            String stack2 = stack.pop();

            stack.push(stack1);
            stack.push(stack2);

            updateStack();
        } else
        {
            Toast.makeText(this, R.string.stackMustHaveAtLeastTwoValues, Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickClear(View view)
    {
        textInput.setText("");

        stack.clear();
        updateStack();
    }

    public void onClickEnter(View view)
    {
        if(textInput.getText() != "")
        {
            stack.push((String) textInput.getText());
            textInput.setText("");
            updateStack();
        } else
        {
            Toast.makeText(this, R.string.inputIsEmpty, Toast.LENGTH_SHORT).show();
        }
    }

    public void doOperation(char operationCharacter)
    {
        if(stack.size() >= 2)
        {
            int nb2 = Integer.parseInt(stack.pop());
            int nb1 = Integer.parseInt(stack.pop());
            int res = 0;

            switch (operationCharacter)
            {
                case '+': res = nb1 + nb2; break;
                case '-': res = nb1 - nb2; break;
                case '/':
                    if(nb2 != 0)
                    {
                        res = nb1 / nb2;
                        break;
                    } else
                    {
                        Toast.makeText(this, R.string.divideByZeroError, Toast.LENGTH_SHORT).show();
                    }
            }

            stack.push(String.valueOf(res));
            updateStack();
        } else
        {
            Toast.makeText(this, R.string.stackMustHaveAtLeastTwoValues, Toast.LENGTH_SHORT).show();
        }
    }

    public void updateStack()
    {
        for(int i = 0; i < textStack.length; i++)
        {
            if(i < stack.size())
            {
                String text = stack.elementAt(stack.size() - 1 - i);
                textStack[i].setText(text);
            } else
            {
                textStack[i].setText("");
            }
        }
    }
}