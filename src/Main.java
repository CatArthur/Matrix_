public class Main {
    public static void main(String[] args) {
        double[][] a={ {0.25,0.2},
                {5,2}};
        Matrix m=new Matrix(a);
        m.print();
        m.getIndentMatrix().print();
    }
}
