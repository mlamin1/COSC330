package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Chapter_1 extends AppCompatActivity {

    ListView listView;

    /*
    LIST OF THE WORDS FOR THE GLOSSARY
     */
    String[] words = {"Appointment","Allergy","Checkup","Co-pay","Emergency","Fever","Fiber","Generic Medicine","Headache","Health History","Health Insurance","Label",
    "Medicine Interpreter","Medicine","Nutrition","Obesity","Over-the-counter(OTC)","Pharmacy","Pharmacist","Prescription(Rx)","Primary Care Center","Recipe","Side Effect",
    "Sodium","Sore Throat","Symptoms","Warning Label","Vitamins"};

    /*
    DEFINITION OF THE GLOSSARY
     */
    String[] definition = {"A time to meet or agree to see someone", "Reaction to certain foods or other things, may cause rash, hives, sneezing, or other  problems",
    "A visit to the doctor when you are not sick, also called a well visit", "When you pay a set fee every time you go to the doctor and your health insurance pays the rest",
    "When there is a serious problem and you need help right away", "When your body temperature is too high",
    "Foods that help you feel full and helps your stool come out", "Not a name brand medicine, usually less expensive than the name brand",
    "Pain or ache in your head", "The health problems you had in the past", "A program where you pay each month and then the program pays for your health care",
    "On the bottle or box to describe the medicine and how to take it", "A person who is trained to translate information from doctor to patient and from patient to doctor",
    "Used when you are sick or have aches and pain to help make you feel well", "How the body uses food to stay healthy", "Being very overweight, a weight that is dangerous for your health",
    "Medicine anyone can buy at a store, you do not need a prescription","Where you go to buy medicine","A person who works in the pharmacy, a person who fills prescriptions",
    "You need one of these from a doctor to buy some kinds of medicines","The place you go for all your basic health care needs, could be a health center, health clinic, or doctor�s office",
            "List of what goes into a meal and how to prepare it","An unwanted result or symptom, you get from taking some medicines","Another word for salt",
    "When your throat hurts, it is hard to swallow","Something that happens in the body that shows you have an injury or illness","Describes dangers and what NOT to do when taking medicines",
    "A kind of nutrient in foods that help fight sickness and keep the body strong and healthy"};

    /*
    PICTURES FOR THE GLOSSARY
     */
    int[] pictures = {R.drawable.appointment, R.drawable.alllergy, R.drawable.checkup, R.drawable.co_pay, R.drawable.emergency, R.drawable.fever,
    R.drawable.fiber, R.drawable.geeneric_medicine,R.drawable.heeadache, R.drawable.health_history,R.drawable.health_insurance,R.drawable.label,
    R.drawable.medical_intepreter,R.drawable.medicine,R.drawable.nutrition,R.drawable.obesity,R.drawable.over_the_counter,R.drawable.pharmacy,
    R.drawable.pharmacist,R.drawable.prescription,R.drawable.primary_caare_center,R.drawable.recipe,R.drawable.side_effect,R.drawable.sodium,
    R.drawable.soar_throat,R.drawable.symptoms,R.drawable.warning_label,R.drawable.vitamins};

    /*
    SOUND PICTURES FOR THE GLOSSARY?
     */
/*
    int[] sound = {R.drawable.sound,R.drawable.sound,R.drawable.sound,R.drawable.sound,R.drawable.sound,R.drawable.sound,R.drawable.sound,
            R.drawable.sound,R.drawable.sound,R.drawable.sound,R.drawable.sound,R.drawable.sound,R.drawable.sound,R.drawable.sound,R.drawable.sound,
            R.drawable.sound,R.drawable.sound,R.drawable.sound,R.drawable.sound,R.drawable.sound,R.drawable.sound,R.drawable.sound,R.drawable.sound,
            R.drawable.sound,R.drawable.sound,R.drawable.sound,R.drawable.sound,R.drawable.sound};*/

    /*
    PRONUNCIATION OF THE WORDS
    */
    int[] pronounce = {R.raw.appointment, R.raw.allergy};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_1);

        listView = findViewById(R.id.listview);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent intent = new Intent(getApplicationContext(), Listdata.class);
                intent.putExtra("name", words[i]);
                intent.putExtra("image", pictures[i]);
                intent.putExtra("def", definition[i]);

                /*
                DR WANG'S IDEA

                //   intent.putExtra("index", i);
                 */
                startActivity(intent);
            }
        });

    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return pictures.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data, null);

            TextView name = view1.findViewById(R.id.words);
            ImageView image = view1.findViewById(R.id.pictures);
         //   ImageButton button = view1.findViewById(R.id.sound);

            name.setText(words[position]);
            image.setImageResource(pictures[position]);
           // button.setImageResource(sound[position]);



            return view1;
        }
    }
}
