package com.yun.adapter;

import java.io.File;
import java.util.List;

import com.yun.entity.ChatEntity;
import com.yun.entity.PeopleEntity;
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

public class AdapterPeopleList extends BaseAdapter {
	private Context context;
	private List<PeopleEntity> datas;

	public AdapterPeopleList(Context context, List<PeopleEntity> datas) {
		this.context = context;
		this.datas = datas;
	}

	public int getCount() {
		return datas.size();
	}

	public PeopleEntity getItem(int position) {
		return datas.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View view, ViewGroup parent) {
		PeopleEntity bean = getItem(position);
		if (bean.isStar()) {
			ItemHolder holder;
			if (view == null) {
				holder = new ItemHolder();
				LayoutInflater inflater = LayoutInflater.from(context);
				view = inflater.inflate(R.layout.item_inlist, null);
				holder.nameview = (TextView) view.findViewById(R.id.textview);

				view.setTag(holder);
			} else {
				holder = (ItemHolder) view.getTag();
			}
			//
			holder.nameview.setText(bean.getUserName());
			return view;
		} else {
			ItemHolder holder;
			if (view == null) {
				holder = new ItemHolder();
				LayoutInflater inflater = LayoutInflater.from(context);
				view = inflater.inflate(R.layout.item_people, null);
				//
				holder.nameview = (TextView) view.findViewById(R.id.peoplename);
				holder.imageview = (ImageView) view
						.findViewById(R.id.peopleimage);

				view.setTag(holder);
			} else {
				holder = (ItemHolder) view.getTag();
			}
			//

			holder.nameview.setText(bean.getUserName());
			if (!bean.getHeadImage().equals("")) {
				if (bean.getHeadImage().equals("1")) {
					holder.imageview.setImageResource(R.drawable.addpeople1);
				} else if (bean.getHeadImage().equals("2")) {
					holder.imageview.setImageResource(R.drawable.manypeople);
				} else if (bean.getHeadImage().equals("3")) {
					holder.imageview.setImageResource(R.drawable.tagpng);
				} else if (bean.getHeadImage().equals("4")) {
					holder.imageview.setImageResource(R.drawable.publicpng);
				} else {

					// System.out.println(">>>>>>>>>>>>>>" +
					// bean.getHeadImage());
					Bitmap bitmap = getDiskBitmap("/mnt/sdcard/tencent/MobileQQ/head/_hd/"
							+ bean.getHeadImage());
					if (bitmap != null) {
						holder.imageview.setImageBitmap(bitmap);
					}
				}
			}
			return view;
		}
	}

	private class ItemHolder {
		TextView nameview;
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