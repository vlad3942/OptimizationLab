package call_center;

import java.util.ArrayList;

public class CallsQueue implements Queue {
    private final ArrayList<Call> calls = new ArrayList<>();

    @Override
    public void pushCall(Call c) {
        calls.add(c);
        c.reject("Your position in the queue: " + size());
    }

    @Override
    public Call popCall() {
        if (calls.size() > 0) {
            Call c = calls.get(0);
            calls.remove(0);
            for (int i = 0; i < calls.size(); i++) {
                calls.get(i).reject("Your position in the queue: " + (i + 1));
            }
            return c;
        }
        return null;
    }

    @Override
    public int size() {
        return calls.size();
    }
}
