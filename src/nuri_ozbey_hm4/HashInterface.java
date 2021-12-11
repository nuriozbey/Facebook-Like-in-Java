/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuri_ozbey_hm4;

/**
 *
 * @author nurio
 */
public interface HashInterface {
    public String Insert(String fName);                            //O(1)
    public void Friend(String fName,String sName);                 //O(1)
    public void DeleteFriendship(String fName,String sName);       //O(n)
    public void Erase(String fName);                             //O(n)
    public void List(String fName);                                //O(n)
    public boolean ScheckF(String fName,String sName);             //O(1)
    public void Ofriends(String fName);                            //O(n)
}
