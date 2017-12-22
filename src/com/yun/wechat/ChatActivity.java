package com.yun.wechat;

import java.util.ArrayList;
import java.util.List;

import com.yun.adapter.AdapterChatList;
import com.yun.entity.ChatEntity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class ChatActivity extends Fragment {
	public View v;
	private ListView list;
	private List<ChatEntity> datas;	
	private AdapterChatList adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		LayoutInflater myinflater = getActivity().getLayoutInflater();
		v = myinflater.inflate(R.layout.activity_chat,null);
		list=(ListView)v.findViewById(R.id.chatlist);		
		datas=new ArrayList<ChatEntity>();
		datas.add(new ChatEntity("云闯","干嘛呢！","2月2日","0A9E1D1FCC73E52EFB72BA05E362E94D.png"));
		datas.add(new ChatEntity("Tom","Hello！","昨天","0AF5732F814911C7005F74AB69428D16.png"));
		datas.add(new ChatEntity("Jane","干嘛呢！","2月2日","1ADAFCAC45AF37C430D07ACCFA132FAE.png"));
		datas.add(new ChatEntity("Kangkang","Welcome","今天","1BADE75A9AA5FAF348D28117BB1F3793.png"));
		datas.add(new ChatEntity("Jhon","干嘛呢！","2月2日","6AA57B398F77BFFBCDE822A0A12CA0B3.png"));
		datas.add(new ChatEntity("Nice","干嘛呢！","2月2日","02C8FDEA55E7CAFA790D50D6E5608DC0.png"));
		datas.add(new ChatEntity("Yunchuang","来了吗！","2月2日","3F7BBC4CEC0ED94FBAFD5B1CAD037853.png"));
		datas.add(new ChatEntity("San","来了吗！","2月2日","5D5B48FC94A2645365AE50BE9373731C.png"));
		datas.add(new ChatEntity("Mesan","来了吗！","2月2日","dSAD"));
		adapter=new AdapterChatList(getActivity(),datas);
		list.setAdapter(adapter);
		return v;
	}

}
