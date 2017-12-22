package com.yun.wechat;

import java.util.ArrayList;
import java.util.List;

import com.yun.until.*;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	public static ViewPager pages;
	public View v1, v2;
	public Fragment chatview, peopleview, findview, myview;
	public TextView tchat, tpeople, tfind, tmy;
	public ImageView ichat, ipeople, ifind, imy;
	public LinearLayout chat, people, find, my;
	public List<Fragment> pagelist;
	public int current = 0;
	private ImageView isearch, iadd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_main); // 软件activity的布局
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.titlebar);
		Init();
	}

	public void Init() {
		tchat = (TextView) findViewById(R.id.tmenu1);
		tpeople = (TextView) findViewById(R.id.tmenu2);
		tfind = (TextView) findViewById(R.id.tmenu3);
		tmy = (TextView) findViewById(R.id.tmenu4);

		ichat = (ImageView) findViewById(R.id.imenu1);
		ipeople = (ImageView) findViewById(R.id.imenu2);
		ifind = (ImageView) findViewById(R.id.imenu3);
		imy = (ImageView) findViewById(R.id.imenu4);

		chat = (LinearLayout) findViewById(R.id.menu1);
		people = (LinearLayout) findViewById(R.id.menu2);
		find = (LinearLayout) findViewById(R.id.menu3);
		my = (LinearLayout) findViewById(R.id.menu4);

		isearch = (ImageView) findViewById(R.id.search);
		iadd = (ImageView) findViewById(R.id.add);

		isearch.setOnClickListener(new MyOnClickListener());
		iadd.setOnClickListener(new MyOnClickListener());

		chat.setOnClickListener(new MyOnClickListener());
		people.setOnClickListener(new MyOnClickListener());
		find.setOnClickListener(new MyOnClickListener());
		my.setOnClickListener(new MyOnClickListener());

		pages = (ViewPager) findViewById(R.id.mypageview);

		pagelist = new ArrayList<Fragment>();
		chatview = new ChatActivity();
		peopleview = new PeopleActivity();
		findview = new FindActivity();
		myview = new MyActivity();
		pagelist.add(chatview);
		pagelist.add(peopleview);
		pagelist.add(findview);
		pagelist.add(myview);
		pages.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
		pages.setCurrentItem(0);
		pages.setOnPageChangeListener(new MyOnPageChangeListener());
	}

	public class MyOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (v.getId() == R.id.menu1) {
				pages.setCurrentItem(0);
				current = 0;
				tchat.setTextColor(0xffcccc33);
				tpeople.setTextColor(0xffcaaccc);
				tfind.setTextColor(0xffcaaccc);
				tmy.setTextColor(0xffcaaccc);

				ichat.setImageDrawable(getResources().getDrawable(
						R.drawable.chat2));
				ipeople.setImageDrawable(getResources().getDrawable(
						R.drawable.people1));
				ifind.setImageDrawable(getResources().getDrawable(
						R.drawable.find1));
				imy.setImageDrawable(getResources().getDrawable(R.drawable.my1));
			} else if (v.getId() == R.id.menu2) {
				pages.setCurrentItem(1);
				current = 1;
				tchat.setTextColor(0xffcaaccc);
				tpeople.setTextColor(0xffcccc33);
				tfind.setTextColor(0xffcaaccc);
				tmy.setTextColor(0xffcaaccc);

				ichat.setImageDrawable(getResources().getDrawable(
						R.drawable.chat1));
				ipeople.setImageDrawable(getResources().getDrawable(
						R.drawable.people2));
				ifind.setImageDrawable(getResources().getDrawable(
						R.drawable.find1));
				imy.setImageDrawable(getResources().getDrawable(R.drawable.my1));
			} else if (v.getId() == R.id.menu3) {
				pages.setCurrentItem(2);
				current = 2;
				tchat.setTextColor(0xffcaaccc);
				tpeople.setTextColor(0xffcaaccc);
				tfind.setTextColor(0xffcccc33);
				tmy.setTextColor(0xffcaaccc);

				ichat.setImageDrawable(getResources().getDrawable(
						R.drawable.chat1));
				ipeople.setImageDrawable(getResources().getDrawable(
						R.drawable.people1));
				ifind.setImageDrawable(getResources().getDrawable(
						R.drawable.find2));
				imy.setImageDrawable(getResources().getDrawable(R.drawable.my1));
			} else if (v.getId() == R.id.menu4) {
				pages.setCurrentItem(3);
				current = 3;
				tchat.setTextColor(0xffcaaccc);
				tpeople.setTextColor(0xffcaaccc);
				tfind.setTextColor(0xffcaaccc);
				tmy.setTextColor(0xffcccc33);

				ichat.setImageDrawable(getResources().getDrawable(
						R.drawable.chat1));
				ipeople.setImageDrawable(getResources().getDrawable(
						R.drawable.people1));
				ifind.setImageDrawable(getResources().getDrawable(
						R.drawable.find1));
				imy.setImageDrawable(getResources().getDrawable(R.drawable.my2));
			} else if (v.getId() == R.id.add) {
				popUpMyOverflow();
			}

		}
	}

	public class MyFragmentAdapter extends FragmentPagerAdapter {

		public MyFragmentAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int arg0) {
			return  pagelist.get(arg0);
		}

		@Override
		public int getCount() {
			return pagelist.size();
		}

		@Override
		public Object instantiateItem(ViewGroup arg0, int arg1) {
			// TODO Auto-generated method stub
			return super.instantiateItem(arg0, arg1);
		}

	}

	/*
	 * @Override protected void onActivityResult(int arg0, int arg1, Intent
	 * arg2) { super.onActivityResult(arg0, arg1, arg2); if (arg1 == 1) {
	 * finish(); } }
	 */

	public class MyOnPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageSelected(int arg0) {
			switch (arg0) {
			case 0:
				current = 0;
				tchat.setTextColor(0xffcccc33);
				tpeople.setTextColor(0xffcaaccc);
				tfind.setTextColor(0xffcaaccc);
				tmy.setTextColor(0xffcaaccc);

				ichat.setImageDrawable(getResources().getDrawable(
						R.drawable.chat2));
				ipeople.setImageDrawable(getResources().getDrawable(
						R.drawable.people1));
				ifind.setImageDrawable(getResources().getDrawable(
						R.drawable.find1));
				imy.setImageDrawable(getResources().getDrawable(R.drawable.my1));
				break;
			case 1:
				current = 1;
				tchat.setTextColor(0xffcaaccc);
				tpeople.setTextColor(0xffcccc33);
				tfind.setTextColor(0xffcaaccc);
				tmy.setTextColor(0xffcaaccc);

				ichat.setImageDrawable(getResources().getDrawable(
						R.drawable.chat1));
				ipeople.setImageDrawable(getResources().getDrawable(
						R.drawable.people2));
				ifind.setImageDrawable(getResources().getDrawable(
						R.drawable.find1));
				imy.setImageDrawable(getResources().getDrawable(R.drawable.my1));
				break;
			case 2:
				current = 2;
				tchat.setTextColor(0xffcaaccc);
				tpeople.setTextColor(0xffcaaccc);
				tfind.setTextColor(0xffcccc33);
				tmy.setTextColor(0xffcaaccc);

				ichat.setImageDrawable(getResources().getDrawable(
						R.drawable.chat1));
				ipeople.setImageDrawable(getResources().getDrawable(
						R.drawable.people1));
				ifind.setImageDrawable(getResources().getDrawable(
						R.drawable.find2));
				imy.setImageDrawable(getResources().getDrawable(R.drawable.my1));
				break;
			case 3:
				current = 2;
				tchat.setTextColor(0xffcaaccc);
				tpeople.setTextColor(0xffcaaccc);
				tfind.setTextColor(0xffcaaccc);
				tmy.setTextColor(0xffcccc33);

				ichat.setImageDrawable(getResources().getDrawable(
						R.drawable.chat1));
				ipeople.setImageDrawable(getResources().getDrawable(
						R.drawable.people1));
				ifind.setImageDrawable(getResources().getDrawable(
						R.drawable.find1));
				imy.setImageDrawable(getResources().getDrawable(R.drawable.my2));
				break;
			}
		}
	}

	public void popUpMyOverflow() {
		/**
		 * 定位PopupWindow，让它恰好显示在Action Bar的下方。 通过设置Gravity，确定PopupWindow的大致位置。
		 * 首先获得状态栏的高度，再获取Action bar的高度，这两者相加设置y方向的offset样PopupWindow就显示在action
		 * bar的下方了。 通过dp计算出px，就可以在不同密度屏幕统一X方向的offset.但是要注意不要让背景阴影大于所设置的offset，
		 * 否则阴影的宽度为offset.
		 */
		// 获取状态栏高度
		Rect frame = new Rect();
		getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
		// 状态栏高度：frame.top
		// int xOffset = frame.top + getActionBar().getHeight() - 25;//
		// 减去阴影宽度，适配UI.
		// int yOffset = Dp2Px(this, 5f); // 设置x方向offset为5dp
		View parentView = getLayoutInflater().inflate(R.layout.activity_main,
				null);
		View popView = getLayoutInflater().inflate(R.layout.menu_add, null);
		PopupWindow popWind = new PopupWindow(popView, 400,
				LayoutParams.WRAP_CONTENT, true);// popView即popupWindow的布局，ture设置focusAble.

		// 必须设置BackgroundDrawable后setOutsideTouchable(true)才会有效。这里在XML中定义背景，所以这里设置为null;
		popWind.setBackgroundDrawable(new BitmapDrawable(getResources(),
				(Bitmap) null));
		popWind.setOutsideTouchable(true); // 点击外部关闭。
		popWind.setAnimationStyle(android.R.style.Animation_Dialog); // 设置一个动画。
		// 设置Gravity，让它显示在右上角。
		popWind.showAsDropDown(iadd, 50, 0);
	}

	public int Dp2Px(Context context, float dp) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dp * scale + 0.5f);
	}
}
