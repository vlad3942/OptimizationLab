package call_center;

public class Caller {
    private String name;
    private String callResult;

    public Caller(String name) {
        this.name = name;
    }

    public void makeCall(Defendant accepter) {
        Call c = new CallersCall(this);
        accepter.acceptCall(c);
    }

    private void setCallResult(String callResult) {
        this.callResult = callResult;
    }

    public void printCallResult() {
        System.out.println(name + " received the following response:");
        System.out.println(this.callResult);
    }

    public static class CallersCall implements Call {

        private Caller caller;

        public CallersCall(Caller caller) {
            this.caller = caller;
        }

        public void accept(String byWhom) {
            caller.setCallResult("Call was accepted by " + byWhom + ".");
        }

        public void reject(String message) {
            caller.setCallResult(message);
        }
    }

}
