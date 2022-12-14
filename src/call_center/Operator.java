package call_center;

public class Operator implements Defendant {

    private final Defendant next;
    private boolean isFree;

    public Operator(Defendant next, boolean isFree) {
        this.next = next;
        this.isFree = isFree;
    }

    @Override
    public void acceptCall(Call c) {
        if (this.isFree) {
            this.isFree = false;    //Имитация занятости оператора.
            c.accept("Operator");
        } else {
            if (next != null) {
                next.acceptCall(c);
            } else {
                c.reject("System error, please call back later.");
            }
        }
    }

    @Override
    public void notifyDefendant() {
        this.isFree = true;
    }
}
