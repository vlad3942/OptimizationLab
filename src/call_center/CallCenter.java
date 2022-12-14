package call_center;

import java.util.ArrayList;
import java.util.Random;

public class CallCenter implements Defendant {

    private final Defendant first;

    private final ArrayList<Defendant> defs;

    private final Queue callsQueue = new CallsQueue();

    private static final Random r = new Random();

    public CallCenter(int operatorsCount, int managersCount) {
        defs = new ArrayList<>();
        QueueDefendant queueDefendant = new QueueDefendant(this);
        Defendant tmp = new Director(queueDefendant, r.nextBoolean());
        defs.add(tmp);
        for (int i = 0; i < managersCount; i++) {
            tmp = new Manager(tmp, r.nextBoolean());
            defs.add(tmp);
        }
        for (int i = 0; i < operatorsCount; i++) {
            tmp = new Operator(tmp, r.nextBoolean());
            defs.add(tmp);
        }
        this.first = tmp;
    }

    @Override
    public void acceptCall(Call c) {
        if (callsQueue.size() > 0) {
            callsQueue.pushCall(c);
        } else {
            first.acceptCall(c);
        }
    }

    @Override
    public void notifyDefendant() {
        int i = r.nextInt(defs.size());
        defs.get(i).notifyDefendant();
        if (callsQueue.size() > 0) {
            Call call = callsQueue.popCall();
            first.acceptCall(call);
        }
    }

    static class QueueDefendant implements Defendant {
        private final CallCenter callCenter;
        QueueDefendant(CallCenter callCenter) {
            this.callCenter = callCenter;
        }
        @Override
        public void acceptCall(Call c) {
            callCenter.callsQueue.pushCall(c);
        }

        public void notifyDefendant() {
            //Всегда доступен. Добавляет звонки в очередь.
        }
    }
}
