package com.aps.hamburgueriamaluca.model;

public class Position {
    Player player;

    public boolean hasOwn() { return player !=null; }

    public Player getPlayerInPosition() { return player; }

    public void removeOwner() { player = null; }

    public void setOwner(Player owner) { player = owner; }

}
