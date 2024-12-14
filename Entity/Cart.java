package com.infosys.jdbc_prepared_statement_crud.Entity;

import java.time.LocalDate;
import java.util.Objects;

public class Cart {

	  private int Pid;
      private String Pname;
      private String Pcolor;
      private Double Pprice;
      private LocalDate Pmfd;
      private LocalDate Pexpd;
     
      private int userid;
     // private int Pcount;
	public Cart() {
		super();
	}
	public Cart(int pid, String pname, String pcolor, Double pprice, LocalDate pmfd, LocalDate pexpd,int userid) {
		super();
		Pid = pid;
		Pname = pname;
		Pcolor = pcolor;
		Pprice = pprice;
		Pmfd = pmfd;
		Pexpd = pexpd;
		this.userid = userid;
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(Pcolor, Pexpd, Pid, Pmfd, Pname, Pprice,userid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return Objects.equals(Pcolor, other.Pcolor) && Objects.equals(Pexpd, other.Pexpd) && Pid == other.Pid
				&& Objects.equals(Pmfd, other.Pmfd) && Objects.equals(Pname, other.Pname)
				&& Objects.equals(Pprice, other.Pprice) && userid == other.userid;
	}
	@Override
	public String toString() {
		return "Cart [Pid=" + Pid + ", Pname=" + Pname + ", Pcolor=" + Pcolor + ", Pprice=" + Pprice + ", Pmfd=" + Pmfd
				+ ", Pexpd=" + Pexpd + ", userid=" + userid + "]";
	}
      
}
