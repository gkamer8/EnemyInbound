// 
// Decompiled by Procyon v0.5.36
// 

public class Player
{
    private int width;
    private int height;
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int speed;
    private int health;
    
    public Player() {
        this.width = 30;
        this.height = 30;
        this.x = 400;
        this.y = 500;
        this.dx = 0;
        this.dy = 0;
        this.speed = 4;
        this.health = 200;
    }
    
    public void setX(final int nx) {
        this.x = nx;
    }
    
    public int getX() {
        return this.x;
    }
    
    public void setY(final int nx) {
        this.y = nx;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setWidth(final int nx) {
        this.width = nx;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public void setHeight(final int nx) {
        this.height = nx;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public void setDx(final int nx) {
        this.dx = nx;
    }
    
    public int getDx() {
        return this.dx;
    }
    
    public void setDy(final int nx) {
        this.dy = nx;
    }
    
    public int getDy() {
        return this.dy;
    }
    
    public void setSpeed(final int nx) {
        this.speed = nx;
    }
    
    public int getSpeed() {
        return this.speed;
    }
    
    public void setHealth(final int nx) {
        this.health = nx;
    }
    
    public int getHealth() {
        return this.health;
    }
}
