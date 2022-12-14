package call_center;

public interface Queue {
    void pushCall(Call c);
    Call popCall();
    int size();
}
