package com.erkuai.layoutmanagergroup.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.erkuai.layoutmanagergroup.R;
import com.erkuai.layoutmanagergroup.managers.EchelonLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class EchelonFragment extends Fragment {


    private RecyclerView recyclerView;
    private List<String> headList;
    private List<String> nicknames;
    private List<String> decs;
    private List<String> bgs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        initData();
        View view = inflater.inflate(R.layout.fragment_echelon, container, false);
        recyclerView = view.findViewById(R.id.recycler);

        recyclerView.setLayoutManager(new EchelonLayoutManager());
        recyclerView.setAdapter(new EchelonAdapter(headList, nicknames, decs, bgs));

        return view;
    }

    class EchelonAdapter extends RecyclerView.Adapter<EchelonAdapter.EchelonViewHolder> {

        private List<String> headList;
        private List<String> nicknames;
        private List<String> des;
        private List<String> bgs;

        private RequestOptions requestOptions1;
        private RequestOptions requestOptions2;

        public EchelonAdapter(List<String> headList, List<String> nicknames, List<String> des, List<String> bgs) {
            this.headList = headList;
            this.nicknames = nicknames;
            this.des = des;
            this.bgs = bgs;

            requestOptions1 = RequestOptions.circleCropTransform()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                    .skipMemoryCache(false);//不做内存缓存
            requestOptions2 = new RequestOptions();

        }

        @NonNull
        @Override
        public EchelonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.echelon_item, parent, false);
            return new EchelonViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull EchelonViewHolder holder, int position) {

            Glide.with(getContext()).setDefaultRequestOptions(requestOptions2).load(bgs.get(position % 4)).into(holder.bg);
            Glide.with(getContext()).setDefaultRequestOptions(requestOptions1).load(headList.get(position % 4)).into(holder.head);
            holder.nickname.setText(nicknames.get(position % 4));
            holder.des.setText(des.get(position % 4));
        }

        @Override
        public int getItemCount() {
            return 60;
        }

        class EchelonViewHolder extends RecyclerView.ViewHolder {

            ImageView head;
            ImageView bg;
            TextView nickname;
            TextView des;

            public EchelonViewHolder(@NonNull View itemView) {
                super(itemView);

                head = itemView.findViewById(R.id.head);
                bg = itemView.findViewById(R.id.bg);
                nickname = itemView.findViewById(R.id.tv_nickname);
                des = itemView.findViewById(R.id.des);

            }
        }
    }


    private void initData() {
        headList = new ArrayList<>();
        headList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576666138264&di=9af0f563b46b9dd800af3fe509f7a7fc&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Fsinacn10107%2F530%2Fw700h630%2F20190331%2F1743-huxwryw4256913.jpg");
        headList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576666138262&di=ba6a0414ba5fab82e0092d6feabb1a2d&imgtype=0&src=http%3A%2F%2Fpic2.zhimg.com%2F50%2Fv2-9d8c2e2ce175a049bda795f5b1a481dc_hd.jpg");
        headList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576666138259&di=a19fb853c0686c122dbe52da710f7019&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201511%2F06%2F20151106233720_ALJMe.jpeg");
        headList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576666138258&di=46670cef57fbd8e0df7c16246de03e20&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201703%2F20%2F20170320131919_4UQMP.thumb.700_0.jpeg");

        nicknames = new ArrayList<>();
        nicknames.add("左耳近心");
        nicknames.add("良玉初夏");
        nicknames.add("半窗疏影");
        nicknames.add("金玉良缘");

        decs = new ArrayList<>();
        decs.add("回不去的地方叫故乡 没有根的迁徙叫流浪。。。");
        decs.add("人生就像迷宫。");
        decs.add("原来地久天长 只是误会一场");
        decs.add("只想优雅转身 不料华丽撞墙");


        bgs = new ArrayList<>();
        bgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576666415876&di=20ee723d02259b74f9cb92f594cdac66&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F7cfb45be25c042cae16df82117a2aa87d3bc6865e074c-DzeoJX_fw658");
        bgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576666415876&di=01fde1158aa39d1b3f5ac4b500332bb5&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201603%2F20%2F20160320140722_LnGrH.jpeg");
        bgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576666415875&di=971864acff0f81d663bdb6e8b16dfc35&imgtype=0&src=http%3A%2F%2Fpic.51yuansu.com%2Fpic3%2Fcover%2F01%2F02%2F06%2F58de8d52e7f15_610.jpg");
        bgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576666415874&di=953393d260b623c6df794828a19c32ba&imgtype=0&src=http%3A%2F%2Fimg008.hc360.cn%2Fy4%2FM05%2FE9%2F5E%2FwKhQiFWAGBiEbUXZAAAAAFaj5ng500.jpg");
    }

}
