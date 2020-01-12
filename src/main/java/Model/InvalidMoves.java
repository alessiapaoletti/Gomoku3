package Model;

import javafx.util.Pair;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;

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
        List<Integer> a=new ArrayList<>();
        List<Integer> sub_a=new ArrayList<>();
        for(int i=0;i<c-1;i++){sub_a.add(1);};
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
       for(int i=aux.size()-1;i>0;i--){
           if(i!=0) a.add(aux.get(i)-aux.get(i-1));
        }
        int index=Collections.indexOfSubList(a , sub_a);
        if (index != - 1) return true;
        else return false;

    };

    private void Diagonal(int c,List<Pair<Integer,Integer>> pp,Player p,Player p1){
       /* List<Integer> a_k=new ArrayList<>();
        List<Integer> a_v=new ArrayList<>();
        List<Integer> sub_a=new ArrayList<>();
        List<Integer> sub_a_1=new ArrayList<>();
        for(int i=0;i<c-1;i++){
            sub_a.add(1);
            sub_a_1.add(-1);
        }
        for(int i=pp.size()-1;i>0;i--){
            if(i!=0){
                a_k.add(pp.get(i).getKey()-pp.get(i-1).getKey());
                a_v.add(pp.get(i).getValue()-pp.get(i-1).getValue());
            }
        }
        int index_k=Collections.indexOfSubList(a_k , sub_a);
        int index_v_1=Collections.indexOfSubList(a_v , sub_a);
        int index_v=Collections.indexOfSubList(a_v , sub_a_1);
        System.out.println(a_k);
        System.out.println(a_v);
        System.out.println(index_k);
        System.out.println(index_v);
        System.out.println(index_v_1);

        if ((index_k != - 1 && index_v_1 !=-1) || (index_k != - 1 && index_v !=-1)){
            int key1=pp.get(pp.size()-index_k-1).getKey();
            int key2=pp.get(pp.size()-index_k-a_k.size()-1).getKey();
            int v1=pp.get(pp.size()-index_k-1).getValue();
            int v2=pp.get(pp.size()-index_k-a_k.size()-1).getValue();
            this.Check_opponent(key1,key2,v1,v2,p1,"diag");
        }
        */
       for(Pair<Integer,Integer> i : pp){
           Piece pair1=new Piece(p.getColor().intValue());
           pair1.setX(i.getKey()+1);
           pair1.setY(i.getValue()+1);
           Piece pair2=new Piece(p.getColor().intValue());
           pair2.setX(i.getKey()+(c-1));
           pair2.setY(i.getValue()+(c-1));
           Piece pair3=new Piece(p.getColor().intValue());
           pair3.setX(i.getKey()+1);
           pair3.setY(i.getValue()-1);
           Piece pair4=new Piece(p.getColor().intValue());
           pair4.setX(i.getKey()+(c-1));
           pair4.setY(i.getValue()-(c-1));
           if(p.CheckinMoves(pair1) && p.CheckinMoves(pair2)) {
               this.Check_opponent(i.getKey()-1,pair2.getX()+1,i.getValue()-1,pair2.getY()+1,p1,"diag");
           }
           if(p.CheckinMoves(pair3) && p.CheckinMoves(pair4)) {
               this.Check_opponent(i.getKey()-1,pair4.getX()+1,i.getValue()+1,pair4.getY()-1,p1,"diag");
           }
       }

    };

    private void Check_opponent(Integer x,Integer x1,Integer y,Integer y1,Player p1,String mode){
        Piece piedx=new Piece(p1.getColor().get());
        Piece piesx=new Piece(p1.getColor().get());
        switch (mode) {
            case "row":
                piedx.setX(x - 1);
                piedx.setY(y);
                piesx.setX(x1 + 1);
                piesx.setY(y);
                break;
            case "col":
                piedx.setX(y);
                piedx.setY(x - 1);
                piesx.setX(y);
                piesx.setY(x1 + 1);
                break;
            case "diag":
                piedx.setX(x);
                piedx.setY(y);
                piesx.setX(x1);
                piesx.setY(y1);
        }

        if(p1.CheckinMoves(piedx) || p1.CheckinMoves(piesx)){ System.out.println("ok");}
        else {
            this.Clear();
            throw new Error("Open rows!");
        }

    };

    private void Error_throw(List<Integer> aux,Integer e,Player p,String m,int c,List<Pair<Integer,Integer>> pp){
        if (this.Sequential(aux, e, m, c,pp)) {
            this.Check_opponent(aux.get(0),aux.get(aux.size()-1), e,0, p, m);
        }
    };

    public void Check_diag(Player p,Player p1,int c,List<Pair<Integer,Integer>> pp){
      this.Update();
      Collections.sort(pp, Comparator.comparing(i -> i.getKey()));
      System.out.println(pp);
      this.Diagonal(c,pp,p,p1);
      this.Clear();
    };

    public void Check_or(Player p,Player p1,int c,List<Pair<Integer,Integer>> pp){
        this.Update();
        List<Integer> aux=new ArrayList<Integer>();
        List<Integer> unique = new ArrayList<>();
        p.getPositions().forEach(i -> unique.add(i.getY()));
        Map<Integer, Long>  count = unique.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream().filter(x -> x.getValue() >= c)
                    .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
        if (!count.keySet().isEmpty()) {
            List<Integer> check = new ArrayList<>((count.keySet()));
            check.forEach(i->Error_throw(aux,i,p1,"row",c,pp));
        }
        this.Clear();
    };

    public void Check_vert(Player p,Player p1,int c,List<Pair<Integer,Integer>> pp){
        this.Update();
        List <Integer> aux=new ArrayList<>();
        List<Integer> unique = new ArrayList<>();
        p.getPositions().forEach(i -> unique.add(i.getX()));
        Map<Integer, Long> count = unique.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() >= c)
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
        if(!count.keySet().isEmpty()){
            List<Integer> check = new ArrayList<>((count.keySet()));
            check.forEach(i->Error_throw(aux,i,p1,"col",c,pp));
        }
        this.Clear();
    };

    public void three_and_three(int c){
        if (c==1){
            Check_or(this.GetBlack(),this.GetWhite(),3,this.stones_player1);
            Check_vert(this.GetBlack(),this.GetWhite(),3,this.stones_player1);
            Check_diag(this.GetBlack(),this.GetWhite(),3,this.stones_player1);
        }
        else {
            Check_or(this.GetWhite(),this.GetBlack(),3,this.stones_player2);
            Check_vert(this.GetWhite(),this.GetBlack(),3,this.stones_player2);
            Check_diag(this.GetWhite(),this.GetBlack(),3,this.stones_player2);
        }

    };

    public void four_and_four(int c){
        if (c==1){
            Check_or(this.GetBlack(),this.GetWhite(),4,this.stones_player1);
            Check_vert(this.GetBlack(),this.GetWhite(),4,this.stones_player1);
            Check_diag(this.GetBlack(),this.GetWhite(),4,this.stones_player1);
        }
        else {
            Check_or(this.GetWhite(),this.GetBlack(),4,this.stones_player2);
            Check_vert(this.GetWhite(),this.GetBlack(),4,this.stones_player2);
            Check_diag(this.GetWhite(),this.GetBlack(),4,this.stones_player2);
        }
    };
}
