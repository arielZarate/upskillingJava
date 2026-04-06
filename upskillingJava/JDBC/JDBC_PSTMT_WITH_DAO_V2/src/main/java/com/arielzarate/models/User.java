package com.arielzarate.models;

public class User {

        private int id;
        private String name;


    //constructor sin  parametros
    public User()
    {}

    public User( String name){
        this.name=name;
    }

        // Getters y Setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }




    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}



