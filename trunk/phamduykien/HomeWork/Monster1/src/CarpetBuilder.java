//PDKIEN - Class dùng build carpet - test java static method, for, stringbuilder, newline
public class CarpetBuilder {
	public static String BuildCarpetString(int height, int width) {
		StringBuilder builder = new StringBuilder();
		String firstRow = "";
		for (int j = 0; j < width; j++) {
			firstRow += "*";
		}
		for (int i = 0; i < height; i++) {
			builder.append(firstRow);
			if (i < height - 1) {
				builder.append("\n");

			}
		}

		return builder.toString();
	}

}
