package com.examples.lapgar.testr2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import java.sql.Connection;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Driver;
import android.content.Intent;


//import net.sourceforge.jtds.jdbc.*;






public class MyTestActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_test);
        //addListenerOnButton();
        final Button button = (Button) findViewById(R.id.bTN1);

        final Button buttonI = (Button) findViewById(R.id.instanceBTN);
        buttonI.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast msg;
                msg = Toast.makeText(getBaseContext(), "Going to the new screen.", Toast.LENGTH_LONG);
                msg.show();
                Intent i;
                i = new Intent(MyTestActivity.this, testMenu.class);
                //String myString ="Hello everyone.";
                //i.putExtra("qString", myString);
                startActivity(i);
                //startActivityForResult(i, 1);//What did that number 1 do again?
                // Perform action on click
                //Intent intent = new Intent(this, testMenu.class);

            }
        });
    }

    public void onbTN(View view) throws ClassNotFoundException {
        Toast msg;
        msg = Toast.makeText(getBaseContext(), "You have clicked Button 1", Toast.LENGTH_LONG);
        msg.show();
        TextView view1 = (TextView) findViewById(R.id.txtView1);
        view1.setText(getConnection());
    }

    public void onciTest(View view)
    {
        TextView view1 = (TextView) findViewById(R.id.txtView1);
        classyTest testClassString = new classyTest("What is this?");
        view1.setText(testClassString.printInterfaceTest());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public String getConnection() throws ClassNotFoundException {

        Connection conn = null;
        //conn = "//Lapgar-PC//SQLEXPRESS//58450"; //Lapgar-PC\SQLEXPRESS
        Properties connectionProps = new Properties();
        //connectionProps.put("user", this.userName);

        //String databaseURL = "jdbc:mysql://localhost:3306/test?user=root&password=root123";
        //String databaseURL = "jdbc:mysql://Lapgar-PC:58450//SQLEXPRESS?user=softlab_des&password=SUPER";
        //String databaseURL = "jdbc:sqlserver://Lapgar-PC\\SQLEXPRESS;databaseName=SoftClinic7;integratedSecurity=true";
        //String databaseURL = "jdbc:sqlserver://Lapgar-PC\\SQLEXPRESS;databaseName=SoftClinic7;integratedSecurity=true";
        String userName = "softlab_des";
        String password = "SUPER";
        //Lapgar-PC\SQLEXPRESS
        //String databaseURL = "jdbc:jtds:sqlserver://Lapgar-PC:58450;instanceName=Lapgar-PC\\MSSQLSERVER2008;DatabaseName="+"SoftClinic7"+";integratedSecurity=true;user="+userName+";password="+password;
        //String databaseURL = "jdbc:jtds:sqlserver://Lapgar-PC:58450;instanceName=Lapgar-PC\\MSSQLSERVER2008;DatabaseName="+"SoftClinic7"+";integratedSecurity=true;user="+userName+";password="+password;
        //"jdbc:jtds:sqlserver://10.0.2.2:1433;instanceName=14GRAFICALI\MSSQLSERVER2008;DatabaseName="+DBName+";integratedSecurity=true;user="+UserName+";password="+Password;

        String databaseURL = "jdbc:jtds:sqlserver://Lapgar-PC:58450;instanceName=Lapgar-PC\\SQLEXPRESS;DatabaseName="+"SoftClinic7"+";integratedSecurity=true;user="+userName+";password="+password;
        //String databaseURL = "jdbc:sqlserver://Lapgar-PC:58450;instanceName=Lapgar-PC\\SQLEXPRESS;DatabaseName="+"SoftClinic7"+";integratedSecurity=true;user="+userName+";password="+password;

        //C:\Users\Lapgar\AndroidStudioProjects\TestR2\app\libs\sqljdbc4-3.0.jar!\com\microsoft\sqlserver\jdbc
        //Connection conn = null;
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try
        {
            String driver = "net.sourceforge.jtds.jdbc.Driver";

            conn = DriverManager.getConnection(databaseURL);
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Driver d = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            //Driver d = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Driver d;
            //d = (Driver)(java.sql.DriverManager.getDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver"));

            //conn = d.connect(databaseURL, new Properties());

            //Class.forName(driver);



            conn = DriverManager.getConnection(databaseURL, userName, password);
            if (conn != null)
            {
                System.out.println("Connected to the database");
                //return "success";
            }
        }
        catch (SQLException ex)
        {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        finally {
            if (conn != null)
            {
                try
                {
                    conn.close();
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }

        //if (this.dbms.equals("mysql"))
        {
            /*conn = DriverManager.getConnection(
                    "jdbc:" + this.dbms + "://" +
                            this.serverName +
                            ":" + this.portNumber + "/",
                    connectionProps);*/

        }
        /*else if (this.dbms.equals("derby")) {
            conn = DriverManager.getConnection(
                    "jdbc:" + this.dbms + ":" +
                            this.dbName +
                            ";create=true",
                    connectionProps);
        }*/
        System.out.println("Connected to database?!");
        //return conn;

        return "Done";
    }
}
