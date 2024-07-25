package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    AppCompatButton btn11, btn12, btn13, btn21, btn22, btn23, btn31, btn32, btn33;
    int flag= 0;
    String b11, b12, b13, b21, b22, b23, b31, b32, b33;
    int count= 0;
    Button btnReStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn11= findViewById(R.id.btn11);
        btn12= findViewById(R.id.btn12);
        btn13= findViewById(R.id.btn13);
        btn21= findViewById(R.id.btn21);
        btn22= findViewById(R.id.btn22);
        btn23= findViewById(R.id.btn23);
        btn31= findViewById(R.id.btn31);
        btn32= findViewById(R.id.btn32);
        btn33= findViewById(R.id.btn33);

        btnReStart= findViewById(R.id.btnReStart);

//        btn11.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        btnReStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reStartGame();
            }
        });

    }

    public void check(View vw) {
        Button currBtn= (Button) vw;
        if(currBtn.getText().toString().isEmpty()) {
            count++;

            if (flag == 0) {
                currBtn.setText("X");
                flag = 1;
            } else {
                currBtn.setText("0");
                flag = 0;
            }

            if (count > 4) {
                b11 = btn11.getText().toString();
                b12 = btn12.getText().toString();
                b13 = btn13.getText().toString();
                b21 = btn21.getText().toString();
                b22 = btn22.getText().toString();
                b23 = btn23.getText().toString();
                b31 = btn31.getText().toString();
                b32 = btn32.getText().toString();
                b33 = btn33.getText().toString();

                if (b11.equals(b12) && b12.equals(b13) && !b11.isEmpty()) {  //or we can write  !b11.equals("")
                    Toast.makeText(this, "Winner is : " + b11, Toast.LENGTH_SHORT).show();
                    reStartGame();
                } else if (b21.equals(b22) && b22.equals(b23) && !b23.isEmpty()) {
                    Toast.makeText(this, "Winner is : " + b21, Toast.LENGTH_SHORT).show();
                    reStartGame();
                } else if (b31.equals(b32) && b32.equals(b33) && !b33.isEmpty()) {
                    Toast.makeText(this, "Winner is : " + b31, Toast.LENGTH_SHORT).show();
                    reStartGame();
                } else if (b11.equals(b21) && b21.equals(b31) && !b31.isEmpty()) {
                    Toast.makeText(this, "Winner is : " + b11, Toast.LENGTH_SHORT).show();
                    reStartGame();
                } else if (b12.equals(b22) && b22.equals(b32) && !b32.isEmpty()) {
                    Toast.makeText(this, "Winner is : " + b12, Toast.LENGTH_SHORT).show();
                    reStartGame();
                } else if (b13.equals(b23) && b23.equals(b33) && !b33.isEmpty()) {
                    Toast.makeText(this, "Winner is : " + b13, Toast.LENGTH_SHORT).show();
                    reStartGame();
                } else if (b11.equals(b22) && b22.equals(b33) && !b33.isEmpty()) {
                    Toast.makeText(this, "Winner is : " + b11, Toast.LENGTH_SHORT).show();
                    reStartGame();
                } else if (b13.equals(b22) && b22.equals(b31) && !b31.isEmpty()) {
                    Toast.makeText(this, "Winner is : " + b13, Toast.LENGTH_SHORT).show();
                    reStartGame();
                }// Draw Condition : -
                else if (count==9) {  //other-hand we can check each btn is filled through   isBlank()  condition in each button
                    Toast.makeText(this, "Game is Drawn !!", Toast.LENGTH_SHORT).show();
                    reStartGame();
                }
            }

        }

    }
        //after winning the  all buttons should be reBlank
        public void reStartGame() {
            btn11.setText("");
            btn12.setText("");
            btn13.setText("");
            btn21.setText("");
            btn22.setText("");
            btn23.setText("");
            btn31.setText("");
            btn32.setText("");
            btn33.setText("");
            count= 0;
            flag= 0;
        }
    }