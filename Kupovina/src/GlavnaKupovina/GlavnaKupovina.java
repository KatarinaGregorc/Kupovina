package GlavnaKupovina;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import Kupci.Kupci;

public class GlavnaKupovina {

	public static void main(String[] args) {
		
	/*	String url="jdbc:mysql://localhost:3306/kupovina";
		String user="root";
		String password="root";
		
	try {
		Connection konekcija=DriverManager.getConnection(url, user, password);
		System.out.println("Uspesna konekcija");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Neuspesna konekcija");
	}	*/
		
	/*	MetodeJdbcK metode=new MetodeJdbcK();
		Scanner ucitaj=new Scanner(System.in);
		System.out.println("Unesite prezime");
		String prezime=ucitaj.nextLine();
		System.out.println("Unesite id");
		//int id=ucitaj.nextInt();
		int id=Integer.parseInt(ucitaj.nextLine());
		try {
			Connection konekcije=metode.konektujSe();
			System.out.println("Uspesna konekcija");
			Statement statement=konekcije.createStatement();
			String query="update kupci set prezime='"+prezime+"' where id_kupci="+id;
			statement.executeUpdate(query);
			System.out.println("Uspesno ste uneli u tabelu");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Neuspesna konekcija");
		}
		
		*/
   /* Scanner ucitaj=new Scanner(System.in);
    System.out.println("Unesite ime");
    String ime=ucitaj.nextLine();
   System.out.println("Unesite prezime");
   String prezime=ucitaj.nextLine();
   System.out.println("Unesite grad");
   String grad=ucitaj.nextLine();
	System.out.println("Unesite drzavu");
	String drzava=ucitaj.nextLine();
	System.out.println("Unesite mail");
	String mail=ucitaj.nextLine();
	
	MetodeJdbcK.ubaciKupcauTabelu(ime, prezime, grad, drzava, mail);
		*/
		/*Scanner ucitaj=new Scanner(System.in);
		System.out.println("Unesi id");
		int id=ucitaj.nextInt();
		List<String>imena=MetodeJdbcK.dajImeKupcu(id);
	    System.out.println("ime kupca je"+imena);*/
		
		/*Scanner ucitaj=new Scanner(System.in);
		System.out.println("Unesite id");
		//ovako smo pozvali kupca bez liste
		int id=Integer.parseInt(ucitaj.nextLine());
		Kupci k=MetodeJdbcK.dajKupca(id);
		System.out.println("ime"+"   "+"prezime "+"  "+"grad"+" "+"drzava"+"'"+"mail");
		System.out.println(k.getIme()+" "+k.getPrezime()+" "+k.getGrad()+" "+k.getDrzava()+" "+k.getMail());
		*/
		
		List<Kupci>listaKupci=MetodeJdbcK.dajSveKupce();
		System.out.println("ime"+"  "+"prezime"+" "+"gr"+" "+"drz"+"   "+"mail" );
		
		for (Kupci kupci : listaKupci) {
			
			System.out.println(kupci.getIme()+" "+kupci.getPrezime()+" "+kupci.getGrad()+" "+kupci.getDrzava()+" "+kupci.getMail());
			
		}
		
		
	}

}
