package com.leesin.chapter10.SeparateQueryfromModifier;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/24 10:09 上午
 */
public class Example {
    //原来的
    String foundMiscreant_original(String[] people){
        for (int i = 0; i < people.length; i++) {
            if (people[i].equals ("Don")){
                sendAlert(people);
                return "Don";
            }
            if (people[i].equals ("John")){
                sendAlert(people);
                return "John";
            }
        }
        return "";
    }

    void checkSecurity_original(String[] people) {
        // String found = foundMiscreant(people);
        // someLaterCode(found);
    }

    // TODO：①查询函数
    String foundPerson(String[] people){
        for (int i = 0; i < people.length; i++) {
            if (people[i].equals ("Don")){
                return "Don";
            }
            if (people[i].equals ("John")){
                return "John";
            }
        }
        return "";
    }

    // String foundMiscreant(String[] people){
    //     for (int i = 0; i < people.length; i++) {
    //         if (people[i].equals ("Don")){
    //             sendAlert(people);
    //             return foundPerson(people);
    //         }
    //         if (people[i].equals ("John")){
    //             sendAlert(people);
    //             return foundPerson(people);
    //         }
    //     }
    //     return foundPerson(people);
    // }

    // TODO：②只剩下修改函数，返回值变成void
    void foundMiscreant (String[] people){
        for (int i = 0; i < people.length; i++) {
            if (people[i].equals ("Don")){
                sendAlert(people);
                return;

            }
            if (people[i].equals ("John")){
                sendAlert(people);
                return;
            }
        }
    }
    // 略：foundMiscreant：可以更新为
    void sendAlert(String[] people){
        if (! foundPerson(people).equals("")) {
            sendAlert(people);
        }
    }

    // TODO：③变成调用 修改函数+查询函数
    void checkSecurity(String[] people) {
        foundMiscreant(people);
        String found = foundPerson(people);
        // someLaterCode(found);
    }
}

