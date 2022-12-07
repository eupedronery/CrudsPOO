/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagamentos;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.beans.binding.Bindings;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

public class PagamentoBoundary extends Application{

	    
		private Label lblTitulo = new Label("Pagamento");
		private Label lbId = new Label("ID:");
		private TextField TextId = new TextField(); 
		private Label lbformaPagamento = new Label("Forma de Pagamento:");
		private TextField TextformaPagamento = new TextField(); 		
		private Label lbvalorTotal = new Label("Valor Total:");
		private TextField TextvalorTotal = new TextField(); 
		
		private TableView<Pagamento> tablePagamento = new TableView<>();
		
		private Button btnPesquisar = new Button("Pesquisar");
		private Button btnSalvar = new Button("Salvar");
		
		private PagamentoControl controle = new PagamentoControl();
		
		
		@Override
		public void start(Stage stage) throws Exception {
			
			Pane painel = new Pane();
			
			lblTitulo.relocate(180, 15);
			lblTitulo.setStyle("-fx-text-fill: 'white';"
                                         + "-fx-font-size: 2.5em");
			painel.getChildren().add(lblTitulo);
			
			lbformaPagamento.relocate(30, 80);
			lbformaPagamento.setStyle("-fx-text-fill: 'white';"
	                                + "-fx-font-size: 1.em");		
                        painel.getChildren().add(lbformaPagamento);
			
	                TextformaPagamento.relocate(150, 80);
	                TextformaPagamento.setPrefSize(240, 0);
                        CheckBox cb = new CheckBox("a checkbox");
                        cb.setIndeterminate(false);
			painel.getChildren().add(TextformaPagamento);			
		
			lbvalorTotal.relocate(30, 150);
			lbvalorTotal.setStyle("-fx-text-fill: 'white';"
                                            + "-fx-font-size: 1em");
			painel.getChildren().add(lbvalorTotal);
			
	                TextvalorTotal.relocate(150, 150);
	                TextvalorTotal.setPrefSize(240, 0);
			painel.getChildren().add(TextvalorTotal);
			
			btnPesquisar.relocate(220, 260);
			painel.getChildren().addAll(btnPesquisar);
			
			btnSalvar.relocate(150, 260);
			painel.getChildren().addAll(btnSalvar);	   

			prepararTable();
			
                        tablePagamento.relocate(20, 350);
			tablePagamento.setPrefSize(480, 200);
			painel.getChildren().addAll(tablePagamento);
						
		//Botao Inserir
		btnSalvar.setOnAction(e ->{
					
		//	String cmd = e.getSource().toString();
		//	System.out.println(cmd)	;
			if(((TextId.getText().isEmpty()
			  || TextformaPagamento.getText().isEmpty()
			  || TextvalorTotal.getText().isEmpty()))) {
						
						
	            JOptionPane.showMessageDialog(null, "Não deixei campos em branco", "ERRO", JOptionPane.ERROR_MESSAGE);				   
					}
			
			controle.salvar();
			controle.limpar();
			controle.pesquisar();
		});
                
		//Botao Pesquisar		
		btnPesquisar.setOnAction(e ->{	
			
			
		//	String cmd = e.getSource().toString();
		//	System.out.println(cmd);
			
			
			controle.pesquisar();
		});
		
		//Metodo que vincula os TextFields com os atributos da pizza salgada
		vincular();

			Scene cena = new Scene(painel, 520, 560);
			painel.setStyle("-fx-background-color: red;");
			
			stage.setScene(cena);
			stage.setFullScreen(false);
			stage.setTitle("Tela de Sobremesa");
			stage.show();
		}
		
		//Adição e preparacao da tabela
		
		private void prepararTable() {
			//Insercao das colunas
			
			TableColumn<Pagamento, Integer > col1 = new TableColumn<>("ID_SOBREMESA");
			col1.setCellValueFactory(
					new PropertyValueFactory<Pagamento, Integer>("id"));
			
			
			TableColumn<Pagamento, String  > col2 = new TableColumn<>("NOME");
			col2.setCellValueFactory(
					new PropertyValueFactory<Pagamento, String>("nome"));
		
			TableColumn<Pagamento, Double  > col4 = new TableColumn<>("PREÇO");
			col4.setCellValueFactory(
					new PropertyValueFactory<Pagamento, Double>("preço"));
			
			TableColumn<Pagamento, String  > col5 = new TableColumn<>("Opções");

			

			
			
	        Callback<TableColumn<Pagamento, String>, TableCell<Pagamento, String>> cellFactory
            = //
            new Callback<TableColumn<Pagamento, String>, TableCell<Pagamento, String>>() {
        @Override
        public TableCell call(final TableColumn<Pagamento, String> param) {
            final TableCell<Pagamento, String> cell = new TableCell<Pagamento, String>() {

            	
                final Button btnApagar = new Button("Apagar");
                final Button btnEditar = new Button("Editar");
                

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                    	btnApagar.setOnAction(e -> {
                    		
                		//	String cmd = e.getSource().toString();
                		//	System.out.println(cmd);
                			
                        	Pagamento ps = getTableView().getItems().get(getIndex());
                        	
                            controle.apagar(ps);
                            controle.limpar();
                            controle.pesquisar();
                        });
                    	
                    	btnEditar.setOnAction(e -> {
                		//	String cmd = e.getSource().toString();
                		//	System.out.println(cmd);
                			
                        	Pagamento ps = getTableView().getItems().get(getIndex());
                            controle.setEntity(ps);
                        	controle.editar();
                        });
                    	
                    	//Campo FlowPane que exibe os botoes de Apagar e Editar
                    	FlowPane fpanel = new FlowPane();
                    	fpanel.getChildren().addAll(btnApagar, btnEditar);
                        setGraphic(fpanel);
                        setText(null);
                    }
                }
            };
            return cell;
        }
    };

    col5.setCellFactory(cellFactory);
			
			
			tablePagamento.getColumns().clear();
			tablePagamento.getColumns().addAll(col1, col2, col4, col5);
			tablePagamento.setItems(controle.getListaPizzaSalgada());	
			
		}
		
		//metodo de vinculacao de TextFields e os atributos da pizza salgada

		public void vincular() {
			
			StringConverter<? extends Number> converterInteiro =
					new IntegerStringConverter();
			
			Bindings.bindBidirectional(TextId.textProperty(), controle.idProperty(),
					                  (StringConverter)converterInteiro);	
			
			StringConverter<? extends Number> converterDouble =
					new DoubleStringConverter();
			
			Bindings.bindBidirectional(TextvalorTotal.textProperty(), controle.preçoProperty(),
					  (StringConverter)converterDouble);
		}
		
		public static void main(String[] args) {
			
			Application.launch(PagamentoBoundary.class, args);
		}
	}

