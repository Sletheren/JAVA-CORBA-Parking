package tp.location;


/**
* tp/location/LocationHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from tp.idl
* vendredi 23 d�cembre 2016 17 h 37 WET
*/

abstract public class LocationHelper
{
  private static String  _id = "IDL:tp/location/Location:1.0";

  public static void insert (org.omg.CORBA.Any a, tp.location.Location that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static tp.location.Location extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (tp.location.LocationHelper.id (), "Location");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static tp.location.Location read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_LocationStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, tp.location.Location value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static tp.location.Location narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof tp.location.Location)
      return (tp.location.Location)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      tp.location._LocationStub stub = new tp.location._LocationStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static tp.location.Location unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof tp.location.Location)
      return (tp.location.Location)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      tp.location._LocationStub stub = new tp.location._LocationStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
