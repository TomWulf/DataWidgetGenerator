import java.util.Objects;

public class Product
{
    private String IDNum;
    private String name;
    private String descrip;
    private double cost;

    public Product(String IDNum, String name, String descrip, double cost) {
        this.IDNum = IDNum;
        this.name = name;
        this.descrip = descrip;
        this.cost = cost;
    }

    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toCSVDataString()
    {
        return IDNum + ", " + name  + ", " + descrip  + cost;
    }
    @Override
    public String toString() {
        return "Product{" +
                "IDNum='" + IDNum + '\'' +
                ", name='" + name + '\'' +
                ", descrip='" + descrip + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(cost, product.cost) == 0 && Objects.equals(IDNum, product.IDNum) && Objects.equals(name, product.name) && Objects.equals(descrip, product.descrip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDNum, name, descrip, cost);
    }
}
