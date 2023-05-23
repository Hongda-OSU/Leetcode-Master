class Excel {
    private Cell[][] table;

    public Excel(int height, char width) {
        table = new Cell[height + 1][width - 'A' + 1];
    }
    
    public void set(int row, char column, int val) {
        if (table[row][column - 'A'] == null)
            table[row][column - 'A'] = new Cell(val);
        else
            table[row][column - 'A'].setValue(val);
    }
    
    public int get(int row, char column) {
        if (table[row][column - 'A'] == null)
            return 0;
        else
            return table[row][column - 'A'].getValue();
    }
    
    public int sum(int row, char column, String[] numbers) {
        if (table[row][column - 'A'] == null)
            table[row][column - 'A'] = new Cell(numbers);
        else 
            table[row][column - 'A'].setFormula(numbers);
        return table[row][column - 'A'].getValue();
    }
    
    class Cell {
    public int val = 0;
    public HashMap<Cell, Integer> formula = new HashMap<>();
    
    public Cell(int val) {
        setValue(val);
    }
    
    public Cell(String[] formulaStr) {
        setFormula(formulaStr);
    }
    
    public void setValue(int val) {
        formula.clear();
        this.val = val;
    }
    
    public void setFormula(String[] formulaStr) {
        formula.clear();
        for (String str : formulaStr) {
            if (str.indexOf(":") < 0) {
                int[] pos = getPos(str);
                addFormulaCell(pos[0], pos[1]);
            } else {
                String[] pos = str.split(":");
                int[] start = getPos(pos[0]);
                int[] end = getPos(pos[1]);
                for (int r = start[0]; r <= end[0]; r++) {
                    for (int c = start[1]; c <= end[1]; c++) 
                        addFormulaCell(r, c);
                }
            }
        }
    }
    
    public int getValue() {
        if (formula.isEmpty())
            return val;
        int sum = 0;
        for (Cell cell : formula.keySet())
            sum += cell.getValue() * formula.get(cell);
        return sum;
    }
    
    private int[] getPos(String str) {
        int[] pos = new int[2];
        pos[1] = str.charAt(0) - 'A';
        pos[0] = Integer.parseInt(str.substring(1));
        return pos;
    }
    
    private void addFormulaCell(int r, int c) {
        if (table[r][c] == null)
            table[r][c] = new Cell(0);
        Cell cell = table[r][c];
        formula.put(cell, (formula.containsKey(cell) ? formula.get(cell) : 0) + 1);
    }
}
}



/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(height, width);
 * obj.set(row,column,val);
 * int param_2 = obj.get(row,column);
 * int param_3 = obj.sum(row,column,numbers);
 */