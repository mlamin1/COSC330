package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.AndroidException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.patriques.AlphaVantageConnector;
import org.patriques.TimeSeries;
import org.patriques.input.timeseries.Interval;
import org.patriques.input.timeseries.OutputSize;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.timeseries.IntraDay;
import org.patriques.output.timeseries.data.StockData;

import java.net.*;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;


public class AlphaVantage {

    public String api_key = "Q4XEK6ZUXET8G86P";
    int linecount;
    TextView txtJson;
    public String[] data = new String[10]; //symbol, price, date, time, open, close, high, low, volume, prediction.
    String symbolMain = "AAPL";

    private void printData(){
        for (int i = 0; i <= 8; i++) {
            txtJson.append("\n" + i + "  " + data[i]);
        }
    }

    public void executeFunc1(String symbol) throws Exception{
        JsonTask task = new JsonTask();
        String result = task.execute("https://financialmodelingprep.com/api/v3/stock/real-time-price/"+symbol).get();
        String delims = "[{:},\n\"]";
        String[] tokens = result.split(delims);
        data[0] = tokens[6];    //symbol
        data[1] = tokens[12];   //price
    }

    public void executeFunc2(String symbol) throws Exception{
        JsonTask task = new JsonTask();
        String result = task.execute("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol="+symbol+"&interval=5min&apikey="+ api_key).get();
        String delims = "[{:},\n\"]";
        String[] tokens = result.split(delims);
        String[] temp = tokens[62].split(" ");
        String tempTime = (temp[1]+":"+tokens[63]+":"+tokens[64]);
        data[2] = temp[0];     //date
        data[3] = tempTime;     //time
        data[4] = tokens[72];     //open
        data[5] = tokens[93];     //close
        data[6] = tokens[79];     //high
        data[7] = tokens[86];     //low
        data[8] = tokens[100];     //volume
        data[9] = "Buy";
    }

    private class JsonTask extends AsyncTask<String, String, String> {


        protected String doInBackground(String... params) {


            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";
                linecount = 0;
                while ((line = reader.readLine()) != null && linecount < 25) {
                    buffer.append(line+"\n");
                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)
                    linecount++;
                }

                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
        }
    }

}
