package com.uangel.suishouji;

import java.util.ArrayList;

import android.view.LayoutInflater;//在实际工作中，事先写好的布局文件往往不能满足我们的需求，有时会根据情况在代码中自定义控件，这就需要用到LayoutInflater。
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AccountListAdapter extends BaseAdapter {//适配器
	SettingAccountActivity 	acc_activity;		//????????????
	ArrayList<Object> 		accounts;		//????????????
	LayoutInflater 			inflater;		//使用临时布局功能
	CommonData commondata;					//????????????  共4个
	
	public AccountListAdapter(SettingAccountActivity activity, ArrayList<Object> accounts)
	{	//4个参数构造函数
		this.acc_activity = activity;//????????????
		this.accounts = accounts;//????????????
		this.inflater = LayoutInflater.from(acc_activity);//????????????
		this.commondata = CommonData.getInstance();//????????????
	}

	@Override
	public int getCount() {
		return accounts.size();		//?账簿数量
	}

	@Override
	public Object getItem(int position) {
		return accounts.get(position);	//获得整个账户
	}

	@Override
	public long getItemId(int position) {
		return position;				//获得账户坐标
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {//??????????
		
		Object item = accounts.get(position);//??????????
		if (item.getClass() == AccountData.class) {//??????????
			convertView = inflater.inflate(R.layout.simple_list_item_single_choice_for_account, null);//使用这个样式覆盖
			AccountData data = (AccountData)item;//??????????????
			
			String subcatname = commondata.accountsubcategory.get(data.category).name;//??????????????
			String cost;// 效益
			if (data.balance >= 0)//??????????????
				cost = String.format("￥%.2f", data.balance);//??????????????
			else//??????????????
				cost = String.format("-￥%.2f", -data.balance);
			
			((TextView)convertView.findViewById(R.id.account_name_tv)).setText(data.name);//??????????????
			((TextView)convertView.findViewById(R.id.second_level_account_group_name_tv)).setText(subcatname);//??????????????
			((TextView)convertView.findViewById(R.id.account_balance_tv)).setText(cost);//??????????????
			
			convertView.setTag(data);//??????????????
		} else {
			convertView = inflater.inflate(R.layout.widget_separated_listview_title_for_account, null);
			TextView title = (TextView)convertView.findViewById(R.id.list_header_title);
			title.setText(item.toString());
		}

		return convertView;
	}

}
