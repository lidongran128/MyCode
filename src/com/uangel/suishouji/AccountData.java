package com.uangel.suishouji;

public class AccountData implements Cloneable {//使用clone() 方法  需继续，否则报异常 CloneNotSupportedException
	int id;						//?????????id
	int type_id;				//?????????
	int category;				//?????????
	String name;				//?????????
	double balance;				//?????????				共5个参数
	
	public AccountData()	//空参数的构造函数，防止报错
	{
		
	}
	
	public AccountData(int id, String name,int type_id,int category, double balance)
	{						//五个参数，和定义一样
		this.id = id;
		this.type_id = type_id;
		this.category = category;
		this.name = name;
		this.balance = balance;
	}
	
	public Object clone() {			//以指示 Object.clone() 方法可以合法地对该类实例进行按字段复制。
		try {		//抛出：CloneNotSupportedException - 如果对象的类不支持 Cloneable 接口，则重写 clone 方法的子类也会抛出此异常，以指示无法复制某个实例。
			return super.clone();			//???????????????
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();		//打印信息
		}
		
		return null;//??????????????哈啊东冉
	}
}
