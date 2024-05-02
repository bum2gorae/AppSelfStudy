//enum은 class에서 정의되어야한다고 한다
//Override 위쪽으로 옮기니까 Debugging되었다
//가독성을 위해 MbtiEnum파일을 따로 만들었다
package com.example.mbti;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        String mbtiTypes[] = {"ISFJ", "INFJ", "ISFP", "INFP", "ISTJ", "INTJ", "ISTP", "INTP", "ESFJ", "ENFJ", "ESFP", "ENFP", "ESTJ", "ENTJ", "ESTP", "ENTP"};
        for (int i = 0; i < mbtiTypes.length; i++) {
            String mbtiType = mbtiTypes[i];
            MbtiEnum.MBTI_ID mbtiEnumId = MbtiEnum.MBTI_ID.valueOf(mbtiType);
            Button button = findViewById(mbtiEnumId.getMbtiBtnId());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, SubActivity.class);
                    intent.putExtra("mbtiTitleId", mbtiEnumId.getMbtiTitleId());
                    intent.putExtra("mbtiBodyId", mbtiEnumId.getMbtiBodyId());
                    startActivity(intent);
                }
            });
        }
    }
}
