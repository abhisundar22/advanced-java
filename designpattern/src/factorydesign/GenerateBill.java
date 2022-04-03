package factorydesign;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GenerateBill {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		GetPlanFactory planFactory = new GetPlanFactory();
		
		System.out.println("Enter the name of the plan to generate bill");
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		String planName=br.readLine();
		
		int units =Integer.parseInt(br.readLine());
		
		Plan p = planFactory.getPlan(planName);
		
		
		
		System.out.println("Bill amount for "+planName+" of "+units + "units is:");
		p.getRate();
		p.calculateBill(units);
		
		

	}

}
