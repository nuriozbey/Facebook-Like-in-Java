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

public class MyLinkedList<AnyType> extends Person<AnyType> {
    private Person<AnyType> first;
    private int listsize;
    public void LinkedList(){
        first = null; 
        listsize = 0;
    }
    
    public void Insert(AnyType newElement, int pos) throws Exception{
        if (pos < 0)
            throw ArrayIndexOutOfBoundsException();
        Person<AnyType> Dummy;
        Dummy = first;
        if (pos == 0) // Add to the first location
        {
            Person<AnyType> NewNode = new Person<>();
            NewNode.Name = newElement;
            NewNode.next = first;
            first = NewNode;
            listsize++;
        }
        else
        {
            for (int i = 0; i < pos-1; i++)
            {
                  Dummy = Dummy.next;
            }
            Person<AnyType> NewNode = new Person<>();
            NewNode.Name = newElement;
            NewNode.next = Dummy.next;
            Dummy.next = NewNode;
            listsize++;
        }
    }
    public AnyType Delete(int pos) throws Exception {
        AnyType DeletedNodeElement;
        if (pos < 0)
            throw ArrayIndexOutOfBoundsException();
        Person<AnyType> Dummy; 
        if (pos == 0 && first != null){    // The First Element
            DeletedNodeElement = first.Name;
            first = first.next;  
            listsize--;
        }else{ 
            Dummy = first;
            for (int i = 0; i < pos-1; i++)
            {
                Dummy = Dummy.next;
                if (pos > 0 && Dummy == null)
                    throw ArrayIndexOutOfBoundsException();
                }
            DeletedNodeElement = (AnyType) Dummy.next.Name;
            Dummy.next = Dummy.next.next;
            listsize--;
        }
        return DeletedNodeElement;
    }
    
    public int getsize(){
        return listsize;
    }
    
    public String getNodeData(int pos) throws Exception{
        String NodeElement;
        if (pos < 0)
            throw ArrayIndexOutOfBoundsException();
        Person<AnyType> Dummy; 
        if (pos == 0 && first != null){    // The First Element
            NodeElement = (String)first.Name; 
        }else{
            Dummy = first;
            for (int i = 0; i < pos-1; i++)
            {
                Dummy = Dummy.next;
                if (pos > 0 && Dummy == null)
                    throw ArrayIndexOutOfBoundsException();
                }
                NodeElement = (String) Dummy.next.Name;
        }
        return NodeElement;
    }
    
    public void Output(){
        Person<AnyType> Dummy;
        Dummy = first;
        //System.out.print("The Elements in the list are : ");
        if(Dummy == null)
            System.out.print("Person has No friend");
        while (Dummy != null){
            System.out.print(Dummy.Name + " " );
            Dummy = Dummy.next;
        }
        System.out.println("");
        
    }
    
    
    private Exception ArrayIndexOutOfBoundsException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
