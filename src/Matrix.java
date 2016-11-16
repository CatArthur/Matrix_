public class Matrix {
    double[][] a;
    int n;
    int m;
    public static final int nl = 3;
    Matrix(double[][] a){
        this.n=a.length;
        this.m=a[0].length;
        this.a=new double[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.a[i][j]=a[i][j];
            }
        }
    }
    Matrix(){
        this.n=1;
        this.m=1;
        this.a=new double[1][1];
        this.a[0][0]=0;
    }
    Matrix(int n){
        this.n=n;
        this.m=n;
        this.a=new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.a[i][j]=0;
            }
        }
    }
    Matrix(int n,int m){
        this.n=n;
        this.m=m;
        this.a=new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.a[i][j]=0;
            }
        }
    }
    String toStr(){
        String key="Matrix=\n[\n";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                key+=this.a[i][j]+" ";
            }
            key+="\n";
        }
        return key+"]";
    }
    void print(){
        System.out.print("Matrix=\n[\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String b=a[i][j]+" ";
                System.out.print(b+"\t");
            }
            System.out.print("\n");
        }
        System.out.println("]");
    }
    void printf(){
        System.out.print("Matrix=\n[\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%5.1f",a[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");
        }
        System.out.println("]");
    }
    Matrix sum(Matrix v){
        if(m==v.m&&n==v.n) {
            Matrix f = new Matrix(n, m);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    f.a[i][j] = v.a[i][j] + a[i][j];
                }
            }
            return f;
        }
        else{
            System.out.println("Error!");
            return new Matrix();
        }
    }
    Matrix mult(int v){
        Matrix f= new Matrix(a);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                f.a[i][j]=a[i][j]*v;
            }
        }
        return f;
    }
    Matrix mult(Matrix v){
        if(m==v.n) {
            Matrix f = new Matrix(n,v.m);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < v.m; j++) {
                    for (int k = 0; k < m; k++) {
                        f.a[i][j] += a[i][k] * v.a[k][j];
                    }
                }
            }
            return f;
        }
        else {
            System.out.println("Error!");
            return new Matrix();
        }
    }
    Matrix dim(int i,int j){
        Matrix f=new Matrix(n-1,m-1);
        for (int k = 0; k < i-1; k++) {
            for (int l = 0; l < j-1; l++) {
                f.a[k][l]=a[k][l];
            }
            for (int l = j; l < m; l++) {
                f.a[k][l-1]=a[k][l];
            }
        }
        for (int k = i; k < n; k++) {
            for (int l = 0; l < j-1; l++) {
                f.a[k-1][l]=a[k][l];
            }
            for (int l = j; l < m; l++) {
                f.a[k-1][l-1]=a[k][l];
            }
        }
        return f;
    }
    double det(){
        double d=0;
        if(m==n) {
            if(n==1)
                d=a[0][0];
            if(n==2)
                d=d+a[0][0]*a[1][1]-a[0][1]*a[1][0];
            else
                for (int i = 1; i <= n; i++) {
                    double d1=this.dim(1,i).det();
                    d=d+d1*a[0][i-1]*(int)(Math.pow(-1,i+1));
                }
        }
        else
            System.out.println("Error!");
        return d;
    }
    Matrix inv(){
        Matrix f=new Matrix();
        if(m!=n||this.det()==0){
            System.out.println("Error!");
        }
        else
        {
            f=new Matrix(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    f.a[i][j]=1/a[i][j];
                }
            }
        }
        return f;
    }
    public static Matrix  getNullMatrix(int n,int m){
        return new Matrix(n,m);
    }
    public static Matrix  getIndentMatrix(int N){
        Matrix f=new Matrix(N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                f.a[i][j]=1;
            }
        }
        return f;
    }
    public static Matrix getIndentMatrix(){
        return getIndentMatrix(nl);

    }
}