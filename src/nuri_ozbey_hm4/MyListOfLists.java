/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuri_ozbey_hm4;

import java.util.Iterator;

/**
 *
 * @author nurio
 * @param <AnyType>
 */
public class MyListOfLists<AnyType>  extends LNode2<AnyType>{
    private LNode2<AnyType> head;
    private int listssize;
    
    public MyListOfLists() {
        head = null;
        listssize = 0;
    }
    public LNode2 getNode(){
        return head;
    }
    public AnyType getElement(int pos){
        AnyType retElement = null;
        LNode2<AnyType> Dummy;
        if (pos == 0 && head != null){    // The First Element
            retElement = head.Element2;
        }else{
            Dummy = head;
            for (int i = 0; i < pos-1; i++)
            {
                Dummy = Dummy.link2;
            }
            retElement = (AnyType)Dummy.link2.Element2;
        } 
        return retElement;
    }
    public MyLinkedList getList(int pos){
        MyLinkedList retList = new MyLinkedList<>();
        LNode2<AnyType> Dummy;
        if (pos == 0 && head != null){    // The First Element
            retList = head.InList;
        }else{
            Dummy = head;
            for (int i = 0; i < pos; i++)
            {
                Dummy = Dummy.link2;
            }
            
            retList =  Dummy.InList;
        } 
        return retList;
    }
    
    public void setList(MyLinkedList list,int pos) {
		LNode2 current = goTo(pos);
		current.InList = list;
    }
    private LNode2 goTo(int index) {
		LNode2 current = head;
		for (int i = 0; i < index; i++) {
			current = current.link2;
		}
		return current;
    }
    private class LinkedListIterator implements Iterator<AnyType> {
		private LNode2 current;   // current position in list

		public LinkedListIterator() {
			current = head;
		}

                @Override
		public boolean hasNext() {
			return current != null;
		}

                @Override
		public AnyType next() {
			AnyType result =(AnyType)current.Element2;
			current = current.link2;
			return result;
		}
	}	
    public void InsertList(AnyType newElement, int pos){
        LNode2<AnyType> Dummy;
        Dummy = head;
        if (pos == 0) // Add to the first location
        {
            LNode2 NewNode = new LNode2<>();
            NewNode.Element2 = newElement;
            NewNode.InList = new MyLinkedList<>();
            NewNode.link2 = head;
            head = NewNode;
            listssize++;
        }
        else
        {
            for (int i = 0; i < pos-1; i++)
            {
                Dummy = Dummy.link2;
            }
            LNode2<AnyType> NewNode = new LNode2<>();
            NewNode.Element2 = newElement;
            NewNode.InList = new MyLinkedList<>();
            NewNode.link2 = Dummy.link2;
            Dummy.link2 = NewNode;
            listssize++;
        }
    }
    public AnyType DeleteList(int pos) {
        AnyType DeletedNodeElement = null;
        LNode2<AnyType> Dummy; 
        if (pos == 0 && head != null){    // The First Element
            DeletedNodeElement = head.Element2;
            head = head.link2;  
            listssize--;
        }else{ 
            Dummy = head;
            for (int i = 0; i < pos-1; i++)
            {
                Dummy = Dummy.link2;
            }  
            DeletedNodeElement = (AnyType) Dummy.link2.Element2;
            Dummy.link2 = Dummy.link2.link2;
            listssize--;
        }
        return DeletedNodeElement;
    }
    public AnyType getListNodeData(int pos) {
        AnyType NodeElement;
        LNode2<AnyType> Dummy; 
        if (pos == 0 && head != null){    // The First Element
            NodeElement = head.Element2; 
        }else{
            Dummy = head;
            for (int i = 0; i < pos-1; i++)
            {
                Dummy = Dummy.link2;
            }
            NodeElement = (AnyType) Dummy.link2.Element2;
        }
        return NodeElement;
    }
    public int getInnersize(){
        return listssize;
    }
    public void InsertInner(AnyType newElement, int pos,MyLinkedList<AnyType> list) throws Exception{
        list.Insert(newElement, pos);
    }
    public AnyType DeleteInner(int pos,MyLinkedList<AnyType> list) throws Exception {
        AnyType DeletedNodeElement;
        DeletedNodeElement = list.Delete(pos);
        return DeletedNodeElement;
    }
    
    public int getInnersize(MyLinkedList<AnyType> list){
        int innersize = list.getsize();
        return innersize;
    }
    
    public String getInnerNodeData(int pos,MyLinkedList<AnyType> list) throws Exception{
        String NodeElement;
        NodeElement = list.getNodeData(pos);
        return NodeElement;
    }
}
