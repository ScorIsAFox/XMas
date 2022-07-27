
public class TreeModel {
	
	public TreeModel(int layer) {
		this.drawLeafs(layer);
		this.drawRoot(layer);
	}
	
	private void drawLeafs(int layer) {
		int maxWidth = layer*4 + 3;
		int star = 1;
		int pos = maxWidth/2 + 1;
		for (int i = 0; i < layer; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < pos; k++) {
					System.out.print(" ");
				}
				for (int k = 0; k < star; k++) {
					System.out.print("*");
				}
				for (int k = pos+1; k < maxWidth; k++) {
					System.out.print(" ");
				}
				
				star += 2;
				pos --;
				System.out.println();
			}
			star -= 4;
			pos += 2;
		}
	}
	
	private void drawRoot(int layer) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < (layer+2); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < (2*layer+1); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
