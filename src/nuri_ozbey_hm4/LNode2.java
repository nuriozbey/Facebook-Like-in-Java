/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuri_ozbey_hm4;

/**
 *
 * @author nurio
 * @param <AnyType>
 */
public class LNode2<AnyType> extends MyLinkedList<AnyType> implements Comparable<LNode2>{
    public AnyType Element2;
    public MyLinkedList InList;
    public LNode2 link2;

    @Override
    public int compareTo(LNode2 t) {
//        if (ID > o.ID)
//           return 1;
//        else if (ID < o.ID)
//            return -1;
//        else return 0;
    if(t.Element2 == this.Element2){
        return 1;
    }else{
        return 0;
    }
    //return this.Element2.compareTo(t.Element2);
    
    } 
}
