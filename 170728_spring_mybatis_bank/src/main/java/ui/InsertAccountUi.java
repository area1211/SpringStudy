package ui;

import java.util.Scanner;

import dao.AccountDao;
import model.Account;

public class InsertAccountUi {
	private AccountDao accountDao;

	Scanner sc = new Scanner(System.in);
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public void show(){
		System.out.println("[���°���]");
		System.out.print("* ���¹�ȣ : ");
		int id=Integer.parseInt(sc.nextLine());
		System.out.print("* �̸� : ");
		String name=sc.nextLine();
		System.out.print("* �Աݾ� : ");
		int deposit=Integer.parseInt(sc.nextLine());
		
		Account account=accountDao.getAccount(id);
		if(account != null){
			System.out.println("**** �̹� ������ ���¹�ȣ �Դϴ�! ****");
			return;
		}
		account=new Account(id, name, deposit);
		accountDao.insertAccount(account);
	}
}
