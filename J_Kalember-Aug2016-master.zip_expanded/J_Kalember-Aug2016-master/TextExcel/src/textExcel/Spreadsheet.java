package textExcel;

public class Spreadsheet implements Grid
{
	private int rowsNumber = 20;
	private int colsNumber = 12;
	Cell[][] arraySpreadsheet = new EmptyCell[rowsNumber][colsNumber];
	
	public Spreadsheet(){
		for(int i=0;i<rowsNumber; i++){
			for(int j=0; j<colsNumber; j++){
				arraySpreadsheet[i][j] = new EmptyCell();
			}
		}
		setRows(rowsNumber);
		setColumns(colsNumber);
	}
	
	public void setRows(int num){
		this.rowsNumber = num;
	}
	
	public void setColumns(int num){
		this.colsNumber = num;
	}
	
	@Override
	public String processCommand(String command){
		// TODO Auto-generated method stub
		//Empty command
		if(command.equals("")){
			return "";
		}
		
		String lowerCommand = command.toLowerCase();
		//Clear command
		if(lowerCommand.equals("clear")){
			for(int i=0;i<rowsNumber; i++){
				for(int j=0; j<colsNumber; j++){
					arraySpreadsheet[i][j] = new EmptyCell();
				}
			}
		}
		
		//Clear Cell command
		if(lowerCommand.contains("clear ")){
			String[] splitCommand = command.split(" ");
			SpreadsheetLocation location = new SpreadsheetLocation(splitCommand[0]);
			arraySpreadsheet[location.getCol()][location.getRow()] = new EmptyCell();
		}
		
		//Cell assignment
		if(lowerCommand.contains("=")){
			String[] splitCommand = command.split("=");
			SpreadsheetLocation location = new SpreadsheetLocation(splitCommand[0]);
			//Command is assigning text 
			if(command.contains("\"")){
				arraySpreadsheet[location.getCol()][location.getRow()] = new TextCell(splitCommand[1]);
			}
			/*	 
			//Command is assigning a formula
			if(lowerCommand.contains("+") || lowerCommand.contains("-") || lowerCommand.contains("/")){
				arraySpreadsheet[location.getCol()][location.getRow()] = new FormulaCell(splitCommand[1]);
			}

			//Command is assigning a decimal
			if(lowerCommand.contains(".")){
				arraySpreadsheet[location.getCol()][location.getRow()] = new PercentCell(splitCommand[1]);
				
			}
			
			if(lowerCommand.contains("("){
				arraySpreadsheet[location.getCol()][location.getRow()] = new FormulaCell(splitCommand[0]);
			}else{
				arraySpreadsheet[location.getCol()][location.getRow()] = new RealCell(splitCommand[1]);
			}*/
		}else{
			//Cell Inspection
			SpreadsheetLocation location = new SpreadsheetLocation(command);
			return(arraySpreadsheet[location.getCol()][location.getRow()].fullCellText());
		}
		return "";
	}

	@Override
	public int getRows(){
		return this.rowsNumber;
	}

	@Override
	public int getCols(){
		return this.colsNumber;
	}

	@Override
	public Cell getCell(Location loc){
		return(arraySpreadsheet[loc.getCol()][loc.getRow()]);
	}

	@Override
	public String getGridText(){
		String gridText = "";
		String spaces = "         ";
		
		for(int i = 0; i <=20; i++){
			if(i==0){
				gridText += "   |";
			}
			
			if(i > 0 && i < 10){
				gridText += (i) + "  " + "|";
			}
			
			if(i < 99 && i >= 10){
				gridText += (i) + " " + "|";
			}
			
			for(char j = 'A'; j < 'M'; j++){
				//row 1
				if(i == 0){
					gridText += (j) + spaces + "|";
				}
				
				//rows 2-20
				if(i > 0){
					gridText += spaces + " " + "|";
				}
			}
			gridText += "\n";
		}
		return gridText;
	}

}
