package tp.server;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import tp.location.LocationPOA;
import tp.restitution.Restitution;
import tp.restitution.RestitutionHelper;

public class LocationImpl extends LocationPOA {

	private int d;

	public LocationImpl() {

	}

	@Override
	public int d() {
		// TODO Auto-generated method stub
		return d;
	}

	@Override
	public void d(int newD) {
		d = newD;
	}

	@Override
	public void louer() {
		int r = 0;
		try {
			Context ctx = new InitialContext();
			Object ref = ctx.lookup("restitution");
			Restitution restitution = RestitutionHelper.narrow((org.omg.CORBA.Object) ref);
			r = restitution.r();
			if (r - d > 0) {
				d++;
				System.out.println("louer   !!!!");

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public static void main(String[] args) {
		// initialiser l'orb

		try {
			ORB orb = ORB.init(args, null);
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootPOA.the_POAManager().activate();
			LocationImpl od = new LocationImpl();
			Context ctx = new InitialContext();
			Object ref = rootPOA.servant_to_reference(od);
			System.out.println(ref);
			ctx.rebind("location", ref);
			orb.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
