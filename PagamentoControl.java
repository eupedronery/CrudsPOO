/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagamentos;

import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PagamentoControl {
	
	private IntegerProperty id = new SimpleIntegerProperty(0);
	private StringProperty formaPagamento = new SimpleStringProperty("");
        private DoubleProperty valorTotal = new SimpleDoubleProperty(0.0);
	
	private PagamentoDAO pagamentoDAO = new PagamentoDAOImplement();
	
	private boolean editando = false;
	private String nomeAntigo = null;
	
	private ObservableList<Pagamento> lista = 
			FXCollections.observableArrayList();
	
	
	public Pagamento getentity() {
		
		Pagamento ps = new Pagamento();
		
		ps.setId(id.get());
		ps.setformaPagamento(formaPagamento.get());
		ps.setvalorTotal(valorTotal.get());
		return ps;
	}
	
	public void setEntity(Pagamento ps) {
		
		id.set(ps.getId());
		formaPagamento.set(ps.getformaPagamento());
		valorTotal.set(ps.getvalorTotal());
	}
	
	public void editar() {
		this.editando = true;
		this.nomeAntigo = formaPagamento.get();
	}
	
	public void salvar() {
		Pagamento ps = getentity();
		
		//Condição que permite salvar uma edicao dos valores da pizza
		
		if(this.editando) {
			pizzasalgadaDAO.atualizar(nomeAntigo, ps);
			
		} else {
		pizzasalgadaDAO.criar(ps);
		}
		
	}
	

	public void limpar() {
		
		id.set(0);
		formaPagamento.set("");
		valorTotal.set(0.0);
		this.editando = false;
		this.nomeAntigo = null;
	}
	
	public void pesquisar () {
		//Lista temporaria
		List<Pagamento> tempLista = pizzasalgadaDAO.pesquisarPizzaSalgadaSabor(formaPagamento.get());
		
		lista.clear();
		lista.addAll(tempLista);
		
	}
	

	public void apagar(Pagamento ps) {
		pizzasalgadaDAO.apagar(ps);
	}
	
	
	
	public IntegerProperty idProperty() {
		return id;
		
	}
	
	public StringProperty saborProperty() {
		return formaPagamento;
		
	}
	
	
	public DoubleProperty preçoProperty() {
		return valorTotal;
		
	}


	public ObservableList<Pagamento> getListaPizzaSalgada() {
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

        private void atualizar(String saborAntigo, Pagamento ps) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void criar(Pagamento ps) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private List<Pagamento> pesquisarPizzaSalgadaSabor(String get) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void apagar(Pagamento ps) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    private static class PizzaSalgadaDAOImplement extends PizzaSalgadaDAO {

        public PizzaSalgadaDAOImplement() {
        }
    }
}

