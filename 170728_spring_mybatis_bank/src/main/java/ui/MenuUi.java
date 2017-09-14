package ui;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi {
	Scanner sc = new Scanner(System.in);
	private InsertAccountUi insertAccountUi;
	private SelectAccountUi selectAccountUi;
//	private SelectTeamUi selectTeamUi;
//	private PlayerListUi playerListUi;
//	private InsertPlayerUi insertPlayerUi;
//	private InsertTeamUi insertTeamUi;
//	private SelectPlayerUi selectPlayerUi;
//	
//
//	public void setSelectPlayerUi(SelectPlayerUi selectPlayerUi) {
//		this.selectPlayerUi = selectPlayerUi;
//	}
//
//	public void setPlayerListUi(PlayerListUi selectPlayerUi) {
//		this.playerListUi = selectPlayerUi;
//	}
//
//	public SelectTeamUi getSelectTeamUi() {
//		return selectTeamUi;
//	}
//
//	public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
//		this.selectTeamUi = selectTeamUi;
//	}
//	public void setInsertPlayerUi(InsertPlayerUi insertPlayerUi) {
//		this.insertPlayerUi = insertPlayerUi;
//	}
//	public void setInsertTeamUi(InsertTeamUi insertTeamUi) {
//		this.insertTeamUi = insertTeamUi;
//	}

	public void setSelectAccountUi(SelectAccountUi selectAccountUi) {
		this.selectAccountUi = selectAccountUi;
	}
	public void setInsertAccountUi(InsertAccountUi insertAccountUi) {
		this.insertAccountUi = insertAccountUi;
	}



	protected int showMenu(){
		System.out.println("--------------------------------------------------");
		System.out.println("0. ����");
		System.out.println("1. ���°���");
		System.out.println("2. �Ա�");
		System.out.println("3. ���");
		System.out.println("4. ������ȸ");
		System.out.println("5. ��ü���� ��ȸ");
		System.out.print("* ���� > ");
		int sel = Integer.parseInt(sc.next());
		return sel;
	}
	
	

	protected void execute(int number){
		switch(number){
		case 0: System.out.println("����Ǿ����ϴ�."); System.exit(0);
		case 1: insertAccountUi.show(); break;
		case 2: selectAccountUi.showDeposit(); break;
		case 3: selectAccountUi.showWithdraw(); break;
//			System.out.print("** �� �̸� �Է� > ");
//			String name = sc.next();
//			playerListUi.show(name); 
//			playerListUi.show();
//			break;
		case 4: selectAccountUi.show(); break;
		case 5: selectAccountUi.showAccountList(); break;
		}
	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		MenuUi menuUi = context.getBean(MenuUi.class);
		while(true){			
			menuUi.execute(menuUi.showMenu());
		}
	}

}
