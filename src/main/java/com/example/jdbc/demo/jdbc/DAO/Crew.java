package com.example.jdbc.demo.jdbc.DAO;

public class Crew {
    public enum Role{
        Director, Writer,Self,Cinematographer
        ,Composer,Editor, Actor, Producer,Actress
        , Production_designer,Archive_sound, Archive_footage
    }


    private String id;
    private String name_id;
    private String role;
    private int order;

    public Crew() {
    }


    public Crew( String id, String name_id, String role){

        this.id = id;
        this.name_id = name_id;
        this.role = role;

    }

    public Crew(String id, String order, String name_id, String role) {
        this.id = id;
        this.order = Integer.parseInt(order);
        this.name_id = name_id;
        this.role = role;

    }

    @Override
    public String toString() {
        return "Crew{" +
                "id='" + id + '\'' +
                ", name_id='" + name_id + '\'' +
                ", role='" + role + '\'' +
                ", order=" + order +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_id() {
        return name_id;
    }

    public void setName_id(String name_id) {
        this.name_id = name_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}

