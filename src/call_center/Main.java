package call_center;

/*
2. Имеется центр обработки звонков с тремя уровнями сотрудников: оператор, менеджер и директор.
Входящий телефонный звонок адресуется свободному оператору.
Если оператор не может обработать звонок, он автоматически перенаправляется менеджеру.
Если менеджер занят, то звонок перенаправляется директору.
Разработайте классы и структуры данных для этой задачи.
Реализуйте метод dispatchCall(), который перенаправляет звонок первому свободному сотруднику.
*/

public class Main {
    public static void main(String[] args) {
        int operatorsCount = 1;
        int managersCount = 1;
        CallCenter callCenter = new CallCenter(operatorsCount, managersCount);

        Caller[] callers = new Caller[4];
        callers[0] = new Caller("Ivan");
        callers[0].makeCall(callCenter);
        callers[1] = new Caller("Maxim");
        callers[1].makeCall(callCenter);
        callers[2] = new Caller("Andrew");
        callers[2].makeCall(callCenter);
        callers[3] = new Caller("Vladimir");
        callers[3].makeCall(callCenter);

        System.out.println("<----Results before notify--->");
        for (int i = 0; i < 4; i++) {
            callers[i].printCallResult();
        }

        callCenter.notifyDefendant();
        callCenter.notifyDefendant();

        System.out.println("<----Results after notify--->");
        for (int i = 0; i < 4; i++) {
            callers[i].printCallResult();
        }
    }
}
