package com.example.acewithpace2.ui.notifications;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.acewithpace2.R;

public class NotificationsFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    public NotificationsViewModel notificationsViewModel;
    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText edit_text;
    public Spinner spinner;
    public Button ButtonDisplay;
    public static final String[] paths = {"Select The Unit Of Plot","hectare", "mtr sq", "ft sq"};
    private Object AdapterView;
    TextView finalAnswer;
    double value;
    int id1;
    String selectedText, duration, unit;
    Button DisplayButton;
    EditText area;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        area = root.findViewById(R.id.ed_area);
        finalAnswer=root.findViewById(R.id.textView);
/*        DisplayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(String.valueOf(area.getText()));
                int Fer = a * 150;
                Double fer2 = Fer / 57.69;
            }
        });*/
        spinner = (Spinner) root.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
 /*       DisplayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(String.valueOf(area.getText()));
                int Fer = a * 150;
                Double fer2 = Fer / 57.69;
            }
        });*/

        return root;
    }
    @Override
    public void onItemSelected (android.widget.AdapterView < ? > parent, View view,int position,
                                long id){
        if (position == 0) {
        }
        if (position==1){
            Double a = Double.parseDouble(String.valueOf(area.getText()));
            Double Fer = a * 150;
            Double fer2 = Fer / 57.69;
            finalAnswer.setText("The amount Of fertilizer you need is"+fer2.toString()+"kg");
        }
        if (position==2){
            Double a = Double.parseDouble(String.valueOf(area.getText()));
            Double Fer = a / 10000;
            Double fer2=Fer * 150;
            Double fer3= (fer2 / 57.69);
            finalAnswer.setText("The amount Of fertilizer you need is"+fer3.toString()+"kg");
        }
        if (position==3){
            Double a = Double.parseDouble(String.valueOf(area.getText()));
            Double Fer = a / 107639;
            Double fer2=Fer * 150;
            Double fer3= fer2 / 57.69;
            finalAnswer.setText("The amount Of fertilizer you need is"+fer3.toString()+"kg");
        }
    }
    @Override
    public void onNothingSelected (android.widget.AdapterView < ? > parent){
    }
}
