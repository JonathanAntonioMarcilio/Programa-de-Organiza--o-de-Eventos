import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu{
    public static void main(String[] args) throws Exception{
        final String url = "jdbc:mysql://localhost:3306/mydb";
        final String user = "root";
        final String password = "";
        
        Scanner scanner = new Scanner(System.in);
        
        int op, id, idLocal, idEvento, data, vaga;
        String nome, email, descricao, telefone;
        
        do{
            System.out.println("Digite o Número Equivalente a Opção que Você Deseja Selecionar: ");
            System.out.println("[1] Cadastrar Organizador");
            System.out.println("[2] Cadastrar Participante");
            System.out.println("[3] Cadastrar Local");
            System.out.println("[4] Cadastrar Evento");
            System.out.println("[5] Listar Organizador");
            System.out.println("[6] Listar Participante");
            System.out.println("[7] Listar Local");
            System.out.println("[8] Listar Evento");
            System.out.println("[9] Cadastrar Participante no Evento");
            System.out.println("[10] Alterar Organizador");
            System.out.println("[11] Alterar Participante");
            System.out.println("[12] Alterar Local");
            System.out.println("[13] Alterar Evento");
            System.out.println("[14] Excluir Organizador");
            System.out.println("[15] Excluir Participante");
            System.out.println("[16] Excluir Local");
            System.out.println("[17] Excluir Evento");
            System.out.println("[18] Sair");
            op = scanner.nextInt();
            switch(op){ 
                case 1: // Cadastrar Organizador ================================================================================================================
                    try{
                        System.out.println("Cadastrar Organizador");
                        System.out.println("Digite o id do organizador: ");
                        id = scanner.nextInt();
                        System.out.println("Digite o nome do organizador: ");
                        nome = scanner.next();
                        System.out.println("Digite o email do organizador: ");
                        email = scanner.next();
                        // Conexão com o banco de dados para inserir os valores no banco através do INSERT
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO organizador"
                            + "(idorganizador, nome, email) VALUES "
                            + "('"+id+"', '"+nome+"', '"+email+"')");
                        con.close();
                    }catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2: // Cadastrar Participante ===============================================================================================================
                    try{
                        System.out.println("Cadastrar Participante");
                        System.out.println("Digite o id do participante: ");
                        id = scanner.nextInt();
                        System.out.println("Digite o nome do participante: ");
                        nome = scanner.next();
                        System.out.println("Digite o telefone do participante: ");
                        telefone = scanner.next();
                        // Conexão com o banco de dados para inserir os valores no banco através do INSERT
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO participante"
                            + "(idparticipante, nome, telefone) VALUES "
                            + "('"+id+"', '"+nome+"', '"+telefone+"')");
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3: // Cadastrar Local ======================================================================================================================
                    try{
                        System.out.println("Cadastrar Local");
                        System.out.println("Digite o id do local: ");
                        idLocal = scanner.nextInt();
                        System.out.println("Digite a descricao do local: ");
                        descricao = scanner.next();
                        System.out.println("Digite o número de vagas do local: ");
                        vaga = scanner.nextInt();
                        // Conexão com o banco de dados para inserir os valores no banco através do INSERT
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO local"
                            + "(idlocal, descricao, vagas) VALUES "
                            + "('"+idLocal+"', '"+descricao+"', '"+vaga+"')");
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4: // Cadastrar Evento =====================================================================================================================
                    try{
                        System.out.println("Cadastrar Evento");
                        System.out.println("Digite o id do evento: ");
                        idEvento = scanner.nextInt();
                        System.out.println("Digite a data do evento: ");
                        data = scanner.nextInt();
                        System.out.println("Digite a descrição do evento: ");
                        descricao = scanner.next();
                        System.out.println("Informe a quantidade de vagas do evento: ");
                        vaga = scanner.nextInt();
                        System.out.println("Digite o id do organizador: ");
                        id = scanner.nextInt();
                        System.out.println("Digite o id do local: ");
                        idLocal = scanner.nextInt();
                        // Conexão com o banco de dados para inserir os valores no banco através do INSERT
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO evento"
                            + "(idevento, date, descricao, vagas, organizador_idorganizador, local_idlocal) VALUES "
                            + "('"+idEvento+"', '"+data+"', '"+descricao+"', '"+vaga+"','"+id+"','"+idLocal+"')");
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5: // Listar Organizador ===================================================================================================================
                    System.out.println("Listar Organizador");
                    try {
                        // Conexão com o banco de dados para exibir as informações cadastradas através do SELECT
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM organizador;");
                        while(sql.next()) {
                            System.out.println(new Organizador(
                            sql.getInt("idorganizador"),
                            sql.getString("nome"),
                            sql.getString("email")
                        ));
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6: // Listar Participante ==================================================================================================================
                    System.out.println("Listar Participante");
                    try {
                        // Conexão com o banco de dados para exibir as informações cadastradas através do SELECT
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM participante;");
                        while(sql.next()) {
                            System.out.println(new Participante(
                            sql.getInt("idparticipante"),
                            sql.getString("nome"),
                            sql.getString("telefone")
                        ));
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7: // Listar Local =========================================================================================================================
                    System.out.println("Listar Local");
                    try {
                        // Conexão com o banco de dados para exibir as informações cadastradas através do SELECT
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM local;");
                        while(sql.next()) {
                            System.out.println(new Local(
                            sql.getInt("idlocal"),
                            sql.getString("descricao"),
                            sql.getInt("vagas")
                        ));
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8: // Listar Evento ========================================================================================================================
                    System.out.println("Listar Evento");
                    try {
                        // Conexão com o banco de dados para exibir as informações cadastradas através do SELECT
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM evento");
                        while(sql.next()) {
                            System.out.println(new Evento(
                            sql.getInt("idevento"),
                            sql.getString("date"),
                            sql.getString("descricao"),
                            sql.getInt("vagas"),
                            sql.getInt("organizador_idorganizador"),
                            sql.getInt("local_idlocal")
                        ));
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9: // Cadastrar Participante no Evento =====================================================================================================
                    try{
                        System.out.println("Cadastrar Participante no Evento");
                        System.out.println("Digite o id da pessoa que vai participar do evento: ");
                        id = scanner.nextInt();
                        System.out.println("Digite o id do Evento: ");
                        idEvento = scanner.nextInt();
                        // Conexão com o banco de dados para inserir os valores no banco através do INSERT
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO evento_participante"
                            + "(evento_idevento, participante_idparticipante) VALUES "
                            + "('"+idEvento+"', '"+id+"')");
                        con.close();
                    }  catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 10: // Alterar Organizador ========================================================================================================================



                
                    break;
                case 11: // Alterar Participante ========================================================================================================================




                    break;
                case 12: // Alterar Local ========================================================================================================================




                    break;
                case 13: // Alterar Evento ========================================================================================================================




                    break;
                case 14: // Excluir Organizador ========================================================================================================================




                    break;
                case 15: // Excluir Participante ========================================================================================================================




                    break;
                case 16: // Excluir Local ========================================================================================================================




                    break;
                case 17: // Excluir Evento ========================================================================================================================




                    break;
                case 18: // Sair do Sistema ======================================================================================================================
                    System.out.println("Obrigado por usar o programa :)");
                   break;
                default: 
                    System.out.println("Por favor, digite uma opção válida...");
                    break;
            }
        } while(op != 18);
        scanner.close();
    }
}