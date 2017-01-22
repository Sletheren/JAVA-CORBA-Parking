package tp.client;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.omg.CORBA.ORB;

import tp.location.Location;
import tp.location.LocationHelper;
import tp.restitution.Restitution;
import tp.restitution.RestitutionHelper;

public class Client {
	public static void main(String[] args) {
		try {
			Context ctx=new InitialContext();
			Object ref=ctx.lookup("location");
			Location location=LocationHelper.narrow((org.omg.CORBA.Object)ref);
			
			Object ref1=ctx.lookup("restitution");
			Restitution restitution=RestitutionHelper.narrow((org.omg.CORBA.Object)ref1);
			
			location.louer();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
	
}
