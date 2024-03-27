package cscmatch;

import positionallist.LinkedPositionalList;
import positionallist.PositionalList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.Serializable;
import java.util.Iterator;

public class Membership implements Iterable<Member>, Serializable {

    private PositionalList<Member> mbrList;

    public Membership() {
        mbrList = new LinkedPositionalList<Member>();
    }

    public Member addMember(String name, int year) {
        Member memberObj = new Member(name, year);
        mbrList.addLast(memberObj);

        return memberObj;

    }

    public Iterator<Member> iterator() {
        return mbrList.iterator();
    }

    public String toString() {
        String result = "";
        for (Member mbr : mbrList) {
            result += mbr.getName() + "\n";
        }
        return result;
    }

    public Member findMember(String name) {
        for (Member mbr : mbrList) {
            if (mbr.getName().equalsIgnoreCase(name)) {
                return mbr;
            }
        }
        return null;
    }

    public void save(String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
        }

    }

    public static Membership load(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            Membership mbr = (Membership) ois.readObject();
            return mbr;
        }
    }

}
