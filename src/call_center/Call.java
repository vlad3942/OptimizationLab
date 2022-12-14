package call_center;

public interface Call {

    void accept(String byWhom);
    void reject(String message);
}
