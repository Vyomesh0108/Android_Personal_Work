package com.example.avengercustomizedlistvew;

public class Avenger
{
    int image;
    String name,weapon;

    Avenger()
    {}

    Avenger(int img,String na ,String w)
    {
        image=img;
        name=na;
        weapon=w;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
}
