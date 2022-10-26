package com.example.recyclerviewradiobuttonkotlin.recyclerview;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerviewradiobuttonkotlin.R;

import java.util.ArrayList;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder>{

    ArrayList<String> arrayList;
    ItemClickListener itemClickListener;
    int selectedPosition = -1;

    public itemAdapter(ArrayList<String> arrayList, ItemClickListener itemClickListener) {
        this.arrayList = arrayList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //라디오버튼 텍스트 설정
        holder.rb.setText(arrayList.get(position));

        //라디오버튼 체크 설정
        holder.rb.setChecked(position == selectedPosition);

        holder.rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){
                    //선택한 값 변수에 담기
                    selectedPosition = holder.getAdapterPosition();

                    //클릭이벤트
                    itemClickListener.onClick(holder.rb.getText().toString());
                }
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        RadioButton rb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rb = itemView.findViewById(R.id.radio_button);
        }
    }
}