package com.bizhi.xiuse;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.ViewGroup;

import com.bizhi.adapter.RecyclerAdapter;
import com.bizhi.adapter.RecyclerHolder;
import com.bizhi.adapter.ViewHolder;
import com.bizhi.module.BizhiData;
import com.koushikdutta.ion.Ion;

public class ChoiceFragment extends BaseFragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ChoiceFragment() {
    }

    public static ChoiceFragment newInstance(String param1, String param2) {
        ChoiceFragment fragment = new ChoiceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public int getLayoutId() {
        return R.layout.fragment_choice;
    }


    RecyclerAdapter<BizhiData> adapter;
    RecyclerView recyclerView;

    public void initView(ViewHolder holder) {

        holder.text(R.id.title, "推荐");

        recyclerView = holder.get(R.id.recyclerView);
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(sglm);

        adapter = new RecyclerAdapter<BizhiData>(context, R.layout.sub_title_item, R.layout.image_item, R.layout.image_line_item) {

            public int getItemViewType(int position) {
                return list.get(position).type;
            }

            //神奇方法 设置Item是否全屏
            public void onViewAttachedToWindow(RecyclerHolder holder) {
                super.onViewAttachedToWindow(holder);
                ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
                if (lp != null && lp instanceof StaggeredGridLayoutManager.LayoutParams) {
                    StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
                    p.setFullSpan(list.get(holder.getLayoutPosition()).type != BizhiData.TYPE_IMAGE);
                }
            }

            public void onBindViewHolder(ViewHolder holder, int position, BizhiData bean) {

                switch (bean.type) {
                    case BizhiData.TYPE_SUB_TITLE: {
                        holder.text(R.id.text, bean.style);
                        break;
                    }
                    case BizhiData.TYPE_IMAGE: {
                        Ion.with(holder.image(R.id.image))
                                .load(bean.imgUrl);
                        break;
                    }
                    case BizhiData.TYPE_IMAGE_LINE: {
                        holder.text(R.id.name, bean.name);
                        holder.text(R.id.content, bean.content);
                        Ion.with(holder.image(R.id.image))
                                .load(bean.imgUrl);
                        break;
                    }
                }
            }
        };

        recyclerView.setAdapter(adapter);
        fillAdapter();
        adapter.notifyDataSetChanged();
    }

    private void fillAdapter() {
        adapter.list.add(new BizhiData(BizhiData.TYPE_SUB_TITLE, "每周壁纸推荐", "http://www.bz55.com/uploads/allimg/140320/1-140320094R1.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE, "情感", "http://image2.90e.com/image/1600x900/1497.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE, "城市", "http://img1.gamedog.cn/2013/07/18/44-130GPU4490-50.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE, "风景", "http://www.windows7en.com/uploads/140829/2009120309142160.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE, "文字", "http://img5.duitang.com/uploads/item/201504/24/20150424H5038_tViRW.jpeg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE, "动漫", "http://image2.90e.com/image/1600x900/1497.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE, "动漫", "http://img1.mydrivers.com/img/20120727/3a0495aeee1a4643adb8ef1196d00ecb.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_SUB_TITLE, "热门排行", "http://www.bz55.com/uploads/allimg/140320/1-140320094R1.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE, "文字", "http://img5.duitang.com/uploads/item/201504/24/20150424H5038_tViRW.jpeg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE, "明显", "http://img4q.duitang.com/uploads/item/201410/02/20141002204704_htUSC.jpeg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE, "城市", "http://img1.gamedog.cn/2013/07/18/44-130GPU4490-50.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE, "情感", "http://www.bz55.com/uploads/allimg/140320/1-140320094R1.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE, "情感", "http://image2.90e.com/image/1600x900/1497.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE, "风景", "http://www.windows7en.com/uploads/140829/2009120309142160.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_SUB_TITLE, "最新美图", "http://www.bz55.com/uploads/allimg/140320/1-140320094R1.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE, "动漫", "http://img1.mydrivers.com/img/20120727/3a0495aeee1a4643adb8ef1196d00ecb.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE, "明显", "http://img4q.duitang.com/uploads/item/201410/02/20141002204704_htUSC.jpeg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE, "明显", "http://www.windows7en.com/uploads/140829/2009120309142160.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE, "风景", "http://d.3987.com/nenm_150307/desk_001.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE, "城市", "http://img1.gamedog.cn/2013/07/18/44-130GPU4490-50.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE, "文字", "http://img5.duitang.com/uploads/item/201504/24/20150424H5038_tViRW.jpeg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_SUB_TITLE, "专辑推荐", "http://www.bz55.com/uploads/allimg/140320/1-140320094R1.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE_LINE, "小清新", "那些有的没的所谓青春,所谓文艺.", "http://d.3987.com/hsqpmn_140709/003.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE_LINE, "LOL英雄联盟", "LOL,由美国Riot Games开发的3D大型竞技场战网游戏", "http://attach.bbs.miui.com/forum/201411/16/121257cfrtzt8srj8f77cv.png"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE_LINE, "插画絮语", "美味插画家都是孩子", "http://img1.gamedog.cn/2013/08/01/34-130P11150300.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE_LINE, "换个头像", "只有你想不到的没有蛋蛋君不提供的", "http://d.3987.com/nenm_150307/desk_001.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE_LINE, "刀剑神域", "这个世界,只需要一把剑就可以去往任何地方", "http://www.bz55.com/uploads/allimg/140320/1-140320094R1.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE_LINE, "动漫大杂烩", "全部倒进来,翻滚吧!", "http://image2.90e.com/image/1600x900/1497.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE_LINE, "我是福利", "你懂的", "http://www.windows7en.com/uploads/140829/2009120309142160.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE_LINE, "小清新", "那些有的没的所谓青春,所谓文艺.", "http://d.3987.com/hsqpmn_140709/003.jpg"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE_LINE, "LOL英雄联盟", "LOL,由美国Riot Games开发的3D大型竞技场战网游戏", "http://attach.bbs.miui.com/forum/201411/16/121257cfrtzt8srj8f77cv.png"));
        adapter.list.add(new BizhiData(BizhiData.TYPE_IMAGE_LINE, "插画絮语", "美味插画家都是孩子", "http://img1.gamedog.cn/2013/08/01/34-130P11150300.jpg"));
    }

}
