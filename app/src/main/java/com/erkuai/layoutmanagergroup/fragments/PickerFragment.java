package com.erkuai.layoutmanagergroup.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.erkuai.layoutmanagergroup.R;
import com.erkuai.layoutmanagergroup.managers.PickerLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class PickerFragment extends Fragment implements PickerLayoutManager.OnSelectedViewListener {

    private TextView tv_hour;
    private TextView tv_minute;
    private RecyclerView recycler_hour;
    private RecyclerView recycler_minute;
    private PickerLayoutManager hourManager;
    private PickerLayoutManager minuteManager;
    private List<String> hourData = new ArrayList<>();
    private List<String> minuteData = new ArrayList<>();

    {
        for (int i = 1; i <= 24; i++) {
            if (i <= 9) {
                hourData.add("0" + i);
            } else {
                hourData.add(i + "");
            }
        }

        for (int i = 0; i < 60; i++) {
            if (i <= 9) {
                minuteData.add("0" + i);
            } else {
                minuteData.add("" + i);
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_picker, container, false);
        tv_hour = (TextView) view.findViewById(R.id.tv_hour);
        tv_minute = (TextView) view.findViewById(R.id.tv_minute);
        recycler_hour = (RecyclerView) view.findViewById(R.id.recycler_hour);
        recycler_minute = (RecyclerView) view.findViewById(R.id.recycler_minute);

        hourManager = new PickerLayoutManager(getContext(), recycler_hour, PickerLayoutManager.VERTICAL, false, 3, 0.4f, true);
        recycler_hour.setLayoutManager(hourManager);
        recycler_hour.setAdapter(new PickAdapter(hourData));

        minuteManager = new PickerLayoutManager(getContext(), recycler_minute, PickerLayoutManager.VERTICAL, false, 3, 0.4f, true);
//        recycler_minute.setLayoutManager(minuteManager);
//        recycler_minute.setAdapter(new PickAdapter(minuteData));

        hourManager.setOnSelectedViewListener(this);
        minuteManager.setOnSelectedViewListener(this);
        return view;
    }

    @Override
    public void onSelectedView(View view, int position) {
        String tag = (String) view.getTag();
        switch (tag) {
            case "hour":
                tv_hour.setText(hourData.get(position));
                break;
            case "minute":
                tv_minute.setText(minuteData.get(position));
                break;

        }
    }

    class PickAdapter extends RecyclerView.Adapter<PickAdapter.ViewHolder> {

        private List<String> data;

        public PickAdapter(List<String> data) {
            this.data = data;
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.picker_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.textView.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            TextView textView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.item_text);
            }
        }
    }


}
