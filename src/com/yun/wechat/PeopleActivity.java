package com.yun.wechat;

import java.util.ArrayList;
import java.util.List;

import com.yun.adapter.AdapterPeopleList;
import com.yun.entity.ChatEntity;
import com.yun.entity.PeopleEntity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class PeopleActivity extends Fragment {
	public View v;
	private ListView listview;
	private List<PeopleEntity> datas;
	private AdapterPeopleList adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		LayoutInflater myinflater = getActivity().getLayoutInflater();
		v = myinflater.inflate(R.layout.activity_people,
				(ViewGroup) getActivity().findViewById(R.id.mypageview), false);
		listview = (ListView) v.findViewById(R.id.listview);
		datas = new ArrayList<PeopleEntity>();
		datas.add(new PeopleEntity("新的朋友", "1", false));
		datas.add(new PeopleEntity("群聊", "2", false));
		datas.add(new PeopleEntity("标签", "3", false));
		datas.add(new PeopleEntity("公众号", "4", false));
		datas.add(new PeopleEntity("星标朋友", "123", true));
		datas.add(new PeopleEntity("云闯",
				"0A9E1D1FCC73E52EFB72BA05E362E94D.png", false));
		datas.add(new PeopleEntity("Tom",
				"0AF5732F814911C7005F74AB69428D16.png", false));
		datas.add(new PeopleEntity("Jane",
				"1ADAFCAC45AF37C430D07ACCFA132FAE.png", false));
		datas.add(new PeopleEntity("Kangkang",
				"1BADE75A9AA5FAF348D28117BB1F3793.png", false));
		datas.add(new PeopleEntity("Jhon",
				"6AA57B398F77BFFBCDE822A0A12CA0B3.png", false));
		datas.add(new PeopleEntity("Nice",
				"02C8FDEA55E7CAFA790D50D6E5608DC0.png", false));
		datas.add(new PeopleEntity("Yunchuang",
				"3F7BBC4CEC0ED94FBAFD5B1CAD037853.png", false));
		adapter = new AdapterPeopleList(getActivity(), datas);
		listview.setAdapter(adapter);
		return v;
	}

}
