package org.example;

import java.util.ArrayList;

class Movie extends TVShow {

    private int length;
    public void setLength(int newLength) {
        length = newLength;
    }
    public int getLength() {
        return length;
    }

    public Movie()
    {
        super();
    }
}
