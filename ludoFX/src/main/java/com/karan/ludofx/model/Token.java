package com.karan.ludofx.model;
public class Token {
    static final int SQUARES_MAX=51;
    private final Color color;
    private int position;
    private TokenState tokenState;
    private final int id;

    public Token(Color color, int id) {
        this.color = color;
        this.id=id;
        this.tokenState=TokenState.BASE;
    }

    public Color getColor() {
        return color;
    }

    public TokenState getTokenState() {
        return tokenState;
    }

    public void setTokenState(TokenState tokenState) {
        this.tokenState = tokenState;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void activate(){
        setTokenState(TokenState.ACTIVE);
        setPosition(getColor().getStart());
    }

    public void stepForward(){
        setPosition(getPosition()+1);
    }

    public void move (int steps) {
        if(isBase() && steps==6){
            activate();
            return;
        }
        if (isBase() || isFinished()){
            throw new IllegalStateException();
        }
        for (int i = 0; i < steps; i++) {
            /*handle a circular motion*/
            if(getPosition() == SQUARES_MAX && isActive()){
                setPosition(0);
            } else stepForward();

            if(getPosition() == getColor().getEnd()) {
                setPosition(101);
                setTokenState(TokenState.HOME);
            }
            /*how to act if on home run*/
            if(isHome()){
                if(getPosition()==106){
                    setTokenState(TokenState.FINISHED);
                }
            }
        }
    }

    public boolean isFinished(){
        return getTokenState()==TokenState.FINISHED;
    }

    public boolean isBase(){
        return getTokenState()==TokenState.BASE;
    }

    public boolean isActive(){
        return getTokenState()==TokenState.ACTIVE;
    }

    public boolean isHome(){
        return getTokenState()==TokenState.HOME;
    }

    public boolean movable(int steps) {
        if (isFinished()) return false;
        else if (isBase()) return steps == 6;
        else if (isHome()) return (position + steps) <= 106;
        else return true;
    }

    public void captured(){
        setTokenState(TokenState.BASE);
        setPosition(-1);
    }

    @Override
    public String toString() {
        return "Token{" +
                "color=" + color +
                ", position=" + position +
                ", tokenState=" + tokenState +
                ", id=" + id +
                '}';
    }
}
