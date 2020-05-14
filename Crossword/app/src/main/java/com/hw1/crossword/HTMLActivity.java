package com.totsp.crossword;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import com.totsp.crossword.shortyz.R;
import com.totsp.crossword.versions.AndroidVersionUtils;
import com.totsp.crossword.view.recycler.ShowHideOnScroll;


public class HTMLActivity extends ShortyzActivity {
	protected AndroidVersionUtils utils = AndroidVersionUtils.Factory.getInstance();
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        utils.holographic(this);
        utils.finishOnHomeButton(this);
        this.setContentView(R.layout.html_view);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        WebView webview = (WebView) this.findViewById(R.id.webkit);
        Uri u = this.getIntent()
                    .getData();
        webview.loadUrl(u.toString());
        FloatingActionButton download = (FloatingActionButton) this.findViewById(R.id.button_floating_action);
        if(download != null) {
            download.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            download.setImageBitmap(createBitmap("icons1.ttf", "k"));
            webview.setOnTouchListener(new ShowHideOnScroll(download));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getTitle() == null){
            finish();
            return true;
        }
        return false;
    }
}
