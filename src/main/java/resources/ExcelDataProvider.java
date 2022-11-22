package resources;

public class ExcelDataProvider {

	public static Object[][] testData(String path, String sheetName) throws Exception {
		ExcelUtils.setExcelFile(path, sheetName);
		int rowCount = ExcelUtils.getRowCount();
		int coulmCount = ExcelUtils.getColumCount();

		Object array[][] = new Object[rowCount - 1][coulmCount];

		for (int i = 1; i < rowCount; i++) {

			for (int j = 0; j < coulmCount; j++) {

				array[i - 1][j] = ExcelUtils.getCellData(i, j);
			}

		}
		return array;
	}

}
