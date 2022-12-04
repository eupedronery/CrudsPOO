 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sobremesa;

import java.util.List;

public interface SobremesaDAO {
	
	void criar(Sobremesa ps);
    List<Sobremesa> pesquisarPizzaSalgadaSabor(String sabor);
    void apagar(Sobremesa ps);
    void atualizar(String nomeAntigo, Sobremesa ps);
    
}