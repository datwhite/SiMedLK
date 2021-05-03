package com.datwhite.simedlk.ui.profile;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.datwhite.simedlk.R;
import com.datwhite.simedlk.entity.Doctor;

import java.util.HashMap;

public class ProfileFragment extends Fragment {

    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        Doctor doctor = (Doctor) getArguments().getSerializable("doctor");
        System.out.println("DOCTOR " + doctor.getName());

        TextView docName = root.findViewById(R.id.doctorName);
//        TextView docSpec = root.findViewById(R.id.doctorSpec);

        docName.setText(doctor.getName());
//        if (doctor.getSpecialization().length() > 0)
//            docSpec.setText(doctor.getSpecialization());

//        //Скрол страницы
//        ScrollView scrollView = new ScrollView(getContext());

        LinearLayout layout = root.findViewById(R.id.profile_layout);
        // создаем параметры позиционирования для элемента
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams
                        (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        //Описание
        System.out.println(doctor.getDesc() != "");
        System.out.println(doctor.getDesc());
        if (!doctor.getDesc().equals("") && !doctor.getDesc().equals("-1")) {
            LinearLayout descrLayout = new LinearLayout(getContext(), null, 0, R.style.profile_item);
            // горизонтальная ориентация
            descrLayout.setOrientation(LinearLayout.VERTICAL);

            // устанавливаем отступы
            layoutParams.setMargins(0, 16, 0, 16);
            descrLayout.setPadding(20, 20, 20, 20);
            descrLayout.setLayoutParams(layoutParams);
            // добавляем элемент в LinearLayout
            TextView descr = new TextView(getContext());
            descr.setText("Описание");
            descr.setTextAppearance(R.style.TextAppearance_AppCompat_Body1);
            descr.setTextSize(18);
            descrLayout.addView(descr);
            // добавляем элемент в LinearLayout
            TextView descrText = new TextView(getContext());
            descrText.setText(doctor.getDesc());
            descrText.setTextSize(18);
            descrText.setPadding(20, 0, 0, 0);
            descrLayout.addView(descrText);

            layout.addView(descrLayout);
        }

        //Квалификация
        if (doctor.getQualification() != "") {
            LinearLayout qualifLayout = new LinearLayout(getContext(), null, 0, R.style.profile_item);
            // горизонтальная ориентация
            qualifLayout.setOrientation(LinearLayout.VERTICAL);
            // устанавливаем отступы
            layoutParams.setMargins(0, 16, 0, 16);
            qualifLayout.setPadding(20, 20, 20, 20);
            qualifLayout.setLayoutParams(layoutParams);
            // добавляем элемент в LinearLayout
            TextView qualif = new TextView(getContext());
            qualif.setText("Квалификация");
            qualif.setTextAppearance(R.style.TextAppearance_AppCompat_Body1);
            qualif.setTextSize(18);
            qualifLayout.addView(qualif);
            // добавляем элемент в LinearLayout
            TextView qualifText = new TextView(getContext());
            qualifText.setText(doctor.getQualification());
            qualifText.setTextSize(18);
            qualifText.setPadding(20, 0, 0, 0);
            qualifLayout.addView(qualifText);

            layout.addView(qualifLayout);
        }

        //Оказываемые услуги
        if (doctor.getServices() != "") {
            LinearLayout servicesLayout = new LinearLayout(getContext(), null, 0, R.style.profile_item);
            // горизонтальная ориентация
            servicesLayout.setOrientation(LinearLayout.VERTICAL);
            // устанавливаем отступы
            layoutParams.setMargins(0, 16, 0, 16);
            servicesLayout.setPadding(20, 20, 20, 20);
            servicesLayout.setLayoutParams(layoutParams);

            // добавляем элемент в LinearLayout
            TextView services = new TextView(getContext());
            services.setText("Оказываемые услуги");
            services.setTextAppearance(R.style.TextAppearance_AppCompat_Body1);
            services.setTextSize(18);
            servicesLayout.addView(services);
            // добавляем элемент в LinearLayout
            TextView servicesText = new TextView(getContext());
            servicesText.setText(doctor.getServices());
            servicesText.setTextSize(18);
            servicesText.setPadding(20, 0, 0, 0);
            servicesLayout.addView(servicesText);

            layout.addView(servicesLayout);
        }

        //Специальности
        if (doctor.getDOCT_IDs().size() > 0) {
            LinearLayout specsLayout = new LinearLayout(getContext(), null, 0, R.style.profile_item);
            // горизонтальная ориентация
            specsLayout.setOrientation(LinearLayout.VERTICAL);
            // устанавливаем отступы
            layoutParams.setMargins(0, 16, 0, 16);
            specsLayout.setPadding(20, 20, 20, 20);
            specsLayout.setLayoutParams(layoutParams);

            // добавляем элемент в LinearLayout
            TextView specs = new TextView(getContext());
            specs.setText("Спецальность");
            specs.setTextAppearance(R.style.TextAppearance_AppCompat_Body1);
            specs.setTextSize(18);
            specsLayout.addView(specs);
            // добавляем элемент в LinearLayout
            HashMap<String, String> specializations = (HashMap<String, String>) getArguments().getSerializable("specialization");
            for (int i : doctor.getDOCT_IDs()) {
                System.out.println(specializations.get(Integer.toString(i)));
                if (specializations.get(Integer.toString(i)) == null)
                    continue;
                TextView specsText = new TextView(getContext());
                specsText.setText(specializations.get(Integer.toString(i)));
                specsText.setTextSize(18);
                specsText.setPadding(20, 0, 0, 0);
                specsLayout.addView(specsText);
            }

            layout.addView(specsLayout);
        }

//        scrollView.addView(layout);


        return root;
    }

}
