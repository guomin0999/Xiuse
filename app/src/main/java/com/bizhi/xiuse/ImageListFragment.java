package com.bizhi.xiuse;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.bizhi.adapter.RecyclerAdapter;
import com.bizhi.adapter.ViewHolder;
import com.bizhi.module.BizhiData;
import com.koushikdutta.ion.Ion;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ImageListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ImageListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageListFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public static ImageListFragment newInstance(String param1, String param2) {
        ImageListFragment fragment = new ImageListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ImageListFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
 
    public int getLayoutId() {
        return R.layout.fragment_image_list;
    }


    RecyclerAdapter<BizhiData> adapter;

    public void initView(ViewHolder holder) {
        RecyclerView recyclerView = holder.get(R.id.list);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        //recyclerView.addItemDecoration(new SpacesItemDecoration(16));

        adapter = new RecyclerAdapter<BizhiData>(getContext(), R.layout.bizhi_item) {
            public void onBindViewHolder(ViewHolder holder, int position, BizhiData bean) {
                Ion.with(holder.image(R.id.image))
                        .placeholder(R.drawable.ic_launcher)
                        .error(R.drawable.ic_launcher)
                        .load(bean.imgUrl);
            }
        };
        adapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getContext(), WallpaperActivity.class).putExtra("IMAGE_URL", adapter.list.get(position).imgUrl));
            }
        });

        adapter.list.add(new BizhiData("http://www.bz55.com/uploads/allimg/140320/1-140320094R1.jpg"));
        adapter.list.add(new BizhiData("http://image2.90e.com/image/1600x900/1497.jpg"));
        adapter.list.add(new BizhiData("http://www.windows7en.com/uploads/140829/2009120309142160.jpg"));
        adapter.list.add(new BizhiData("http://img1.mydrivers.com/img/20120727/3a0495aeee1a4643adb8ef1196d00ecb.jpg"));
        adapter.list.add(new BizhiData("http://img5.duitang.com/uploads/item/201504/24/20150424H5038_tViRW.jpeg"));
        adapter.list.add(new BizhiData("http://img4q.duitang.com/uploads/item/201410/02/20141002204704_htUSC.jpeg"));
        adapter.list.add(new BizhiData("http://img1.gamedog.cn/2013/07/18/44-130GPU4490-50.jpg"));
        adapter.list.add(new BizhiData("http://d.3987.com/hsqpmn_140709/003.jpg"));
        adapter.list.add(new BizhiData("http://attach.bbs.miui.com/forum/201411/16/121257cfrtzt8srj8f77cv.png"));
        adapter.list.add(new BizhiData("http://img1.gamedog.cn/2013/08/01/34-130P11150300.jpg"));
        adapter.list.add(new BizhiData("http://d.3987.com/nenm_150307/desk_001.jpg"));
        adapter.list.add(new BizhiData("http://www.bz55.com/uploads/allimg/140320/1-140320094R1.jpg"));
        adapter.list.add(new BizhiData("http://image2.90e.com/image/1600x900/1497.jpg"));
        adapter.list.add(new BizhiData("http://www.windows7en.com/uploads/140829/2009120309142160.jpg"));
        adapter.list.add(new BizhiData("http://img1.mydrivers.com/img/20120727/3a0495aeee1a4643adb8ef1196d00ecb.jpg"));
        adapter.list.add(new BizhiData("http://img5.duitang.com/uploads/item/201504/24/20150424H5038_tViRW.jpeg"));
        adapter.list.add(new BizhiData("http://img4q.duitang.com/uploads/item/201410/02/20141002204704_htUSC.jpeg"));
        adapter.list.add(new BizhiData("http://img1.gamedog.cn/2013/07/18/44-130GPU4490-50.jpg"));
        adapter.list.add(new BizhiData("http://d.3987.com/hsqpmn_140709/003.jpg"));
        adapter.list.add(new BizhiData("http://attach.bbs.miui.com/forum/201411/16/121257cfrtzt8srj8f77cv.png"));
        adapter.list.add(new BizhiData("http://img1.gamedog.cn/2013/08/01/34-130P11150300.jpg"));
        adapter.list.add(new BizhiData("http://d.3987.com/nenm_150307/desk_001.jpg"));
        adapter.list.add(new BizhiData("http://www.bz55.com/uploads/allimg/140320/1-140320094R1.jpg"));
        adapter.list.add(new BizhiData("http://image2.90e.com/image/1600x900/1497.jpg"));
        adapter.list.add(new BizhiData("http://www.windows7en.com/uploads/140829/2009120309142160.jpg"));
        adapter.list.add(new BizhiData("http://img1.mydrivers.com/img/20120727/3a0495aeee1a4643adb8ef1196d00ecb.jpg"));
        adapter.list.add(new BizhiData("http://img5.duitang.com/uploads/item/201504/24/20150424H5038_tViRW.jpeg"));
        adapter.list.add(new BizhiData("http://img4q.duitang.com/uploads/item/201410/02/20141002204704_htUSC.jpeg"));
        adapter.list.add(new BizhiData("http://img1.gamedog.cn/2013/07/18/44-130GPU4490-50.jpg"));
        adapter.list.add(new BizhiData("http://d.3987.com/hsqpmn_140709/003.jpg"));
        adapter.list.add(new BizhiData("http://attach.bbs.miui.com/forum/201411/16/121257cfrtzt8srj8f77cv.png"));
        adapter.list.add(new BizhiData("http://img1.gamedog.cn/2013/08/01/34-130P11150300.jpg"));
        adapter.list.add(new BizhiData("http://d.3987.com/nenm_150307/desk_001.jpg"));
        adapter.list.add(new BizhiData("http://www.bz55.com/uploads/allimg/140320/1-140320094R1.jpg"));
        adapter.list.add(new BizhiData("http://image2.90e.com/image/1600x900/1497.jpg"));
        adapter.list.add(new BizhiData("http://www.windows7en.com/uploads/140829/2009120309142160.jpg"));
        adapter.list.add(new BizhiData("http://img1.mydrivers.com/img/20120727/3a0495aeee1a4643adb8ef1196d00ecb.jpg"));
        adapter.list.add(new BizhiData("http://img5.duitang.com/uploads/item/201504/24/20150424H5038_tViRW.jpeg"));
        adapter.list.add(new BizhiData("http://img4q.duitang.com/uploads/item/201410/02/20141002204704_htUSC.jpeg"));
        adapter.list.add(new BizhiData("http://img1.gamedog.cn/2013/07/18/44-130GPU4490-50.jpg"));
        adapter.list.add(new BizhiData("http://d.3987.com/hsqpmn_140709/003.jpg"));
        adapter.list.add(new BizhiData("http://attach.bbs.miui.com/forum/201411/16/121257cfrtzt8srj8f77cv.png"));
        adapter.list.add(new BizhiData("http://img1.gamedog.cn/2013/08/01/34-130P11150300.jpg"));
        adapter.list.add(new BizhiData("http://d.3987.com/nenm_150307/desk_001.jpg"));
        recyclerView.setAdapter(adapter);
    }

    class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = space;
            }
        }
    }
}
