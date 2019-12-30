package com.bwie.wymzhoukaoyi.view.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.wymzhoukaoyi.R;
import com.bwie.wymzhoukaoyi.model.bean.Bean;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {
    @BindView(R.id.tv_dj)
    TextView tvDj;
    @BindView(R.id.sm_ma)
    Button smMa;
    @BindView(R.id.xc_ma)
    Button xcMa;
    @BindView(R.id.img_er)
    ImageView imgEr;
    @BindView(R.id.bt)
    Button bt;
    @BindView(R.id.bt2)
    Button bt2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        //初始化数据
        CodeUtils.init(this);

        imgEr.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CodeUtils.analyzeByImageView(imgEr, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(SecondActivity.this, result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(SecondActivity.this, "解析失败", Toast.LENGTH_SHORT).show();
                    }
                });

                return true;
            }
        });

    }

    @OnClick({R.id.tv_dj, R.id.sm_ma, R.id.xc_ma})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_dj:
                String name = tvDj.getText().toString().trim();
                if (!TextUtils.isEmpty(name)) {
                    Bitmap image = CodeUtils.createImage(name, 400, 400, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round));
                    imgEr.setImageBitmap(image);
                }

                break;
            case R.id.sm_ma:
                CodeUtils.analyzeByCamera(this);
                break;
            case R.id.xc_ma:
                CodeUtils.analyzeByPhotos(this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        CodeUtils.onActivityResult(this, requestCode, resultCode, data, new CodeUtils.AnalyzeCallback() {
            @Override
            public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                Toast.makeText(SecondActivity.this, result, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnalyzeFailed() {
                Toast.makeText(SecondActivity.this, "解析失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.bt)
    public void onViewClicked() {
        EventBus.getDefault().post("张奕漫");

    }

    @Override
    protected void onStart() {
        super.onStart();
        // TODO: 2019/12/28 注册
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //todo 解绑
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onGetString(String string) {
        Toast.makeText(SecondActivity.this, "接受成功 " + string, Toast.LENGTH_SHORT).show();

    }

    @Subscribe
    public void onGetBean(Bean bean) {
        Toast.makeText(this, bean.getName() + bean.getAge() + "", Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.bt2)
    public void onViewClicked2() {
        EventBus.getDefault().post(new Bean("张奕漫", 18));
    }
}
