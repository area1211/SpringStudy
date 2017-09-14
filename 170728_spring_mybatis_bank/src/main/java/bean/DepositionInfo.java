package bean;

public class DepositionInfo {
	private String id;
	private String money;
	
	
	public DepositionInfo() {
		super();
	}
	public DepositionInfo(String id, String money) {
		super();
		this.id = id;
		this.money = money;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "D.I[id=" + id + ", money=" + money + "]";
	}
	
	
}
