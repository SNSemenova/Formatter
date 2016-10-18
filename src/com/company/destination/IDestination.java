package com.company.destination;

public interface IDestination {
    void write(String string);
    void write(char symbol);
    void close();
}
