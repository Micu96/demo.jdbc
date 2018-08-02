package com.example.jdbc.demo.jdbc.DAO;

public class Name {

    private String name_id;
    private String primaryName;
    private String birthYear;
    private String deathYear;

    public Name() {
    }

    public Name(String[] splited) {
        this.name_id = splited[0];
        this.primaryName = splited[1];
        this.birthYear = splited[2];
        this.deathYear = splited[3];
    }

    public String getName_id() {
        return name_id;
    }

    public void setName_id(String name_id) {
        this.name_id = name_id;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(String deathYear) {
        this.deathYear = deathYear;
    }

    @Override
    public String toString() {
        return "Name{" +
                "name_id='" + name_id + '\'' +
                ", primaryName='" + primaryName + '\'' +
                ", birthYear=" + birthYear +
                ", deathYear=" + deathYear +
                '}';
    }
}
