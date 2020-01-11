package Controller;
import Model.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginController {

    private  GomokuGame targetGomoku;

//    ActionListener listener1;
//    ActionListener listener2;

    private ObservableList<String> methods= FXCollections.observableArrayList("Standard","Renju","Omok");
    private ObservableList<String> openings= FXCollections.observableArrayList("Standard","Pro","LongPro","Swap","Swap2");
    private ObservableList<String> colors= FXCollections.observableArrayList("Black","White");

    @FXML private javafx.scene.control.Button eBottim;

    @FXML private javafx.scene.control.TextField playerf;

    @FXML private javafx.scene.control.TextField players;

    @FXML private ChoiceBox choice;

    @FXML private ChoiceBox choicecol;

    //@FXML
    //private ChoiceBox choicecol1;

    //@FXML
    //private ChangeListener choicecol2;

    @FXML private ChoiceBox choiceOpening;

    public LoginController() {
    }

    @FXML private void initialize(){

        choice.setItems(methods);
        choicecol.setItems(colors);
        //choicecol1.setItems(colors);
        //choicecol2.getItems(colors);
        choiceOpening.setItems(openings);

    }

    @FXML
    public void startGame() throws IOException {

        System.out.println("start game!");
        boolean isMyComboBoxEmpty = choice.getSelectionModel().isEmpty();
        boolean isMyColEmpty = choicecol.getSelectionModel().isEmpty();
        //boolean isMyCol1Empty = choicecol1.getSelectionModel().isEmpty();
        //boolean isMyCol2Empty = choicecol2.getSelectionModel().isEmpty();
        boolean isOpeningEmpty = choiceOpening.getSelectionModel().isEmpty();

        //if (!isMyComboBoxEmpty && !isMyCol1Empty && !isMyCol2Empty){
        if (!isMyComboBoxEmpty && !isMyColEmpty){
            if (!(playerf.getText().equals("")) && !(players.getText().equals(""))) {
                //if(choicecol1.getSelectionModel().getSelectedItem().toString()!=choicecol2.getSelectionModel().getSelectedItem().toString()) {
                Player p1 = new Player(playerf.getText(), choicecol.getSelectionModel().getSelectedItem().toString());
                Player p2= new Player(players.getText(), colors.get(2-((Integer) choicecol.getSelectionModel().getSelectedIndex()+1)));
                    //Player p1 = new Player(playerf.getText(), choicecol1.getSelectionModel().getSelectedItem().toString());
                    //Player p2 = new Player(players.getText(), choicecol2.getSelectionModel().getSelectedItem().toString());
                    String opening_meth;
                    if(!isOpeningEmpty){ opening_meth=choiceOpening.getSelectionModel().getSelectedItem().toString();}
                    else {opening_meth="Standard";}
                    startGameUsingFactory(p1, p2, choice.getSelectionModel().getSelectedItem().toString(),opening_meth);
                    Stage stage = (Stage) eBottim.getScene().getWindow();
                    stage.close();

                    Stage mainStage = new Stage(StageStyle.DECORATED);
                    GomokuBoard myBoard = new GomokuBoard(mainStage,targetGomoku);

                    //myBoard.start(mainStage); //decidere se chiamare lo start method qui o nel constructor di GomokuBoard


//                    Parent root = null;
//                    try {
//                        root = FXMLLoader.load(getClass().getResource("../View/boardView.fxml"));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    mainStage.setTitle("Gomoku Board");
//                    mainStage.setScene(new Scene(root, 500, 450));
//                    mainStage.show();
                //}

                /*  *else{
                    Alert alertColors = new Alert(Alert.AlertType.ERROR);
                    alertColors.setTitle("ERROR - Colors");
                    alertColors.setHeaderText(null);
                    alertColors.setContentText("Choose different colors");
                    alertColors.showAndWait();
                 }* */
            }
            else {
                Alert alertNames = new Alert(Alert.AlertType.ERROR);
                alertNames.setTitle("ERROR - Missing values");
                alertNames.setHeaderText(null);
                alertNames.setContentText("Insert the name of both players");
                alertNames.showAndWait();
            }
        }else{
            System.out.println("Please select the type of Gomoku");
        }
    }

    @FXML
    public void close(){
        Stage stage = (Stage) eBottim.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    private void startGameUsingFactory(Player p1, Player p2, String game,String m){
        this.targetGomoku = GomokuFactory.getGame(game).orElseThrow(() -> new IllegalArgumentException("Invalid operator"));
        this.targetGomoku.setPlayers(p1, p2);

        int gridSize = 15; //default size
        if (game.equals("Omok")) gridSize = 19; //different size for the Omok version
        this.targetGomoku.setSize(gridSize);

        this.targetGomoku.setOp(m);
        //return targetGomoku.initGame();

    }

}
