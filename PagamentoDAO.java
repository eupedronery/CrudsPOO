/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagamentos;


import java.util.List;

public interface PagamentoDAO {
	
	void criar(Pagamento ps);
    List<Pagamento> pesquisarPizzaSalgadaSabor(String sabor);
    void apagar(Pagamento ps);
    void atualizar(String saborAntigo, Pagamento ps);
    
}
