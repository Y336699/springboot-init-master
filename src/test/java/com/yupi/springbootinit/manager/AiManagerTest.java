package com.yupi.springbootinit.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.*;

@SpringBootTest
class AiManagerTest {

    @Resource
    private AiManager aiManager;
    @Test
    void doChat() {
        //String answer = aiManager.doChat("你好");
       //System.out.println(answer);
    }

    public static void main(String[] args) {
        /*String goal = "test";
        String newGoal = goal;
        if (StringUtils.isNotBlank(newGoal)) {
            newGoal += "this is a";
        }
        System.out.println(newGoal);*/
        /*flyInpm(()-> System.out.println("fly"));
        Sum sum = (a,b) ->  a+b  ;
        sum.sum(10,20);
        Fly fly = () -> System.out.println("I can fly");
        fly.fly();
        Fly1 fly0 = (name1,name2) -> {return name1 + "和" +  name2 + "都会飞";};
        Fly1 fly1 =(name1,name2) -> name1 + "和" + name2 + "都会飞";
        System.out.println(fly0.fly("aa","bb"));
        System.out.println(fly1.fly("cc","dd"));*/
        /*ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.forEach(s -> System.out.println(s));*/
       /* HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1,"a");
        hashMap.put(2,"b");
        hashMap.put(3,"c");
        System.out.println(hashMap);
        System.out.println(hashMap.entrySet());
        System.out.println(hashMap.values());
        for(Map.Entry<Integer,String> entry :hashMap.entrySet()){
            System.out.println(entry.getKey()+entry.getValue());
        }
        Iterator ite = hashMap.entrySet().iterator();
        while (ite.hasNext()){
            System.out.println(ite.next());
        }
        List<String> strings = new ArrayList<String>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        Iterator<String> strings1 = strings.iterator();
        while (strings1.hasNext()){
            System.out.println(strings1.next());
        }
*/
        int[] list= new int[]{2,5,1,3,6,4,9,7,8,11,10,13,12};
/*
        for ( int j =0 ;j<list.length-1;j++){
         for( int i =0 ;i<list.length-1-j;i++){
            if(list[i]>list[i+1]){
                int c =list[i];
                list[i]=list[i+1];
                list[i+1]=c;
            }
        }
        }*/
       /* for(int i =0;i<list.length-1;i++){
            int mid =i;
            for(int j=i+1;j<list.length;j++){
                if(list[j]<list[mid]){
                    mid =j;
                }
                if(mid != i){
                    int temp =list[i];
                    list[i] =list[mid];
                    list[mid] =temp;
                }
            }
        }*/
        for (int i =1;i<list.length;i++){
            int temp = list[i];
            int j=i-1;
            for (;j>=0;j--){
                if (list[j]>temp){
                    list[j+1] =list[j];
                }else break;
            }
            list[j+1] = temp;
        }
        for (int a:list
             ) {
            System.out.println(a);
        }
    }
    public static void run(){
       Fly run ;
    }
    public static void flyInpm(Fly a){
       a.fly();
    }
    @FunctionalInterface
    public interface Fly{
        abstract void fly();
    }
    @FunctionalInterface
    public interface Sum {
        public abstract int sum(int a ,int b);
    }
    @FunctionalInterface
    public interface Fly1{

        String fly(String name1,String name2);

    }
    /*public static String D(String[] employee1 , String[] employee2){
        return Collections.sort(employee1,);
    }*/

}