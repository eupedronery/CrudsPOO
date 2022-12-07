/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagamentos;

public class Pagamento{
	
	private int id = 0;
	private String formaPagamento = "";
        private double valorTotal = 0.0;

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getformaPagamento() {
		return formaPagamento;
	}
	
	public void setformaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public Double getvalorTotal() {
		return valorTotal;
	}

    void setvalorTotal(double get) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

