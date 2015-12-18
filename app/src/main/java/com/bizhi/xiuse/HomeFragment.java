package com.bizhi.xiuse;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bizhi.adapter.BeanAdapter;
import com.bizhi.adapter.ViewHolder;
import com.bizhi.module.BizhiData;
import com.bizhi.view.NetworkImageHolderView;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.GridViewWithHeaderAndFooter;

public class HomeFragment extends BaseFragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        return R.layout.fragment_home;
    }

    ConvenientBanner convenientBanner;
    BeanAdapter<BizhiData> adapter;
    GridViewWithHeaderAndFooter gridView;
    View header;

    public void initView(ViewHolder holder) {

        holder.text(R.id.title, "靓女壁纸");

        gridView = holder.get(R.id.grid);
        List<String> list = new ArrayList<>();
        list.add("http://img4.imgtn.bdimg.com/it/u=1508874223,494983671&fm=23&gp=0.jpg");
        list.add("http://img4.imgtn.bdimg.com/it/u=2211669641,2130303495&fm=23&gp=0.jpg");
        list.add("http://img4.imgtn.bdimg.com/it/u=1817164915,4043312701&fm=23&gp=0.jpg");
        list.add("http://img5.imgtn.bdimg.com/it/u=1984942354,925187071&fm=23&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=3678070140,3981933523&fm=23&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=1126717431,3542427520&fm=23&gp=0.jpg");
        list.add("http://img5.imgtn.bdimg.com/it/u=1460146393,1006150582&fm=23&gp=0.jpg");
        list.add("http://img2.imgtn.bdimg.com/it/u=1254845797,4004545901&fm=23&gp=0.jpg");
        list.add("http://img0.imgtn.bdimg.com/it/u=1399333239,3338131705&fm=23&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=2711403346,2140197657&fm=23&gp=0.jpg");
        list.add("http://img4.imgtn.bdimg.com/it/u=1298504124,3890824970&fm=23&gp=0.jpg");
        list.add("http://img0.imgtn.bdimg.com/it/u=1413006554,3209171348&fm=23&gp=0.jpg");
        list.add("http://img2.imgtn.bdimg.com/it/u=224772102,3742934588&fm=23&gp=0.jpg");
        list.add("http://img1.imgtn.bdimg.com/it/u=253933332,231979285&fm=23&gp=0.jpg");
        list.add("http://img1.imgtn.bdimg.com/it/u=831688875,916583386&fm=23&gp=0.jpg");
        list.add("http://img2.imgtn.bdimg.com/it/u=2628239434,1077451720&fm=23&gp=0.jpg");

        header = LayoutInflater.from(context).inflate(R.layout.banner, null);
        convenientBanner = (ConvenientBanner) header.findViewById(R.id.convenientBanner);
        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, list).setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                .setOnItemClickListener(new OnItemClickListener() {
                    public void onItemClick(int position) {
//                        startActivity(new Intent(context, BannerActivity.class).putExtra("POSITION", position).putExtra("ARRAY", array.toString()));
                    }
                }).startTurning(2000);

        gridView.addHeaderView(header);

        adapter = new BeanAdapter<BizhiData>(context, R.layout.style_item) {
            public void getView(int position, ViewHolder holder, BizhiData bean) {
                Ion.with(holder.image(R.id.image))
                        .load(bean.imgUrl);
                holder.text(R.id.text, bean.style);
            }
        };


        gridView.setAdapter(adapter);
        fillAdapter();
        adapter.notifyDataSetChanged();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    private void fillAdapter() {
        adapter.list.add(new BizhiData("美女", "http://www.bz55.com/uploads/allimg/140320/1-140320094R1.jpg"));
        adapter.list.add(new BizhiData("情感", "http://image2.90e.com/image/1600x900/1497.jpg"));
        adapter.list.add(new BizhiData("风景", "http://www.windows7en.com/uploads/140829/2009120309142160.jpg"));
        adapter.list.add(new BizhiData("动漫", "http://img1.mydrivers.com/img/20120727/3a0495aeee1a4643adb8ef1196d00ecb.jpg"));
        adapter.list.add(new BizhiData("文字", "http://img5.duitang.com/uploads/item/201504/24/20150424H5038_tViRW.jpeg"));
        adapter.list.add(new BizhiData("明显", "http://img4q.duitang.com/uploads/item/201410/02/20141002204704_htUSC.jpeg"));
        adapter.list.add(new BizhiData("城市", "http://img1.gamedog.cn/2013/07/18/44-130GPU4490-50.jpg"));
        adapter.list.add(new BizhiData("错觉", "http://d.3987.com/hsqpmn_140709/003.jpg"));
        adapter.list.add(new BizhiData("设计", "http://attach.bbs.miui.com/forum/201411/16/121257cfrtzt8srj8f77cv.png"));
        adapter.list.add(new BizhiData("物语", "http://img1.gamedog.cn/2013/08/01/34-130P11150300.jpg"));
        adapter.list.add(new BizhiData("其他", "http://d.3987.com/nenm_150307/desk_001.jpg"));
        adapter.list.add(new BizhiData("机械", "http://www.bz55.com/uploads/allimg/140320/1-140320094R1.jpg"));
        adapter.list.add(new BizhiData("男人", "http://image2.90e.com/image/1600x900/1497.jpg"));
        adapter.list.add(new BizhiData("动物", "http://www.windows7en.com/uploads/140829/2009120309142160.jpg"));
        adapter.list.add(new BizhiData("游戏", "http://img1.mydrivers.com/img/20120727/3a0495aeee1a4643adb8ef1196d00ecb.jpg"));
        adapter.list.add(new BizhiData("艺术", "http://img5.duitang.com/uploads/item/201504/24/20150424H5038_tViRW.jpeg"));

    }

}
