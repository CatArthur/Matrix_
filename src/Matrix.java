public class Matrix {
    int[][] a;
    int n;
    int m;
    Matrix(int[][] a){
        this.n=a.length;
        this.m=a[0].length;
        this.a=new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.a[i][j]=a[i][j];
            }
        }
    }
    Matrix(){
        this.n=1;
        this.m=1;
        this.a=new int[1][1];
        this.a[0][0]=0;
    }
    Matrix(int n){
        this.n=n;
        this.m=n;
        this.a=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.a[i][j]=0;
            }
        }
    }
    Matrix(int n,int m){
        this.n=n;
        this.m=m;
        this.a=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.a[i][j]=0;
            }
        }
    }
    String toStr(){
        String key="Matrix=\n[";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                key+=this.a[i][j]+" ";
            }
            key+="\n";
        }
        return key+"]";
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
    
}
