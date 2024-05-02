package com.example.mbti;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

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

        enum MBTI_ID {
            ISFJ(R.id.btn_ISFJ, R.string.ISFJ, R.string.describe_ISFJ),
            INFJ(R.id.btn_INFJ, R.string.INFJ, R.string.describe_INFJ),
            ISTJ(R.id.btn_ISTJ, R.string.ISTJ, R.string.describe_ISTJ),
            INTJ(R.id.btn_INTJ, R.string.INTJ, R.string.describe_INTJ),
            ISFP(R.id.btn_ISFP, R.string.ISFP, R.string.describe_ISFP),
            INFP(R.id.btn_INFP, R.string.INFP, R.string.describe_INFP),
            ISTP(R.id.btn_ISTP, R.string.ISTP, R.string.describe_ISTP),
            INTP(R.id.btn_INTP, R.string.INTP, R.string.describe_INTP),
            ESFJ(R.id.btn_ESFJ, R.string.ESFJ, R.string.describe_ESFJ),
            ENFJ(R.id.btn_ENFJ, R.string.ENFJ, R.string.describe_ENFJ),
            ESTJ(R.id.btn_ESTJ, R.string.ESTJ, R.string.describe_ESTJ),
            ENTJ(R.id.btn_ENTJ, R.string.ENTJ, R.string.describe_ENTJ),
            ESFP(R.id.btn_ESFP, R.string.ESFP, R.string.describe_ESFP),
            ENFP(R.id.btn_ENFP, R.string.ENFP, R.string.describe_ENFP),
            ESTP(R.id.btn_ESTP, R.string.ESTP, R.string.describe_ESTP),
            ENTP(R.id.btn_ENTP, R.string.ENTP, R.string.describe_ENTP);

            private int mbtiBtnId;
            private int mbtiTitleId;
            private int mbtiBodyId;

            MBTI_ID(int mbtiBtnId, int mbtiTitleId, int mbtiBodyId) {
                this.mbtiBtnId = mbtiBtnId;
                this.mbtiTitleId = mbtiTitleId;
                this.mbtiBodyId = mbtiBodyId;
            }

            public int getMbtiBtnId() {
                return mbtiBtnId;
            }

            public int getMbtiTitleId() {
                return mbtiTitleId;
            }

            public int getMbtiBodyId() {
                return mbtiBodyId;
            }
            }


        String mbtiTypes[] = {"ISFJ","INFJ","ISFP","INFP","ISTJ","INTJ","ISTP","INTP","ESFJ","ENFJ","ESFP","ENFP","ESTJ","ENTJ","ESTP","ENTP"};
        for (int i = 0; i < mbtiTypes.length; i++) {
            String mbtiType = mbtiTypes[i];   //Bug발생
                      //enum에서 어떻게 field를 호출해야 하는지
            
            Button button = findViewById(MBTI_ID.getMbtiBtnId());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, SubActivity.class);
                    intent.putExtra("mbtiTitleId", MBTI_ID.getMbtiTitleId());
                    intent.putExtra("mbtiBodyId", MBTI_ID.getMbtiBodyId());
                    startActivity(intent);
                }
            });
        }


    }
}
