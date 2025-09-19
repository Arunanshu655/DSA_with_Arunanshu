// Topics: Design, String, Matrix

class Spreadsheet {
    private int n;
    private int[][] sheet;
    public Spreadsheet(int rows) {
        sheet = new int[26][rows+1];
    }
    
    public void setCell(String cell, int value) {
        int x = cell.charAt(0) - 'A';
        int num = 0,i=1, m = cell.length();
           while(i<m){
                num = num * 10 + (int) (cell.charAt(i++)-'0');
                // System.out.println(num);
           }
        int y = num;
        sheet[x][y] = value;
    }
    
    public void resetCell(String cell) {
        int x = cell.charAt(0) - 'A';
        int num = 0,i=1, m = cell.length();
           while(i<m){
                num = num * 10 + (int) (cell.charAt(i++)-'0');
                // System.out.println(num);
           }
        int y = num;
        sheet[x][y] = 0;
    }
    
    public int eval(int a, int b, char op){
        switch(op){
            case '+':
               return (a+b);
            case '-':
               return (a-b);
            case '*':
               return (a*b);
            case '/':
               return (a/b);
        }
        return 0;
    }
    public int getValue(String formula) {
        int val1 , val2, i = 1, m = formula.length();
        // System.out.println(Character.isDigit(formula.charAt(i)));
        if(Character.isDigit(formula.charAt(i))){
            int num = 0;
           while(formula.charAt(i) != '+'){
                num = num * 10 + (int) (formula.charAt(i++)-'0');
                // System.out.println("for val 1 " + num);
           }
           val1 = num;
        }else{
            int x1 = formula.charAt(i++) - 'A';
            int num = 0;
           while(formula.charAt(i) != '+'){
                num = num * 10 + (int) (formula.charAt(i++)-'0');
                // System.out.println("for val 1 " + num);
           }
            int y1 = num;
            val1 = sheet[x1][y1];
        }
        int op = i++;
        if(Character.isDigit(formula.charAt(i)) || formula.charAt(i) == '0'){
            int num = 0;
           while(i<m){
                num = num * 10 + (int) (formula.charAt(i++)-'0');
                // System.out.println(num);
           }
           val2 = num;
        }else{
            int x2 = formula.charAt(i++) - 'A';
            int num = 0;
           while(i<m){
                num = num * 10 + (int) (formula.charAt(i++)-'0');
                // System.out.println(num);
           }
            int y2 = num;
            // System.out.println(x2 +":"+ y2 +":"+ sheet[x2][y2]);
            val2 = sheet[x2][y2];
        }
        
        // System.out.println(val1+":"+val2+":" +formula.charAt(op));
        int ans = eval(val1,val2,formula.charAt(op));

        return ans;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */


// Time Complexity : O(n) n = no. of setCell, resetCell, getValue calls
// Auxiliar Space : O(n) n = no. of rows
