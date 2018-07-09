package com.example.jdbc.demo.jdbc.DAO;

public class Crew {
    public enum Role{
        director, writer,self,cinematographer
        ,composer,editor, actor, producer,actress
        , production_designer,archive_sound, archive_footage
    }


    private String id;
    private String name_id;
    private Role role;
    private int order;

    public Crew() {
    }


    public Crew( String id, String name_id, Role role){

        this.id = id;
        this.name_id = name_id;
        this.role = role;

    }

    public Crew(String id, String order, String name_id, Role role) {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}

