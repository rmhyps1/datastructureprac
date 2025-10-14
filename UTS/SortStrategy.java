package UTS;
import java.util.List;

public interface SortStrategy {
    void sort(List<String> data);
    String getName();
}
