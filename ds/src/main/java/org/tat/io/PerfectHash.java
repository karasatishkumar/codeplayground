package org.tat.io;

public class PerfectHash {
	private int id;
	private long uid;
	private char cid;
	private boolean b;
	private double did;
	private float fid;
	private String s;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (b ? 1231 : 1237);
		result = prime * result + cid;
		long temp;
		temp = Double.doubleToLongBits(did);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(fid);
		result = prime * result + id;
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		result = prime * result + (int) (uid ^ (uid >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PerfectHash other = (PerfectHash) obj;
		if (b != other.b)
			return false;
		if (cid != other.cid)
			return false;
		if (Double.doubleToLongBits(did) != Double.doubleToLongBits(other.did))
			return false;
		if (Float.floatToIntBits(fid) != Float.floatToIntBits(other.fid))
			return false;
		if (id != other.id)
			return false;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
	
	

}
