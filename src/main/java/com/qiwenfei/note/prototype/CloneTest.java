package com.qiwenfei.note.prototype;

/**
 * 2018-05-20
 * sunshine
 */
public class CloneTest {

    public static void main(String[] args) {

        SheepA  sheepA = new SheepA();
        SheepA  clone = null ;
        try {
              clone = (SheepA)sheepA.deepClone();
            System.out.println(sheepA);
            System.out.println(clone);
            System.out.println(sheepA==clone);
            System.out.println(sheepA.getHeight());
            System.out.println(clone.getHeight());
            System.out.println(sheepA.getSex());
            System.out.println(clone.getSex());
            System.out.println(clone.getSex()==sheepA.getSex());
            sheepA.setHeight(10.0);
            System.out.println(clone.getHeight());
            System.out.println(clone.getSex().getSex());
            sheepA.setSex(new Sex("母"));
            System.out.println(clone.getSex().getSex());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
}
