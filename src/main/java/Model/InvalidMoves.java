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


    public InvalidMoves(Player p1 ,Player p2){
        this.player1=p1;
        this.player2=p2;

    };


    public Player GetBlack(){
        if(player1.getColor().get()==1) return player1;
        else return player2;
    }

    public Player GetWhite(){
        if(player1.getColor().get()==2) return player1;
        else return player2;
    }

/*
    private void Sequential(List <Integer> aux, Integer s, String mode, int c,List<Pair<Integer,Integer>> p,Player p1) {
        List<Integer> a=new ArrayList<>();
        List<Integer> sub_a=new ArrayList<>();
        for(int i=0;i<c-1;i++){sub_a.add(1);};
        List <Pair<Integer,Integer>> aux1;
        int index;
        switch (mode) {
            case "row":
                aux.clear();
                aux1 =new ArrayList<>( p.stream().filter(x -> x.getValue().equals(s)).collect(Collectors.toSet()));
                aux1.forEach(i -> aux.add(i.getKey()));
                Collections.sort(aux);
                for(int i=aux.size()-1;i>0;i--){
                    if(i!=0) a.add(aux.get(i)-aux.get(i-1));
                }
                index=Collections.indexOfSubList(a , sub_a);
                if (index != - 1){
                    Check_opponent(aux.get(index)-1,aux.get(index)+c,s,s,p1);
                }
                break;
            case "col":
                aux.clear();
                aux1 =new ArrayList<>( p.stream().filter(x -> x.getKey().equals(s)).collect(Collectors.toSet()));
                aux1.forEach(i -> aux.add(i.getValue()));
                Collections.sort(aux);
                for(int i=aux.size()-1;i>0;i--){
                    if(i!=0) a.add(aux.get(i)-aux.get(i-1));
                }
                index=Collections.indexOfSubList(a , sub_a);
                if (index != - 1){
                    Check_opponent(s,s,aux.get(index)-1,aux.get(index)+c,p1);
                }
                break;
        }
       for(int i=aux.size()-1;i>0;i--){
           if(i!=0) a.add(aux.get(i)-aux.get(i-1));
        }
        int index=Collections.indexOfSubList(a , sub_a);
        if (index != - 1){
            System.out.println(aux.get(index));

        }

    };*/
    private void V(int c,List<Pair<Integer,Integer>> pp,Player p,Player p1){
        for(Pair<Integer,Integer> i : pp){
            Piece pair1=new Piece(p.getColor().intValue());
            pair1.setX(i.getKey());
            pair1.setY(i.getValue()+1);
            Piece pair2=new Piece(p.getColor().intValue());
            pair2.setX(i.getKey());
            pair2.setY(i.getValue()+(c-1));
            Piece pair3=new Piece(p.getColor().intValue());
            pair3.setX(i.getKey());
            pair3.setY(i.getValue()-1);
            Piece pair4=new Piece(p.getColor().intValue());
            pair4.setX(i.getKey());
            pair4.setY(i.getValue()-(c-1));
            if(p.CheckinMoves(pair1) && p.CheckinMoves(pair2)) {
                this.Check_opponent(i.getKey(),pair2.getX(),i.getValue()-1,pair2.getY()+1,p1);
            }
            if(p.CheckinMoves(pair3) && p.CheckinMoves(pair4)) {
                this.Check_opponent(i.getKey(),pair4.getX(),i.getValue()+1,pair4.getY()-1,p1);
            }
    }

    };

    private void Ho(int c,List<Pair<Integer,Integer>> pp,Player p,Player p1){
        for(Pair<Integer,Integer> i : pp){
            Piece pair1=new Piece(p.getColor().intValue());
            pair1.setX(i.getKey()+1);
            pair1.setY(i.getValue());
            Piece pair2=new Piece(p.getColor().intValue());
            pair2.setX(i.getKey()+(c-1));
            pair2.setY(i.getValue());
            Piece pair3=new Piece(p.getColor().intValue());
            pair3.setX(i.getKey()+1);
            pair3.setY(i.getValue());
            Piece pair4=new Piece(p.getColor().intValue());
            pair4.setX(i.getKey()+(c-1));
            pair4.setY(i.getValue());
            if(p.CheckinMoves(pair1) && p.CheckinMoves(pair2)) {
                this.Check_opponent(i.getKey()-1,pair2.getX()+1,i.getValue(),pair2.getY(),p1);
            }
            if(p.CheckinMoves(pair3) && p.CheckinMoves(pair4)) {
                this.Check_opponent(i.getKey()-1,pair4.getX()+1,i.getValue(),pair4.getY(),p1);
            }
        }

    };

    private void Diagonal(int c,List<Pair<Integer,Integer>> pp,Player p,Player p1){
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
               this.Check_opponent(i.getKey()-1,pair2.getX()+1,i.getValue()-1,pair2.getY()+1,p1);
           }
           if(p.CheckinMoves(pair3) && p.CheckinMoves(pair4)) {
               this.Check_opponent(i.getKey()-1,pair4.getX()+1,i.getValue()+1,pair4.getY()-1,p1);
           }
       }

    };

    private void Check_opponent(Integer x,Integer x1,Integer y,Integer y1,Player p1){
        Piece piedx=new Piece(p1.getColor().get());
        Piece piesx=new Piece(p1.getColor().get());
        piedx.setX(x);
        piedx.setY(y);
        piesx.setX(x1);
        piesx.setY(y1);


        if(p1.CheckinMoves(piedx) || p1.CheckinMoves(piesx)){ System.out.println("ok");}
        else {
            throw new Error("Open rows!");
        }

    };
