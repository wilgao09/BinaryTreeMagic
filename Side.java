public enum Side {
    LEFT,
    RIGHT,
    NOT,
    BOTH    
    ;



    public Side negate() {
        switch(this) {
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            case BOTH:
                return NOT;
            case NOT:
                return BOTH;
            default:
                return null;
        }
    }
}
