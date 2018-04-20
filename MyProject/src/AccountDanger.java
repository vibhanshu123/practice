
import java.io.*;
import java.net.*;
public class AccountDanger implements Runnable{

	private Account account = new Account();
	
	public static void main(String[] args){
		AccountDanger r= new AccountDanger();
		Thread one=new Thread(r);
		Thread two=new Thread(r);
		one.setName("vibs");
		two.setName("manu");
		one.start();
		two.start();
		}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int x=0;x<5;x++){
			//makeWithdrawal(10);
			synchronized (this) {
				if(account.getBalance()>=10){
					System.out.println(Thread.currentThread().getName()+" is going to withdraw with balance left"+account.getBalance());
					//System.out.println("amount left"+account.getBalance());
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {}
						 account.withdraw(10);
						 System.out.println(Thread.currentThread().getName()+"completes the withdrawal with balance left "+account.getBalance());
					
					
				}else{
					System.out.println("Not enough in account for"+Thread.currentThread().getName()+"to withdraw" +account.getBalance());
				}
				
			}
			checkSomething();
			if(account.getBalance()<0){
				System.out.println("account is overdrawn");
			}
	      }
		}

	private  void checkSomething() {
		System.out.println(Thread.currentThread().getName()+" to check"+account.getBalance());
		
	}

//	private synchronized void makeWithdrawal(int amt) {
//		// TODO Auto-generated method stub
//		if(account.getBalance()>=amt){
//			System.out.println(Thread.currentThread().getName()+" is going to withdraw with balance left"+account.getBalance());
//			//System.out.println("amount left"+account.getBalance());
//			
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {}
//				 account.withdraw(amt);
//				 System.out.println(Thread.currentThread().getName()+"completes the withdrawal with balance left "+account.getBalance());
//			
//			
//		}else{
//			System.out.println("Not enough in account for"+Thread.currentThread().getName()+"to withdraw" +account.getBalance());
//		}
//		
//	}
	
}