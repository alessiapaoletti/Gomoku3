package Model;

import javafx.util.Pair;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InvalidMoves {
    private Player player1;
    private Player player2;
    private List<Pair<Integer,Integer>> stones_player1=new ArrayList<Pair<Integer, Integer>>();
    private List<Pair<Integer,Integer>> stones_player2=new ArrayList<Pair<Integer, Integer>>();

    public InvalidMoves(Player p1 ,Player p2){
        this.player1=p1;
        this.player2=p2;
        this.Update();
    };

    private void Update(){
        player1.getPositions().forEach(i -> this.stones_player1.add(new Pair<>(i.getX(),i.getY())));
        player2.getPositions().forEach(i -> this.stones_player2.add(new Pair<>(i.getX(),i.getY())));
    };

    private void Clear(){
        this.stones_player1.clear();
        this.stones_player2.clear();
    };

    public Player GetBlack(){
        if(player1.getColor().get()==1) return player1;
        else return player2;
    }

    public Player GetWhite(){
        if(player1.getColor().get()==2) return player1;
        else return player2;
    }

    private Boolean Sequential(List <Integer> aux, Integer s, String mode, int c,List<Pair<Integer,Integer>> p) {
        int a=0;
        List <Pair<Integer,Integer>> aux1;
        switch (mode) {
            case "row":
                aux.clear();
                aux1 =new ArrayList<>( p.stream().filter(x -> x.getValue().equals(s)).collect(Collectors.toSet()));
                aux1.forEach(i -> aux.add(i.getKey()));
                Collections.sort(aux);
                break;
            case "col":
                aux.clear();
                aux1 =new ArrayList<>( p.stream().filter(x -> x.getKey().equals(s)).collect(Collectors.toSet()));
                aux1.forEach(i -> aux.add(i.getValue()));
                Collections.sort(aux);
                break;
        }
        System.out.println(aux);
       for(int i=aux.size()-1;i>0;i--){
            if(i!=0) a+=(aux.get(i)-aux.get(i-1));
        }

            if (a == c - 1) return true;
            else return false;

    };

    private void Check_opponent(List<Integer> x,Integer y,Player p1,String mode){
        Piece piedx=new Piece(p1.getColor().get());
        Piece piesx=new Piece(p1.getColor().get());
        switch (mode) {
            case "row":
                piedx.setX(x.get(0) - 1);
                piedx.setY(y);
                piesx.setX(x.get(x.size() - 1) + 1);
                piesx.setY(y);
                break;
            case "col":
                piedx.setX(y);
                piedx.setY(x.get(0) - 1);
                piesx.setX(y);
                piesx.setY(x.get(x.size() - 1) + 1);
                break;
        }

        if(p1.CheckinMoves(piedx) || p1.CheckinMoves(piesx)){ System.out.println("ok");}
        else {
            this.Clear();
            throw new Error("Open rows!");
        }

    };

    private void Error_throw(List<Integer> aux,Integer e,Player p,String m,int c,List<Pair<Integer,Integer>> pp){
        if (this.Sequential(aux, e, m, c,pp)) {
            this.Check_opponent(aux, e, p, m);
        }
    };

    public void Check_or(Player p,Player p1,int c,List<Pair<Integer,Integer>> pp){
        this.Update();
        List<Integer> aux=new ArrayList<Integer>();
        List<Integer> unique = new ArrayList<>();
        p.getPositions().forEach(i -> unique.add(i.getY()));
        Map<Integer, Long>  count = unique.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream().filter(x -> x.getValue() == c)
                    .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
        if (!count.keySet().isEmpty()) {
            List<Integer> check = new ArrayList<>((count.keySet()));
            check.forEach(i->Error_throw(aux,i,p1,"row",c,pp));
        }
    };

    public void Check_vert(Player p,Player p1,int c,List<Pair<Integer,Integer>> pp){
        this.Update();
        List <Integer> aux=new ArrayList<>();
        List<Integer> unique = new ArrayList<>();
        p.getPositions().forEach(i -> unique.add(i.getX()));
        Map<Integer, Long> count = unique.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == c)
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
        if(!count.keySet().isEmpty()){
            List<Integer> check = new ArrayList<>((count.keySet()));
            check.forEach(i->Error_throw(aux,i,p1,"col",c,pp));
        }

    };

    public void three_and_three(int c){
        if (c==1){
            Check_or(this.GetBlack(),this.GetWhite(),3,this.stones_player1);
            Check_vert(this.GetBlack(),this.GetWhite(),3,this.stones_player1);
        }
        else {
            Check_or(this.GetWhite(),this.GetBlack(),3,this.stones_player2);
            Check_vert(this.GetWhite(),this.GetBlack(),3,this.stones_player2);
        }

    };

    public void four_and_four(int c){
        if (c==1){
            Check_or(this.GetBlack(),this.GetWhite(),4,this.stones_player1);
            Check_vert(this.GetBlack(),this.GetWhite(),4,this.stones_player1);
        }
        else {
            Check_or(this.GetWhite(),this.GetBlack(),4,this.stones_player2);
            Check_vert(this.GetWhite(),this.GetBlack(),4,this.stones_player2);
        }
    };
}
