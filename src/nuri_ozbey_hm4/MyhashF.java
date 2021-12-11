/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuri_ozbey_hm4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nurio
 */
public class MyhashF extends MyListOfLists implements HashInterface{
    private final MyListOfLists[] Myhasharr;
    private final int hashsize;
    public MyhashF() {
        hashsize = 997;
        Myhasharr = new MyListOfLists[hashsize];
        for (int i = 0; i < Myhasharr.length; i++) {
            Myhasharr[i] = new MyListOfLists();
        }
        
    }
    @Override
    public String Insert(String fName) {
        int hashkey = getHashKey(fName, hashsize);
        //myHashArr[hashkey];
        int innersize = Myhasharr[hashkey].getInnersize();
        Myhasharr[hashkey].InsertList(fName, innersize);
        //myHashArr[hashkey].InsertList("ali", 0);
        return fName;
    }
    
    @Override
    public void Friend(String fName, String sName) {
        if(FindPerson(fName)){
            if(FindPerson(sName)){
                try {
                    LNode2 asd = Myhasharr[getHashKey(fName, hashsize)].getNode();
                    //System.out.println("l Node:: " +asd.Element2);
                    addfriend(asd,fName,sName);
                    //Myhasharr[getHashKey(fName, hashsize)].Element2;
                } catch (Exception ex) {
                    Logger.getLogger(MyhashF.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    LNode2 asd = Myhasharr[getHashKey(sName, hashsize)].getNode();
                    //System.out.println("l Node:: " +asd.Element2);
                    addfriend(asd,sName,fName);
                    //Myhasharr[getHashKey(fName, hashsize)].Element2;
                } catch (Exception ex) {
                    Logger.getLogger(MyhashF.class.getName()).log(Level.SEVERE, null, ex);
                }
                String name1 = fName+"@"+sName;
                Insert(name1);
                name1 = sName+"@"+fName;
                Insert(name1);
            }else{
                System.out.println("[ERROR] "+fName+" Not found..!");
            }
        }else{
            System.out.println("[ERROR] "+fName+" Not found..!");
        }    
    }

    @Override
    public void DeleteFriendship(String fName, String sName) {
        if(FindPerson(fName)){
            if(FindPerson(sName)){
                try {
                    LNode2 asd = Myhasharr[getHashKey(fName, hashsize)].getNode();
                    //System.out.println("l Node:: " +asd.Element2);
                    
                    deletefriend(asd,fName,sName,0);
                } catch (Exception ex) {
                    Logger.getLogger(MyhashF.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    LNode2 asd = Myhasharr[getHashKey(sName, hashsize)].getNode();
                    //System.out.println("l Node:: " +asd.Element2);
                    deletefriend(asd,sName,fName,0);
                    //Myhasharr[getHashKey(fName, hashsize)].Element2;
                } catch (Exception ex) {
                    Logger.getLogger(MyhashF.class.getName()).log(Level.SEVERE, null, ex);
                }
                String name1 = fName+"@"+sName;
                Erase(name1);
                name1 = sName+"@"+fName;
                Erase(name1);
            }else{
                System.out.println("[ERROR] "+fName+" Not found..!");
            }
        }else{
            System.out.println("[ERROR] "+fName+" Not found..!");
        }
    
    }

    @Override
    public void Erase(String fName) {
      if(FindPerson(fName)){
            LNode2 asd = Myhasharr[getHashKey(fName, hashsize)].getNode();
            ErasePerson(asd,fName);
        }  
    }

    @Override
    public void List(String fName) {
        if(FindPerson(fName)){
            LNode2 asd = Myhasharr[getHashKey(fName, hashsize)].getNode();
            listFriends(asd,fName);
        }else{
            System.out.println("[ERROR] "+fName+" Not found..!");
        }
    }

    @Override
    public boolean ScheckF(String fName, String sName) {
        String temp= fName+"@"+sName;
        if(FindPerson(fName)){
            if(FindPerson(sName)){
            }else{
                System.out.println("[ERROR] "+sName+" Not found..!");
            }
        }else{
            System.out.println("[ERROR] "+fName+" Not found..!");
        }
        
        //int size = getHashKey(temp, hashsize);
        //String temp2 = (String) Myhasharr[size].Element2;
        return FindPerson(temp);
    }

    @Override
    public void Ofriends(String fName) {
        if(FindPerson(fName)){
            LNode2 asd = Myhasharr[getHashKey(fName, hashsize)].getNode();
            outFriends(asd,fName);
        }
    }
    public boolean FindPerson(String fName){
        LNode2 Dummy ;
        
        Dummy = Myhasharr[getHashKey(fName, hashsize)].getNode();
        if(null == Dummy){
            return false;
        }else{
            while(null != Dummy){
                if(fName.equals(Dummy.Element2)){
                    return true;
                }
                Dummy = Dummy.link2;
            }
        }
        return false;
    }
    public int getHashKey(String StringIn,int hashlength) {
        int num = 1;
        boolean toggle = false;
        for (int i = 0; i < StringIn.length(); i++) {
            if(toggle == false){
                num = (((int)StringIn.charAt(i))*num) % hashlength;
                toggle = true;
            }else{
                num = (((int)StringIn.charAt(i))+num) % hashlength;
                toggle = false;
            }
            //System.out.println(num);
        }
        //num = ((num)+((int)StringIn.charAt(0))) % hashlength;
        num = ((num)*((int)StringIn.charAt(0))) % hashlength;
        num = ((num*(StringIn.length()))+StringIn.length()) % hashlength;
        //System.out.println(num);
        return num;
    }
    public int addfriend(LNode2 mynode,String fName,String sName) throws Exception {
        if(fName.equals(mynode.Element2)){
            int size = mynode.InList.getsize();
            mynode.InList.Insert(sName, size);
            return 1;
        }else{
            addfriend(mynode.link2,fName,sName);

            return 0;
        }
    }
    public int deletefriend(LNode2 mynode,String fName,String sName,int pos) throws Exception {
        if(fName.equals(mynode.Element2)){
            //DeleteInner(pos, mynode.InList);
            DeleteInlist(mynode.InList,sName,0);
            //mynode.InList.Delete(pos);
            return 1;
        }else{
            LNode2 innode = mynode.link2;
            deletefriend(innode,fName,sName,pos++);
            return 0;
        }
    }
    public void DeleteInlist(MyLinkedList list,String dName,int pos){
        
        int size = list.getsize();
        int delpos = 0;
        for (int i = 0; i < size; i++) {
            try {
                if(dName.equals(list.getNodeData(i))){
                    delpos = i;
                }
            } catch (Exception ex) {
                Logger.getLogger(MyhashF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            list.Delete(delpos);
        } catch (Exception ex) {
            Logger.getLogger(MyhashF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int listFriends(LNode2 mynode,String fName)  {
        if(fName.equals(mynode.Element2)){
            LNode2 ret = Myhasharr[getHashKey(fName, hashsize)].getNode();
            //ret.InList.Output();
            int size = ret.InList.getsize();
            if(size == 0){
                System.out.println(fName+" has no friend..!");
            }
            for (int i = 0; i < size; i++) {
                String geri = "";
                try {
                     geri = ret.InList.getNodeData(i);
                } catch (Exception ex) {
                    Logger.getLogger(MyhashF.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(geri+" ");
            }
            return 1;
        }else{
            listFriends(mynode.link2,fName);
            return 0;
        }
    }
    public int outFriends(LNode2 mynode,String fName)  {
        if(fName.equals(mynode.Element2)){
            LNode2 ret = Myhasharr[getHashKey(fName, hashsize)].getNode();
            int size = ret.InList.getsize();
            for (int i = 0; i < size; i++) {
                try {
                    String arki = ret.InList.getNodeData(i);
                    LNode2 arkiark = Myhasharr[getHashKey(arki, hashsize)].getNode();
                    int innersize = arkiark.InList.getsize();
                    if(innersize > 1 ){
                        System.out.println(arki);
                        for (int j = 0; j < innersize; j++) {
                            String arkininarki = arkiark.InList.getNodeData(j);
                            if(!ScheckF(fName,arkininarki)){
                                //System.out.println("True They are Friends Already");
                                if (!(fName.equals(arkininarki))) {
                                    System.out.print("*");
                                    System.out.println(arkininarki);   
                                }    
                            }
                        }
                    }
                    
                } catch (Exception ex) {
                    Logger.getLogger(MyhashF.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //ret.InList.Output();
            return 1;
        }else{
            outFriends(mynode.link2,fName);
            return 0;
        }
    }
    public int ErasePerson(LNode2 mynode,String fName)  {
        if(fName.equals(mynode.Element2)){
            LNode2 ret = Myhasharr[getHashKey(fName, hashsize)].getNode();
            int listsize = ret.InList.getsize();
            MyListOfLists blank = new MyListOfLists();
            if(listsize == 0){
                Myhasharr[getHashKey(fName, hashsize)] = blank;
            }else{
                for (int i = 0; i < listsize; i++) {
                    try {
                        //Person temp = new Person();
                        String temp = ret.InList.getNodeData(0);
                        DeleteFriendship(temp, fName);
//                        if(temp == null){
//                            Myhasharr[getHashKey(fName, hashsize)] = blank;
//                        }
                    } catch (Exception ex) {
                        Logger.getLogger(MyhashF.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                Myhasharr[getHashKey(fName, hashsize)] = blank;
            }
            return 1;
        }else{
            ErasePerson(mynode.link2,fName);
            return 0;
        }
    }


}
