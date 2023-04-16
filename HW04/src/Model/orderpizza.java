package Model;

public class orderpizza {
	private static Integer priceChe=700;
	private static Integer pricePep=500;
	private static Integer priceMush=600;
	private static Integer priceSoda=100;
	
	private Integer id;
	private String serialNo;
	private String username;
	private String name;
	private String address;
	private Integer che;
	private Integer pep;
	private Integer mush;
	private Integer soda;
	private boolean member;
	private Integer total;
	private Integer sum;
	private double discount;
	private double showDiscount;
	
	private Integer chesum;
	private Integer pepsum;
	private Integer mushsum;
	private Integer sodasum;
	
	private Integer payed;
	private Integer change;
	private String time;
	private String showchange;
	private String showdetail;

	
	
	//即時總和
	public orderpizza(Integer che, Integer pep, Integer mush, Integer soda, boolean member, Integer chesum,
			Integer pepsum, Integer mushsum, Integer sodasum) {
		super();
		this.che = che;
		this.pep = pep;
		this.mush = mush;
		this.soda = soda;
		this.member = member;
		this.chesum = chesum;
		this.pepsum = pepsum;
		this.mushsum = mushsum;
		this.sodasum = sodasum;
		getTotal();
		getDiscount();
		sum= (int)((chesum+pepsum+mushsum+sodasum)*discount);
	}

	//結帳
	public orderpizza(String serialNo, String username, String name, String address, Integer che, Integer pep,
			Integer mush, Integer soda, boolean member, Integer chesum, Integer pepsum, Integer mushsum, Integer sodasum,
			Integer total, Integer sum, Integer payed, String time) {
		super();
		this.serialNo = serialNo;
		this.username = username;
		this.name = name;
		this.address = address;
		this.che = che;
		this.pep = pep;
		this.mush = mush;
		this.soda = soda;
		this.member = member;
		this.chesum = chesum;
		this.pepsum = pepsum;
		this.mushsum = mushsum;
		this.sodasum = sodasum;
		getDiscount();
		getShowDiscount();
		getTotal();
		sum= (int)((chesum+pepsum+mushsum+sodasum)*discount);
		this.total = total;
		this.sum = sum;
		this.payed = payed;
		this.time=time;
	}


	//
	public orderpizza(String serialNo, String username, String name, String address, Integer che, Integer pep,
			Integer mush, Integer soda, Integer total, Integer sum) {
		super();
		this.serialNo = serialNo;
		this.username = username;
		this.name = name;
		this.address = address;
		this.che = che;
		this.pep = pep;
		this.mush = mush;
		this.soda = soda;
		this.total = total;
		this.sum = sum;
	}

	public orderpizza(Integer id, String serialNo, String username, String name, String address, Integer che, Integer pep,
			Integer mush, Integer soda, Integer total, Integer sum) {
		super();
		this.id = id;
		this.serialNo = serialNo;
		this.username = username;
		this.name = name;
		this.address = address;
		this.che = che;
		this.pep = pep;
		this.mush = mush;
		this.soda = soda;
		this.total = total;
		this.sum = sum;
	}
	
