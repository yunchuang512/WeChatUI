package com.yun.adapter;

import java.io.File;
import java.util.List;

import com.yun.entity.ChatEntity;
import com.yun.wechat.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterChatList extends BaseAdapter {
	private Context context;
	private List<ChatEntity> datas;

	public AdapterChatList(Context context, List<ChatEntity> datas) {
		this.context = context;
		this.datas = datas;
	}

	public int getCount() {
		return datas.size();
	}

	public ChatEntity getItem(int position) {
		return datas.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View view, ViewGroup parent) {
		ItemHolder holder;
		if (view == null) {
			holder = new ItemHolder();
			LayoutInflater inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.item_currentchat, null);
			//
			holder.nameview = (TextView) view.findViewById(R.id.chatname);
			holder.lastsview = (TextView) view.findViewById(R.id.lasts);
			holder.dateview = (TextView) view.findViewById(R.id.chatdate);
			holder.imageview = (ImageView) view.findViewById(R.id.chatimage);

			view.setTag(holder);
		} else {
			holder = (ItemHolder) view.getTag();
		}
		//
		ChatEntity bean = getItem(position);
		holder.nameview.setText(bean.getName());
		holder.lastsview.setText(bean.getLastS());
		holder.dateview.setText(bean.getDate());
		if (!bean.getImage().equals("")) {
			System.out.println(">>>>>>>>>>>>>>" + bean.getImage());
			Bitmap bitmap = getDiskBitmap("/mnt/sdcard/tencent/MobileQQ/head/_hd/"
					+ bean.getImage());
			if (bitmap != null) {
				holder.imageview.setImageBitmap(bitmap);
			}
		}
		return view;
	}

	private class ItemHolder {
		TextView nameview;
		TextView lastsview;
		TextView dateview;
		ImageView imageview;
	}

	private Bitmap getDiskBitmap(String pathString) {
		Bitmap bitmap = null;
		try {
			File file = new File(pathString);
			if (file.exists()) {
				bitmap = BitmapFactory.decodeFile(pathString);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return bitmap;
	}
}