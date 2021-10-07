package com.example.parcial1_client.model;


import processing.core.PApplet;

public class Particle {
    private float posX,posY,dirX,dirY;
    private int size,spd,r,g,b;
    PApplet app;

    public Particle(float posX, float posY, int r, int g, int b,PApplet app) {
        this.posX = posX;
        this.posY = posY;
        this.dirX = 0;
        this.dirY = 0;
        this.size = 20;
        this.spd = 1;
        this.r = r;
        this.g = g;
        this.b = b;
        this.app = app;
    }

    public Particle() {
    }
    public void draw(){
        app.fill(r,g,b);
        app.ellipse(posX,posY,size,size);
    }
    public void randomDir(float rndX, float rndY){
        //Diferencia entre vectores
        dirX=rndX-this.posX;
        dirY=rndY-this.posY;
        //Normalizar el vector para que valga 1 o -1
        float dist = (float) Math.sqrt(dirX * dirX + dirY * dirY);
        if(dist != 0.0) {
            dirX /= dist;
            dirY /= dist;
        }


    }
    public void move(){
        posX+=dirX*spd;
        posY+=dirY*spd;
        if(posX>app.width||0>posX) {
            dirX=-dirX;
        }
        if(posY>app.height||0>posY) {
            dirY=-dirY;
        }
    }


    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public float getDirX() {
        return dirX;
    }

    public void setDirX(float dirX) {
        this.dirX = dirX;
    }

    public float getDirY() {
        return dirY;
    }

    public void setDirY(float dirY) {
        this.dirY = dirY;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
}