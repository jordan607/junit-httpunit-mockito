package com.nt.service;

public class BankServiceImpl implements BankService {

	@Override
	public float calcSimpleIntrAmt(float pAmt, float rate, float time) {
		System.out.println("BankServiceImpl:calcSimpleIntrAmt(-,-,-)");
		float intrAmt=0.0f;
/*		try{
			Thread.sleep(20000);
		}
		catch(Exception e){e.printStackTrace();}
*/		if(pAmt<=0.0f || rate<=0.0f || time<=0.0f)
			throw new IllegalArgumentException("invalid inputs");
		
		intrAmt=(pAmt*time*rate)/100.0f;
		return intrAmt;
	}
	
	@Override
	public boolean isAccountBlocked(int accNo) {
		 if(accNo<=0)
			 throw new IllegalArgumentException("Invalid Account number");
		
		if(accNo>=100000 && accNo<200000)
		  return true;
		else
			return false;
		
	}

}
