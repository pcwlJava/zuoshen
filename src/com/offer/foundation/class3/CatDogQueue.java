package com.offer.foundation.class3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列问题
 */
public class CatDogQueue {

    public static class Pet{
        private String type;

        public Pet(String type){
            this.type = type;
        }

        public String getPetType(){
            return this.type;
        }
    }

    public static class Dog extends Pet{
        public Dog(){
            super("dog");
        }
    }

    public static class Cat extends Pet{
        public Cat(){
            super("cat");
        }
    }

    public static class CatDog{
        private Pet pet;     // 用于记录是猫还是狗
        private long count;  // 用于记录当前pet的顺序

        public CatDog(Pet pet, long count){
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet(){
            return this.pet;
        }

        public long getCount(){
            return this.count;
        }
    }

    // CatDogQueue 的正式代码
    private Queue<CatDog> catQueue = new LinkedList<CatDog>();   // 猫队列
    private Queue<CatDog> dogQueue = new LinkedList<CatDog>();   // 狗队列
    private long count = 0;

    // 增加元素
    public void add(Pet pet){
        if(pet.getPetType().equals("cat")){
            catQueue.add(new CatDog(pet, count++));
        }else if(pet.getPetType().equals("dog")){
            dogQueue.add(new CatDog(pet, count++));
        }else{
            throw new RuntimeException("error : this is not cat or dog type");
        }
    }

    // 弹出所有元素
    public Pet pollAll(){
        if(!catQueue.isEmpty() && !dogQueue.isEmpty()){
            if(catQueue.peek().count < dogQueue.peek().count){
                // 如果猫队列的第一个元素顺序在狗队列第一个元素之前，则弹出猫队列第一个元素
                return catQueue.poll().getPet();
            }else{
                return dogQueue.poll().getPet();
            }
        }else if(!catQueue.isEmpty()){
            return catQueue.poll().getPet();
        }else if(!dogQueue.isEmpty()){
            return dogQueue.poll().getPet();
        }else{
            throw new RuntimeException("error : queue is empty!");
        }
    }

    // 弹出狗猫列元素
    public Cat pollCat(){
        if(catQueue.isEmpty()){
            throw new RuntimeException("error : the cat queue is empty!");
        }else{
            return (Cat) catQueue.poll().getPet();
        }
    }

    // 弹出狗队列元素
    public Dog pollDog(){
        if(dogQueue.isEmpty()){
            throw new RuntimeException("error : the dog queue is empty!");
        }else{
            return (Dog) dogQueue.poll().getPet();
        }
    }

    public boolean isAllEmpty(){
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }

    public boolean isDogQueueEmpty(){
        return dogQueue.isEmpty();
    }

    public boolean isCatQueueEmpty(){
        return catQueue.isEmpty();
    }
}
