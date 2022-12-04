/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sobremesa;

import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SobremesaControl {
	
	private IntegerProperty id = new SimpleIntegerProperty(0);
	private StringProperty nome = new SimpleStringProperty("");
	private DoubleProperty preço = new SimpleDoubleProperty(0.0);
	
	private SobremesaDAOImplement sobremesaDAO = new SobremesaDAOImplement();
	
	private boolean editando = false;
	private String saborAntigo = null;
	
	private ObservableList<Sobremesa> lista = 
			FXCollections.observableArrayList();
    private Object nomeAntigo;
	
	
	public Sobremesa getentity() {
		Sobremesa ps = new Sobremesa();
		ps.setId(id.get());
		ps.setNome(nome.get());
		ps.setPreço(preço.get());
		return ps;
	}
	
	public void setEntity(Sobremesa ps) {
		
		id.set(ps.getId());
		nome.set(ps.getNome());
		preço.set(ps.getPreço());
	}
	
	public void editar() {
		
		this.editando = true;
		this.saborAntigo = nome.get();
	}
	
	public void salvar() {
		Sobremesa ps = getentity();
		
		//Condição que permite salvar uma edicao dos valores da pizza
		
		if(this.editando) {
			sobremesaDAO.atualizar(saborAntigo, ps);
			
		} else {
		sobremesaDAO.criar(ps);
		}
	}
	
	public void limpar() {
		
		id.set(0);
		nome.set("");
		preço.set(0.0);
		this.editando = false;
		this.nomeAntigo = null;
	}
	
	public void pesquisar () {
		//Lista temporaria
		List<Sobremesa> tempLista = sobremesaDAO.pesquisarSobremesa(nome.get());
		
		lista.clear();
		lista.addAll(tempLista);
		
	}
	

	public void apagar(Sobremesa ps) {
		sobremesaDAO.apagar(ps);
	}
	
	
	public IntegerProperty idProperty() {
		return id;
		
	}
	
	public StringProperty saborProperty() {
		return nome;
		
	}
	
	
	public DoubleProperty preçoProperty() {
		return preço;
		
	}

	public ObservableList<Sobremesa> getListaPizzaSalgada() {
		return lista;
	}
	
	public boolean isEditando() {
		return editando;
	}

	public void setEditando(boolean editando) {
		this.editando = editando;
	}

    private static class PizzaSalgadaDAO {

        public PizzaSalgadaDAO() {
        }

        private void atualizar(String nomeAntigo, Sobremesa ps) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void criar(Sobremesa ps) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private List<Sobremesa> pesquisarSobremesa(String get) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void apagar(Sobremesa ps) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    private static class SobremesaDAOImplement extends sobremesaDAO {

        public SobremesaDAOImplement() {
        }


        private void atualizar(String nomeAntigo, Sobremesa ps) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void criar(Sobremesa ps) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private List<Sobremesa> pesquisarSobremesa(String get) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void apagar(Sobremesa ps) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    private static class nome {

        private static void set(String string) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public nome() {
        }
    }

    private static class SobremesaDAO {

        public SobremesaDAO() {
        }

        private void atualizar(String nomeAntigo, Sobremesa ps) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void criar(Sobremesa ps) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private List<Sobremesa> pesquisarSobremesa(String get) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void apagar(Sobremesa ps) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    private static class sobremesaDAO {

        public sobremesaDAO() {
        }
    }
}
