package ui;

import java.util.List;
import java.util.Scanner;

import dao.AccountDao;
import model.Account;

public class SelectAccountUi {
	Scanner sc = new Scanner(System.in);
	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	public void show(){
		System.out.println("[������ȸ]");
		System.out.print("* ���¹�ȣ : ");
		Integer id = Integer.parseInt(sc.nextLine());
		Account account = accountDao.getAccount(id);
		if(account == null){
			System.out.println("**** �������� �ʴ� ���¹�ȣ�Դϴ�! ****");
			return;
		} else {
			System.out.printf("** ���¹�ȣ : %d, �̸� : %s, �ܾ� : %d��\n", account.getId(), account.getName(), account.getBalance());
		}
	}
	

	public void showDeposit(){
		System.out.println("[�Ա�]");
		System.out.print("* ���¹�ȣ : ");
		Integer id = Integer.parseInt(sc.nextLine());
		Account account = accountDao.getAccount(id);
		if(account == null){
			System.out.println("**** �������� �ʴ� ���¹�ȣ�Դϴ�! ****");
			return;
		}
		synchronized (account){
			System.out.printf("** %s���� ���� �ܾ��� %d���Դϴ�. �Աݾ��� �Է����ּ���.\n", account.getName(), account.getBalance());
			
			
			System.out.print("* �Աݾ� : ");
			Integer deposit = Integer.parseInt(sc.nextLine());
			if(deposit<=0){
				System.out.println("**** �߸��� �Աݾ��� �Է��ϼ̽��ϴ�. ****");
				return;
			}
			account.setBalance(account.getBalance()+deposit);
			//System.out.println("......������ܾ�:"+account.getBalance());
			this.accountDao.updateAccount(account);
			System.out.printf("%d���¿��� %d�� �ԱݵǾ����ϴ�.", account.getId(), deposit);
		}
		
		//account = accountDao.getAccount(id);
		//System.out.println("......DB�κ���..������ܾ�:"+account.getBalance());
	}
	
	public void showWithdraw(){
		System.out.println("[���]");
		System.out.print("* ���¹�ȣ : ");
		Integer id = Integer.parseInt(sc.nextLine());
		Account account = accountDao.getAccount(id);
		if(account == null){
			System.out.println("**** �������� �ʴ� ���¹�ȣ�Դϴ�! ****");
			return;
		}
		synchronized (account){
			System.out.printf("** %s���� ���� �ܾ��� %d���Դϴ�. ��ݾ��� �Է����ּ���.\n", account.getName(), account.getBalance());

			
			System.out.print("* ��ݾ� : ");
			Integer withdraw = Integer.parseInt(sc.nextLine());
			if(withdraw>account.getBalance()){
				System.out.println("**** ���� �ܾ��� �ʰ��� ��ݾ� �Դϴ�. ****");
				return;
			}
			account.setBalance(account.getBalance()-withdraw);
			
			this.accountDao.updateAccount(account);
			System.out.printf("%d���¿��� %d�� ��ݵǾ����ϴ�.", account.getId(), withdraw);
		}
		
	}
	
	public void showAccountList(){
		List<Account> accountList = accountDao.getAccountList();
		System.out.println("[��ü ���� ��ȸ]");
		for(Account account: accountList){
			System.out.printf("** ���¹�ȣ : %d, �̸� : %s, �ܾ� : %d��\n", account.getId(), account.getName(), account.getBalance());
		}
	}
}