/*
    private void Error_throw(List<Integer> aux,Integer e,Player p,String m,int c,List<Pair<Integer,Integer>> pp){
        /*if (this.Sequential(aux, e, m, c,pp)) {
            this.Check_opponent(aux.get(0),aux.get(aux.size()-1), e,0, p, m);
        }
        this.Sequential(aux, e, m, c,pp,p);
    };*/

    public void Check_V(Player p,Player p1,int c,List<Pair<Integer,Integer>> pp){
        Collections.sort(pp, Comparator.comparing(i -> i.getValue()));
        this.V(c,pp,p,p1);
    };

    public void Check_Ho(Player p,Player p1,int c,List<Pair<Integer,Integer>> pp){
        Collections.sort(pp, Comparator.comparing(i -> i.getKey()));
        this.Ho(c,pp,p,p1);
    };

    public void Check_diag(Player p,Player p1,int c,List<Pair<Integer,Integer>> pp){
      Collections.sort(pp, Comparator.comparing(i -> i.getKey()));
      this.Diagonal(c,pp,p,p1);
    };
/*
    public void Check_or(Player p,Player p1,int c,List<Pair<Integer,Integer>> pp){
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
    };

    public void Check_vert(Player p,Player p1,int c,List<Pair<Integer,Integer>> pp){
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
    };*/

    public void three_and_three(int c){
        if (c==1){
            Check_Ho(this.GetBlack(),this.GetWhite(),3,this.getPositions(this.GetBlack()));
            Check_V(this.GetBlack(),this.GetWhite(),3,this.getPositions(this.GetBlack()));
            Check_diag(this.GetBlack(),this.GetWhite(),3,this.getPositions(this.GetBlack()));
        }
        else {
            Check_Ho(this.GetWhite(),this.GetBlack(),3,this.getPositions(this.GetWhite()));
            Check_V(this.GetWhite(),this.GetBlack(),3,this.getPositions(this.GetWhite()));
            Check_diag(this.GetWhite(),this.GetBlack(),3,this.getPositions(this.GetWhite()));
        }

    };

    private List<Pair<Integer,Integer>> getPositions(Player p){
        List<Pair<Integer,Integer>> stones=new ArrayList<Pair<Integer, Integer>>();
        p.getPositions().forEach(i->stones.add(new Pair<>(i.getX(),i.getY())));
        return stones;
    }

    public void four_and_four(int c){
        if (c==1){
            Check_Ho(this.GetBlack(),this.GetWhite(),4,this.getPositions(this.GetBlack()));
            Check_V(this.GetBlack(),this.GetWhite(),4,this.getPositions(this.GetBlack()));
            Check_diag(this.GetBlack(),this.GetWhite(),4,this.getPositions(this.GetBlack()));
        }
        else {
            Check_Ho(this.GetWhite(),this.GetBlack(),4,this.getPositions(this.GetWhite()));
            Check_V(this.GetWhite(),this.GetBlack(),4,this.getPositions(this.GetWhite()));
            Check_diag(this.GetWhite(),this.GetBlack(),4,this.getPositions(this.GetWhite()));
        }
    };
}
