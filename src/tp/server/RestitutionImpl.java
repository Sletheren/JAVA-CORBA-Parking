package tp.server;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import tp.location.Location;
import tp.location.LocationHelper;
import tp.restitution.Restitution;
import tp.restitution.RestitutionHelper;
import tp.restitution.RestitutionPOA;

public class RestitutionImpl extends RestitutionPOA{

	
	private int r;
	
	
	private int n;
	
	
	public RestitutionImpl(int n) {
		this.n=n;
	}
	
	@Override
	public int r() {
		// TODO Auto-generated method stub
		return r;
	}

	@Override
	public void r(int r) {
	this.r=r;
	}

	@Override
	public int n() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public void restituer() {
		// TODO Auto-generated method stub
		int d=0;
		try {
			Context ctx=new InitialContext();
			Object ref=ctx.lookup("location");
			Location location=LocationHelper.narrow((org.omg.CORBA.Object)ref);
			d=location.d();

			if(n>r-d){
				r++;
				System.out.println("restituer   !!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		//initialiser l'orb
		
		try {
			ORB orb=ORB.init(args, null);
			POA rootPOA=POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootPOA.the_POAManager().activate();
			RestitutionImpl od=new RestitutionImpl(10);
			Context ctx=new InitialContext();
			Object ref=rootPOA.servant_to_reference(od);
			System.out.println(ref);
			ctx.rebind("restitution", ref );
			orb.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
