package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
/** Módulo de conexão **/
	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbmovimenta?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "Rsmrsm@000";			
	// <Método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;		
		} catch (Exception e) {
			System.out.println(e);
			return null;			
		}
	}
	/** CRUD CREATE **/
	public void inserirContato(JavaBeans contato) {
		String create = "insert into pessoa(nome, prio1, prio2, prio3, prio4, prio5) values (?,?,?,?,?,?)";
		try {
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			
			// Substituir os parêmtros (?) pelo conteúdo das variáveis do JavaBeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getPrio1());
			pst.setString(3, contato.getPrio2());
			pst.setString(4, contato.getPrio3());
			pst.setString(5, contato.getPrio4());
			pst.setString(6, contato.getPrio5());
			
			
			// Executar a query
			pst.executeUpdate();
			
			// Encerra a conexão com o banco
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	/** CRUD Listar  **/
	public ArrayList<JavaBeans> listarpessoa() {
		//criando objetito para acessar javabeans
		ArrayList<JavaBeans> pessoa = new ArrayList<>();
		String read = "select * from pessoa order by nome";
		try {
			Connection con = conectar ();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			// O laço de mostragem da tabela
			while (rs.next()) {
				//variáveis de apoio q recebe do banco
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String prio1 = rs.getString(3);
				String prio2 = rs.getString(4);
				String prio3 = rs.getString(5);
				String prio4 = rs.getString(6);
				String prio5 = rs.getString(7);
				
				// populando o arraylist
				pessoa.add(new JavaBeans(idcon,nome,prio1,prio2,prio3,prio4,prio5));
				
			}
			
			con.close();
			
			return pessoa;
			
	} catch (Exception e) {
		System.out.println(e);
		return null;
	}
	}
	
	/**CRUD UPDATE**/
	//selecionarContato
	public void selecionarContato(JavaBeans contato) {
	String read2 = "select * from pessoa where idcon = ?";	
		try {
			Connection con = conectar();
			PreparedStatement  pst = con.prepareStatement(read2);
			pst.setString(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				//Setar as varáveis JavaBeans
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setPrio1(rs.getString(3));
				contato.setPrio2(rs.getString(4));
				contato.setPrio3(rs.getString(5));
				contato.setPrio4(rs.getString(6));
				contato.setPrio5(rs.getString(7));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	// editar contato
	public void alterarContato(JavaBeans contato) {
		String create = "update pessoa set nome=?, prio1=?, prio2=?, prio3=?, prio4=?, prio5=? where idcon=?";
		try {
		Connection con = conectar();
		PreparedStatement pst = con.prepareStatement(create);
		pst.setString(1, contato.getNome());
		pst.setString(2, contato.getPrio1());
		pst.setString(3, contato.getPrio2());
		pst.setString(4, contato.getPrio3());
		pst.setString(5, contato.getPrio4());
		pst.setString(6, contato.getPrio5());
		pst.setString(7, contato.getIdcon());
		pst.executeUpdate();
		con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/** CRUD DELETE**/
	public void deletarContato(JavaBeans contato) {
		String delete ="delete from pessoa where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {			
			System.out.println(e);			
		}
	}
}
