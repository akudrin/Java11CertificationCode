import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctMethod {
    public static void main(String[] args) {

        List<Data> dataList = new ArrayList<>();
        dataList.add(new Data(10));
        dataList.add(new Data(20));
        dataList.add(new Data(10));
        dataList.add(new Data(20));

        System.out.println("Data List = " + dataList);
        List<Data> uniqueDataList = dataList.stream().distinct().collect(Collectors.toList());
        System.out.println("Unique Data List = " + uniqueDataList);
        /*
         * The distinct() method didn’t remove the duplicate elements. It’s because the
         * equals() method was not implemented in the Data class. The Object class
         * equals() method implementation is public boolean equals(Object obj) { return
         * (this == obj); }
         */

    }

}

class Data {
    private int id;

    Data(int i) {
        this.setId(i);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Data[%d]", this.id);
    }

    /*
     * both equals() and hashCode() methods are used by Collection classes API to
     * check if two objects are equal or not. So it’s better to provide an
     * implementation for both of them.
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Data equals method");
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Data other = (Data) obj;
        if (id != other.id)
            return false;
        return true;
    }

}