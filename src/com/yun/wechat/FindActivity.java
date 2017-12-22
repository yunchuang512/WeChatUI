package com.yun.wechat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FindActivity extends Fragment {
	public View v;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		LayoutInflater myinflater = getActivity().getLayoutInflater();
		v = myinflater.inflate(R.layout.activity_find,
				(ViewGroup) getActivity().findViewById(R.id.mypageview), false);
		return v;
	}

}