	public orderpizza(Integer id, String name, String address, Integer che, Integer pep, Integer mush, Integer soda, Integer total,
			Integer sum) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.che = che;
		this.pep = pep;
		this.mush = mush;
		this.soda = soda;
		this.total = total;
		this.sum = sum;
	}

	public orderpizza() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getChe() {
		return che;
	}

	public void setChe(Integer che) {
		this.che = che;
	}

	public Integer getPep() {
		return pep;
	}

	public void setPep(Integer pep) {
		this.pep = pep;
	}

	public Integer getMush() {
		return mush;
	}

	public void setMush(Integer mush) {
		this.mush = mush;
	}

	public Integer getSoda() {
		return soda;
	}

	public void setSoda(Integer soda) {
		this.soda = soda;
	}

	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member) {
		this.member = member;
	}

	public Integer getTotal() {
		total= che+pep+mush+soda;
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public double getDiscount() {
		if(member==true)
		{
			discount=0.8;
		}
		else
		{
			discount=1;
		}
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public double getShowDiscount() {
		if(member==true)
		{
			showDiscount= discount*10;;
		}
		else
		{
			showDiscount=discount;
		}
		return showDiscount;
	}

	public void setShowDiscount(double showDiscount) {
		this.showDiscount = showDiscount;
	}

	public Integer getChesum() {
		return chesum;
	}

	public void setChesum(Integer chesum) {
		this.chesum = chesum;
	}

	public Integer getPepsum() {
		return pepsum;
	}

	public void setPepsum(Integer pepsum) {
		this.pepsum = pepsum;
	}

	public Integer getMushsum() {
		return mushsum;
	}

	public void setMushsum(Integer mushsum) {
		this.mushsum = mushsum;
	}

	public Integer getSodasum() {
		return sodasum;
	}

	public void setSodasum(Integer sodasum) {
		this.sodasum = sodasum;
	}

	public Integer getPayed() {
		return payed;
	}

	public void setPayed(Integer payed) {
		this.payed = payed;
	}

	public Integer getChange() {
		return change;
	}

	public void setChange(Integer change) {
		this.change = change;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	//method
	public String showDetail()
	{
		if(member==true)
		{	
			showdetail="訂單編號:"+getSerialNo()+"\t帳號:"+getUsername()
					+"\n-------------------------------------------------------------"
					+"\n訂餐人:"+getName()
					+"\n訂餐時間:"+getTime()
					+"\n======================================"
					+"\n海鮮起司:"+getChe()+"\t$"+getChesum()
					+"\n美式臘腸:"+getPep()+"\t$"+getPepsum()
					+"\n時蔬野菇:"+getMush()+"\t$"+getMushsum()
					+"\n百事可樂:"+getSoda()+"\t$"+getSodasum()
					+"\n-------------------------------------------------------------"
					+"\n餐點總數:\t"+getTotal()
					+"\n優惠:\t"+"會員"+(int)(getShowDiscount())+"折"
					+"\n合計:\t"+getSum();
		}
		else
		{
			showdetail="訂單編號:"+getSerialNo()+"\t帳號:"+getUsername()
					+"\n-------------------------------------------------------------"
					+"\n訂餐人:"+getName()
					+"\n訂餐時間:"+getTime()
					+"\n======================================"
					+"\n海鮮起司:"+getChe()+"\t$"+getChesum()
					+"\n美式臘腸:"+getPep()+"\t$"+getPepsum()
					+"\n時蔬野菇:"+getMush()+"\t$"+getMushsum()
					+"\n百事可樂:"+getSoda()+"\t$"+getSodasum()
					+"\n-------------------------------------------------------------"
					+"\n餐點總數:\t"+getTotal()
					+"\n優惠:\t"+""
					+"\n合計:\t"+getSum();
		}
		return showdetail;
	}
	
	public String showChange()
	{
		if(payed>=0) {
			change=payed-sum;
			if(change>0)
			{	
				int w,x,y,z,i,j,k;
				w= change/1000;
				x= change%1000/500;
				y= change%500/100;
				z= change%100/50;
				i= change%50/10;
				j= change%10/5;
				k= change%5;
				
				showchange= "實付金額:"+getPayed()+"元"+
				        "\n======================"+
						"\n找零:"+getChange()+"元"+
						"\n千元:"+w+"張"+
						"\n五百元:"+x+"張"+
						"\n百元:"+y+"張"+
						"\n五十元:"+z+"個"+
						"\n十元:"+i+"個"+
						"\n五元:"+j+"個"+
						"\n一元:"+k+"個";			
			}
			else if(change==0)
			{
				showchange= "實付金額:"+getPayed()+"元"+
						"\n找零:"+getChange()+"元";
			}
			else
			{
				showchange= "支付金額不足，請重新輸入";
			}		
		}
		else
		{
			showchange= "金額輸入錯誤，請輸入正整數";
		}
		
		return showchange;
	}
	
}
