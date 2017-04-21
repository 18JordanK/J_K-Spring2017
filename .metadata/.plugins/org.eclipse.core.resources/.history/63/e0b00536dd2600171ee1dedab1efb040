package textExcel;

public class TextCell implements Cell {
	private String textCell;
	
	public TextCell(String t){
		setText(t);
	}
	
	public String truncate(String text){
		String truncatedText = text.substring(0,10);
		return truncatedText;
	}
	
	public String padToTen(String text){
		String paddedText = this.textCell;
		while(!(paddedText.length() == 10)){
			paddedText += " ";
		}
		return paddedText;
	}
	
	public void setText(String text){
		this.textCell = text;
	}
	
	public String getText(){
		return this.textCell;
	}
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return null;
	}

}
