
package com.jalinet.grupo11.resultados;


public class DescriptionAmount {
    private int completed ;
    private int cancelled;

    public DescriptionAmount(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }
    
    

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
    
}
