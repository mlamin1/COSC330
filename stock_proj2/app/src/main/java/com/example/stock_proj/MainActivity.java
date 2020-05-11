package com.example.stock_proj;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Model> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        productList = new ArrayList<Model>();
        ListView lview = (ListView) findViewById(R.id.listview);
        listviewAdapter adapter = new listviewAdapter(this, productList);
        lview.setAdapter(adapter);

        populateList();

        adapter.notifyDataSetChanged();

        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String sno = ((TextView) view.findViewById(R.id.symbol)).getText().toString();
                String product = ((TextView) view.findViewById(R.id.name)).getText().toString();
                String category = ((TextView) view.findViewById(R.id.last)).getText().toString();
                String price = ((TextView) view.findViewById(R.id.date)).getText().toString();

                Toast.makeText(getApplicationContext(),
                        "S no : " + sno + "\n"
                                + "Product : " + product + "\n"
                                + "Category : " + category + "\n"
                                + "Price : " + price, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateList() {

        Model item1, item2, item3, item4, item5;

        item1 = new Model("1", "Apple (Northern Spy)", "Fruits", "₹. 200");
        productList.add(item1);

        item2 = new Model("2", "Orange (Sunkist navel)", "Fruits", "₹. 100");
        productList.add(item2);

        item3 = new Model("3", "Tomato", "Vegetable", "₹. 50");
        productList.add(item3);

        item4 = new Model("4", "Carrot", "Vegetable", "₹. 80");
        productList.add(item4);

        item5 = new Model("5", "Banana (Cavendish)", "Fruits", "₹. 100");
        productList.add(item5);

        item5 = new Model("5", "Banana (Cavendish)", "Fruits", "₹. 100");
        productList.add(item5);

        item5 = new Model("5", "Banana (Cavendish)", "Fruits", "₹. 100");
        productList.add(item5);

        item5 = new Model("5", "Banana (Cavendish)", "Fruits", "₹. 100");
        productList.add(item5);

        item5 = new Model("5", "Banana (Cavendish)", "Fruits", "₹. 100");
        productList.add(item5);

        item5 = new Model("5", "Banana (Cavendish)", "Fruits", "₹. 100");
        productList.add(item5);

        item5 = new Model("5", "Banana (Cavendish)", "Fruits", "₹. 100");
        productList.add(item5);

        item5 = new Model("5", "Banana (Cavendish)", "Fruits", "₹. 100");
        productList.add(item5);

        item5 = new Model("5", "Banana (Cavendish)", "Fruits", "₹. 100");
        productList.add(item5);

        item5 = new Model("5", "Banana (Cavendish)", "Fruits", "₹. 100");
        productList.add(item5);

        item5 = new Model("5", "Banana (Cavendish)", "Fruits", "₹. 100");
        productList.add(item5);
    }
}
