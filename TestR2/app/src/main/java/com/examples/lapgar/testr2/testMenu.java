package com.examples.lapgar.testr2;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
/**
 * Created by Lapgar on 10/28/2014.
 */
public class testMenu extends ActionBarActivity
{

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testmenu2);
        Intent intent = getIntent();
        EnglishFunction();
    }

    private void EnglishFunction()
    {

    }

    public void backMain(View view)
    {
        setResult(RESULT_CANCELED);
        finish();
    }

}
