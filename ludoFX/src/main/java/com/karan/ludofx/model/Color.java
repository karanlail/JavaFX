package com.karan.ludofx.model;

public enum Color {
    GREEN(0,50),
    BLUE(13,11),
    YELLOW(26,24),
    RED(39,37);
    private final int start;
    private final int end;
    Color(int start, int end) {
        this.start=start;
        this.end=end;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public static Color colorToBoardPositioning (int i){
        if(i>4 || i<1) throw new IllegalArgumentException();
        if(i==1) return Color.GREEN;
        if (i==2) return Color.YELLOW;
        if (i==3) return Color.RED;
        return Color.BLUE;
    }
}
