package com.jaesung.myqrcodereader;

import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;

import static com.jaesung.myqrcodereader.LogUtil.LOG_TRACE;

/**
 * Created by moon_jaesung on 2018/05/22.
 */

public class QrCodeReaderActivity extends Activity implements QRCodeReaderView.OnQRCodeReadListener {

    private QRCodeReaderView mQrCodeReaderView;
    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code_reader);
        mTextView = findViewById(R.id.textView);
        mQrCodeReaderView = findViewById(R.id.qrdecoderview);
        mQrCodeReaderView.setOnQRCodeReadListener(this);

        // Use this function to enable/disable decoding
        mQrCodeReaderView.setQRDecodingEnabled(true);

        // Use this function to change the autofocus interval (default is 5 secs)
        mQrCodeReaderView.setAutofocusInterval(2000L);

        // Use this function to enable/disable Torch
        mQrCodeReaderView.setTorchEnabled(true);

        // Use this function to set front camera preview
        mQrCodeReaderView.setFrontCamera();

        // Use this function to set back camera preview
        mQrCodeReaderView.setBackCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mQrCodeReaderView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mQrCodeReaderView.stopCamera();
    }

    @Override
    public void onQRCodeRead(String text, PointF[] points) {
        LOG_TRACE("text = " + text);
        mTextView.setText(text);
    }

}
