/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sobremesa;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.beans.binding.Bindings;

import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class SobremesaBoundary extends Application{

	    
		private Label lblTitulo = new Label("Sobremesa");
		
		private Label lbId = new Label("ID:");
		private TextField TextId = new TextField(); 
		
                private Label lbNome = new Label("Preço:");
		private TextField TextNome = new TextField(); 
                
		private Label lbPreco = new Label("Preço:");
		private TextField TextPreco = new TextField(); 
		
		private TableView<Sobremesa> tableSobremesa = new TableView<>();
		
		private Button btnPesquisar = new Button("Pesquisar");
		private Button btnSalvar = new Button("Salvar");
		
		private SobremesaControl controle = new SobremesaControl();
		
		
		@Override
		public void start(Stage stage) throws Exception {
			
			Pane painel = new Pane();
			
			lblTitulo.relocate(180, 18);
			lblTitulo.setStyle("-fx-text-fill: 'white';"
                                         + "-fx-font-size: 3em");
			painel.getChildren().add(lblTitulo);
			
			lbNome.relocate(30, 80);
			lbNome.setStyle("-fx-text-fill: 'white';"
                                      + "-fx-font-size: 1.2em");
			painel.getChildren().add(lbNome);
			
	                TextNome.relocate(100, 80);
	                TextNome.setPrefSize(240, 0);
			painel.getChildren().add(TextNome);			
			
			lbId.relocate(30, 140);
			lbId.setStyle("-fx-text-fill: 'white';"
                                    + "-fx-font-size: 1.2em");
			painel.getChildren().add(lbId);
			
	                TextId.relocate(100, 140);
	                TextId.setPrefSize(240, 0);
			painel.getChildren().add(TextId);
			
			lbPreco.relocate(30, 260);
			lbPreco.setStyle("-fx-text-fill: 'white';"
                                       + "-fx-font-size: 1.2em");
			painel.getChildren().add(lbPreco);
			
                        TextPreco.relocate(100, 260);
	                TextPreco.setPrefSize(240, 0);
			painel.getChildren().add(TextPreco);
			
			
			btnPesquisar.relocate(350, 80);
			painel.getChildren().addAll(btnPesquisar);
			
			btnSalvar.relocate(440, 80);
			painel.getChildren().addAll(btnSalvar);	   

			prepararTable();
			
			tableSobremesa.relocate(20, 350);
			tableSobremesa.setPrefSize(480, 200);
			painel.getChildren().addAll(tableSobremesa);
			

			
		//Botao Inserir
		btnSalvar.setOnAction(e ->{
					
			
		//	String cmd = e.getSource().toString();
		//	System.out.println(cmd)	;
			
			
			if(((TextId.getText().isEmpty()
			  || TextNome.getText().isEmpty()
			  || TextPreco.getText().isEmpty()))) {
						
						
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
			painel.setStyle("-fx-background-color: green;");
			
			stage.setScene(cena);
			stage.setFullScreen(false);
			stage.setTitle("Tela Pizza Salgada");
			stage.show();
		}
		
		//Adição e preparacao da tabela
		
		private void prepararTable() {
			//Insercao das colunas
			
			TableColumn<Sobremesa, Integer > col1 = new TableColumn<>("ID_SOBREMESA");
			col1.setCellValueFactory(
					new PropertyValueFactory<Sobremesa, Integer>("id"));
			
			
			TableColumn<Sobremesa, String  > col2 = new TableColumn<>("nome");
			col2.setCellValueFactory(
					new PropertyValueFactory<Sobremesa, String>("nome"));
			
			
			TableColumn<Sobremesa, Double  > col4 = new TableColumn<>("PREÇO");
			col4.setCellValueFactory(
					new PropertyValueFactory<Sobremesa, Double>("preço"));
			
			TableColumn<Sobremesa, String  > col5 = new TableColumn<>("Opções");

			

			
			
	        Callback<TableColumn<Sobremesa, String>, TableCell<Sobremesa, String>> cellFactory
            = //
            new Callback<TableColumn<Sobremesa, String>, TableCell<Sobremesa, String>>() {
        @Override
        public TableCell call(final TableColumn<Sobremesa, String> param) {
            final TableCell<Sobremesa, String> cell = new TableCell<Sobremesa, String>() {

            	
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
                			
                        	Sobremesa ps = getTableView().getItems().get(getIndex());
                        	
                            controle.apagar(ps);
                            controle.limpar();
                            controle.pesquisar();
                        });
                    	
                    	btnEditar.setOnAction(e -> {
                		//	String cmd = e.getSource().toString();
                		//	System.out.println(cmd);
                			
                        	Sobremesa ps = getTableView().getItems().get(getIndex());
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
			
			
			tableSobremesa.getColumns().clear();
			tableSobremesa.getColumns().addAll(col1, col2, col4, col5);
			
			tableSobremesa.setItems(controle.getListaPizzaSalgada());
			
			
			// Envio de informacoes pros TextFields
//			tablePizzaSal.getSelectionModel()
//			.selectedItemProperty()
//			.addListener( (prop, antiga, novo) -> {
//			
//				
//				controle.setEntity(novo);
//			});
			
			
			
		}
		
		//metodo de vinculacao de TextFields e os atributos da pizza salgada

		public void vincular() {
			
			StringConverter<? extends Number> converterInteiro =
					new IntegerStringConverter();
			
			Bindings.bindBidirectional(TextId.textProperty(), controle.idProperty(),
					                  (StringConverter)converterInteiro);
			
			
			Bindings.bindBidirectional(controle.saborProperty(),
					   TextNome.textProperty());			
			
			StringConverter<? extends Number> converterDouble =
					new DoubleStringConverter();
			
			Bindings.bindBidirectional(TextPreco.textProperty(), controle.preçoProperty(),
					  (StringConverter)converterDouble);
		}
		
		

		
		public static void main(String[] args) {
			
			Application.launch(SobremesaBoundary.class, args);
		}
	}