package com.company.destination;

public class StringDestination implements IDestination {

    private StringBuilder destination = new StringBuilder();

    public void write(String string) {
        this.destination.append(string);
    }

    public void write(char symbol) {
        this.destination.append(symbol);
    }

    public void close() {

    }

    @Override
    public String toString() {
        return this.destination.toString();
    }
}
