package factorydesign;

public class GetPlanFactory {
	
	
	public Plan getPlan(String planType)
	{
		if(planType == null){
		return null;
		}
		else if(planType.equalsIgnoreCase("DOMESTICPLAN"))
		{
			return new DomesticPlan();
		}
		else if(planType.equalsIgnoreCase("COMMERICALPLAN"))
		{
			return new CommericalPlan();
		}
		else if(planType.equalsIgnoreCase("INSPLAN"))
		{
			return new InstitutionPlan();
		}
		
		return null;
		
		
	}
	
	
	
	

}
