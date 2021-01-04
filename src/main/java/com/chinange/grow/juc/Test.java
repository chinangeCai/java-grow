package com.chinange.grow.juc;

public class Test {
    public static void main(String[] args) {
        /*String[] strs = new String[] {"yang","guo","bao"};
        List<String> strings = Arrays.asList(strs);
        //strings.add("hello");
        System.out.println(strings);
        strs[0] = "haha";
        System.out.println(strings);*/
//        List<String> list = new ArrayList<>();
//        list.add("2");
//        list.add("2");
//        Iterator<String> iterator = list.iterator();
//        while(iterator.hasNext()){
//            String next = iterator.next();
//            System.out.println(next);
//            iterator.remove();
//        }
        //AbstractDemo.sayHi("haha");
        /*String s = UUID.randomUUID().toString().replace("-","");
        System.out.println(s);*/

       /* DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String format = dtf.format(LocalDateTime.now());
        System.out.println(format);*/




    }

    private static  boolean isEvenNumber(int a){
        //if(a<0) return (a & 1) == 1;
        return (a & 1) == 0;
    }
}
