package GlavnaKupovina;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import Kupci.Kupci;

public class MetodeJdbcK {
	
	public static Connection konektujSe() throws SQLException {
		
		String url="jdbc:mysql://localhost:3306/kupovina";
		String user="root";
		String password="root";
		
		return DriverManager.getConnection(url, user, password);
		
		
	}
	public static void azurirajPoPrezimenu(String prezime,int id) {
		
		Connection konekcije=null;
		java.sql.PreparedStatement pst=null;
		
		try {
			 konekcije=MetodeJdbcK.konektujSe();
			System.out.println("Uspesna konekcija");
			String query="update kupci set prezime=? where id_kupci=?";
		    pst=konekcije.prepareStatement(query);
			pst.setString(1, prezime);
			pst.setInt(2, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Neuspesna konekcija");
		}finally {
			if(pst !=null)
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(konekcije !=null)
			try {
				konekcije.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
public static void ubaciKupcauTabelu(String ime, String prezime,String grad,String drzava,String mail) {
	
	Connection konekcije=null;
	java.sql.PreparedStatement pst=null;
	
	
	try {
	    konekcije=MetodeJdbcK.konektujSe();
		System.out.println("Uspesna konekcija");
		String query="insert into kupci values (null,?,?,?,?,?)";
	     pst=konekcije.prepareStatement(query);
	     pst.setString(1, ime);
	     pst.setString(2, prezime);
	     pst.setString(3, grad);
	     pst.setString(4, drzava);
	     pst.setString(5, mail);
	     pst.executeUpdate();
	     System.out.println("Uspesno ste uneli podatke u tabelu");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Neuspesna konekcija");
	}finally {
		if(pst !=null)
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if(konekcije !=null)
			try {
				konekcije.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}
	
	
	public static   List<String> dajImeKupcu(int id) {
		Connection konekcije=null;
		java.sql.PreparedStatement pst=null;
		ResultSet rst=null;
		List<String> vracenoIme=new ArrayList<String>();
		try {
			 konekcije=MetodeJdbcK.konektujSe();
			System.out.println("Uspesna konekcija");
			String query="select ime from kupci where id_kupci=?";
		    pst=konekcije.prepareStatement(query);
			pst.setInt(1, id);
		    rst=pst.executeQuery();
		    while(rst.next()) {
		    	vracenoIme.add(rst.getString("ime"));
		    }
		    return vracenoIme;
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Neuspesna konekcija");
			return null;
		}finally {
			if(rst !=null)
				try {
					rst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(pst !=null)
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(konekcije !=null)
				try {
					konekcije.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
		
		public static  Kupci dajKupca(int id) {
			Connection konekcije=null;
			java.sql.PreparedStatement pst=null;
			ResultSet rst=null;
			Kupci kupci=new Kupci();
			try {
			    konekcije=MetodeJdbcK.konektujSe();
				System.out.println("Uspesna konekcija");
				String query="select * from kupci where id_kupci=?";
			    pst=konekcije.prepareStatement(query);
			    pst.setInt(1, id);
			    rst=pst.executeQuery();
			    
			    while(rst.next()) {
			    kupci.setId_kupci(rst.getInt("id_kupci"));
			    kupci.setIme(rst.getString("ime"));
			    kupci.setPrezime(rst.getString("prezime"));
			    kupci.setGrad(rst.getString("grad"));
			    kupci.setDrzava(rst.getString("drzava"));
			    kupci.setMail(rst.getString("mail"));
			    	
			    	
			    	
			    }
			    
			  return kupci;  
			    
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally {
				
				try {
					rst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					konekcije.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
				
				
				
			
			
			public static  List<Kupci> dajSveKupce() {
				Connection konekcije=null;
				java.sql.PreparedStatement pst=null;
				ResultSet rst=null;
				List<Kupci>listaakupci=new ArrayList<Kupci>();
			try {
			    konekcije=MetodeJdbcK.konektujSe();
				String query="select * from kupci";
			    pst=konekcije.prepareStatement(query);
			    rst=pst.executeQuery();
				while(rst.next()) {
					Kupci k=new Kupci();
					k.setId_kupci(rst.getInt("id_kupci"));
					k.setIme(rst.getString("ime"));
					k.setPrezime(rst.getString("prezime"));
					k.setGrad(rst.getString("grad"));
					k.setDrzava(rst.getString("drzava"));
					k.setMail(rst.getString("mail"));
				
					listaakupci.add(k);
					
				}
				
				return listaakupci;
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}	
				
				
			finally {
				
				try {
					rst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					konekcije.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
			
public static void azurirajPoArtiklu(String cena,int id_proizvoda)	{
	Connection konekcije=null;
	java.sql.PreparedStatement pst=null;
	try {
	    konekcije= MetodeJdbcK.konektujSe();
		System.out.println("Uspesna konekcija");
		String query="update proizvodi set cena=? where id_proizvoda=?";
	    pst=konekcije.prepareStatement(query);		
		pst.setString(1, cena);
		pst.setInt(2, id_proizvoda);
		pst.executeUpdate();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Neuspesna konekcija");
	}finally {
		
		try {
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			konekcije.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}		
			
			
			
			
			
}
			
			
				
				
				
				
			
			
			
			
			
			
		
		
		
		
	
	
	
	
		
		
		
	
	
	
	


