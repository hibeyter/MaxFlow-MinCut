/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package havuzproblemi;

/**
 *
 * @author beyter
 */
public class x {
    
    private int parent;
    private int child;
    private int capacity;

    public x(int parent, int child, int capacity) {
        this.parent = parent;
        this.child = child;
        this.capacity = capacity;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    
}
