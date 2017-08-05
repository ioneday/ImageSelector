package com.yongchun.multiimageselector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import com.yongchun.library.view.ImageSelectorActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageButton minus;
    private ImageButton plus;
    private EditText selectNumText;

    private RadioGroup selectMode;
    private RadioGroup showCamera;
    private RadioGroup enablePreview;
    private RadioGroup enableCrop;

    private Button selectPicture;

    private int maxSelectNum = 9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        registerListener();

    }
    public void initView(){
        minus = (ImageButton) findViewById(R.id.minus);
        plus = (ImageButton) findViewById(R.id.plus);
        selectNumText = (EditText) findViewById(R.id.select_num);

        selectMode = (RadioGroup) findViewById(R.id.select_mode);
        showCamera = (RadioGroup) findViewById(R.id.show_camera);
        enablePreview = (RadioGroup) findViewById(R.id.enable_preview);
        enableCrop = (RadioGroup) findViewById(R.id.enable_crop);

        selectPicture = (Button) findViewById(R.id.select_picture);
    }
    public void registerListener(){
        selectMode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.mode_single){
                    enableCrop.check(R.id.crop_enable);
                    findViewById(R.id.crop_enable).setEnabled(true);

                    enablePreview.check(R.id.preview_disable);
                    findViewById(R.id.preview_enable).setEnabled(false);
                }else{
                    enableCrop.check(R.id.crop_disable);
                    findViewById(R.id.crop_enable).setEnabled(false);

                    enablePreview.check(R.id.preview_enable);
                    findViewById(R.id.preview_enable).setEnabled(true);
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maxSelectNum --;
                selectNumText.setText(maxSelectNum+"");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maxSelectNum ++;
                selectNumText.setText(maxSelectNum+"");
            }
        });
        selectPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mode = selectMode.getCheckedRadioButtonId()==R.id.mode_multiple?ImageSelectorActivity.MODE_MULTIPLE:ImageSelectorActivity.MODE_SINGLE;
                boolean isShow = showCamera.getCheckedRadioButtonId() == R.id.camera_yes;
                boolean isPreview = enablePreview.getCheckedRadioButtonId() == R.id.preview_enable;
                boolean isCrop = enableCrop.getCheckedRadioButtonId() == R.id.crop_enable;

                ImageSelectorActivity.start(MainActivity.this, maxSelectNum, mode, isShow,isPreview,isCrop);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == ImageSelectorActivity.REQUEST_IMAGE){
            ArrayList<String> images = (ArrayList<String>) data.getSerializableExtra(ImageSelectorActivity.REQUEST_OUTPUT);
            startActivity(new Intent(this,SelectResultActivity.class).putExtra(SelectResultActivity.EXTRA_IMAGES,images));
        }
    }
}
